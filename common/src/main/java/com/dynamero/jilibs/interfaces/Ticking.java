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

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Represents an interface for entities that can be ticked.
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
public interface Ticking
{
    /**
     * Called on the server side to perform the entity's tick logic.
     */
    void tick();

    /**
     * Called on the client side to perform any client-specific tick logic (default implementation does nothing).
     */
    default void tickClient(){}

    /**
     * Creates a ticker for a given world that will call the appropriate tick method based on whether it is the server or client.
     *
     * @param <T> the type of the block entity
     * @param world the world containing the block entity
     * @return a BlockEntityTicker that will handle ticking the entity
     */
    static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level world)
    {
        return !world.isClientSide()
            ? (pworld, pos, state, entity) -> ((Ticking) entity).tick()
            : (pworld, pos, state, entity) -> ((Ticking) entity).tickClient();
    }

    /**
     * Retrieves the block state of the entity's position in the world.
     *
     * @param world the world containing the entity
     * @param pos   the position of the entity
     * @return the block state at the given position, or null if the world is null
     */
    default BlockState getState(Level world, BlockPos pos)
    {
        return world != null ? world.getBlockState(pos) : null;
    }
}