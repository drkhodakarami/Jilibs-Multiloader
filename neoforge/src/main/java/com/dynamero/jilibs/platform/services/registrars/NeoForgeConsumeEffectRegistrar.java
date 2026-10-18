package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.ConsumeEffectHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import com.dynamero.jilibs.utils.BaseHelper;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class NeoForgeConsumeEffectRegistrar implements IConsumeEffectRegistrar, INeoForgeRegistrar
{
    private final String modId;
    private final DeferredRegister<ConsumeEffect.Type<?>> effects;

    private boolean registered;

    public NeoForgeConsumeEffectRegistrar()
    {
        this.modId = "";
        effects = null;
    }

    public NeoForgeConsumeEffectRegistrar(String modId)
    {
        this.modId = modId;
        effects = DeferredRegister.create(Registries.CONSUME_EFFECT_TYPE, modId);
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        this.effects.register(eventBus);
        registered = true;
    }

    @Override
    public Iterable<? extends ConsumeEffect.Type<?>> getList()
    {
        return this.effects.getEntries()
                           .stream()
                           .map(Holder::value)
                           .toList();
    }

    @Override
    public IConsumeEffectRegistrar forMod(String modId) {
        return new NeoForgeConsumeEffectRegistrar(modId);
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

        var deferred = effects.register(name, () -> new ConsumeEffect.Type<>(codec, streamCodec));

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
                return deferred.get();
            }
        };
    }
}