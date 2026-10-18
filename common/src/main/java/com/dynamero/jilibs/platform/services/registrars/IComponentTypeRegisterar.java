package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import net.minecraft.core.component.DataComponentType;

import java.util.function.UnaryOperator;

/**
 * Registers custom component types for Minecraft data.
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
public interface IComponentTypeRegisterar extends IModScopedRegistrar<IComponentTypeRegisterar>
{
    /**
     * Returns an iterable of all data component types
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<DataComponentType<?>> getList();

    /**
     * Registers a new component type.
     *
     * @param <R>           the type of the component
     * @param name          the name of the component type
     * @param buildOperator an operator that builds the component type
     * @return the registered component type
     */
    <R> DataComponentType<R> register(String name, UnaryOperator<DataComponentType.Builder<R>> buildOperator);
}