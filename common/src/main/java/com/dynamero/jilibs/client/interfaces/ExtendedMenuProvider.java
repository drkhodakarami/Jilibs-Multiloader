package com.dynamero.jilibs.client.interfaces;

import com.dynamero.jilibs.client.ExtendedMenuType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;

import com.dynamero.jilibs.contracts.annotations.*;
/**
 * An extension of {@code MenuProvider} that can write additional data to a screen opening packet.
 * This is used for {@linkplain ExtendedMenuType extended menus}.
 *
 * @see ExtendedMenuType usage examples
 */
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface ExtendedMenuProvider<D> extends MenuProvider
{
    /**
     * Writes additional server -&gt; client screen opening data to the buffer.
     *
     * @param player the player that is opening the screen
     * @return the screen opening data
     */
    D getScreenOpeningData(ServerPlayer player);
}