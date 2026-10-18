package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class FabricFlammableService implements IFlammableService
{
    @Override
    public void register(BlockHandle<? extends Block> block, int encouragement, int flammability)
    {
        FlammableBlockRegistry.getDefaultInstance().add(block.get(), encouragement, flammability);
    }
}