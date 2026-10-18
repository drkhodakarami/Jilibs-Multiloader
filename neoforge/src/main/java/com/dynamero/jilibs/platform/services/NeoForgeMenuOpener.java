package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.client.interfaces.ServerMenuFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.ExtendedMenuFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.MenuTypeHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.OptionalInt;

@SuppressWarnings("unused")
public class NeoForgeMenuOpener implements IMenuService, INeoForgeRegistrar
{
    private final String modId;
    private final DeferredRegister<MenuType<?>> menus;

    private boolean registered;

    public NeoForgeMenuOpener()
    {
        this.modId = "";
        menus = null;
        registered = false;
    }

    public NeoForgeMenuOpener(String modId)
    {
        this.modId = modId;
        menus = DeferredRegister.create(Registries.MENU, modId);
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        this.menus.register(eventBus);
        registered = true;
    }

    @Override
    public Iterable<? extends MenuType<?>> getList()
    {
        return this.menus.getEntries()
                         .stream()
                         .map(Holder::value)
                         .toList();
    }

    @Override
    public IMenuService forMod(String modId)
    {
        return new NeoForgeMenuOpener(modId);
    }

    @Override
    public ResourceKey<MenuType<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.MENU);
    }

    @Override
    public <T extends Entity, M extends AbstractContainerMenu> OptionalInt open(Player player, T entity, int entityId,
                                               ServerMenuFactory<M, T> serverFactory)
    {
        return player.openMenu(new SimpleMenuProvider(
                (containerId, inventory, p) -> serverFactory.create(containerId, inventory, p, entity),
                entity.getDisplayName()
        ), registryFriendlyByteBuf -> registryFriendlyByteBuf.writeInt(entityId));
    }

    @Override
    public <T extends AbstractContainerMenu, D> MenuTypeHandle<MenuType<?>> registerExtendedMenuType(String name, ExtendedMenuFactory<T, D> factory, StreamCodec<? super RegistryFriendlyByteBuf, D> codec)
    {
        var key = key(name);

        var deferred = menus.register(name, () ->
                IMenuTypeExtension.create((syncId, inv, buf) -> {
                    // Decode payload from the buffer using the codec
                    D extraData = codec.decode(buf);
                    return factory.create(syncId, inv, extraData);
                }));

        return new MenuTypeHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<MenuType<?>> key()
            {
                return key;
            }

            @Override
            public MenuType<?> get()
            {
                return deferred.get();
            }
        };
    }
}