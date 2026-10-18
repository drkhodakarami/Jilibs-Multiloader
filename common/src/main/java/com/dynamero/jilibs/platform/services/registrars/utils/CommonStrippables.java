package com.dynamero.jilibs.platform.services.registrars.utils;

import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CommonStrippables
{

    public record StrippableEntry(BlockHandle<? extends Block> input, BlockHandle<? extends Block> output)
    {}

    private static final List<StrippableEntry> ENTRIES = new ArrayList<>();

    public static synchronized void register(BlockHandle<? extends Block> input, BlockHandle<? extends Block> output)
    {
        ENTRIES.add(new StrippableEntry(input, output));
    }

    public static List<StrippableEntry> getEntries()
    {
        return Collections.unmodifiableList(ENTRIES);
    }
}