package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.interfaces.factories.IToolFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.ItemHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
public class NeoForgeItemRegisterar implements IItemRegisterar, INeoForgeRegistrar
{
    private final String modId;
    private final DeferredRegister.Items items;

    private boolean registered;

    public NeoForgeItemRegisterar()
    {
        this.modId = "";
        items = null;
        registered = false;
    }

    public NeoForgeItemRegisterar(String modId)
    {
        this.modId = modId;
        items = DeferredRegister.createItems(modId);
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        this.items.register(eventBus);
        registered = true;
    }

    @Override
    public Iterable<Item> getList()
    {
        return this.items.getEntries()
                         .stream()
                         .map(Holder::value)
                         .toList();
    }

    @Override
    public IItemRegisterar forMod(String modId) {
        return new NeoForgeItemRegisterar(modId);
    }

    @Override
    public ResourceKey<Item> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.ITEM);
    }

    @Override
    public <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, IToolFactory<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem =
                items.register(key.identifier().getPath(),
                               () -> factory.apply(material, attackDamage, attackSpeed,
                                                   new Item.Properties().setId(key)));

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
                return deferredItem.get();
            }
        };
    }

    @Override
    public <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed,
                                                           Item.Properties settings, IToolFactory<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem =
                items.register(key.identifier().getPath(),
                               () -> factory.apply(material, attackDamage, attackSpeed, settings.setId(key)));

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
                return deferredItem.get();
            }
        };
    }

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Function<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem = items.registerItem(key.identifier().getPath(), factory);

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
                return deferredItem.get();
            }
        };
    }

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Function<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem =
                items.registerItem(key.identifier().getPath(), factory,
                                   () -> new Item.Properties().setId(key). stacksTo(stackCount));

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
                return deferredItem.get();
            }
        };
    }

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem =
                items.registerItem(key.identifier().getPath(), factory,
                                   () -> settings.setId(key));

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
                return deferredItem.get();
            }
        };
    }

    @Override
    public <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        DeferredItem<R> deferredItem =
                items.registerItem(key.identifier().getPath(), factory,
                                   () -> settings.setId(key). stacksTo(stackCount));

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
                return deferredItem.get();
            }
        };
    }
}