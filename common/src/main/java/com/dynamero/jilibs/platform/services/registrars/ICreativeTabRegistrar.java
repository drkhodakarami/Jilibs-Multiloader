package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.CreativeTabHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;
import java.util.function.Supplier;
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
public interface ICreativeTabRegistrar extends IModScopedRegistrar<ICreativeTabRegistrar>
{
    /**
     * Returns an iterable of all CreativeModeTabs
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<CreativeModeTab> getList();

    ResourceKey<CreativeModeTab> key(String name);

    CreativeTabHandle<CreativeModeTab> register(String name, String translationKey, Supplier<ItemStack> icon, Consumer<CreativeTabOutput> entries);

    @FunctionalInterface
    interface CreativeTabOutput
    {
        void accept(ItemLike itemLike);
    }
}