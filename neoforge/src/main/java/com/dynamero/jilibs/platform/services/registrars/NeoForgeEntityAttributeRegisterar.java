package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.platform.services.registrars.utils.AttributeEntry;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;
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
public class NeoForgeEntityAttributeRegisterar implements IEntityAttributeRegisterar, INeoForgeRegistrar
{
    private final String modId;
    private final List<AttributeEntry<?>> attributes = new ArrayList<>();

    private boolean registered;

    public NeoForgeEntityAttributeRegisterar()
    {
        this.modId = "";
        registered = false;
    }

    public NeoForgeEntityAttributeRegisterar(String modId)
    {
        this.modId = modId;
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        //NOOP
        registered = true;
    }

    @Override
    public Iterable<AttributeEntry<?>> getList()
    {
        return this.attributes;
    }

    @Override
    public IEntityAttributeRegisterar forMod(String modId) {
        return new NeoForgeEntityAttributeRegisterar(modId);
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