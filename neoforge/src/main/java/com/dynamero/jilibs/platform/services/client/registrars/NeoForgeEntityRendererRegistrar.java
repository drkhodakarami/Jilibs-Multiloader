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

package com.dynamero.jilibs.platform.services.client.registrars;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class NeoForgeEntityRendererRegistrar implements IEntityRendererRegistrar
{
    private final List<EntityRendererEntry<?>> entityRenderers = new ArrayList<>();
    private final List<ModelLayerEntry> modelLayers = new ArrayList<>();

    @Override
    public <T extends Entity> void register(EntityType<T> entityType, EntityRendererProvider<T> provider)
    {
        this.entityRenderers.add(new EntityRendererEntry<>(entityType, provider));
    }

    @Override
    public void registerModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier)
    {
        this.modelLayers.add(new ModelLayerEntry(location, supplier));
    }

    @Override
    public void applyEntityRendererRegistrations(EntityRendererRegistrar registrar)
    {
        for (EntityRendererEntry<?> renderer : this.entityRenderers)
            renderer.register(registrar);
    }

    @Override
    public void applyModelLayerRegistrations(ModelLayerRegistrar registrar)
    {
        for (ModelLayerEntry layer : this.modelLayers)
            layer.register(registrar);
    }

    private record EntityRendererEntry<T extends Entity>(EntityType<T> entityType, EntityRendererProvider<T> provider)
    {
        private void register(EntityRendererRegistrar registrar)
        {
            registrar.register(this.entityType, this.provider);
        }
    }

    private record ModelLayerEntry(ModelLayerLocation location, Supplier<LayerDefinition> supplier)
    {
        private void register(ModelLayerRegistrar registrar)
        {
            registrar.register(this.location, this.supplier);
        }
    }
}