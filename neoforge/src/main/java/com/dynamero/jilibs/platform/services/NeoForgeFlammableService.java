package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

import java.util.ArrayList;
import java.util.List;

public class NeoForgeFlammableService implements IFlammableService
{
    private record Entry(BlockHandle<? extends Block> block, int encouragement, int flammability) {}
    private static final List<Entry> QUEUED = new ArrayList<>();

    @Override
    public void register(BlockHandle<? extends Block> block, int encouragement, int flammability)
    {
        QUEUED.add(new Entry(block, encouragement, flammability));
    }

    /**
     * Call this inside FMLCommonSetupEvent: event.enqueueWork(NeoForgeFlammableService::apply);
     */
    public static void apply()
    {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        for (Entry entry : QUEUED)
            fireBlock.setFlammable(entry.block().get(), entry.encouragement(), entry.flammability());
        QUEUED.clear();
    }
}