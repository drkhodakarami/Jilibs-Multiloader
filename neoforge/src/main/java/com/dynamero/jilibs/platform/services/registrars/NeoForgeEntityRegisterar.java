package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.EntityHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class NeoForgeEntityRegisterar implements IEntityRegisterar, INeoForgeRegistrar
{
    private final String modId;
   private final DeferredRegister.Entities entities;

    private boolean registered;

    public NeoForgeEntityRegisterar()
    {
        this.modId = "";
        entities = null;
        registered = false;
    }

    public NeoForgeEntityRegisterar(String modId)
    {
        this.modId = modId;
        entities = DeferredRegister.createEntities(modId);
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        this.entities.register(eventBus);
        registered = true;
    }

    @Override
    public Iterable<? extends EntityType<?>> getList()
    {
        return this.entities.getEntries()
                            .stream()
                            .map(Holder::value)
                            .toList();
    }

    @Override
    public IEntityRegisterar forMod(String modId) {
        return new NeoForgeEntityRegisterar(modId);
    }

    @Override
    public ResourceKey<EntityType<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.ENTITY_TYPE);
    }

    @Override
    public <R extends Entity> EntityHandle<EntityType<R>> register(String name, MobCategory spawnGroup, EntityType.EntityFactory<R> factory)
    {
        var key = key(name);
        var deferred = entities.register(name, () -> EntityType.Builder.of(factory, spawnGroup).build(key));

        return new EntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<EntityType<?>> key()
            {
                return key;
            }

            @Override
            public EntityType<R> get()
            {
                return deferred.get();
            }
        };
    }

    @Override
    public <R extends Entity> EntityHandle<EntityType<R>> register(String name, EntityType.Builder<R> type)
    {
        var key = key(name);
        var deferred = entities.register(name, () -> type.build(key));

        return new EntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<EntityType<?>> key()
            {
                return key;
            }

            @Override
            public EntityType<R> get()
            {
                return deferred.get();
            }
        };
    }
}