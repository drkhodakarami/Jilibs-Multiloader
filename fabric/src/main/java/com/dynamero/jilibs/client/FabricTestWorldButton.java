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

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.contracts.exceptions.Exceptions;
import com.dynamero.jilibs.testworld.client.TestWorldLauncher;
@Developer("TheMentor")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricTestWorldButton
{
    public FabricTestWorldButton()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init() {
        ScreenEvents.AFTER_INIT.register((_, screen, _, _) -> {
            if (!(screen instanceof TitleScreen)) {
                return;
            }

            var widgets = Screens.getWidgets(screen);

            // Check if vanilla already provided a "Create Test World" button (dev environment)
            Button original = widgets.stream()
                                     .filter(Button.class::isInstance)
                                     .map(Button.class::cast)
                                     .filter(TestWorldLauncher::isVanillaTestWorldButton)
                                     .findFirst()
                                     .orElse(null);

            if (original != null) {
                AbstractWidget replacement = TestWorldLauncher.replacementFor(original, screen);
                widgets.remove(original);
                widgets.add(replacement);
                return;
            }

            // Otherwise generate the fallback button in the proper position
            Button fallback = TestWorldLauncher.createFallbackButton(screen, widgets);
            if (fallback != null) {
                widgets.add(fallback);
            }
        });
    }
}