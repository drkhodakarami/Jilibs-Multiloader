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

package com.dynamero.jilibs.platform;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.IFakePlayerService;
import com.dynamero.jilibs.platform.services.IMenuOpener;
import com.dynamero.jilibs.platform.services.IPlatformHelper;
import com.dynamero.jilibs.platform.services.registrars.*;

import java.util.ServiceLoader;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class Services
{
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IFakePlayerService FAKE_PLAYER = load(IFakePlayerService.class);

    public static final IMenuOpener MENU_OPENER = load(IMenuOpener.class);

    public static <T> T load(Class<T> clazz)
    {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                                             .findFirst()
                                             .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        //LOGGER.logC(String.format("Loaded %s for service %s", loadedService, clazz));
        return loadedService;
    }

    public static class Registrars
    {
        public static final IItemRegistrar ITEMS = load(IItemRegistrar.class);
        public static final IBlockRegistrar BLOCKS = load(IBlockRegistrar.class);
        public static final IEntityRegistrar ENTITIES = load(IEntityRegistrar.class);
        public static final IEntityAttributeRegistrar ENTITIE_ATTRIBUTES = load(IEntityAttributeRegistrar.class);
        public static final ICreativeTabRegistrar CREATIVE_TAB_REGISTRAR = load(ICreativeTabRegistrar.class);
        public static final IConsumeEffectRegistrar CONSUME_EFFECT_REGISTRAR = load(IConsumeEffectRegistrar.class);

        public static final IBlockItemRegistrar BLOCK_ITEMS = new IBlockItemRegistrar() {};

        //TODO: Datagen !!
        //TODO: Woodset
        //TODO: Reference ?!

        //TODO: Finish Registrars :
        // - Menu
        // - Recipe
        // - Stats
        // - Status Effect
        // - Client Registrars
        //TODO: Proper Main Calls for inits

        //TODO: Client Menu Service
        //TODO: Menu Service
        //TODO: Menu Opener

        //TODO: Client Network Hooks
        //TODO: Network Service

        //TODO: Useful Fake Player & Helper - Neoforge

        //TODO: Worldgen Service
        //TODO: Worldgen - Ore

        //TODO: Fluid GUI Widget

        //TODO: Inventory
        //TODO: Fluid
        //TODO: Energy
        //TODO: Gas
        //TODO: Heat
        //TODO: Pressure
        //TODO: Dispersion

        //TODO: Machines


        //TODO: Transfer & Pipe Network
        //TODO: Multi-Blocks
    }
}