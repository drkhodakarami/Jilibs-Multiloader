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

package com.dynamero.jilibs.client.events;

import java.util.Objects;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jspecify.annotations.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.LevelRenderState;

import com.dynamero.jilibs.contracts.annotations.*;

/**
 * Vanilla-only view of the current level rendering callback.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-10")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public record LevelRenderContext(
    Minecraft client,
    ClientLevel level,
    GameRenderer gameRenderer,
    LevelRenderer levelRenderer,
    LevelRenderState levelState,
    PoseStack poseStack,
    //MultiBufferSource.BufferSource bufferSource,
    @Nullable SubmitNodeCollector submitNodeCollector
) {
    public LevelRenderContext {
        Objects.requireNonNull(client, "client");
        Objects.requireNonNull(level, "level");
        Objects.requireNonNull(gameRenderer, "gameRenderer");
        Objects.requireNonNull(levelRenderer, "levelRenderer");
        Objects.requireNonNull(levelState, "levelState");
        Objects.requireNonNull(poseStack, "poseStack");
        //Objects.requireNonNull(bufferSource, "bufferSource");
    }
}