package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.interfaces.factories.IToolFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.ItemHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricItemRegisterar implements IItemRegisterar
{
    private final String modId;
    private final List<Item> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricItemRegisterar()
    {
        this("");
    }

    // Scoped instance
    public FabricItemRegisterar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<Item> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IItemRegisterar forMod(String modId)
    {
        return new FabricItemRegisterar(modId);
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