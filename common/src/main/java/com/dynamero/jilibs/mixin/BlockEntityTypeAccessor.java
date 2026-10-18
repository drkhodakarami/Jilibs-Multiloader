package com.dynamero.jilibs.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.class)
public interface BlockEntityTypeAccessor
{
    /**
     * Sets the collection of blocks valid for this block entity type.
     *
     * @param blocks the new set of valid blocks
     */
    @Accessor("validBlocks")
    void setBlocks(Set<Block> blocks);

    /**
     * Retrieves the current set of blocks valid for this block entity type.
     *
     * @return set of valid blocks
     */
    @Accessor("validBlocks")
    Set<Block> getBlocks();
}