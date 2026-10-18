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

import net.minecraft.world.level.block.entity.BlockEntity;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Represents a functional interface for getting a value from a block entity.
 *
 * @param <T> the type of the value to get
 * @param <B> the type of the block entity
 */
@SuppressWarnings("unused")
@FunctionalInterface
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface FieldGetter<T, B extends BlockEntity>
{
    /**
     * Retrieves the value from the specified block entity.
     *
     * @param blockEntity the block entity from which to retrieve the value
     * @return the retrieved value
     */
    T get(B blockEntity);
}