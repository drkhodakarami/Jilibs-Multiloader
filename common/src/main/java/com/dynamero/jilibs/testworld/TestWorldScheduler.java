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
import net.minecraft.server.level.ServerLevel;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;
@Developer("TheMentor")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public final class TestWorldScheduler {
    private static final Map<ServerLevel, PriorityQueue<ScheduledAction>> ACTIONS = new IdentityHashMap<>();

    private static long nextSequence;

    public static void schedule(TestWorldContext context, long delay, Consumer<TestWorldContext> action) {
        long executionTick = context.overworld().getGameTime() + delay;
        ACTIONS.computeIfAbsent(context.overworld(), _ -> new PriorityQueue<>())
                .add(new ScheduledAction(executionTick, nextSequence++, context, action));
    }

    public static void tick(ServerLevel level) {
        PriorityQueue<ScheduledAction> queue = ACTIONS.get(level);
        if (queue == null)
            return;

        long currentTick = level.getGameTime();
        while (!queue.isEmpty() && queue.peek().executionTick() <= currentTick) {
            ScheduledAction action = queue.remove();
            action.action().accept(action.context());
        }

        if (queue.isEmpty()) {
            ACTIONS.remove(level);
        }
    }

    private record ScheduledAction(
            long executionTick,
            long sequence,
            TestWorldContext context,
            Consumer<TestWorldContext> action
    ) implements Comparable<ScheduledAction> {
        @Override
        public int compareTo(ScheduledAction other) {
            int tickComparison = Long.compare(executionTick, other.executionTick());
            if (tickComparison != 0)
                return tickComparison;

            return Long.compare(sequence, other.sequence());
        }
    }
}