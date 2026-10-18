package com.dynamero.jilibs.datagen;

import com.dynamero.jilibs.platform.services.registrars.utils.CommonStrippables;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.BlockTransformAppender;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

/**
 * Example Usage:
 * A) without inheritence:
 * <pre><code>
 * public class MyModDataMapProvider extends DataMapProvider
 * {
 *     //@Override
 *     protected void gather(HolderLookup.Provider provider)
 *     {
 *         WoodDataMapProvider.contributeStrippables(this);
 *     }
 * }
 * </code></pre>
 * B) with inheritence (you just call super)
 * <pre><code>
 * public class MyModDataMapProvider extends DataMapProvider
 * {
 *     //@Override
 *     protected void gather(HolderLookup.Provider provider)
 *     {
 *         super.gather(provider);
 *     }
 * }
 * </code></pre>
 */
public class WoodDataMapProvider extends DataMapProvider
{
    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    public WoodDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    /**
     * One-line static contributor. If the consumer already extends DataMapProvider
     * directly, this is all they ever need to call.
     */
    public static void contributeStrippables(DataMapProvider provider)
    {
        var entries = CommonStrippables.getEntries();
        if (entries.isEmpty()) return;

        var transformList = entries.stream()
                                   .map(entry -> BlockTransformer.BlockTransformData.builder(
                                           BlockPredicate.matchesBlocks(entry.input().get()),
                                           entry.output().get()
                                   ).build())
                                   .toList();

        // Accesses the builder method via the passed provider instance
        provider.builder(NeoForgeDataMaps.BLOCK_TRANSFORM_APPENDERS)
                .add(BlockTransformers.AXE.identifier(), new BlockTransformAppender(transformList), false);
    }

    @Override
    protected void gather(HolderLookup.Provider provider)
    {
        contributeStrippables(this);
    }
}