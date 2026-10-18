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

package com.dynamero.jilibs.testworld;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.events.Events;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.clock.ServerClockManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.LevelData;
@SuppressWarnings("resource")
@Developer("TheMentor")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public final class TestWorld
{
    public static final String WORLD_ID = "Jilibs Test World";

    private TestWorld() {
    }

    /**
     * Should be called from mod init or even better from mod's event init
     * Example
     * <pre><code>
     * public class SomeGenerator implements TestWorldGenerator
     * {
     *     void generate(TestWorldContext context)
     *     {
     *         TestWorldContext energyGenContext = context.at(0, 0, 5);
     *         energyGenContext.setBlock(-1, 0, 0, ModBlocks.SOME_BLOCK);
     *         energyGenContext.setBlock(0, 0, 0, ModBlocks.SOME_BLOCK);
     *         energyGenContext.setBlock(1, 0, 0, ModBlocks.SOME_BLOCK);
     *     }
     * }
     *
     * public class MainMod
     * {
     *     public static void onInitialize()
     *     {
     *          ModEventHandlers.init();
     *     }
     * }
     *
     * public class ModEventHandlers
     * {
     *     public static void init()
     *     {
     *          Jilibs.setTestWorldGenerator(new SomeGenerator());
     *     }
     * }
     *
     * </code></pre>
     * @param generator The new instance of a class implementing TestWorldGenerator
     */
    public static void init(TestWorldGemerator generator)
    {
        Events.onServerStarted(server ->
        {
            if (!isTestWorld(server))
                return;

            ServerLevel overworld = server.overworld();
            int spawnY = overworld.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0);
            var context = new TestWorldContext(server, overworld, new BlockPos(0, spawnY, 0));

            configureWorld(context);
            generator.generate(context);
        });

        Events.onEndLevelTick(TestWorldScheduler::tick);
    }

    private static void configureWorld(TestWorldContext context)
    {
        context.overworld().setRespawnData(LevelData.RespawnData.of(
                Level.OVERWORLD,
                context.origin(),
                0.0F,
                0.0F
        ));

        context.overworld().getGameRules().set(GameRules.RESPAWN_RADIUS, 0, context.server());
        context.overworld().getGameRules().set(GameRules.SPAWN_MOBS, false, context.server());
        context.overworld().getGameRules().set(GameRules.ADVANCE_TIME, false, context.server());
        context.overworld().getGameRules().set(GameRules.ADVANCE_WEATHER, false, context.server());

        ServerClockManager clockManager = context.server().clockManager();
        clockManager.setTotalTicks(context.overworld().dimensionTypeRegistration().value().defaultClock().orElseThrow(), 6000L);
    }

    private static boolean isTestWorld(MinecraftServer server)
    {
        return WORLD_ID.equals(server.getWorldData().getLevelName());
    }
}