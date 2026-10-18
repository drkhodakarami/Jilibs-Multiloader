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
public class DigitalIndicatorTextures
{
    public static class Normal
    {
        public static class Background
        {
            public static final TextureData DARK =
                    new TextureData(0, 0, 0, 0, 16, 64, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_background_dark.png"));
            public static final TextureData RED =
                    new TextureData(0, 0, 0, 0, 16, 64, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_background_red.png"));
        }

        public static class Progress
        {
            public static final TextureData CYAN =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_cyan.png"));
            public static final TextureData DARK_GREEN =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_dark_green.png"));
            public static final TextureData GRADIANT =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_gradiant.png"));
            public static final TextureData LIME =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_lime.png"));
            public static final TextureData RED =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_red.png"));
            public static final TextureData YELLOW =
                    new TextureData(1, 1, 0, 0, 14, 62, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/main_bar_yellow.png"));
        }
    }

    public static class Small
    {
        public static final TextureData BACKGROUND =
                new TextureData(0, 0, 0, 0, 11, 41, 16, 64,
                                BaseHelper.id("jilibs_gui", "textures/gui/widget/small_energy_dark_background.png"));

        public static class Progress
        {
            public static final TextureData BLUE =
                    new TextureData(0, 1, 0, 0, 11, 39, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/small_energy_dark_blue.png"));
            public static final TextureData RED =
                    new TextureData(0, 1, 0, 0, 11, 39, 16, 64,
                                    BaseHelper.id("jilibs_gui", "textures/gui/widget/small_energy_dark_red.png"));
        }
    }
}