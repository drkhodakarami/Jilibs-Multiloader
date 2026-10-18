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

import java.util.Comparator;
import java.util.List;

import net.neoforged.neoforge.client.event.ScreenEvent;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

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
public class NeoForgeTestWorldButton
{
    public NeoForgeTestWorldButton()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init(ScreenEvent.Init.Post event) {
        if (!(event.getScreen() instanceof TitleScreen titleScreen))
            return;

        Button original = event.getListenersList().stream()
                               .filter(Button.class::isInstance)
                               .map(Button.class::cast)
                               .filter(TestWorldLauncher::isVanillaTestWorldButton)
                               .findFirst()
                               .orElse(null);

        if (original == null) {
            var widgets = event.getListenersList().stream()
                               .filter(AbstractWidget.class::isInstance)
                               .map(AbstractWidget.class::cast)
                               .toList();

            Button fallback = TestWorldLauncher.createFallbackButton(titleScreen, widgets);
            if (fallback != null) {
                // Adds as BOTH a listener (input) and a renderable (drawn on screen)
                event.addListener(fallback);
            }
            return;
        }

        // Pass 'true' to also remove it from the renderables list so it stops drawing
        event.removeListener(original);

        // Add the replacement button
        event.addListener(TestWorldLauncher.replacementFor(original, titleScreen));
    }

    private static void addFallbackButton(TitleScreen screen, List<AbstractWidget> widgets) {
        Button realms = findButton(widgets, "menu.online");
        Button options = findButton(widgets, "menu.options");
        if (realms == null || options == null)
            return;

        // Detect the row containing the small icon buttons (between realms and options)
        int smallButtonsY = realms.getY() + 24;
        List<AbstractWidget> smallIconButtons = widgets.stream()
                                                       .filter(w -> w.getY() == smallButtonsY && w.getWidth() == 20)
                                                       .sorted(Comparator.comparingInt(AbstractWidget::getX))
                                                       .toList();

        if (!smallIconButtons.isEmpty()) {
            // Option A: Put Mod Test to the left, icon buttons aligned to the right edge
            int rowRight = realms.getX() + realms.getWidth();
            int totalIconWidth = (smallIconButtons.size() * 20) + ((smallIconButtons.size() - 1) * 4);

            // Shift icon buttons to the right
            int iconStartX = rowRight - totalIconWidth;
            for (int i = 0; i < smallIconButtons.size(); i++) {
                smallIconButtons.get(i).setPosition(iconStartX + i * 24, smallButtonsY);
            }

            // Add Mod Test to the left side of the icons
            int buttonWidth = (iconStartX - 4) - realms.getX();
            widgets.add(TestWorldLauncher.createButton(
                    screen,
                    realms.getX(),
                    smallButtonsY,
                    buttonWidth,
                    20));
        }
    }

    private static Button findButton(List<AbstractWidget> widgets, String translationKey) {
        Component label = Component.translatable(translationKey);
        return widgets.stream()
                      .filter(Button.class::isInstance)
                      .map(Button.class::cast)
                      .filter(button -> button.getMessage().equals(label))
                      .findFirst()
                      .orElse(null);
    }
}