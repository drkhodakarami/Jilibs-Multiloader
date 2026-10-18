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

package com.dynamero.jilibs.interfaces.factories;

import net.minecraft.world.level.block.Block;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Represents a factory interface for creating item instances from blocks.
 *
 * @param <U> the type of the additional settings required to create the item
 * @param <R> the type of the created item instance
 */
@Developer("TheMentor")
@CreatedAt("2026-10-16")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IBlockItemFactory<U, R>
{
    /**
     * Applies the factory to create an item from a block and additional settings.
     *
     * @param block The block to create an item for.
     * @param settings Additional settings required to create the item.
     * @return The created item instance.
     */
    R apply(Block block, U settings);
}