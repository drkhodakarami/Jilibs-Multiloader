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

package com.dynamero.jilibs.client.gui.constants;

import net.minecraft.client.renderer.Rect2i;

import com.dynamero.jilibs.client.gui.records.TextureData;
import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.utils.BaseHelper;
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
public class FluidContainerTextures
{
    public static class Normal
    {
        public static final TextureData BACKGROUND =
                new TextureData(0, 0, 0, 0, 18, 63, 32, 64,
                                BaseHelper.id("jilibs_gui", "textures/gui/widget/fluid_storage_background.png"));
        public static final TextureData MARKER_BIG =
                new TextureData(1, 15, 0, 0, 16, 33, 16, 64,
                                BaseHelper.id("jilibs_gui", "textures/gui/widget/fluid_storage_marker_big.png"));
        public static final TextureData MARKER_SMALL =
                new TextureData(1, 6, 0, 0, 16, 51, 16, 64,
                                BaseHelper.id("jilibs_gui", "textures/gui/widget/fluid_storage_marker_small.png"));

        public static final Rect2i FLUID_RECT = new Rect2i(1, 1, 16, 62);
    }
}