package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import net.minecraft.world.level.block.Block;

public interface IFlammableService
{
    /**
     * Registers flammability for a block across platforms.
     *
     * @param block The block supplier (evaluated when registry freezes or in common setup)
     * @param encouragement Catch odds (spread chance)
     * @param flammability Burn odds (how fast it is consumed)
     */
    void register(BlockHandle<? extends Block> block, int encouragement, int flammability);
}