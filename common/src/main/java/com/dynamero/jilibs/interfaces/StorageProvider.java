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

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;

import com.dynamero.jilibs.constants.enumerations.MappedDirection;
import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Represents an interface for providing storage entities based on direction and facing.
 *
 * @param <T> the type of the storage entity
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
public interface StorageProvider<T>
{
    /**
     * Retrieves a storage provider based on the specified {@link MappedDirection} and facing direction.
     *
     * @param direction  the mapped direction
     * @param facing   the facing direction
     * @return the storage provider, or null if none is found
     */
    @Nullable
    T getStorageProvider(MappedDirection direction, Direction facing);

    /**
     * Retrieves a storage provider based on the specified facing direction.
     *
     * @param direction  the facing direction
     * @param facing   the facing direction
     * @return the storage provider, or null if none is found
     */
    @Nullable
    T getStorageProvider(Direction direction, Direction facing);
}