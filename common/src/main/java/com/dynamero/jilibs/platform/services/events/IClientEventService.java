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

package com.dynamero.jilibs.platform.services.events;

import com.dynamero.jilibs.client.events.LevelRenderContext;
import com.dynamero.jilibs.client.events.RenderStage;
import com.dynamero.jilibs.client.events.TooltipCallback;
import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.Services;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.ServiceLoader;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Client-only loader implementation for {@link Services.Client.Events}. Never resolve this service from a dedicated server.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IClientEventService
{
    static IClientEventService get() {
        return ServiceHolder.INSTANCE;
    }

    void onStartClientTick(Consumer<Minecraft> callback);

    void onEndClientTick(Consumer<Minecraft> callback);

    void onStartLevelTick(Consumer<ClientLevel> callback);

    void onEndLevelTick(Consumer<ClientLevel> callback);

    void onLevelEnter(Consumer<ClientLevel> callback);

    void onLevelLeave(Consumer<ClientLevel> callback);

    void onBlockEntityUnload(BiConsumer<BlockEntity, ClientLevel> callback);

    void onConnection(Consumer<Minecraft> callback);

    void onDisconnection(Consumer<Minecraft> callback);

    void onTooltip(TooltipCallback callback);

    KeyMapping registerKeyMapping(KeyMapping keyMapping);

    void registerResourceReloadListener(Identifier id, PreparableReloadListener listener);

    void onRenderStage(RenderStage stage, Consumer<LevelRenderContext> callback);

    final class ServiceHolder {
        private static final IClientEventService INSTANCE = ServiceLoader.load(
                IClientEventService.class,
                IClientEventService.class.getClassLoader()
            )
             .findFirst()
             .orElseThrow(() -> new IllegalStateException("No client event service is available"));

        private ServiceHolder() {
        }
    }
}