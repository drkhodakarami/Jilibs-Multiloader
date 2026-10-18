/*
 * Copyright (c) 2026 Alireza Khodakarami
 *
 * Licensed under the LPGL-3.0, (read the "LICENSE" file in repo);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dynamero.jilibs.platform.services.registrars;

import java.util.function.Function;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;

/**
 * Provides utility methods for registering blocks in Minecraft.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-16")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IBlockRegistrar extends IModScopedRegistrar<IBlockRegistrar>
{
    ResourceKey<Block> key(String name);

    /**
     * Returns an iterable of all blocks
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<Block> getList();

    //region MAIN
    <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, R block);

    default <R extends Block> BlockHandle<R> register(String name, R block)
    {
        return register(key(name), block);
    }

    <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, ? extends R> factory);

    default <R extends Block> BlockHandle<R> register(String name, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return register(key(name), factory);
    }

    <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, BlockBehaviour.Properties settings, Function<BlockBehaviour.Properties, ? extends R> factory);

    default <R extends Block> BlockHandle<R> register(String name, BlockBehaviour.Properties settings, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return register(key(name), settings, factory);
    }
    //ednregion

    //region HELPERS
    default BlockHandle<Block> register(ResourceKey<Block> key)
    {
        return register(key, (Function<BlockBehaviour.Properties, Block>) Block::new);
    }

    default BlockHandle<Block> register(BlockItemId blockItemId)
    {
        return register(blockItemId, (Function<BlockBehaviour.Properties, Block>) Block::new);
    }

    default <R extends Block> BlockHandle<R> register(BlockItemId blockItemId, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return register(blockItemId.block(), factory);
    }

    default BlockHandle<Block> register(BlockItemId blockItemId, BlockBehaviour.Properties settings)
    {
        return register(blockItemId, settings, Block::new);
    }

    default <R extends Block> BlockHandle<R> register(BlockItemId blockItemId, R block)
    {
        return register(blockItemId.block(), block);
    }

    default <R extends Block> BlockHandle<R> register(BlockItemId blockItemId, BlockBehaviour.Properties settings, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return register(blockItemId.block(), settings, factory);
    }
    //ednregion

    //region COPY
    default BlockHandle<Block> registerCopy(BlockItemId blockItemId, Block copyBlock)
    {
        return registerCopy(blockItemId, copyBlock, Block::new);
    }

    default <B extends Block> BlockHandle<Block> registerCopy(BlockItemId blockItemId, BlockHandle<B> copyBlock)
    {
        return registerCopy(blockItemId, copyBlock, Block::new);
    }

    default BlockHandle<Block> registerCopy(ResourceKey<Block> key, Block copyBlock)
    {
        return registerCopy(key, copyBlock, Block::new);
    }

    default <B extends Block> BlockHandle<Block> registerCopy(ResourceKey<Block> key, BlockHandle<B> copyBlock)
    {
        return registerCopy(key, copyBlock, Block::new);
    }

    default BlockHandle<Block> registerCopy(String name, Block copyBlock)
    {
        return registerCopy(key(name), copyBlock, Block::new);
    }

    default <B extends Block> BlockHandle<Block> registerCopy(String name, BlockHandle<B> copyBlock)
    {
        return registerCopy(key(name), copyBlock, Block::new);
    }

    default <R extends Block> BlockHandle<R> registerCopy(BlockItemId blockItemId, Block copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(blockItemId.block(), copyBlock, factory);
    }

    default <B extends Block, R extends Block> BlockHandle<R> registerCopy(BlockItemId blockItemId, BlockHandle<B> copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(blockItemId.block(), copyBlock, factory);
    }

    default <R extends Block> BlockHandle<R> registerCopy(String name, Block copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(key(name), copyBlock, factory);
    }

    default <B extends Block, R extends Block> BlockHandle<R> registerCopy(String name, BlockHandle<B> copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(key(name), copyBlock, factory);
    }

    <R extends Block> BlockHandle<R> registerCopy(ResourceKey<Block> key, Block copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory);

    default <B extends Block, R extends Block> BlockHandle<R> registerCopy(ResourceKey<Block> key, BlockHandle<B> copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(key, copyBlock.get(), factory);
    }

    default <R extends Block, C extends Block> BlockHandle<R> registerCopy(C copyBlock, BlockItemId blockItemId, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(blockItemId.block(), copyBlock, factory);
    }

    default <R extends Block, C extends Block> BlockHandle<R> registerCopy(BlockHandle<C> copyBlock, BlockItemId blockItemId, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        return registerCopy(blockItemId.block(), copyBlock, factory);
    }
    //endregion

    BlockHandle<StairBlock> registerStair(String name, Block stateBlock, Block copyBlock);

    BlockHandle<SlabBlock> registerSlab(String name, Block copyBlock);

    BlockHandle<ButtonBlock> registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock);

    BlockHandle<PressurePlateBlock> registerPressurePlate(String name, BlockSetType blockType, Block copyBlock);

    BlockHandle<FenceBlock> registerFence(String name, Block copyBlock);

    BlockHandle<FenceGateBlock> registerFenceGate(String name, WoodType woodType, Block copyBlock);

    BlockHandle<WallBlock> registerWall(String name, Block copyBlock);

    BlockHandle<DoorBlock> registerDoor(String name, BlockSetType blockType, Block copyBlock);

    BlockHandle<TrapDoorBlock> registerTrapdoor(String name, BlockSetType blockType, Block copyBlock);

    default BlockHandle<Block> registerXpBlock(String name, int minXp, int maxXp, BlockBehaviour.Properties settings)
    {
        return register(name, new DropExperienceBlock(UniformInt.of(minXp, maxXp), settings.requiresCorrectToolForDrops()));
    }

    default BlockHandle<Block> registerXpBlock(String name, int minXp, int maxXp)
    {
        return registerXpBlock(name, minXp, maxXp, BlockBehaviour.Properties.of());
    }
}