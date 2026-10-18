package com.dynamero.jilibs.platform.services.registrars.utils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
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
public record ModBlock<B extends Block, I extends BlockItem>(BlockHandle<B> block, ItemHandle<I> item)
{}