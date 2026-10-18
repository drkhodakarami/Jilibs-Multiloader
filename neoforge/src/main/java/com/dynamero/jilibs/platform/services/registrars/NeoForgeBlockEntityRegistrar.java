package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.BlockEntityFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockEntityHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.BlockHandle;
import com.dynamero.jilibs.platform.services.registrars.utils.INeoForgeRegistrar;
import com.dynamero.jilibs.utils.BaseHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;
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
public class NeoForgeBlockEntityRegistrar implements IBlockEntityRegistrar, INeoForgeRegistrar
{
    private final String modId;
    private final DeferredRegister<BlockEntityType<?>> blockEntities;

    private boolean registered;

    public NeoForgeBlockEntityRegistrar()
    {
        this.modId = "";
        blockEntities = null;
        registered = false;
    }

    public NeoForgeBlockEntityRegistrar(String modId)
    {
        this.modId = modId;
        blockEntities = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, modId);
        registered = false;
    }

    @Override
    public void register(IEventBus eventBus)
    {
        if(registered)
            return;

        this.blockEntities.register(eventBus);
        registered = true;
    }

    @Override
    public Iterable<? extends BlockEntityType<?>> getList()
    {
        return this.blockEntities.getEntries()
                          .stream()
                          .map(Holder::value)
                          .toList();
    }

    @Override
    public IBlockEntityRegistrar forMod(String modId)
    {
        return new NeoForgeBlockEntityRegistrar(modId);
    }

    @Override
    public ResourceKey<BlockEntityType<?>> key(String name)
    {
        return BaseHelper.ResourceKeys.create(this.modId, name, Registries.BLOCK_ENTITY_TYPE);
    }

    @SafeVarargs
    @Override
    public final <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, BlockHandle<? extends Block>... validBlocks)
    {
        return register(name, factory, Arrays.stream(validBlocks)
                                             .map(Supplier::get)
                                             .toArray(Block[]::new));
    }

    @Override
    public <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, List<BlockHandle<? extends Block>> validBlocks)
    {
        return register(name, factory, validBlocks.stream()
                                                  .map(Supplier::get)
                                                  .toArray(Block[]::new));
    }

    private <T extends BlockEntity> BlockEntityHandle<BlockEntityType<T>> register(String name, BlockEntityFactory<T> factory, Block[] blocks)
    {
        var key = key(name);

        var deferred = blockEntities.register(name, () -> new BlockEntityType<>(factory::create, blocks));

        return new BlockEntityHandle<>()
        {
            @Override
            public Identifier id()
            {
                return key.identifier();
            }

            @Override
            public ResourceKey<BlockEntityType<?>> key()
            {
                return key;
            }

            @Override
            public BlockEntityType<T> get()
            {
                return deferred.get();
            }
        };
    }
}