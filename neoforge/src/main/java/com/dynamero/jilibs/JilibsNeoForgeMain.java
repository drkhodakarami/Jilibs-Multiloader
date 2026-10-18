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

package com.dynamero.jilibs;

import com.dynamero.jilibs.platform.services.NeoForgeFlammableService;
import com.dynamero.jilibs.platform.services.registrars.NeoForgeStrippableRegistrar;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.SharedConstants;

import com.dynamero.jilibs.contracts.annotations.*;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

//@Mod(JilibsConstants.MOD_ID)
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class JilibsNeoForgeMain
{
    public JilibsNeoForgeMain(IEventBus eventBus)
    {
        SharedConstants.IS_RUNNING_IN_IDE = false;

        JilibsCommonMain.init();

        eventBus.addListener((FMLCommonSetupEvent event) -> event.enqueueWork(() -> {
            NeoForgeFlammableService.apply();
            NeoForgeStrippableRegistrar.apply();
        }));
    }
}