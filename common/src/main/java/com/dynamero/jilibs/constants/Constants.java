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

package com.dynamero.jilibs.constants;


import net.minecraft.core.Direction;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.contracts.exceptions.Exceptions;

/**
 * A class containing various constants used throughout the project.
 *
 * @author TheMentor
 * @since 2025-04-18
 */
@SuppressWarnings("unused")
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public class Constants
{

    /**
     * Inner class containing constants related to inventory settings.
     */
    public static class Inventory
    {
        /**
         * Default output size for an inventory.
         */
        public static int DEFAULT_OUTPUT_SIZE = 1;

        /**
         * Default output direction for an inventory.
         */
        public static Direction DEFAULT_OUTPUT_DIRECTION = Direction.DOWN;
    }

    /**
     * Inner class containing constants related to fluid settings.
     */
    public static class Fluid
    {
        /**
         * Inner class containing constants related to fluid container capacities.
         */
        public static class ContainerCapacity
        {
            public static class Fabric
            {
                /**
                 * Inner class containing constants related to fluid capacities based on size.
                 */
                public static class SizeBased
                {
                    /**
                     * Default fluid capacity in buckets.
                     */
                    public static long DEFAULT = 81_000 * 20;

                    /**
                     * Small fluid capacity in buckets.
                     */
                    public static long SMALL = 81_000 * 10;

                    /**
                     * Medium fluid capacity in buckets.
                     */
                    public static long MEDIUM = 81_000 * 50;

                    /**
                     * Large fluid capacity in buckets.
                     */
                    public static long LARGE = 81_000 * 100;
                    /**
                     * XLarge fluid capacity in buckets.
                     */
                    public static long XLARGE = 81_000 * 250;
                }

                /**
                 * Inner class containing constants related to fluid capacities based on material.
                 */
                public static class MaterialBased
                {
                    /**
                     * Wood-based fluid capacity in buckets.
                     */
                    public static long WOOD = 81_000 * 4;

                    /**
                     * Stone-based fluid capacity in buckets.
                     */
                    public static long STONE = 81_000 * 16;

                    /**
                     * Copper-based fluid capacity in buckets.
                     */
                    public static long COPPER = 81_000 * 40;

                    /**
                     * Iron-based fluid capacity in buckets.
                     */
                    public static long IRON = 81_000 * 80;

                    /**
                     * Gold-based fluid capacity in buckets.
                     */
                    public static long GOLD = 81_000 * 120;

                    /**
                     * Obsidian-based fluid capacity in buckets.
                     */
                    public static long OBSIDIAN = 81_000 * 160;

                    /**
                     * Diamond-based fluid capacity in buckets.
                     */
                    public static long DIAMOND = 81_000 * 200;

                    /**
                     * Emerald-based fluid capacity in buckets.
                     */
                    public static long EMERALD = 81_000 * 280;

                    /**
                     * Star-based fluid capacity in buckets.
                     */
                    public static long STAR = 81_000 * 360;
                    /**
                     * Netherite-based fluid capacity in buckets.
                     */
                    public static long NETHERITE = 81_000 * 500;

                    /**
                     * End-based fluid capacity in buckets.
                     */
                    public static long END = 81_000 * 800;
                }

                /**
                 * Conversion factor from buckets to milli-buckets.
                 */
                public static long MILLI_BUCKET = 81_000 / 1000;
            }

            public static class MilliBucket
            {
                /**
                 * Inner class containing constants related to fluid capacities based on size.
                 */
                public static class SizeBased
                {
                    /**
                     * Default fluid capacity in buckets.
                     */
                    public static long DEFAULT = 1_000 * 20;

                    /**
                     * Small fluid capacity in buckets.
                     */
                    public static long SMALL = 1_000 * 10;

                    /**
                     * Medium fluid capacity in buckets.
                     */
                    public static long MEDIUM = 1_000 * 50;

                    /**
                     * Large fluid capacity in buckets.
                     */
                    public static long LARGE = 1_000 * 100;
                    /**
                     * XLarge fluid capacity in buckets.
                     */
                    public static long XLARGE = 1_000 * 250;
                }

                /**
                 * Inner class containing constants related to fluid capacities based on material.
                 */
                public static class MaterialBased
                {
                    /**
                     * Wood-based fluid capacity in buckets.
                     */
                    public static long WOOD = 1_000 * 4;

                    /**
                     * Stone-based fluid capacity in buckets.
                     */
                    public static long STONE = 1_000 * 16;

                    /**
                     * Copper-based fluid capacity in buckets.
                     */
                    public static long COPPER = 1_000 * 40;

                    /**
                     * Iron-based fluid capacity in buckets.
                     */
                    public static long IRON = 1_000 * 80;

                    /**
                     * Gold-based fluid capacity in buckets.
                     */
                    public static long GOLD = 1_000 * 120;

                    /**
                     * Obsidian-based fluid capacity in buckets.
                     */
                    public static long OBSIDIAN = 1_000 * 160;

                    /**
                     * Diamond-based fluid capacity in buckets.
                     */
                    public static long DIAMOND = 1_000 * 200;

                    /**
                     * Emerald-based fluid capacity in buckets.
                     */
                    public static long EMERALD = 1_000 * 280;

                    /**
                     * Star-based fluid capacity in buckets.
                     */
                    public static long STAR = 1_000 * 360;
                    /**
                     * Netherite-based fluid capacity in buckets.
                     */
                    public static long NETHERITE = 1_000 * 500;

                    /**
                     * End-based fluid capacity in buckets.
                     */
                    public static long END = 1_000 * 800;
                }

                /**
                 * Conversion factor from buckets to milli-buckets.
                 */
                public static long MILLI_BUCKET = 1;
            }

        }

    }

    /**
     * Inner class containing constants related to energy settings.
     */
    public static class Energy
    {
        /**
         * Default energy capacity in the system.
         */
        public static int DEFAULT_CAPACITY = 100_000;

        /**
         * Maximum amount of energy that can be inserted into the system per operation.
         */
        public static int DEFAULT_MAX_INSERT = 1000;

        /**
         * Maximum amount of energy that can be extracted from the system per operation.
         */
        public static int DEFAULT_MAX_EXTRACT = 1000;

        /**
         * Normal amount of energy to insert into the system per operation.
         */
        public static int DEFAULT_NORMAL_INSERT = 100;

        /**
         * Normal amount of energy to extract from the system per operation.
         */
        public static int DEFAULT_NORMAL_EXTRACT = 100;
    }

    // Private constructor to prevent instantiation
    public Constants()
    {
        Exceptions.throwCtorAssertion();
    }
}