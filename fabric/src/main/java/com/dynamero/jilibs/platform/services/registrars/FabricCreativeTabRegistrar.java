package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.CreativeTabHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.dynamero.jilibs.JilibsConstants.CREATIVE_TAB_PREFIX;
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
public class FabricCreativeTabRegistrar implements ICreativeTabRegistrar
{
    private final String modId;
    private final List<CreativeModeTab> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricCreativeTabRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricCreativeTabRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<CreativeModeTab> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public ICreativeTabRegistrar forMod(String modId)
    {
        return new FabricCreativeTabRegistrar(modId);
    }

    @Override
    public ResourceKey<CreativeModeTab> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.CREATIVE_MODE_TAB);
    }

    @Override
    public CreativeTabHandle<CreativeModeTab> register(String name, String translationKey, Supplier<ItemStack> icon, Consumer<CreativeTabOutput> entries)
    {
        var key = key(name);

        var registered = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, FabricCreativeModeTab.builder()
                .title(Component.translatable(CREATIVE_TAB_PREFIX + "." + this.modId + "." + translationKey))
                .icon(icon)
                .displayItems((_, output) -> entries.accept(output::accept))
                .build());

        this.list.add(registered);

        return new CreativeTabHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<CreativeModeTab> key()
            {
                return key;
            }

            @Override
            public CreativeModeTab get()
            {
                return registered;
            }
        };
    }
}