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

package com.dynamero.jilibs.platform;

import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.contracts.exceptions.Exceptions;
import com.dynamero.jilibs.events.BlockBreakCallback;
import com.dynamero.jilibs.events.LivingDamageCallback;
import com.dynamero.jilibs.events.PlayerDimensionChangeCallback;
import com.dynamero.jilibs.platform.services.IFakePlayerService;
import com.dynamero.jilibs.platform.services.IMenuService;
import com.dynamero.jilibs.platform.services.IPlatformHelper;
import com.dynamero.jilibs.platform.services.events.IEventService;
import com.dynamero.jilibs.platform.services.registrars.*;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class Services
{

    //TODO: Datagen !!
    //TODO: Woodset
    //TODO: Reference ?!

    //TODO: Finish Registrars :
    // - Recipe
    // - Stats
    // - Status Effect
    // - Client Registrars
    //TODO: Proper Main Calls for inits

    //TODO: Client Menu Service

    //TODO: Client Network Hooks
    //TODO: Network Service

    //TODO: Useful Fake Player & Helper - Neoforge

    //TODO: Worldgen Service
    //TODO: Worldgen - Ore

    //TODO: Fluid GUI Widget

    //TODO: Inventory
    //TODO: Fluid
    //TODO: Energy
    //TODO: Gas
    //TODO: Heat
    //TODO: Pressure
    //TODO: Dispersion

    //TODO: Machines


    //TODO: Transfer & Pipe Network
    //TODO: Multi-Blocks

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IFakePlayerService FAKE_PLAYER = load(IFakePlayerService.class);
    public static final IMenuService MENU = load(IMenuService.class);

    public static <T> T load(Class<T> clazz)
    {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                                             .findFirst()
                                             .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        //LOGGER.logC(String.format("Loaded %s for service %s", loadedService, clazz));

        return loadedService;
    }

    public static class Client
    {

    }

    public static class Events
    {
        public Events()
        {
            Exceptions.throwCtorAssertion();
        }

        public static void onServerStarting(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onServerStarting(require(callback));
        }

        public static void onServerStarted(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onServerStarted(require(callback));
        }

        public static void onServerStopping(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onServerStopping(require(callback));
        }

        public static void onServerStopped(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onServerStopped(require(callback));
        }

        public static void onLevelLoad(Consumer<ServerLevel> callback)
        {
            IEventService.get().onLevelLoad(require(callback));
        }

        public static void onLevelUnload(Consumer<ServerLevel> callback)
        {
            IEventService.get().onLevelUnload(require(callback));
        }

        public static void onStartServerTick(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onStartServerTick(require(callback));
        }

        public static void onEndServerTick(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onEndServerTick(require(callback));
        }

        public static void onStartLevelTick(Consumer<ServerLevel> callback)
        {
            IEventService.get().onStartLevelTick(require(callback));
        }

        public static void onEndLevelTick(Consumer<ServerLevel> callback)
        {
            IEventService.get().onEndLevelTick(require(callback));
        }

        public static void onPlayerJoin(Consumer<ServerPlayer> callback)
        {
            IEventService.get().onPlayerJoin(require(callback));
        }

        public static void onPlayerDisconnect(Consumer<ServerPlayer> callback)
        {
            IEventService.get().onPlayerDisconnect(require(callback));
        }

        public static void onPlayerRespawn(Consumer<ServerPlayer> callback)
        {
            IEventService.get().onPlayerRespawn(require(callback));
        }

        /**
         * Registers a callback that runs after a server player has entered another dimension.
         */
        public static void onPlayerDimensionChange(PlayerDimensionChangeCallback callback)
        {
            IEventService.get().onPlayerDimensionChange(require(callback));
        }

        public static void onBlockBroken(BlockBreakCallback callback)
        {
            IEventService.get().onBlockBroken(require(callback));
        }

        public static void onLivingDamaged(LivingDamageCallback callback)
        {
            IEventService.get().onLivingDamaged(require(callback));
        }

        public static void onLivingKilled(BiConsumer<LivingEntity, DamageSource> callback)
        {
            IEventService.get().onLivingKilled(require(callback));
        }

        public static void onCommandRegistration(Consumer<CommandDispatcher<CommandSourceStack>> callback)
        {
            IEventService.get().onCommandRegistration(require(callback));
        }

        public static void onDatapackReload(Consumer<MinecraftServer> callback)
        {
            IEventService.get().onDatapackReload(require(callback));
        }

        private static <T> T require(T callback)
        {
            return Objects.requireNonNull(callback, "callback");
        }
    }

    public static class Registrars
    {
        public static final IItemRegistrar ITEMS = load(IItemRegistrar.class);
        public static final IBlockRegistrar BLOCKS = load(IBlockRegistrar.class);
        public static final IEntityRegistrar ENTITIES = load(IEntityRegistrar.class);
        public static final IEntityAttributeRegistrar ENTITIE_ATTRIBUTES = load(IEntityAttributeRegistrar.class);
        public static final ICreativeTabRegistrar CREATIVE_TAB_REGISTRAR = load(ICreativeTabRegistrar.class);
        public static final IConsumeEffectRegistrar CONSUME_EFFECT_REGISTRAR = load(IConsumeEffectRegistrar.class);

        public static final IBlockItemRegistrar BLOCK_ITEMS = new IBlockItemRegistrar() {};
    }
}