package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.ConsumeEffectHandle;
import com.dynamero.jilibs.utils.BaseHelper;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.consume_effects.ConsumeEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricConsumeEffectRegistrar implements IConsumeEffectRegistrar
{
    private final String modId;
    private final List<ConsumeEffect.Type<?>> list = new ArrayList<>();

    // Required by ServiceLoader
    public FabricConsumeEffectRegistrar()
    {
        this("");
    }

    // Scoped instance
    public FabricConsumeEffectRegistrar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<ConsumeEffect.Type<?>> getList() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public IConsumeEffectRegistrar forMod(String modId)
    {
        return new FabricConsumeEffectRegistrar(modId);
    }

    @Override
    public ResourceKey<ConsumeEffect.Type<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.CONSUME_EFFECT_TYPE);
    }

    @Override
    public <T extends ConsumeEffect> ConsumeEffectHandle<ConsumeEffect.Type<T>> register(String name, MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec)
    {
        var key = key(name);

        var registered = Registry.register(BuiltInRegistries.CONSUME_EFFECT_TYPE, key,
                                           new ConsumeEffect.Type<>(codec, streamCodec));

        this.list.add(registered);

        return new ConsumeEffectHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<ConsumeEffect.Type<?>> key()
            {
                return key;
            }

            @Override
            public ConsumeEffect.Type<T> get()
            {
                return registered;
            }
        };
    }
}