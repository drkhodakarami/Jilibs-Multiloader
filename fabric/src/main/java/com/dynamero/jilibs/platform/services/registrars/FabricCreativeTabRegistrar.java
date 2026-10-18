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

package com.dynamero.jilibs.platform.services.registrars;

import static com.dynamero.jilibs.JilibsConstants.CREATIVE_TAB_PREFIX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.CreativeTabHandle;
import com.dynamero.jilibs.utils.BaseHelper;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricCreativeTabRegistrar implements ICreativeTabRegistrar
{
    private final String modId;
    private final List<CreativeModeTab> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricCreativeTabRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricCreativeTabRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<CreativeModeTab> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public ICreativeTabRegistrar forMod(String modId)
    {
        return new FabricCreativeTabRegistrar(modId);
    }

    @Override
    public ResourceKey<CreativeModeTab> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.CREATIVE_MODE_TAB);
    }

    @Override
    public CreativeTabHandle<CreativeModeTab> register(String name, String translationKey, Supplier<ItemStack> icon, Consumer<CreativeTabOutput> entries)
    {
        var key = key(name);

        var registered = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, FabricCreativeModeTab.builder()
                .title(Component.translatable(CREATIVE_TAB_PREFIX + "." + this.modId + "." + translationKey))
                .icon(icon)
                .displayItems((_, output) -> entries.accept(output::accept))
                .build());

        this.list.add(registered);

        return new CreativeTabHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<CreativeModeTab> key()
            {
                return key;
            }

            @Override
            public CreativeModeTab get()
            {
                return registered;
            }
        };
    }
}