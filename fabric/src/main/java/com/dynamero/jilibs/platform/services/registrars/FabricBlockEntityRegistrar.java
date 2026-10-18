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
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.BlockEntityFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockEntityHandle;
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
public class FabricBlockEntityRegistrar implements IBlockEntityRegistrar
{
    private final String modId;
    private final List<? extends BlockEntityType<?>> list = new ArrayList<>();

    public FabricBlockEntityRegistrar()
    {
        this("");
    }

    public FabricBlockEntityRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<? extends BlockEntityType<?>> getList()
    {
        return list;
    }

    @Override
    public IBlockEntityRegistrar forMod(String modId)
    {
        return new FabricBlockEntityRegistrar(modId);
    }

    @Override
    public ResourceKey<BlockEntityType<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.BLOCK_ENTITY_TYPE);
    }

    @SafeVarargs
    @Override
    public final <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, BlockHandle<? extends Block>... validBlocks)
    {
        return register(name, factory, Arrays.stream(validBlocks)
                                             .map(Supplier::get)
                                             .toArray(Block[]::new));
    }

    @Override
    public <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, List<BlockHandle<? extends Block>> validBlocks)
    {
        return register(name, factory, validBlocks.stream()
                                                  .map(Supplier::get)
                                                  .toArray(Block[]::new));
    }

    private <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, Block[] blocks)
    {
        var key = key(name);

        BlockEntityType<T> type = FabricBlockEntityTypeBuilder.create(factory::create, blocks).build();

        var registered = Registry.register( BuiltInRegistries.BLOCK_ENTITY_TYPE, name, type);

        return new BlockEntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<BlockEntityType<?>> key()
            {
                return key;
            }

            @Override
            public BlockEntityType<T> get()
            {
                return registered;
            }
        };
    }
}