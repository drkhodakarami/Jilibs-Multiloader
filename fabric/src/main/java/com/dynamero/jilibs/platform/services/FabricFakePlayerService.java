package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.player.UsefulFakePlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public final class FabricFakePlayerService implements IFakePlayerService
{
    @Override
    public ServerPlayer get(ServerLevel level, GameProfile profile)
    {
        return UsefulFakePlayer.createPlayer(level, profile);
    }
}