package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.EntityHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricEntityRegisterar implements IEntityRegisterar
{
    private final String modId;
    private final List<EntityType<?>> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricEntityRegisterar()
    {
        this("");
    }

    // Scoped instance
    public FabricEntityRegisterar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<EntityType<?>> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IEntityRegisterar forMod(String modId)
    {
        return new FabricEntityRegisterar(modId);
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
        var entityType = EntityType.Builder.of(factory, spawnGroup).build(key);
        var registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityType);

        this.list.add(registered);

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
                return registered;
            }
        };
    }

    @Override
    public <R extends Entity> EntityHandle<EntityType<R>> register(String name, EntityType.Builder<R> type)
    {
        var key = key(name);
        var registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, key, type.build(key));

        this.list.add(registered);

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
                return registered;
            }
        };
    }
}