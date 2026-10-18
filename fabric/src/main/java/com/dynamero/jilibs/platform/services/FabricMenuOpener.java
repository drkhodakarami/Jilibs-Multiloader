package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.client.ExtendedMenuType;
import com.dynamero.jilibs.client.interfaces.ExtendedMenuProvider;
import com.dynamero.jilibs.client.interfaces.ServerMenuFactory;
import com.dynamero.jilibs.network.IntegerPayload;
import com.dynamero.jilibs.platform.services.registrars.utils.ExtendedMenuFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.MenuTypeHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

@SuppressWarnings("unused")
public class FabricMenuOpener implements IMenuService
{
    private final String modId;
    private final List<MenuType<?>> list = new ArrayList<>();

    public FabricMenuOpener()
    {
        this("");
    }

    public FabricMenuOpener(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<MenuType<?>> getList()
    {
        return list;
    }

    @Override
    public IMenuService forMod(String modId)
    {
        return new FabricMenuOpener(modId);
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
        return player.openMenu(new ExtendedMenuProvider<>()
        {
            @Override
            public @Nullable AbstractContainerMenu createMenu(int containerId, @NonNull Inventory inventory, @NonNull Player player)
            {
                return serverFactory.create(containerId, inventory, player, entity);
            }

            @Override
            public @NonNull Component getDisplayName()
            {
                return entity.getDisplayName();
            }

            @Override
            public Object getScreenOpeningData(ServerPlayer player)
            {
                return new IntegerPayload(entityId);
            }
        });
    }

    @Override
    public <T extends AbstractContainerMenu, D> MenuTypeHandle<MenuType<?>> registerExtendedMenuType(String name, ExtendedMenuFactory<T, D> factory, StreamCodec<? super RegistryFriendlyByteBuf, D> codec)
    {
        var key = key(name);

        var menuType = new ExtendedMenuType<>(
                factory::create,
                codec
        );

        var registered = Registry.<MenuType<?>>register(
                BuiltInRegistries.MENU,
                name,
                menuType
        );

        return new MenuTypeHandle<MenuType<?>>()
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
                return registered;
            }
        };
    }
}