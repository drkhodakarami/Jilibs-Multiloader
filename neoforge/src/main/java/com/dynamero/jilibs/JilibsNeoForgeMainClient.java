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

package com.dynamero.jilibs;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.apache.commons.lang3.function.TriFunction;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.ClientServices;
import com.dynamero.jilibs.platform.services.client.registrars.IScreenRegistrar;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class JilibsNeoForgeMainClient
{
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        JilibsCommonClient.init();
        ClientServices.ENTITY.applyEntityRendererRegistrations(event::registerEntityRenderer);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        JilibsCommonClient.init();
        ClientServices.ENTITY.applyModelLayerRegistrations(event::registerLayerDefinition);
    }

    public static void registerScreens(RegisterMenuScreensEvent event)
    {
        JilibsCommonClient.init();
        ClientServices.SCREEN.applyRegistrations(
                new IScreenRegistrar.MenuScreenRegistrar()
                {
                    @Override
                    public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>>
                    void register(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> factory)
                    {
                        event.register(menuType, factory::apply);
                    }
                });
    }
}