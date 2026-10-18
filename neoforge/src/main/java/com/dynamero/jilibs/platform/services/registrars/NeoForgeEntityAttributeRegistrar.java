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
import java.util.List;
import java.util.function.Supplier;

import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.AttributeEntry;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class NeoForgeEntityAttributeRegistrar implements IEntityAttributeRegistrar, INeoForgeRegistrar
{
    private final String modId;
    private final List<AttributeEntry<?>> attributes = new ArrayList<>();

    private boolean registered;

    public NeoForgeEntityAttributeRegistrar()
    {
        this.modId = "";
        registered = false;
    }

    public NeoForgeEntityAttributeRegistrar(String modId)
    {
        this.modId = modId;
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        //NOOP
        registered = true;
    }

    @Override
    public Iterable<AttributeEntry<?>> getList()
    {
        return this.attributes;
    }

    @Override
    public IEntityAttributeRegistrar forMod(String modId) {
        return new NeoForgeEntityAttributeRegistrar(modId);
    }

    @Override
    public <T extends LivingEntity> void register(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier)
    {
        this.attributes.add(new AttributeEntry<>(entityTypeSupplier, builderSupplier));
    }

    @Override
    public void applyEntityAttributeRegistrations(EntityAttributeRegistrar registrar)
    {
        for (var attribute : this.attributes)
            attribute.register(registrar);
    }
}