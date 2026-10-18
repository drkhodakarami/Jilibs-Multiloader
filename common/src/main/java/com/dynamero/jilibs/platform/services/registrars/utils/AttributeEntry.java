package com.dynamero.jilibs.platform.services.registrars.utils;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.IEntityAttributeRegisterar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.Supplier;
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public record AttributeEntry<T extends LivingEntity>(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier)
{
    public void register(IEntityAttributeRegisterar.EntityAttributeRegistrar registrar)
    {
        registrar.register(this.entityTypeSupplier.get(), this.builderSupplier.get());
    }
}