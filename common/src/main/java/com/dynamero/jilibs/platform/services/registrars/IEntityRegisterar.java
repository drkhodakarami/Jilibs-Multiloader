package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.EntityHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * Registers custom block entities and entity types for Minecraft.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-16")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IEntityRegisterar extends IModScopedRegistrar<IEntityRegisterar>
{
    /**
     * Returns an iterable of all EntityTypes
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<? extends EntityType<?>> getList();

    ResourceKey<EntityType<?>> key(String name);

    /**
     * Registers a new block entity type.
     *
     * @param <R>             the type of the block entity
     * @param name            the name of the block entity type
     * @param block           the block associated with the block entity
     * @param factory         the factory used to create instances of the block entity
     * @return the registered block entity type
     */
    //<R extends BlockEntity> BlockEntityType<R> register(String name, Block block, FabricBlockEntityTypeBuilder.Factory<R> factory);

    /**
     * Registers a new entity type.
     *
     * @param <R>             the type of the entity
     * @param name            the name of the entity type
     * @param spawnGroup      the spawn group for the entity
     * @param factory         the factory used to create instances of the entity
     * @return the registered entity type
     */
    <R extends Entity> EntityHandle<EntityType<R>> register(String name, MobCategory spawnGroup, EntityType.EntityFactory<R> factory);

    /**
     * Registers a new entity type.
     *
     * @param <R>             the type of the entity
     * @param name            the name of the entity type
     * @param type            the entity type builder used to create instances of the entity
     * @return the registered entity type
     */
    <R extends Entity> EntityHandle<EntityType<R>> register(String name, EntityType.Builder<R> type);
}