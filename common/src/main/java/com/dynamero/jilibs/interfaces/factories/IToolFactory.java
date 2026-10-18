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

import net.minecraft.world.item.ToolMaterial;

import com.dynamero.jilibs.contracts.annotations.*;
/**
 * Represents a factory interface for creating tool instances from materials and settings.
 *
 * @param <U> the type of the additional settings required to create the tool
 * @param <R> the type of the created tool instance
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
public interface IToolFactory<U, R>
{
    /**
     * Applies the factory to create a tool from a material, damage stat, speed stat, and additional settings.
     *
     * @param material The material of the tool.
     * @param damage The base damage stat of the tool.
     * @param speed The attack speed stat of the tool.
     * @param settings Additional settings required to create the tool.
     * @return The created tool instance.
     */
    R apply(ToolMaterial material, Float damage, float speed, U settings);
}