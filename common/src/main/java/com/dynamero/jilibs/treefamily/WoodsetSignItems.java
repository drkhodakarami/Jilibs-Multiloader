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

package com.dynamero.jilibs.treefamily;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.IItemRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.ItemHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;

/**
 * Container and registry holder for sign and hanging sign items within a {@link TreeFamilyBuilder}.
 *
 * @param sign Registered sign item instance.
 * @param hangingSign Registered hanging sign item instance.
 */
@SuppressWarnings("unused")
@Developer("TurtyWurty")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-08")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public record WoodsetSignItems (ItemHandle<StandingAndWallBlockItem> sign, ItemHandle<HangingSignItem> hangingSign)
{

    /**
     * Constructs and registers sign and hanging sign items for a wood set.
     *
     * @param modid           the mod identifier
     * @param name            the base wood name
     * @param itemRegister    the item registerer helper
     * @param sign            the standing sign block
     * @param wallSign        the wall sign block
     * @param hangingSign     the ceiling hanging sign block
     * @param wallHangingSign the wall hanging sign block
     */
    public static <S extends BlockHandle<StandingSignBlock>, W extends BlockHandle<WallSignBlock>,
            C extends BlockHandle<CeilingHangingSignBlock>, H extends BlockHandle<WallHangingSignBlock>,
            SI extends StandingAndWallBlockItem, HI extends HangingSignItem>
        WoodsetSignItems build(String modid, String name,
                            IItemRegistrar itemRegister,
                            S sign,
                            W wallSign,
                            C hangingSign,
                            H wallHangingSign)
    {
        var signItemId = BaseHelper.ResourceKeys.create(modid, name + "_sign", Registries.ITEM);
        var hangingSignItemId = BaseHelper.ResourceKeys.create(modid, name + "_hanging_sign", Registries.ITEM);

        var signItem = itemRegister
                .register(name + "_sign",
                          settings -> new StandingAndWallBlockItem(sign.get(),
                                                                   wallSign.get(),
                                                                   Direction.DOWN,
                                                                   settings.stacksTo(16)));

        var hangingSignItem = itemRegister
                .register(name + "_hanging_sign",
                          settings ->
                                  new HangingSignItem(hangingSign.get(), wallHangingSign.get(), settings.stacksTo(16)));

        return new WoodsetSignItems(signItem, hangingSignItem);
    }
}