package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.AttributeEntry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
@SuppressWarnings("FieldCanBeLocal")
@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class FabricEntityAttributeRegisterar implements IEntityAttributeRegisterar
{
    private final String modId;

    private final List<AttributeEntry<?>> attributes = new ArrayList<>();

    // Required by ServiceLoader
    public FabricEntityAttributeRegisterar()
    {
        this("");
    }

    // Scoped instance
    public FabricEntityAttributeRegisterar(String modId)
    {
        this.modId = modId;
    }

    @Override
    public Iterable<AttributeEntry<?>> getList() {
        return Collections.unmodifiableList(this.attributes);
    }

    @Override
    public IEntityAttributeRegisterar forMod(String modId)
    {
        return new FabricEntityAttributeRegisterar(modId);
    }

    @Override
    public <T extends LivingEntity> void register(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier)
    {
        this.attributes.add(new AttributeEntry<>(entityTypeSupplier, builderSupplier));
    }

    @Override
    public void applyEntityAttributeRegistrations(EntityAttributeRegistrar registrar)
    {
        for (var attribute : this.attributes)
            attribute.register(registrar);
    }
}