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
import com.dynamero.jilibs.constants.enumerations.MappedDirection;
import net.minecraft.core.Direction;

import java.util.List;
import java.util.Map;

/**
 * Represents an interface for managing storage entities.
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
public interface StorageHandler<T>
{
    /**
     * Adds a storage entity to this handler.
     *
     * @param storage the storage entity to add
     */
    void addStorage(T storage);

    /**
     * Adds a storage entity to this handler in a specific direction using {@link MappedDirection}.
     *
     * @param storage  the storage entity to add
     * @param direction the direction of the connection
     */
    void addStorage(T storage, MappedDirection direction);

    /**
     * Adds a storage entity to this handler in a specific direction.
     *
     * @param storage  the storage entity to add
     * @param direction the direction of the connection
     */
    void addStorage(T storage, Direction direction);

    /**
     * Retrieves all storage entities managed by this handler.
     *
     * @return a list of all storage entities
     */
    List<T> getStorages();

    /**
     * Retrieves a map of storage entities indexed by their {@link MappedDirection}.
     *
     * @return a map of storage entities
     */
    Map<MappedDirection, T> getSidedMap();

    /**
     * Retrieves the storage entity associated with a specific side using {@link MappedDirection}.
     *
     * @param side the side to retrieve the storage for
     * @return the storage entity associated with the given side
     */
    T getStorage(MappedDirection side);

    /**
     * Retrieves the storage entity associated with a specific direction.
     *
     * @param side the direction of the connection
     * @return the storage entity associated with the given direction
     */
    T getStorage(Direction side);

    /**
     * Retrieves the storage entity at a specified index in the list of managed storages.
     *
     * @param index the index of the storage to retrieve
     * @return the storage entity at the given index
     */
    T getStorage(int index);
}