package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.ConsumeEffectHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
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
public interface IConsumeEffectRegistrar extends IModScopedRegistrar<IConsumeEffectRegistrar>
{
    /**
     * Returns an iterable of all ConsumeEffect.Types
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<? extends ConsumeEffect.Type<?>> getList();

    ResourceKey<ConsumeEffect.Type<?>> key(String name);

    <T extends ConsumeEffect> ConsumeEffectHandle<ConsumeEffect.Type<T>> register(String name, MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec);
}