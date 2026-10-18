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

package com.dynamero.jilibs.platform.services.client.registrars;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.function.TriFunction;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class NeoForgeScreenRegistrar implements IScreenRegistrar
{
    private final List<MenuScreenEntry> menuScreens = new ArrayList<>();

    @Override
    public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>>
    void register(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> factory)
    {
        this.menuScreens.add(new MenuScreenEntry<>(menuType, factory));
    }

    @Override
    public void applyRegistrations(MenuScreenRegistrar registrar)
    {
        for (var screen : this.menuScreens)
            screen.register(registrar);
    }

    private record MenuScreenEntry<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>>
            (MenuType<T> menuType, TriFunction<T, Inventory, Component, U> factory)
    {
        private void register(MenuScreenRegistrar registrar)
        {
            registrar.register(this.menuType, this.factory);
        }
    }
}