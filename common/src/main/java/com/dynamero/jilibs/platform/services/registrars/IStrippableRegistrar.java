package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.CommonStrippables;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import net.minecraft.world.level.block.Block;

public interface IStrippableRegistrar
{
    /**
     * Registers a block to be stripped into another block with an axe.
     *
     * @param input Block to be stripped
     * @param stripped Resulting stripped block
     */
    default void register(BlockHandle<? extends Block> input, BlockHandle<? extends Block> stripped)
    {
        CommonStrippables.register(input, stripped);
    }
}