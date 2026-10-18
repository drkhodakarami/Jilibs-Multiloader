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

import java.util.function.UnaryOperator;

import net.minecraft.core.component.DataComponentType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;

/**
 * Registers custom component types for Minecraft data.
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
public interface IComponentTypeRegistrar extends IModScopedRegistrar<IComponentTypeRegistrar>
{
    /**
     * Returns an iterable of all data component types
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<DataComponentType<?>> getList();

    /**
     * Registers a new component type.
     *
     * @param <R>           the type of the component
     * @param name          the name of the component type
     * @param buildOperator an operator that builds the component type
     * @return the registered component type
     */
    <R> DataComponentType<R> register(String name, UnaryOperator<DataComponentType.Builder<R>> buildOperator);
}