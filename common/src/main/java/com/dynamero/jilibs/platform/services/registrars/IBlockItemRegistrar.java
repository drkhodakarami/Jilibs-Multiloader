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

import java.util.Collections;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.interfaces.factories.IBlockItemFactory;
import com.dynamero.jilibs.platform.Services;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import com.dynamero.jilibs.contracts.records.ModBlock;

/**
 * Provides utility methods for registering block items in Minecraft.
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
public interface IBlockItemRegistrar
{
    default BlockItemId key(String name)
    {
        return new BlockItemId(Services.Registrars.BLOCKS.key(name), Services.Registrars.ITEMS.key(name));
    }

    /**
     * Returns an iterable of all ModBlocks
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    default Iterable<ModBlock<?, ?>> getList()
    {
        return Collections.unmodifiableList(BlockItemRegistrarHolder.LIST);
    }

    //region Helper Overloads
    /**
     * Registers a block item using default settings.
     *
     * @param block The block to register as an item.
     * @return The registered block item.
     */
    default <B extends Block> ModBlock<B, BlockItem> register(BlockHandle<B> block)
    {
        var key = key(block.key().identifier().getPath());
        return register(block, key);
    }

    /**
     * Registers a block item using a custom IBlockItemFactory.
     *
     * @param block The block to register as an item.
     * @param factory The factory to create the block item with custom settings.
     * @return The registered block item.
     */
    default  <B extends Block, I extends BlockItem> ModBlock<B, I> register(BlockHandle<B> block, IBlockItemFactory<Item.Properties, I> factory)
    {
        var key = key(block.key().identifier().getPath());
        return register(block, key, factory);
    }

    /**
     * Registers a block item with custom settings using a custom IBlockItemFactory.
     *
     * @param block The block to register as an item.
     * @param settings Custom settings for the block item.
     * @param factory The factory to create the block item with custom settings.
     * @return The registered block item.
     */
    default <B extends Block, I extends BlockItem> ModBlock<B, I> register(BlockHandle<B> block, Item.Properties settings, IBlockItemFactory<Item.Properties, I> factory)
    {
        var key = key(block.key().identifier().getPath());
        return register(block, key, settings, factory);
    }
    //endregion

    //region Main Overloads

    /**
     * Registers a block item for the specified block using a ResourceKey.
     *
     * @param block the block to register as an item
     * @param key   the resource key for the item registry
     * @return the registered BlockItem instance
     */
    default <B extends Block> ModBlock<B, BlockItem> register(BlockHandle<B> block, ResourceKey<Item> key)
    {
        var registered = Services.Registrars.ITEMS.register(key,
                                                 properties ->
                                                         new BlockItem(block.get(),
                                                                       properties
                                                                               .useBlockDescriptionPrefix()
                                                                               .setId(key)));
        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }

    /**
     * Registers a block item for the specified block using a BlockItemId.
     *
     * @param block       the block to register as an item
     * @param blockItemId the block item identifier
     * @return the registered BlockItem instance
     */
    default <B extends Block> ModBlock<B, BlockItem> register(BlockHandle<B> block, BlockItemId blockItemId)
    {
        var registered = Services.Registrars.ITEMS.register(blockItemId.item(),
                                                 properties ->
                                                         new BlockItem(block.get(),
                                                                       properties
                                                                               .useBlockDescriptionPrefix()
                                                                               .setId(blockItemId.item())));

        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }

    /**
     * Registers a block item for the specified block using a ResourceKey and custom factory.
     *
     * @param <R>     the concrete BlockItem type
     * @param block   the block to register as an item
     * @param key     the resource key for the item registry
     * @param factory the factory creating the block item
     * @return the registered BlockItem instance
     */
    default <B extends Block, R extends BlockItem> ModBlock<B, R> register(BlockHandle<B> block, ResourceKey<Item> key, IBlockItemFactory<Item.Properties, R> factory)
    {
        var item = factory.apply(block.get(),
                                 new Item.Properties()
                                         .useBlockDescriptionPrefix()
                                         .setId(key));
        var registered = Services.Registrars.ITEMS.register(key, _ -> item);


        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }

    /**
     * Registers a block item for the specified block using a BlockItemId and custom factory.
     *
     * @param <R>         the concrete BlockItem type
     * @param block       the block to register as an item
     * @param blockItemId the block item identifier
     * @param factory     the factory creating the block item
     * @return the registered BlockItem instance
     */
    default <B extends Block, R extends BlockItem> ModBlock<B, R> register(BlockHandle<B> block, BlockItemId blockItemId, IBlockItemFactory<Item.Properties, R> factory)
    {
        var item = factory.apply(block.get(),
                                 new Item.Properties()
                                         .useBlockDescriptionPrefix()
                                         .setId(blockItemId.item()));
        var registered = Services.Registrars.ITEMS.register(blockItemId.item(), _ -> item);


        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }

    /**
     * Registers a block item with custom settings using a ResourceKey and custom factory.
     *
     * @param <R>      the concrete BlockItem type
     * @param block    the block to register as an item
     * @param key      the resource key for the item registry
     * @param settings the custom item properties to use
     * @param factory  the factory creating the block item
     * @return the registered BlockItem instance
     */
    default <B extends Block, R extends BlockItem> ModBlock<B, R> register(BlockHandle<B> block, ResourceKey<Item> key, Item.Properties settings, IBlockItemFactory<Item.Properties, R> factory)
    {
        var item = factory.apply(block.get(),
                                 settings
                                         .useBlockDescriptionPrefix()
                                         .setId(key));
        var registered = Services.Registrars.ITEMS.register(key, _ -> item);


        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }

    /**
     * Registers a block item with custom settings using a BlockItemId and custom factory.
     *
     * @param <R>         the concrete BlockItem type
     * @param block       the block to register as an item
     * @param blockItemId the block item identifier
     * @param settings    the custom item properties to use
     * @param factory     the factory creating the block item
     * @return the registered BlockItem instance
     */
    default <B extends Block, R extends BlockItem> ModBlock<B, R> register(BlockHandle<B> block, BlockItemId blockItemId, Item.Properties settings, IBlockItemFactory<Item.Properties, R> factory)
    {
        var item = factory.apply(block.get(),
                                 settings
                                         .useBlockDescriptionPrefix()
                                         .setId(blockItemId.item()));
        var registered = Services.Registrars.ITEMS.register(blockItemId.item(), _ -> item);


        var modBlock = new ModBlock<>(block, registered);

        BlockItemRegistrarHolder.LIST.add(modBlock);

        return modBlock;
    }
    //endregion
}