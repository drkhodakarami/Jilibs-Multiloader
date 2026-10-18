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

package com.dynamero.jilibs.client.gui.utils;

import com.dynamero.jilibs.contracts.annotations.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jspecify.annotations.Nullable;


@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-08")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FluidRenderUtils
{
    private FluidRenderUtils() {
    }

    public static @Nullable GuiFluidRenderData getRenderData(Fluid fluid, @Nullable Level level, @Nullable BlockPos pos) {
        if (fluid == null || fluid == Fluids.EMPTY)
            return null;

        FluidState fluidState = fluid.defaultFluidState();
        FluidModel model = Minecraft.getInstance().getModelManager().getFluidStateModelSet().get(fluidState);
        BlockState blockState = fluidState.createLegacyBlock();
        int tintColor = getTintColor(model.tintSource(), blockState, level, pos);
        return new GuiFluidRenderData(model.stillMaterial().sprite(), tintColor);
    }

    public static @Nullable GuiFluidRenderData getRenderData(@Nullable FluidVariant fluidVariant, @Nullable Level level, @Nullable BlockPos pos) {
        if (fluidVariant == null || fluidVariant.isBlank())
            return null;

        return getRenderData(fluidVariant.getFluid(), level, pos);
    }

    private static int getTintColor(@Nullable BlockTintSource tintSource, BlockState blockState, @Nullable Level level, @Nullable BlockPos pos) {
        if (tintSource == null)
            return 0xFFFFFFFF;

        int tintColor;
        if (level instanceof BlockAndTintGetter blockAndTintGetter && pos != null) {
            tintColor = tintSource.colorInWorld(blockState, blockAndTintGetter, pos);
        } else {
            tintColor = tintSource.color(blockState);
        }

        return 0xFF000000 | (tintColor & 0xFFFFFF);
    }


}