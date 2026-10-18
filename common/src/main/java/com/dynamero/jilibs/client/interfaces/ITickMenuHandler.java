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

package com.dynamero.jilibs.client.interfaces;

import net.minecraft.server.level.ServerPlayer;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.Services;

/**
 * Interface implemented by screen handlers (container menus) that require per-tick updates
 * on the server for players currently interacting with the menu.
 */
@SuppressWarnings("unused")
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface ITickMenuHandler
{
    /**
     * Invoked every server tick for the player viewing this screen handler.
     *
     * @param player the server player viewing the container menu
     */
    void tick(ServerPlayer player);

    /**
     * Initializes the server tick listener hook to dispatch ticks to open {@link ITickMenuHandler} menus.
     */
    static void init()
    {
        Services.Events.onEndServerTick(world ->
                               {
                                   for (ServerPlayer player : world.getPlayerList().getPlayers())
                                       if(player.containerMenu instanceof ITickMenuHandler tickableScreen)
                                           tickableScreen.tick(player);
                               });
    }
}