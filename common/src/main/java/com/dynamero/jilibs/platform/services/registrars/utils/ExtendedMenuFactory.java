package com.dynamero.jilibs.platform.services.registrars.utils;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

@FunctionalInterface
public interface ExtendedMenuFactory<T extends AbstractContainerMenu, D> {
    T create(int syncId, Inventory playerInventory, D extraData);
}