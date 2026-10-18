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

package com.dynamero.jilibs.client;

import com.dynamero.jilibs.contracts.annotations.*;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.Level;

/**
 * Base block entity render state (BERS) storing the level context, item render state,
 * and display entity render state.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class BaseBERS extends BlockEntityRenderState
{
    /**
     * The default constructor for the class
     */
    public BaseBERS()
    {
    }

    /**
     * The Minecraft level in which the block entity exists.
     */
    public Level world;

    /**
     * Render state for items displayed by the block entity.
     */
    public ItemStackRenderState itemRenderState = new ItemStackRenderState();

    /**
     * Render state for entities displayed by the block entity.
     */
    public EntityRenderState displayEntityRenderState = new EntityRenderState();
}