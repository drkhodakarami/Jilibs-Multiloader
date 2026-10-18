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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import com.dynamero.jilibs.utils.BaseHelper;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricBlockRegistrar implements IBlockRegistrar
{
    private final String modId;
    private final List<Block> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricBlockRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricBlockRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<Block> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IBlockRegistrar forMod(String modId)
    {
        return new FabricBlockRegistrar(modId);
    }

    @Override
    public ResourceKey<Block> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.BLOCK);
    }

    public <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, R block)
    {
        var registered = Registry.register(BuiltInRegistries.BLOCK, key, block);

        this.list.add(registered);

        return new BlockHandle<R>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Block> key()
            {
                return key;
            }

            @Override
            public R get()
            {
                return registered;
            }
        };
    }

    public <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        R block = factory.apply(BlockBehaviour.Properties.of().setId(key));
        var registered = Registry.register(BuiltInRegistries.BLOCK, key, block);

        this.list.add(registered);

        return new BlockHandle<R>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Block> key()
            {
                return key;
            }

            @Override
            public R get()
            {
                return registered;
            }
        };
    }

    public <R extends Block> BlockHandle<R> register(ResourceKey<Block> key, BlockBehaviour.Properties settings, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        R block = factory.apply(settings.setId(key));
        var registered = Registry.register(BuiltInRegistries.BLOCK, key, block);

        this.list.add(registered);

        return new BlockHandle<R>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Block> key()
            {
                return key;
            }

            @Override
            public R get()
            {
                return registered;
            }
        };
    }

    public <R extends Block> BlockHandle<R> registerCopy(ResourceKey<Block> key, Block copyBlock, Function<BlockBehaviour.Properties, ? extends R> factory)
    {
        R block = factory.apply(BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key));
        var registered = Registry.register(BuiltInRegistries.BLOCK, key, block);

        this.list.add(registered);

        return new BlockHandle<R>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Block> key()
            {
                return key;
            }

            @Override
            public R get()
            {
                return registered;
            }
        };
    }

    public BlockHandle<StairBlock> registerStair(String name, Block stateBlock, Block copyBlock)
    {
        return register(name,
                        new StairBlock(
                                stateBlock.defaultBlockState(),
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<SlabBlock> registerSlab(String name, Block copyBlock)
    {
        return register(name,
                        new SlabBlock(
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<ButtonBlock> registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock)
    {
        return register(name,
                        new ButtonBlock(
                                blockType, pressureTicks,
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<PressurePlateBlock> registerPressurePlate(String name, BlockSetType blockType, Block copyBlock)
    {
        return register(name,
                        new PressurePlateBlock(
                                blockType,
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<FenceBlock> registerFence(String name, Block copyBlock)
    {
        return register(name,
                        new FenceBlock(
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<FenceGateBlock> registerFenceGate(String name, WoodType woodType, Block copyBlock)
    {
        return register(name,
                        new FenceGateBlock(
                                woodType,
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<WallBlock> registerWall(String name, Block copyBlock)
    {
        return register(name,
                        new WallBlock(
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<DoorBlock> registerDoor(String name, BlockSetType blockType, Block copyBlock)
    {
        return register(name,
                        new DoorBlock(
                                blockType,
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }

    public BlockHandle<TrapDoorBlock> registerTrapdoor(String name, BlockSetType blockType, Block copyBlock)
    {
        return register(name,
                        new TrapDoorBlock(
                                blockType,
                                BlockBehaviour.Properties.ofFullCopy(copyBlock).setId(key(name))));
    }
}