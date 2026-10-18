/*
 * Copyright (c) 2026 Alireza Khodakarami
 *
 * Licensed under the LPGL-3.0, (read the "LICENSE" file in repo);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dynamero.jilibs.client.datagen;

import java.util.List;
import java.util.Locale;

import com.dynamero.jilibs.interfaces.TagLookup;
import com.dynamero.jilibs.treefamily.TreeFamily;
import com.dynamero.jilibs.treefamily.TreeFamilyBuilder;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.BlockTransformAppender;

/**
 * Reusable data-generator contribution for {@link TreeFamilyBuilder}.
 */
@SuppressWarnings("unchecked")
public final class TreeFamilyDataGen
{
    /**
     * Example Usage:
     * <pre><code>
     * public class ModItemTagsProvider extends ItemTagsProvider
     * {
     *      public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags)
     *      {
     *          super(output, lookupProvider, blockTags);
     *      }
     *
     *     //@Override
     *     protected void addTags(HolderLookup.Provider provider)
     *     {
     *         // 'this::tag' cleanly matches TagLookup<Item>
     *         TreeFamilyDataGen.generateItemTags(this::tag, MyTreeFamilies.MAPLE);
     *     }
     * }
     * </code></pre>
     * @param lookup
     * @param set
     */
    public static void generateItemTags(TagLookup<Item> lookup, TreeFamily set)
    {
        lookup.tag(set.tags().item()).add(
                set.blocks().log().item().key(),
                set.blocks().strippedLog().item().key(),
                set.blocks().wood().item().key(),
                set.blocks().strippedWood().item().key());
        lookup.tag(ItemTags.LOGS_THAT_BURN).addTag(set.tags().item());
        lookup.tag(ItemTags.PLANKS).add(set.blocks().planks().item().key());
        lookup.tag(ItemTags.LEAVES).add(set.blocks().leaves().item().key());
        lookup.tag(ItemTags.SAPLINGS).add(set.blocks().sapling().item().key());
        lookup.tag(ItemTags.WOODEN_BUTTONS).add(set.blocks().button().item().key());
        lookup.tag(ItemTags.WOODEN_DOORS).add(set.blocks().door().item().key());
        lookup.tag(ItemTags.WOODEN_FENCES).add(set.blocks().fence().item().key());
        lookup.tag(ItemTags.FENCE_GATES).add(set.blocks().fenceGate().item().key());
        lookup.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(set.blocks().pressurePlate().item().key());
        lookup.tag(ItemTags.WOODEN_TRAPDOORS).add(set.blocks().trapdoor().item().key());
        lookup.tag(ItemTags.WOODEN_STAIRS).add(set.blocks().stairs().item().key());
        lookup.tag(ItemTags.WOODEN_SLABS).add(set.blocks().slab().item().key());
        lookup.tag(ItemTags.SIGNS).add(set.signs().items().sign().key());
        lookup.tag(ItemTags.HANGING_SIGNS).add(set.signs().hangingSign().item().key());
        lookup.tag(ItemTags.BOATS).add(set.boats().boatItem().key());
        lookup.tag(ItemTags.CHEST_BOATS).add(set.boats().chestBoatItem().key());
    }

    /**
     * Example Usage:
     * <pre><code>
     * public class ModBlockTagsProvider extends BlockTagsProvider
     * {
     *     public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
     *     {
     *         super(output, lookupProvider);
     *     }
     *
     *     //@Override
     *     protected void addTags(HolderLookup.Provider provider) {
     *         // 'this::tag' cleanly matches TagLookup<Block>
     *         TreeFamilyDataGen.generateBlockTags(this::tag, MyTreeFamilies.MAPLE);
     *     }
     * }
     * </code></pre>
     * @param lookup
     * @param set
     */
    public static void generateBlockTags(TagLookup<Block> lookup, TreeFamily set)
    {
        lookup.tag(set.tags().block()).add(
                set.blocks().log().block().key(),
                set.blocks().strippedLog().block().key(),
                set.blocks().wood().block().key(),
                set.blocks().strippedWood().block().key());
        lookup.tag(BlockTags.PLANKS).add(set.blocks().planks().block().key());
        lookup.tag(BlockTags.LEAVES).add(set.blocks().leaves().block().key());
        lookup.tag(BlockTags.WOODEN_BUTTONS).add(set.blocks().button().block().key());
        lookup.tag(BlockTags.WOODEN_DOORS).add(set.blocks().door().block().key());
        lookup.tag(BlockTags.WOODEN_FENCES).add(set.blocks().fence().block().key());
        lookup.tag(BlockTags.FENCE_GATES).add(set.blocks().fenceGate().block().key());
        lookup.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(set.blocks().pressurePlate().block().key());
        lookup.tag(BlockTags.WOODEN_TRAPDOORS).add(set.blocks().trapdoor().block().key());
        lookup.tag(BlockTags.WOODEN_STAIRS).add(set.blocks().stairs().block().key());
        lookup.tag(BlockTags.WOODEN_SLABS).add(set.blocks().slab().block().key());
        lookup.tag(BlockTags.STANDING_SIGNS).add(set.signs().sign().block().key());
        lookup.tag(BlockTags.WALL_SIGNS).add(set.signs().wallSign().block().key());
        lookup.tag(BlockTags.CEILING_HANGING_SIGNS).add(set.signs().hangingSign().block().key());
        lookup.tag(BlockTags.WALL_HANGING_SIGNS).add(set.signs().wallHangingSign().block().key());
    }

