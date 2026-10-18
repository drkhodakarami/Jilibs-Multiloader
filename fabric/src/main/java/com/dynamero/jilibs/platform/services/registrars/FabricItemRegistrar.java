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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.interfaces.factories.IToolFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.ItemHandle;
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
public class FabricItemRegistrar implements IItemRegistrar
{
    private final String modId;
    private final List<Item> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricItemRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricItemRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<Item> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IItemRegistrar forMod(String modId)
    {
        return new FabricItemRegistrar(modId);
    }

    @Override
    public ResourceKey<Item> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.ITEM);
    }

    @Override
    public <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, IToolFactory<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(material, attackDamage, attackSpeed, new Item.Properties().setId(key));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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

    @Override
    public <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed,
                                                           Item.Properties settings, IToolFactory<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(material, attackDamage, attackSpeed, settings.setId(key));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Function<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(new Item.Properties().setId(key));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Function<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(new Item.Properties().setId(key). stacksTo(stackCount));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(settings.setId(key));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        var item = factory.apply(settings.setId(key). stacksTo(stackCount));
        var registered = Registry.register(BuiltInRegistries.ITEM, key, item);

        this.list.add(registered);

        return new ItemHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<Item> key()
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
}