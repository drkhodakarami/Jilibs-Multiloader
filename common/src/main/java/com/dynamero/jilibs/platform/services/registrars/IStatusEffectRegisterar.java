package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.BiFunction;

/**
 * Registers custom status effects for Minecraft.
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
public interface IStatusEffectRegisterar extends IModScopedRegistrar<IStatusEffectRegisterar>
{
    /**
     * Returns an iterable of all MobEffects
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<MobEffect> getList();

    /**
     * Registers a status effect using a factory function.
     *
     * @param name          the name of the status effect
     * @param category      the category of the status effect (e.g., BENEFICIAL, HARMFUL)
     * @param color         the color of the status effect icon
     * @param factory       the factory used to create instances of the status effect
     * @return the registered status effect entry
     */
    Holder<MobEffect> register(String name, MobEffectCategory category, int color,
                                            BiFunction<MobEffectCategory, Integer, MobEffect> factory);
}