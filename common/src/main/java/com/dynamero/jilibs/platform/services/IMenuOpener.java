package com.dynamero.jilibs.platform.services;

import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import org.jspecify.annotations.Nullable;
import com.dynamero.jilibs.contracts.annotations.*;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IMenuOpener
{
    @Nullable <T extends Entity> MenuProvider createMenuProvider(T entity, int entityId);
}