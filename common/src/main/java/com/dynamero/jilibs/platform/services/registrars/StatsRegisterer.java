package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

/**
 * Provides utility methods for registering custom game statistics in Minecraft.
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
public class StatsRegisterer
{
    /**
     * The unique identifier for the mod.
     */
    private final String modId;

    /**
     * Constructs a new instance of StatsRegisterer with the specified mod ID.
     *
     * @param modId the mod ID
     */
    public StatsRegisterer(String modId)
    {
        this.modId = modId;
    }

    /**
     * Registers a custom statistic using the default number formatter.
     *
     * @param key the unique key of the statistic
     * @return the registered custom statistic instance
     */
    public Stat<?> register(String key)
    {
        return register(key, StatFormatter.DEFAULT);
    }

    /**
     * Registers a custom statistic with a specified statistic formatter.
     *
     * @param key       the unique key of the statistic
     * @param formatter the formatter used for rendering the statistic value
     * @return the registered custom statistic instance
     */
    public Stat<?> register(String key, StatFormatter formatter)
    {
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, key,
                                               BaseHelper.id(this.modId, key));
        return Stats.CUSTOM.get(newStat, formatter);
    }
}