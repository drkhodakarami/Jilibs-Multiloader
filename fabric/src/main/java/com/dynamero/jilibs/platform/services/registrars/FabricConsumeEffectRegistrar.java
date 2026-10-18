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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.consume_effects.ConsumeEffect;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.ConsumeEffectHandle;
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
public class FabricConsumeEffectRegistrar implements IConsumeEffectRegistrar
{
    private final String modId;
    private final List<ConsumeEffect.Type<?>> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricConsumeEffectRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricConsumeEffectRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<ConsumeEffect.Type<?>> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IConsumeEffectRegistrar forMod(String modId)
    {
        return new FabricConsumeEffectRegistrar(modId);
    }

    @Override
    public ResourceKey<ConsumeEffect.Type<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.CONSUME_EFFECT_TYPE);
    }

    @Override
    public <T extends ConsumeEffect> ConsumeEffectHandle<ConsumeEffect.Type<T>> register(String name, MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec)
    {
        var key = key(name);

        var registered = Registry.register(BuiltInRegistries.CONSUME_EFFECT_TYPE, key,
                                           new ConsumeEffect.Type<>(codec, streamCodec));

        this.list.add(registered);

        return new ConsumeEffectHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<ConsumeEffect.Type<?>> key()
            {
                return key;
            }

            @Override
            public ConsumeEffect.Type<T> get()
            {
                return registered;
            }
        };
    }
}