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

import java.util.function.BiFunction;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;

/**
 * Registers custom status effects for Minecraft.
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
public interface IStatusEffectRegistrar extends IModScopedRegistrar<IStatusEffectRegistrar>
{
    /**
     * Returns an iterable of all MobEffects
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<MobEffect> getList();

    /**
     * Registers a status effect using a factory function.
     *
     * @param name          the name of the status effect
     * @param category      the category of the status effect (e.g., BENEFICIAL, HARMFUL)
     * @param color         the color of the status effect icon
     * @param factory       the factory used to create instances of the status effect
     * @return the registered status effect entry
     */
    Holder<MobEffect> register(String name, MobEffectCategory category, int color,
                                            BiFunction<MobEffectCategory, Integer, MobEffect> factory);
}