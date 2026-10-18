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

import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.contracts.records.AttributeEntry;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IEntityAttributeRegistrar extends IModScopedRegistrar<IEntityAttributeRegistrar>
{
    /**
     * Returns an iterable of all LivingEntities
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<AttributeEntry<?>> getList();

    <T extends LivingEntity> void register(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier);

    void applyEntityAttributeRegistrations(EntityAttributeRegistrar registrar);

    interface EntityAttributeRegistrar
    {
        <T extends LivingEntity> void register(EntityType<T> entityType, AttributeSupplier.Builder builder);
    }
}