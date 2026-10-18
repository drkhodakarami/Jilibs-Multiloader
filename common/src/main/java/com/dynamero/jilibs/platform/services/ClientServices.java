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

package com.dynamero.jilibs.platform.services;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.world.level.block.entity.BlockEntity;

import com.dynamero.jilibs.client.events.LevelRenderContext;
import com.dynamero.jilibs.client.events.RenderStage;
import com.dynamero.jilibs.client.events.TooltipCallback;
import com.dynamero.jilibs.contracts.exceptions.Exceptions;
import com.dynamero.jilibs.platform.Services;
import com.dynamero.jilibs.platform.services.client.registrars.IEntityRendererRegistrar;
import com.dynamero.jilibs.platform.services.client.registrars.IScreenRegistrar;
import com.dynamero.jilibs.platform.services.events.IClientEventService;

public class ClientServices
{
    public static final IEntityRendererRegistrar ENTITY = Services.load(IEntityRendererRegistrar.class);
    public static final IScreenRegistrar SCREEN = Services.load(IScreenRegistrar.class);

    public static class Events
    {
        public static void onStartClientTick(Consumer<Minecraft> callback) {
            IClientEventService.get().onStartClientTick(require(callback));
        }

        public static void onEndClientTick(Consumer<Minecraft> callback) {
            IClientEventService.get().onEndClientTick(require(callback));
        }

        public static void onStartLevelTick(Consumer<ClientLevel> callback) {
            IClientEventService.get().onStartLevelTick(require(callback));
        }

        public static void onEndLevelTick(Consumer<ClientLevel> callback) {
            IClientEventService.get().onEndLevelTick(require(callback));
        }

        public static void onLevelEnter(Consumer<ClientLevel> callback) {
            IClientEventService.get().onLevelEnter(require(callback));
        }

        public static void onLevelLeave(Consumer<ClientLevel> callback) {
            IClientEventService.get().onLevelLeave(require(callback));
        }

        public static void onBlockEntityUnload(BiConsumer<BlockEntity, ClientLevel> callback) {
            IClientEventService.get().onBlockEntityUnload(require(callback));
        }

        public static void onConnection(Consumer<Minecraft> callback) {
            IClientEventService.get().onConnection(require(callback));
        }

        public static void onDisconnection(Consumer<Minecraft> callback) {
            IClientEventService.get().onDisconnection(require(callback));
        }

        public static void onTooltip(TooltipCallback callback) {
            IClientEventService.get().onTooltip(require(callback));
        }

        public static KeyMapping registerKeyMapping(KeyMapping keyMapping) {
            return IClientEventService.get().registerKeyMapping(require(keyMapping));
        }

        public static void registerResourceReloadListener(Identifier id, PreparableReloadListener listener) {
            IClientEventService.get().registerResourceReloadListener(require(id), require(listener));
        }

        public static void onRenderStage(RenderStage stage, Consumer<LevelRenderContext> callback) {
            IClientEventService.get().onRenderStage(require(stage), require(callback));
        }

        private static <T> T require(T value) {
            return Objects.requireNonNull(value, "value");
        }
    }

    public ClientServices()
    {
        Exceptions.throwCtorAssertion();
    }
}