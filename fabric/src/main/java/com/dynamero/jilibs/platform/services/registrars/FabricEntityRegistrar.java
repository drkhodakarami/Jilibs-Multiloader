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

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.EntityHandle;
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
public class FabricEntityRegistrar implements IEntityRegistrar
{
    private final String modId;
    private final List<EntityType<?>> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricEntityRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricEntityRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<EntityType<?>> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IEntityRegistrar forMod(String modId)
    {
        return new FabricEntityRegistrar(modId);
    }

    @Override
    public ResourceKey<EntityType<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.ENTITY_TYPE);
    }

    @Override
    public <R extends Entity> EntityHandle<EntityType<R>> register(String name, MobCategory spawnGroup, EntityType.EntityFactory<R> factory)
    {
        var key = key(name);
        var entityType = EntityType.Builder.of(factory, spawnGroup).build(key);
        var registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityType);

        this.list.add(registered);

        return new EntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<EntityType<?>> key()
            {
                return key;
            }

            @Override
            public EntityType<R> get()
            {
                return registered;
            }
        };
    }

    @Override
    public <R extends Entity> EntityHandle<EntityType<R>> register(String name, EntityType.Builder<R> type)
    {
        var key = key(name);
        var registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, key, type.build(key));

        this.list.add(registered);

        return new EntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<EntityType<?>> key()
            {
                return key;
            }

            @Override
            public EntityType<R> get()
            {
                return registered;
            }
        };
    }
}