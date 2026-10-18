package com.dynamero.jilibs;

import com.dynamero.jilibs.client.FabricTestWorldButton;
import com.dynamero.jilibs.contracts.annotations.*;
import net.fabricmc.api.ClientModInitializer;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class JilibsFabricMainClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        FabricTestWorldButton.init();
        JilibsCommonClient.init();
    }
}