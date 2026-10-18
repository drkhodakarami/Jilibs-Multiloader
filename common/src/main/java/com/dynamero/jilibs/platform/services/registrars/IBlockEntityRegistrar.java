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

package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.BlockEntityFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockEntityHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;

/**
 * Registers custom block entities and entity types for Minecraft.
 */
@SuppressWarnings("unchecked")
@Developer("TheMentor")
@CreatedAt("2026-10-16")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IBlockEntityRegistrar extends IModScopedRegistrar<IBlockEntityRegistrar>
{
    /**
     * Returns an iterable of all EntityTypes
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<? extends BlockEntityType<?>> getList();

    ResourceKey<BlockEntityType<?>> key(String name);

    <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(
            String name,
            BlockEntityFactory<T> factory,
            BlockHandle<? extends Block>... validBlocks
    );

    <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(
            String name,
            BlockEntityFactory<T> factory,
            List<BlockHandle<? extends Block>> validBlocks
    );
}