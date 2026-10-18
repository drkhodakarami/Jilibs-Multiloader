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

package com.dynamero.jilibs.treefamily;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.contracts.records.ModBlock;
import com.dynamero.jilibs.platform.Services;
import com.dynamero.jilibs.platform.services.registrars.IBlockItemRegistrar;
import com.dynamero.jilibs.platform.services.registrars.IBlockRegistrar;
import com.dynamero.jilibs.utils.BaseHelper;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

/**
 * Container and registry holder for all standard blocks and corresponding block items within a {@link TreeFamilyBuilder}.
 *
 * @param log Log block for this wood set.
 * @param strippedLog Stripped log block for this wood set.
 * @param wood Wood block (6-sided log bark) for this wood set.
 * @param strippedWood Stripped wood block for this wood set.
 * @param planks Planks block for this wood set.
 * @param leaves Leaves block for this wood set.
 * @param sapling Sapling block for this wood set.
 * @param stairs Stairs block for this wood set.
 * @param slab Slab block for this wood set.
 * @param fence Fence block for this wood set.
 * @param fenceGate Fence gate block for this wood set.
 * @param door Door block for this wood set.
 * @param trapdoor Trapdoor block for this wood set.
 * @param pressurePlate Pressure plate block for this wood set.
 * @param button Button block for this wood set.
 */