    /**
     * Example Usage:
     * <pre><code>
     * public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider
     * {
     *     public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
     *     {
     *         super(output, lookupProvider);
     *     }
     *
     *     //@Override
     *     protected void addTags(HolderLookup.Provider provider) {
     *         TreeFamilyDataGen.generateEntityTags(this::tag, MyTreeFamilies.MAPLE);
     *     }
     * }
     * </code></pre>
     * @param lookup
     * @param set
     */
    public static void generateEntityTags(TagLookup<EntityType<?>> lookup, TreeFamily set)
    {
        lookup.tag(EntityTypeTags.BOAT).add(set.boats().boat().key(), set.boats().chestBoat().key());
    }

    public static void generateLanguage(LanguageProvider provider, TreeFamily set)
    {
        String name = displayName(set.name());
        provider.add(set.blocks().planks().block().get(), name + " Planks");
        provider.add(set.blocks().log().block().get(), name + " Log");
        provider.add(set.blocks().strippedLog().block().get(), "Stripped " + name + " Log");
        provider.add(set.blocks().strippedWood().block().get(), "Stripped " + name + " Wood");
        provider.add(set.blocks().wood().block().get(), name + " Wood");
        provider.add(set.blocks().leaves().block().get(), name + " Leaves");
        provider.add(set.blocks().sapling().block().get(), name + " Sapling");
        provider.add(set.blocks().stairs().block().get(), name + " Stairs");
        provider.add(set.blocks().slab().block().get(), name + " Slab");
        provider.add(set.blocks().fence().block().get(), name + " Fence");
        provider.add(set.blocks().fenceGate().block().get(), name + " Fence Gate");
        provider.add(set.blocks().door().block().get(), name + " Door");
        provider.add(set.blocks().trapdoor().block().get(), name + " Trapdoor");
        provider.add(set.blocks().pressurePlate().block().get(), name + " Pressure Plate");
        provider.add(set.blocks().button().block().get(), name + " Button");
        provider.add(set.signs().items().sign().get(), name + " Sign");
        provider.add(set.signs().items().hangingSign().get(), name + " Hanging Sign");
        provider.add(set.boats().boatItem().get(), name + " Boat");
        provider.add(set.boats().chestBoatItem().get(), name + " Chest Boat");
        provider.add(set.boats().boat().get(), name + " Boat");
        provider.add(set.boats().chestBoat().get(), name + " Chest Boat");
    }

    public static void generateRecipes(RecipeProvider provider, RecipeOutput output, TreeFamily set)
    {
        provider.planksFromLogs(set.blocks().planks().block().get(), set.tags().item(), 4);
        provider.woodFromLogs(set.blocks().wood().block().get(), set.blocks().log().block().get());
        provider.woodFromLogs(set.blocks().strippedWood().block().get(), set.blocks().strippedLog().block().get());
        provider.woodenBoat(set.boats().boatItem().get(), set.blocks().planks().block().get());
        provider.chestBoat(set.boats().chestBoatItem().get(), set.boats().boatItem().get());
        provider.hangingSignBuilder(set.signs().items().hangingSign().get(),
                           Ingredient.of(set.blocks().strippedLog().block().get()))
                .save(output);
        provider.generateRecipes(set.blockFamily(), FeatureFlags.DEFAULT_FLAGS);
    }

    public static void generateLootTables(BlockLootSubProvider provider, TreeFamily set)
    {
        for (var block : List.of(
                set.blocks().planks(), set.blocks().log(), set.blocks().strippedLog(), set.blocks().strippedWood(), set.blocks().wood(), set.blocks().sapling(),
                set.blocks().stairs(), set.blocks().fence(), set.blocks().fenceGate(), set.blocks().trapdoor(), set.blocks().pressurePlate(), set.blocks().button()
        ))
            provider.dropSelf(block.block().get());

        provider.createSlabItemTable(set.blocks().slab().block().get());
        provider.createDoorTable(set.blocks().door().block().get());
        provider.dropOther(set.signs().sign().block().get(), set.signs().items().sign().get());
        provider.dropOther(set.signs().wallSign().block().get(), set.signs().items().sign().get());
        provider.dropOther(set.signs().hangingSign().block().get(), set.signs().items().hangingSign().get());
        provider.dropOther(set.signs().wallHangingSign().block().get(), set.signs().items().hangingSign().get());
        provider.createLeavesDrops(set.blocks().leaves().block().get(), set.blocks().sapling().block().get(), BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES);
    }

    private static void generateModels(BlockModelGenerators models, ItemModelGenerators items, TreeFamily set) {
        models.woodProvider(set.blocks().log().block().get())
              .logWithHorizontal(set.blocks().log().block().get())
              .wood(set.blocks().wood().block().get());
        models.woodProvider(set.blocks().strippedLog().block().get())
            .logWithHorizontal(set.blocks().strippedLog().block().get())
              .wood(set.blocks().strippedWood().block().get());
        models.createTintedLeaves(set.blocks().leaves().block().get(), TexturedModel.LEAVES, 0x00BB0A);
        models.createCrossBlockWithDefaultItem(set.blocks().sapling().block().get(), BlockModelGenerators.PlantType.NOT_TINTED);
        models.family(set.blocks().planks().block().get()).generateFor(set.blockFamily());
        items.generateFlatItem(set.boats().boatItem().get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(set.boats().chestBoatItem().get(), ModelTemplates.FLAT_ITEM);
    }

    private static String displayName(String path) {
        StringBuilder result = new StringBuilder();
        for (String part : path.split("_")) {
            if (part.isEmpty()) continue;
            if (!result.isEmpty()) result.append(' ');
            result.append(part.substring(0, 1).toUpperCase(Locale.ROOT)).append(part.substring(1));
        }
        return result.toString();
    }
}