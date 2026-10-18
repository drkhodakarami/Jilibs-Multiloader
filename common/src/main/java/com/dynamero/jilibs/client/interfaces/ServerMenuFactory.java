package com.dynamero.jilibs.client.interfaces;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

@FunctionalInterface
public interface ServerMenuFactory<M extends AbstractContainerMenu, E> {
    M create(int containerId, Inventory playerInventory, Player player, E target);
}