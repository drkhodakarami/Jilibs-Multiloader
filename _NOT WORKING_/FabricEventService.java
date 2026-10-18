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

package com.dynamero.jilibs.events;

import com.dynamero.jilibs.contracts.annotations.*;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Developer("TurtyWurty")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-10")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricEventService implements IEventService
{
    public FabricEventService()
    {
    }

    @Override
    public void onServerStarting(Consumer<MinecraftServer> callback)
    {
        ServerLifecycleEvents.SERVER_STARTING.register(require(callback)::accept);
    }

    @Override
    public void onServerStarted(Consumer<MinecraftServer> callback)
    {
        ServerLifecycleEvents.SERVER_STARTED.register(require(callback)::accept);
    }

    @Override
    public void onServerStopping(Consumer<MinecraftServer> callback)
    {
        ServerLifecycleEvents.SERVER_STOPPING.register(require(callback)::accept);
    }

    @Override
    public void onServerStopped(Consumer<MinecraftServer> callback)
    {
        ServerLifecycleEvents.SERVER_STOPPED.register(require(callback)::accept);
    }

    @Override
    public void onLevelLoad(Consumer<ServerLevel> callback)
    {
        ServerLevelEvents.LOAD.register((server, level) -> require(callback).accept(level));
    }

    @Override
    public void onLevelUnload(Consumer<ServerLevel> callback)
    {
        ServerLevelEvents.UNLOAD.register((server, level) -> require(callback).accept(level));
    }

    @Override
    public void onStartServerTick(Consumer<MinecraftServer> callback)
    {
        ServerTickEvents.START_SERVER_TICK.register(require(callback)::accept);
    }

    @Override
    public void onEndServerTick(Consumer<MinecraftServer> callback)
    {
        ServerTickEvents.END_SERVER_TICK.register(require(callback)::accept);
    }

    @Override
    public void onStartLevelTick(Consumer<ServerLevel> callback)
    {
        ServerTickEvents.START_LEVEL_TICK.register(require(callback)::accept);
    }

    @Override
    public void onEndLevelTick(Consumer<ServerLevel> callback)
    {
        ServerTickEvents.END_LEVEL_TICK.register(require(callback)::accept);
    }

    @Override
    public void onPlayerJoin(Consumer<ServerPlayer> callback)
    {
        ServerPlayerEvents.JOIN.register(require(callback)::accept);
    }

    @Override
    public void onPlayerDisconnect(Consumer<ServerPlayer> callback)
    {
        ServerPlayerEvents.LEAVE.register(require(callback)::accept);
    }

    @Override
    public void onPlayerRespawn(Consumer<ServerPlayer> callback)
    {
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) ->
                                                          require(callback).accept(newPlayer)
        );
    }

    @Override
    public void onPlayerDimensionChange(PlayerDimensionChangeCallback callback)
    {
        require(callback);
        ServerEntityLevelChangeEvents.AFTER_PLAYER_CHANGE_LEVEL.register(callback::afterDimensionChange);
    }

    @Override
    public void onBlockBroken(BlockBreakCallback callback)
    {
        require(callback);
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {
            if (level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer)
                callback.afterBlockBreak(serverLevel, serverPlayer, pos, state, blockEntity);
        });
    }

    @Override
    public void onLivingDamaged(LivingDamageCallback callback)
    {
        require(callback);
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, damageTaken, blocked) ->
                                                               callback.afterDamage(entity, source, damageTaken)
        );
    }

    @Override
    public void onLivingKilled(BiConsumer<LivingEntity, DamageSource> callback)
    {
        ServerLivingEntityEvents.AFTER_DEATH.register(require(callback)::accept);
    }

    @Override
    public void onCommandRegistration(Consumer<CommandDispatcher<CommandSourceStack>> callback)
    {
        CommandRegistrationCallback.EVENT.register((dispatcher, context, selection) ->
                                                           require(callback).accept(dispatcher)
        );
    }

    @Override
    public void onDatapackReload(Consumer<MinecraftServer> callback)
    {
        ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, manager, success) -> {
            if (success)
                require(callback).accept(server);
        });
    }

    private static <T> T require(T callback)
    {
        return Objects.requireNonNull(callback, "callback");
    }
}