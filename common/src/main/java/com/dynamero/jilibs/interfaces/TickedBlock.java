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

package com.dynamero.jilibs.interfaces;

import com.dynamero.jilibs.contracts.annotations.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface TickedBlock
{
    String TICK_PROPERTY_NAME = "tick_level";
    IntegerProperty TICK_LEVEL = IntegerProperty.create(TICK_PROPERTY_NAME, 0, 20);

    default BlockState withRandomTick(BlockPlaceContext ctx, BlockState superState, Block block, int propertyMin, int propertyMax)
    {
        BlockState state = superState == null ? block.defaultBlockState() : superState;
        return state.setValue(TICK_LEVEL, ctx.getLevel().getRandom().nextIntBetweenInclusive(propertyMin + 1, propertyMax));
    }

    default void tickBlock(BlockState state, ServerLevel world, BlockPos pos, RandomSource random)
    {
        if(random.nextInt(10) == 0)
            world.setBlockAndUpdate(pos, state.setValue(TICK_LEVEL, state.getValue(TICK_LEVEL) - 1));
    }
}