@SuppressWarnings("unused")
@Developer("TurtyWurty")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-08")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public record WoodsetBlocks (ModBlock<?, ?> log, ModBlock<?, ?> strippedLog, ModBlock<?, ?> wood, ModBlock<?, ?> strippedWood, ModBlock<?, ?> planks,
                             ModBlock<?, ?> leaves, ModBlock<?, ?> sapling, ModBlock<?, ?> stairs, ModBlock<?, ?> slab,
                             ModBlock<?, ?> fence, ModBlock<?, ?> fenceGate, ModBlock<?, ?> door, ModBlock<?, ?> trapdoor,
                             ModBlock<?, ?> pressurePlate, ModBlock<?, ?> button, WoodType woodType, BlockSetType blockSetType)
{

    /**
     * Constructs and registers all standard blocks and block items for a wood set.
     *
     * @param modid             the mod identifier
     * @param name              the base wood name
     * @param blockRegister     the block registerer helper
     * @param blockItemRegister the block-item registerer helper
     * @param saplingGenerator  the tree grower generator for saplings
     * @param woodType          supplier providing the wood type
     * @param blockSetType      the block set type
     */
    public static WoodsetBlocks build(String modid, String name,
                                      IBlockRegistrar blockRegister, IBlockItemRegistrar blockItemRegister,
                                      TreeGrower saplingGenerator, WoodType woodType, BlockSetType blockSetType)
    {
        //region Item IDs
        var woodItemId = BaseHelper.ResourceKeys.create(modid, name + "_wood", Registries.ITEM);
        var logItemId = BaseHelper.ResourceKeys.create(modid, name + "_log", Registries.ITEM);
        var plankItemId = BaseHelper.ResourceKeys.create(modid, name + "_planks", Registries.ITEM);
        var leaveItemId = BaseHelper.ResourceKeys.create(modid, name + "_leaves", Registries.ITEM);
        var saplingItemId = BaseHelper.ResourceKeys.create(modid, name + "_sapling", Registries.ITEM);
        var strippedWoodItemId = BaseHelper.ResourceKeys.create(modid, "stripped_" + name + "_wood", Registries.ITEM);
        var strippedLogItemId = BaseHelper.ResourceKeys.create(modid, "stripped_" + name + "_log", Registries.ITEM);
        var stairsItemId = BaseHelper.ResourceKeys.create(modid, name + "_stairs", Registries.ITEM);
        var slabItemId = BaseHelper.ResourceKeys.create(modid, name + "_slab", Registries.ITEM);
        var fenceItemId = BaseHelper.ResourceKeys.create(modid, name + "_fence", Registries.ITEM);
        var fenceGateItemId = BaseHelper.ResourceKeys.create(modid, name + "_fence_gate", Registries.ITEM);
        var doorItemId = BaseHelper.ResourceKeys.create(modid, name + "_door", Registries.ITEM);
        var trapdoorItemId = BaseHelper.ResourceKeys.create(modid, name + "_trapdoor", Registries.ITEM);
        var pressurePlateItemId = BaseHelper.ResourceKeys.create(modid, name + "_pressure_plate", Registries.ITEM);
        var buttonItemId = BaseHelper.ResourceKeys.create(modid, name + "_button", Registries.ITEM);
        //endregion

        //region Block IDs
        var woodBlockId = BaseHelper.ResourceKeys.create(modid, name + "_wood", Registries.BLOCK);
        var logBlockId = BaseHelper.ResourceKeys.create(modid, name + "_log", Registries.BLOCK);
        var plankBlockId = BaseHelper.ResourceKeys.create(modid, name + "_planks", Registries.BLOCK);
        var leaveBlockId = BaseHelper.ResourceKeys.create(modid, name + "_leaves", Registries.BLOCK);
        var saplingBlockId = BaseHelper.ResourceKeys.create(modid, name + "_sapling", Registries.BLOCK);
        var strippedWoodBlockId = BaseHelper.ResourceKeys.create(modid, "stripped_" + name + "_wood", Registries.BLOCK);
        var strippedLogBlockId = BaseHelper.ResourceKeys.create(modid, "stripped_" + name + "_log", Registries.BLOCK);
        var stairsBlockId = BaseHelper.ResourceKeys.create(modid, name + "_stairs", Registries.BLOCK);
        var slabBlockId = BaseHelper.ResourceKeys.create(modid, name + "_slab", Registries.BLOCK);
        var fenceBlockId = BaseHelper.ResourceKeys.create(modid, name + "_fence", Registries.BLOCK);
        var fenceGateBlockId = BaseHelper.ResourceKeys.create(modid, name + "_fence_gate", Registries.BLOCK);
        var doorBlockId = BaseHelper.ResourceKeys.create(modid, name + "_door", Registries.BLOCK);
        var trapdoorBlockId = BaseHelper.ResourceKeys.create(modid, name + "_trapdoor", Registries.BLOCK);
        var pressurePlateBlockId = BaseHelper.ResourceKeys.create(modid, name + "_pressure_plate", Registries.BLOCK);
        var buttonBlockId = BaseHelper.ResourceKeys.create(modid, name + "_button", Registries.BLOCK);
        var signBlockId = BaseHelper.ResourceKeys.create(modid, name + "_sign", Registries.BLOCK);
        var wallSignBlockId = BaseHelper.ResourceKeys.create(modid, name + "_wall_sign", Registries.BLOCK);
        var hangingSignBlockId = BaseHelper.ResourceKeys.create(modid, name + "_hanging_sign", Registries.BLOCK);
        var wallHangingSignBlockId = BaseHelper.ResourceKeys.create(modid, name + "_wall_hanging_sign", Registries.BLOCK);
        //endregion

        //region BlockItem IDs
        var woodBlockItemId = new BlockItemId(woodBlockId, woodItemId);
        var logBlockItemId = new BlockItemId(logBlockId, logItemId);
        var plankBlockItemId = new BlockItemId(plankBlockId, plankItemId);
        var leaveBlockItemId = new BlockItemId(leaveBlockId, leaveItemId);
        var saplingBlockItemId = new BlockItemId(saplingBlockId, saplingItemId);
        var strippedWoodBlockItemId = new BlockItemId(strippedWoodBlockId, strippedWoodItemId);
        var strippedLogBlockItemId = new BlockItemId(strippedLogBlockId, strippedLogItemId);
        var stairsBlockItemId = new BlockItemId(stairsBlockId, stairsItemId);
        var slabBlockItemId = new BlockItemId(slabBlockId, slabItemId);
        var fenceBlockItemId = new BlockItemId(fenceBlockId, fenceItemId);
        var fenceGateBlockItemId = new BlockItemId(fenceGateBlockId, fenceGateItemId);
        var doorBlockItemId = new BlockItemId(doorBlockId, doorItemId);
        var trapdoorBlockItemId = new BlockItemId(trapdoorBlockId, trapdoorItemId);
        var pressurePlateBlockItemId = new BlockItemId(pressurePlateBlockId, pressurePlateItemId);
        var buttonBlockItemId = new BlockItemId(buttonBlockId, buttonItemId);
        //endregion

        //region Register
        var plankBlock =
                blockRegister.registerCopy(plankBlockItemId,
                                           Blocks.OAK_PLANKS,
                                           Block::new);
        var planks =
                new ModBlock<>(plankBlock, blockItemRegister.register(plankBlock).item());

        var logBlock =
                blockRegister.registerCopy(logBlockItemId,
                                           Blocks.OAK_LOG,
                                           RotatedPillarBlock::new);
        var log =
                new ModBlock<>(logBlock, blockItemRegister.register(logBlock).item());

        var strippedLogBlock =
                blockRegister.registerCopy(strippedLogBlockItemId,
                                           Blocks.STRIPPED_OAK_LOG,
                                           RotatedPillarBlock::new);
        var strippedLog = new ModBlock<>(strippedLogBlock, blockItemRegister.register(strippedLogBlock).item());

        var strippedWoodBlock =
                blockRegister.registerCopy(strippedWoodBlockItemId,
                                           Blocks.STRIPPED_OAK_WOOD,
                                           RotatedPillarBlock::new);
        var strippedWood = new ModBlock<>(strippedWoodBlock, blockItemRegister.register(strippedWoodBlock).item());

        var woodBlock =
                blockRegister.registerCopy(woodBlockItemId,
                                           Blocks.OAK_WOOD,
                                           RotatedPillarBlock::new);
        var wood = new ModBlock<>(woodBlock, blockItemRegister.register(woodBlock).item());

        var leavesBlock =
                blockRegister.registerCopy(leaveBlockItemId,
                                              Blocks.OAK_LEAVES,
                                              settings -> new TintedParticleLeavesBlock(0.01F, settings));

        var leaves = new ModBlock<>(leavesBlock, blockItemRegister.register(leavesBlock).item());

        var saplingBlock =
                blockRegister.registerCopy(saplingBlockItemId,
                                           Blocks.OAK_SAPLING,
                                           settings -> new SaplingBlock(saplingGenerator, settings));
        var sapling = new ModBlock<>(saplingBlock, blockItemRegister.register(saplingBlock).item());


        var stairsBlock =
                blockRegister.registerCopy(stairsBlockItemId,
                                           Blocks.OAK_STAIRS,
                                           settings -> new StairBlock(planks.block().get().defaultBlockState(), settings));
        var stairs = new ModBlock<>(stairsBlock, blockItemRegister.register(stairsBlock).item());


        var slabBlock =
                blockRegister.registerCopy(slabBlockItemId,
                                           Blocks.OAK_SLAB,
                                           SlabBlock::new);
        var slab = new ModBlock<>(slabBlock, blockItemRegister.register(slabBlock).item());


        var fenceBlock =
                blockRegister.registerCopy(fenceBlockItemId,
                                           Blocks.OAK_FENCE,
                                           FenceBlock::new);
        var fence = new ModBlock<>(fenceBlock, blockItemRegister.register(fenceBlock).item());


        var fenceGateBlock =
                blockRegister.registerCopy(fenceGateBlockItemId,
                                           Blocks.OAK_FENCE_GATE,
                                           settings -> new FenceGateBlock(woodType, settings));
        var fenceGate = new ModBlock<>(fenceGateBlock, blockItemRegister.register(fenceGateBlock).item());

        var doorBlock =
                blockRegister.registerCopy(doorBlockItemId,
                                           Blocks.OAK_DOOR,
                                           settings -> new DoorBlock(blockSetType, settings));
        var door = new ModBlock<>(doorBlock, blockItemRegister.register(doorBlock).item());

        var trapdoorBlock =
                blockRegister.registerCopy(trapdoorBlockItemId,
                                           Blocks.OAK_TRAPDOOR,
                                           settings -> new TrapDoorBlock(blockSetType, settings));
        var trapdoor = new ModBlock<>(trapdoorBlock, blockItemRegister.register(trapdoorBlock).item());

        var pressureBlock =
                blockRegister.registerCopy(pressurePlateBlockItemId,
                                           Blocks.OAK_PRESSURE_PLATE,
                                           settings -> new PressurePlateBlock(blockSetType, settings));
        var pressurePlate = new ModBlock<>(pressureBlock, blockItemRegister.register(pressureBlock).item());

        var buttonBlock =
                blockRegister.registerCopy(buttonBlockItemId,
                                           Blocks.OAK_BUTTON,
                                           settings -> new ButtonBlock(blockSetType, 30, settings));
        var button = new ModBlock<>(buttonBlock, blockItemRegister.register(buttonBlock).item());

        var blocks = new WoodsetBlocks(log, strippedLog, wood, strippedWood, planks, leaves, sapling, stairs, slab,
                                       fence, fenceGate, door, trapdoor, pressurePlate, button, woodType, blockSetType);
        //endregion

        //region Burnables
        Services.FLAMMABLE.register(blocks.planks.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.log.block(), 5, 5);
        Services.FLAMMABLE.register(blocks.strippedLog.block(), 5, 5);
        Services.FLAMMABLE.register(blocks.strippedWood.block(), 5, 5);
        Services.FLAMMABLE.register(blocks.wood.block(), 5, 5);
        Services.FLAMMABLE.register(blocks.leaves.block(), 30, 60);
        Services.FLAMMABLE.register(blocks.sapling.block(), 60, 20);
        Services.FLAMMABLE.register(blocks.stairs.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.slab.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.fence.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.fenceGate.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.door.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.trapdoor.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.pressurePlate.block(), 5, 20);
        Services.FLAMMABLE.register(blocks.button.block(), 5, 20);
        //endregion

        return blocks;
    }
}