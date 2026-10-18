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

package com.dynamero.jilibs.platform.services.registrars;

import java.util.function.Function;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.interfaces.factories.IToolFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.ItemHandle;
import com.dynamero.jilibs.utils.BaseHelper;

/**
 * Registers custom items for Minecraft.
 */
@Developer("TheMentor")
@CreatedAt("2026-10-16")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IItemRegistrar extends IModScopedRegistrar<IItemRegistrar>
{
    /**
     * Returns an iterable of all Items
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<Item> getList();

    ResourceKey<Item> key(String name);

    //region Helper Overloads
    /**
     * Registers an item using default settings and a factory function.
     *
     * @param name    the name of the item
     * @return the registered item
     */
    default ItemHandle<Item> register(String name)
    {
        return register(name, Item::new);
    }

    /**
     * Registers an item using default settings and a factory function.
     *
     * @param key    the resource key of the item
     * @return the registered item
     */
    default ItemHandle<Item> register(ResourceKey<Item> key)
    {
        return register(key, Item::new);
    }

    /**
     * Registers an item with custom settings and a factory function.
     *
     * @param name    the name of the item
     * @param settings the custom settings for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(String name, Item.Properties settings)
    {
        return register(name, settings, Item::new);
    }

    /**
     * Registers an item with custom settings using a ResourceKey.
     *
     * @param key      the resource key of the item
     * @param settings the custom settings for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(ResourceKey<Item> key, Item.Properties settings)
    {
        return register(key, settings, Item::new);
    }

    /**
     * Registers an item with a stack count and default settings using a factory function.
     *
     * @param name       the name of the item
     * @param stackCount the maximum stack size for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(String name, int stackCount)
    {
        return register(name, stackCount, Item::new);
    }

    /**
     * Registers an item with a stack count using a ResourceKey.
     *
     * @param key        the resource key of the item
     * @param stackCount the maximum stack size for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(ResourceKey<Item> key, int stackCount)
    {
        return register(key, stackCount, Item::new);
    }

    /**
     * Registers an item with a stack count and custom settings using a factory function.
     *
     * @param name       the name of the item
     * @param stackCount the maximum stack size for the item
     * @param settings   the custom settings for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(String name, int stackCount, Item.Properties settings)
    {
        return register(name, stackCount, settings, Item::new);
    }

    /**
     * Registers an item with a stack count and custom settings using a ResourceKey.
     *
     * @param key        the resource key of the item
     * @param stackCount the maximum stack size for the item
     * @param settings   the custom settings for the item
     * @return the registered item
     */
    default ItemHandle<Item> register(ResourceKey<Item> key, int stackCount, Item.Properties settings)
    {
        return register(key, stackCount, settings, Item::new);
    }

    /**
     * Registers an item using a factory function.
     *
     * @param <R>             the type of the item
     * @param name            the name of the item
     * @param factory         the factory used to create instances of the item
     * @return the registered item
     */
    default <R extends Item> ItemHandle<R> register(String name, Function<Item.Properties, ? extends R> factory)
    {
        return register(key(name), factory);
    }

    /**
     * Registers an item with a stack count using a factory function.
     *
     * @param <R>             the type of the item
     * @param name            the name of the item
     * @param stackCount      the maximum stack size for the item
     * @param factory         the factory used to create instances of the item
     * @return the registered item
     */
    default <R extends Item> ItemHandle<R> register(String name, int stackCount, Function<Item.Properties, ? extends R> factory)
    {
        return register(key(name), stackCount, factory);
    }

    /**
     * Registers an item with custom settings using a factory function.
     *
     * @param <R>             the type of the item
     * @param name            the name of the item
     * @param settings        the custom settings for the item
     * @param factory         the factory used to create instances of the item
     * @return the registered item
     */
    default <R extends Item> ItemHandle<R> register(String name, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(key(name), settings, factory);
    }

    /**
     * Registers an item with a stack count and custom settings using a factory function.
     *
     * @param <R>             the type of the item
     * @param name            the name of the item
     * @param stackCount      the maximum stack size for the item
     * @param settings        the custom settings for the item
     * @param factory         the factory used to create instances of the item
     * @return the registered item
     */
    default <R extends Item> ItemHandle<R> register(String name, int stackCount, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        var key = key(name);
        return register(key, stackCount, settings, factory);
    }
    //endregion

    //region Specials
    //region Tools
    /**
     * Registers an axe with default settings and a material.
     *
     * @param name            the name of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered axe item
     */
    default <R extends Item> ItemHandle<R> registerAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().axe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers an axe with default settings and a material.
     *
     * @param name            the name of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @param settings the custom item properties
     * @param factory         the factory used to create instances of the tool item
     * @return the registered axe item
     */
    default <R extends Item> ItemHandle<R> registerAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.axe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers an axe with default settings and a material.
     *
     * @param name            the name of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @return the registered axe item
     */
    default ItemHandle<Item> registerAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Properties().axe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers an axe with default settings and a material.
     *
     * @param name            the name of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @param settings the custom item properties
     * @return the registered axe item
     */
    default ItemHandle<Item> registerAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings)
    {
        return register(name, settings.axe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param name            the name of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered hoe item
     */
    default <R extends Item> ItemHandle<R> registerHoe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().hoe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param name            the name of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @param settings the custom item properties
     * @param factory         the factory used to create instances of the tool item
     * @return the registered hoe item
     */
    default <R extends Item> ItemHandle<R> registerHoe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.hoe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param name            the name of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @return the registered hoe item
     */
    default ItemHandle<Item> registerHoe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Properties().hoe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param name            the name of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @param settings the custom item properties
     * @return the registered hoe item
     */
    default ItemHandle<Item> registerHoe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings)
    {
        return register(name, new Item.Properties().hoe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param name            the name of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered pickaxe item
     */
    default <R extends Item> ItemHandle<R> registerPickaxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param name            the name of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @param settings the custom item properties
     * @param factory         the factory used to create instances of the tool item
     * @return the registered pickaxe item
     */
    default <R extends Item> ItemHandle<R> registerPickaxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param name            the name of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @return the registered pickaxe item
     */
    default ItemHandle<Item> registerPickaxe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param name            the name of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @param settings the custom item properties
     * @return the registered pickaxe item
     */
    default ItemHandle<Item> registerPickaxe(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings)
    {
        return register(name, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param name            the name of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @param factory         the factory used to create instances of the tool item
     * @return the registered shovel item
     */
    default <R extends Item> ItemHandle<R> registerShovel(String name, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().shovel(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param name            the name of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @param settings the custom item properties
     * @param factory         the factory used to create instances of the tool item
     * @return the registered shovel item
     */
    default <R extends Item> ItemHandle<R> registerShovel(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().shovel(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param name            the name of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @return the registered shovel item
     */
    default ItemHandle<Item> registerShovel(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Properties().shovel(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param name            the name of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @param settings the custom item properties
     * @return the registered shovel item
     */
    default ItemHandle<Item> registerShovel(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings)
    {
        return register(name, new Item.Properties().shovel(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a sword with default settings and a material.
     *
     * @param name            the name of the sword
     * @param material        the tool material for the sword
     * @param attackDamage    the attack damage of the sword
     * @param attackSpeed     the attack speed of the sword
     * @param factory         the factory used to create instances of the tool item
     * @return the registered sword item
     */
    default <R extends Item> ItemHandle<R>  registerSword(String name, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().sword(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a sword with default settings and a material.
     *
     * @param name            the name of the sword
     * @param material        the tool material for the sword
     * @param attackDamage    the attack damage of the sword
     * @param attackSpeed     the attack speed of the sword
     * @param settings the custom item properties
     * @param factory         the factory used to create instances of the tool item
     * @return the registered sword item
     */
    default <R extends Item> ItemHandle<R>  registerSword(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().sword(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a sword with default settings and a material.
     *
     * @param name            the name of the sword
     * @param material        the tool material for the sword
     * @param attackDamage    the attack damage of the sword
     * @param attackSpeed     the attack speed of the sword
     * @param settings the custom item properties
     * @return the registered sword item
     */
    default ItemHandle<Item> registerSword(String name, ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings)
    {
        return register(name, new Item.Properties().sword(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a tool with default settings and a material.
     *
     * @param <R>             the type of the tool item
     * @param name            the name of the tool item
     * @param material        the tool material for the tool
     * @param attackDamage    the attack damage of the tool
     * @param attackSpeed     the attack speed of the tool
     * @param factory         the factory used to create instances of the tool item
     * @return the registered tool item
     */
    default <R extends Item> ItemHandle<R> registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed, IToolFactory<Item.Properties, ? extends R> factory)
    {
        return registerTool(key(name), material, attackDamage, attackSpeed, factory);
    }

    /**
     * Registers a tool with custom settings and a material.
     *
     * @param <R>             the type of the tool item
     * @param name            the name of the tool item
     * @param material        the tool material for the tool
     * @param attackDamage    the attack damage of the tool
     * @param attackSpeed     the attack speed of the tool
     * @param settings        the custom settings for the tool item
     * @param factory         the factory used to create instances of the tool item
     * @return the registered tool item
     */
    default <R extends Item> ItemHandle<R> registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed,
                                             Item.Properties settings, IToolFactory<Item.Properties, ? extends R> factory)
    {
        return registerTool(key(name), material, attackDamage, attackSpeed, settings, factory);
    }
    //endregion

    //region Armor
    //region Animals
    /**
     * Registers horse armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the horse armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered horse armor item
     */
    default <R extends Item> ItemHandle<R> registerHorseArmor(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().horseArmor(material), factory);
    }

    /**
     * Registers nautilus armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the nautilus armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered nautilus armor item
     */
    default <R extends Item> ItemHandle<R> registerNautilusArmor(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().nautilusArmor(material), factory);
    }

    /**
     * Registers wolf armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the wolf armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered wolf armor item
     */
    default <R extends Item> ItemHandle<R> registerWolfArmor(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().wolfArmor(material), factory);
    }

    /**
     * Registers horse armor with default settings.
     *
     * @param name     the name of the horse armor item
     * @param material the armor material
     * @return the registered horse armor item
     */
    default ItemHandle<Item> registerHorseArmor(String name, ArmorMaterial material)
    {
        return register(name, new Item.Properties().horseArmor(material), Item::new);
    }

    /**
     * Registers nautilus armor with default settings.
     *
     * @param name     the name of the nautilus armor item
     * @param material the armor material
     * @return the registered nautilus armor item
     */
    default ItemHandle<Item> registerNautilusArmor(String name, ArmorMaterial material)
    {
        return register(name, new Item.Properties().nautilusArmor(material), Item::new);
    }

    /**
     * Registers wolf armor with default settings.
     *
     * @param name     the name of the wolf armor item
     * @param material the armor material
     * @return the registered wolf armor item
     */
    default ItemHandle<Item> registerWolfArmor(String name, ArmorMaterial material)
    {
        return register(name, new Item.Properties().wolfArmor(material), Item::new);
    }

    /**
     * Registers horse armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the horse armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered horse armor item
     */
    default <R extends Item> ItemHandle<R> registerHorseArmor(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.horseArmor(material), factory);
    }

    /**
     * Registers nautilus armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the nautilus armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered nautilus armor item
     */
    default <R extends Item> ItemHandle<R> registerNautilusArmor(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.nautilusArmor(material), factory);
    }

    /**
     * Registers wolf armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the name of the wolf armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered wolf armor item
     */
    default <R extends Item> ItemHandle<R> registerWolfArmor(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.wolfArmor(material), factory);
    }

    /**
     * Registers horse armor with custom settings.
     *
     * @param name     the name of the horse armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered horse armor item
     */
    default ItemHandle<Item> registerHorseArmor(String name, ArmorMaterial material, Item.Properties settings)
    {
        return register(name, settings.horseArmor(material), Item::new);
    }

    /**
     * Registers nautilus armor with custom settings.
     *
     * @param name     the name of the nautilus armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered nautilus armor item
     */
    default ItemHandle<Item> registerNautilusArmor(String name, ArmorMaterial material, Item.Properties settings)
    {
        return register(name, settings.nautilusArmor(material), Item::new);
    }

    /**
     * Registers wolf armor with custom settings.
     *
     * @param name     the name of the wolf armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered wolf armor item
     */
    default ItemHandle<Item> registerWolfArmor(String name, ArmorMaterial material, Item.Properties settings)
    {
        return register(name, settings.wolfArmor(material), Item::new);
    }
    //endregion

    //region Humanoid
    /**
     * Registers an armor item with default settings and a material.
     *
     * @param name            the name of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param factory         the factory used to create instances of the tool item
     * @return the registered armor item
     */
    default <R extends Item> ItemHandle<R> registerArmor(String name, ArmorMaterial material, ArmorType equipment, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, new Item.Properties().humanoidArmor(material, equipment), factory);
    }

    /**
     * Registers a helmet with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered helmet item
     */
    default <R extends Item> ItemHandle<R> registerHelmet(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_helmet", material, ArmorType.HELMET, factory);
    }

    /**
     * Registers a chestplate with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered chestplate item
     */
    default <R extends Item> ItemHandle<R> registerChestplate(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_chestplate", material, ArmorType.CHESTPLATE, factory);
    }

    /**
     * Registers leggings with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered leggings item
     */
    default <R extends Item> ItemHandle<R> registerLeggings(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_leggings", material, ArmorType.LEGGINGS, factory);
    }

    /**
     * Registers boots with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered boots item
     */
    default <R extends Item> ItemHandle<R> registerBoots(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_boots", material, ArmorType.BOOTS, factory);
    }

    /**
     * Registers body armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered body armor item
     */
    default <R extends Item> ItemHandle<R> registerBody(String name, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_body", material, ArmorType.BODY, factory);
    }

    /**
     * Registers an armor item with default settings and a material.
     *
     * @param name            the name of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @return the registered armor item
     */
    default ItemHandle<Item> registerArmor(String name, ArmorMaterial material, ArmorType equipment)
    {
        return register(name, new Item.Properties().humanoidArmor(material, equipment), Item::new);
    }

    /**
     * Registers a helmet with default settings.
     *
     * @param name     the base name of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @return the registered helmet item
     */
    default ItemHandle<Item> registerHelmet(String name, ArmorMaterial material)
    {
        return registerArmor(name + "_helmet", material, ArmorType.HELMET, Item::new);
    }

    /**
     * Registers a chestplate with default settings.
     *
     * @param name     the base name of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @return the registered chestplate item
     */
    default ItemHandle<Item> registerChestplate(String name, ArmorMaterial material)
    {
        return registerArmor(name + "_chestplate", material, ArmorType.CHESTPLATE, Item::new);
    }

    /**
     * Registers leggings with default settings.
     *
     * @param name     the base name of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @return the registered leggings item
     */
    default ItemHandle<Item> registerLeggings(String name, ArmorMaterial material)
    {
        return registerArmor(name + "_leggings", material, ArmorType.LEGGINGS, Item::new);
    }

    /**
     * Registers boots with default settings.
     *
     * @param name     the base name of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @return the registered boots item
     */
    default ItemHandle<Item> registerBoots(String name, ArmorMaterial material)
    {
        return registerArmor(name + "_boots", material, ArmorType.BOOTS, Item::new);
    }

    /**
     * Registers body armor with default settings.
     *
     * @param name     the base name of the armor set (will have "_body" appended)
     * @param material the armor material
     * @return the registered body armor item
     */
    default ItemHandle<Item> registerBody(String name, ArmorMaterial material)
    {
        return registerArmor(name + "_body", material, ArmorType.BODY, Item::new);
    }

    /**
     * Registers an armor item with custom settings and a material.
     *
     * @param name            the name of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param settings        the custom settings for the armor item
     * @param factory         the factory used to create instances of the tool item
     * @return the registered armor item
     */
    default <R extends Item> ItemHandle<R> registerArmor(String name, ArmorMaterial material, ArmorType equipment, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(name, settings.humanoidArmor(material, equipment), factory);
    }

    /**
     * Registers a helmet with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered helmet item
     */
    default <R extends Item> ItemHandle<R> registerHelmet(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_helmet", material, ArmorType.HELMET, factory);
    }

    /**
     * Registers a chestplate with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered chestplate item
     */
    default <R extends Item> ItemHandle<R> registerChestplate(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_chestpalte", material, ArmorType.CHESTPLATE, factory);
    }

    /**
     * Registers leggings with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered leggings item
     */
    default <R extends Item> ItemHandle<R> registerLeggings(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_leggings", material, ArmorType.LEGGINGS, factory);
    }

    /**
     * Registers boots with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered boots item
     */
    default <R extends Item> ItemHandle<R> registerBoots(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_boots", material, ArmorType.BOOTS, factory);
    }

    /**
     * Registers body armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param name     the base name of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered body armor item
     */
    default <R extends Item> ItemHandle<R> registerBody(String name, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(name + "_body", material, ArmorType.BODY, factory);
    }

    /**
     * Registers an armor item with custom settings and a material.
     *
     * @param name            the name of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param settings        the custom settings for the armor item
     * @return the registered armor item
     */
    default ItemHandle<Item> registerArmor(String name, ArmorMaterial material, ArmorType equipment, Item.Properties settings)
    {
        return register(name, settings.humanoidArmor(material, equipment), Item::new);
    }

    /**
     * Registers a helmet with custom settings.
     *
     * @param name     the base name of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered helmet item
     */
    default ItemHandle<Item> registerHelmet(String name, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(name + "_helmet", material, ArmorType.HELMET, Item::new);
    }

    /**
     * Registers a chestplate with custom settings.
     *
     * @param name     the base name of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered chestplate item
     */
    default ItemHandle<Item> registerChestplate(String name, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(name + "_chestplate", material, ArmorType.CHESTPLATE, Item::new);
    }

    /**
     * Registers leggings with custom settings.
     *
     * @param name     the base name of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered leggings item
     */
    default ItemHandle<Item> registerLeggings(String name, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(name + "_leggings", material, ArmorType.LEGGINGS, Item::new);
    }

    /**
     * Registers boots with custom settings.
     *
     * @param name     the base name of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered boots item
     */
    default ItemHandle<Item> registerBoots(String name, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(name + "_boots", material, ArmorType.BOOTS, Item::new);
    }

    /**
     * Registers body armor with custom settings.
     *
     * @param name     the base name of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered body armor item
     */
    default ItemHandle<Item> registerBody(String name, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(name + "_body", material, ArmorType.BODY, Item::new);
    }
    //endregion
    //endregion

    //region FOOD
    /**
     * Registers a snack food item with default settings.
     *
     * @param name            the name of the food item
     * @param stackCount      the maximum stack size for the food item
     * @param nutrition       the nutritional value of the food item
     * @param saturation      the saturation modifier of the food item
     * @return the registered snack food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, int nutrition, float saturation, boolean alwaysEdibale)
    {
        return registerFood(name, stackCount, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale));
    }

    /**
     * Registers a food item with specified nutrition and saturation with default max stack of 64.
     *
     * @param name          the name of the food item
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int nutrition, float saturation, boolean alwaysEdibale)
    {
        return registerFood(name, 64, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale));
    }

    /**
     * Registers a consumable food item with specified stack count, nutrition, saturation, and consumable effect.
     *
     * @param name          the name of the food item
     * @param stackCount    the maximum stack size
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @param consumable    the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, int nutrition, float saturation, boolean alwaysEdibale, Consumable consumable)
    {
        return registerFood(name, stackCount, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale), consumable);
    }

    /**
     * Registers a consumable food item with specified nutrition, saturation, and consumable effect with default max stack of 64.
     *
     * @param name          the name of the food item
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @param consumable    the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int nutrition, float saturation, boolean alwaysEdibale, Consumable consumable)
    {
        return registerFood(name, 64, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale), consumable);
    }

    /**
     * Registers a food item with given FoodProperties and custom stack count.
     *
     * @param name       the name of the food item
     * @param stackCount the maximum stack size
     * @param properties the food properties
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, FoodProperties properties)
    {
        return register(name, stackCount,
                        new Item.Properties()
                                .food(properties));
    }

    /**
     * Registers a food item with given FoodProperties and default max stack of 64.
     *
     * @param name       the name of the food item
     * @param properties the food properties
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, FoodProperties properties)
    {
        return registerFood(name, 64, properties);
    }

    /**
     * Registers a food item with given FoodProperties, custom stack count, and consumable component.
     *
     * @param name       the name of the food item
     * @param stackCount the maximum stack size
     * @param properties the food properties
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, FoodProperties properties, Consumable consumable)
    {
        return register(name, stackCount,
                        new Item.Properties()
                                .food(properties, consumable));
    }

    /**
     * Registers a food item with given FoodProperties and consumable component with default max stack of 64.
     *
     * @param name       the name of the food item
     * @param properties the food properties
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, FoodProperties properties, Consumable consumable)
    {
        return registerFood(name, 64, properties, consumable);
    }

    /**
     * Registers a food item with default settings.
     *
     * @param name            the name of the food item
     * @param stackCount      the maximum stack size for the food item
     * @param nutrition       the nutritional value of the food item
     * @param saturation      the saturation modifier of the food item
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, int nutrition, float saturation)
    {
        return registerFood(name, stackCount, nutrition, saturation, false);
    }

    /**
     * Registers a food item with specified nutrition and saturation with default max stack of 64.
     *
     * @param name       the name of the food item
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int nutrition, float saturation)
    {
        return registerFood(name, 64, nutrition, saturation, false);
    }

    /**
     * Registers a food item with specified nutrition, saturation, stack count, and consumable component.
     *
     * @param name       the name of the food item
     * @param stackCount the maximum stack size
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int stackCount, int nutrition, float saturation, Consumable consumable)
    {
        return registerFood(name, stackCount, nutrition, saturation, false, consumable);
    }

    /**
     * Registers a food item with specified nutrition, saturation, and consumable component with default max stack of 64.
     *
     * @param name       the name of the food item
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(String name, int nutrition, float saturation, Consumable consumable)
    {
        return registerFood(name, 64, nutrition, saturation, false, consumable);
    }
    //endregion
    //endregion

    //region Specials
    //region Tools
    /**
     * Registers an axe with default settings and a material.
     *
     * @param key    the resource key of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered axe item
     */
    default <R extends Item> ItemHandle<R> registerAxe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().axe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers an axe with default settings and a material.
     *
     * @param key    the resource key of the axe
     * @param material        the tool material for the axe
     * @param attackDamage    the attack damage of the axe
     * @param attackSpeed     the attack speed of the axe
     * @return the registered axe item
     */
    default ItemHandle<Item> registerAxe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(key, new Item.Properties().axe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param key    the resource key of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered hoe item
     */
    default <R extends Item> ItemHandle<R> registerHoe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().hoe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a hoe with default settings and a material.
     *
     * @param key    the resource key of the hoe
     * @param material        the tool material for the hoe
     * @param attackDamage    the attack damage of the hoe
     * @param attackSpeed     the attack speed of the hoe
     * @return the registered hoe item
     */
    default ItemHandle<Item> registerHoe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(key, new Item.Properties().hoe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param key    the resource key of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @param factory         the factory used to create instances of the tool item
     * @return the registered pickaxe item
     */
    default <R extends Item> ItemHandle<R> registerPickaxe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a pickaxe with default settings and a material.
     *
     * @param key    the resource key of the pickaxe
     * @param material        the tool material for the pickaxe
     * @param attackDamage    the attack damage of the pickaxe
     * @param attackSpeed     the attack speed of the pickaxe
     * @return the registered pickaxe item
     */
    default ItemHandle<Item> registerPickaxe(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(key, new Item.Properties().pickaxe(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param key    the resource key of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @param factory         the factory used to create instances of the tool item
     * @return the registered shovel item
     */
    default <R extends Item> ItemHandle<R> registerShovel(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().shovel(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a shovel with default settings and a material.
     *
     * @param key    the resource key of the shovel
     * @param material        the tool material for the shovel
     * @param attackDamage    the attack damage of the shovel
     * @param attackSpeed     the attack speed of the shovel
     * @return the registered shovel item
     */
    default ItemHandle<Item> registerShovel(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(key, new Item.Properties().shovel(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a sword with default settings and a material.
     *
     * @param key    the resource key of the sword
     * @param material        the tool material for the sword
     * @param attackDamage    the attack damage of the sword
     * @param attackSpeed     the attack speed of the sword
     * @param factory         the factory used to create instances of the tool item
     * @return the registered sword item
     */
    default <R extends Item> ItemHandle<R>  registerSword(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().sword(material, attackDamage, attackSpeed), factory);
    }

    /**
     * Registers a sword with default settings and a material.
     *
     * @param key    the resource key of the sword
     * @param material        the tool material for the sword
     * @param attackDamage    the attack damage of the sword
     * @param attackSpeed     the attack speed of the sword
     * @return the registered sword item
     */
    default ItemHandle<Item> registerSword(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(key, new Item.Properties().sword(material, attackDamage, attackSpeed), Item::new);
    }

    /**
     * Registers a tool with default settings and a material.
     *
     * @param <R>             the type of the tool item
     * @param key    the resource key of the tool item
     * @param material        the tool material for the tool
     * @param attackDamage    the attack damage of the tool
     * @param attackSpeed     the attack speed of the tool
     * @param factory         the factory used to create instances of the tool item
     * @return the registered tool item
     */
    <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed, IToolFactory<Item.Properties, ? extends R> factory);

    /**
     * Registers a tool with custom settings and a material.
     *
     * @param <R>             the type of the tool item
     * @param key    the resource key of the tool item
     * @param material        the tool material for the tool
     * @param attackDamage    the attack damage of the tool
     * @param attackSpeed     the attack speed of the tool
     * @param settings        the custom settings for the tool item
     * @param factory         the factory used to create instances of the tool item
     * @return the registered tool item
     */
    <R extends Item> ItemHandle<R> registerTool(ResourceKey<Item> key, ToolMaterial material, float attackDamage, float attackSpeed,
                                            Item.Properties settings, IToolFactory<Item.Properties, ? extends R> factory);
    //endregion

    //region Armor
    //region Animals
    /**
     * Registers horse armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the horse armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered horse armor item
     */
    default <R extends Item> ItemHandle<R> registerHorseArmor(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().horseArmor(material), factory);
    }

    /**
     * Registers nautilus armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the nautilus armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered nautilus armor item
     */
    default <R extends Item> ItemHandle<R> registerNautilusArmor(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().nautilusArmor(material), factory);
    }

    /**
     * Registers wolf armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the wolf armor item
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered wolf armor item
     */
    default <R extends Item> ItemHandle<R> registerWolfArmor(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().wolfArmor(material), factory);
    }

    /**
     * Registers horse armor with default settings.
     *
     * @param key    the resource key of the horse armor item
     * @param material the armor material
     * @return the registered horse armor item
     */
    default ItemHandle<Item> registerHorseArmor(ResourceKey<Item> key, ArmorMaterial material)
    {
        return register(key, new Item.Properties().horseArmor(material), Item::new);
    }

    /**
     * Registers nautilus armor with default settings.
     *
     * @param key    the resource key of the nautilus armor item
     * @param material the armor material
     * @return the registered nautilus armor item
     */
    default ItemHandle<Item> registerNautilusArmor(ResourceKey<Item> key, ArmorMaterial material)
    {
        return register(key, new Item.Properties().nautilusArmor(material), Item::new);
    }

    /**
     * Registers wolf armor with default settings.
     *
     * @param key    the resource key of the wolf armor item
     * @param material the armor material
     * @return the registered wolf armor item
     */
    default ItemHandle<Item> registerWolfArmor(ResourceKey<Item> key, ArmorMaterial material)
    {
        return register(key, new Item.Properties().wolfArmor(material), Item::new);
    }

    /**
     * Registers horse armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the horse armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered horse armor item
     */
    default <R extends Item> ItemHandle<R> registerHorseArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, settings.horseArmor(material), factory);
    }

    /**
     * Registers nautilus armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the nautilus armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered nautilus armor item
     */
    default <R extends Item> ItemHandle<R> registerNautilusArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, settings.nautilusArmor(material), factory);
    }

    /**
     * Registers wolf armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the wolf armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered wolf armor item
     */
    default <R extends Item> ItemHandle<R> registerWolfArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, settings.wolfArmor(material), factory);
    }

    /**
     * Registers horse armor with custom settings.
     *
     * @param key    the resource key of the horse armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered horse armor item
     */
    default ItemHandle<Item> registerHorseArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return register(key, settings.horseArmor(material), Item::new);
    }

    /**
     * Registers nautilus armor with custom settings.
     *
     * @param key    the resource key of the nautilus armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered nautilus armor item
     */
    default ItemHandle<Item> registerNautilusArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return register(key, settings.nautilusArmor(material), Item::new);
    }

    /**
     * Registers wolf armor with custom settings.
     *
     * @param key    the resource key of the wolf armor item
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered wolf armor item
     */
    default ItemHandle<Item> registerWolfArmor(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return register(key, settings.wolfArmor(material), Item::new);
    }
    //endregion

    //region Humanoid
    /**
     * Registers an armor item with default settings and a material.
     *
     * @param key    the resource key of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param factory         the factory used to create instances of the tool item
     * @return the registered armor item
     */
    default <R extends Item> ItemHandle<R> registerArmor(ResourceKey<Item> key, ArmorMaterial material, ArmorType equipment, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, new Item.Properties().humanoidArmor(material, equipment), factory);
    }

    /**
     * Registers a helmet with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered helmet item
     */
    default <R extends Item> ItemHandle<R> registerHelmet(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.HELMET, factory);
    }

    /**
     * Registers a chestplate with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered chestplate item
     */
    default <R extends Item> ItemHandle<R> registerChestplate(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.CHESTPLATE, factory);
    }

    /**
     * Registers leggings with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered leggings item
     */
    default <R extends Item> ItemHandle<R> registerLeggings(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.LEGGINGS, factory);
    }

    /**
     * Registers boots with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered boots item
     */
    default <R extends Item> ItemHandle<R> registerBoots(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.BOOTS, factory);
    }

    /**
     * Registers body armor with default settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param factory  the factory creating the item
     * @return the registered body armor item
     */
    default <R extends Item> ItemHandle<R> registerBody(ResourceKey<Item> key, ArmorMaterial material, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.BODY, factory);
    }

    /**
     * Registers an armor item with default settings and a material.
     *
     * @param key    the resource key of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @return the registered armor item
     */
    default ItemHandle<Item> registerArmor(ResourceKey<Item> key, ArmorMaterial material, ArmorType equipment)
    {
        return register(key, new Item.Properties().humanoidArmor(material, equipment), Item::new);
    }

    /**
     * Registers a helmet with default settings.
     *
     * @param key    the resource key of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @return the registered helmet item
     */
    default ItemHandle<Item> registerHelmet(ResourceKey<Item> key, ArmorMaterial material)
    {
        return registerArmor(key, material, ArmorType.HELMET, Item::new);
    }

    /**
     * Registers a chestplate with default settings.
     *
     * @param key    the resource key of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @return the registered chestplate item
     */
    default ItemHandle<Item> registerChestplate(ResourceKey<Item> key, ArmorMaterial material)
    {
        return registerArmor(key, material, ArmorType.CHESTPLATE, Item::new);
    }

    /**
     * Registers leggings with default settings.
     *
     * @param key    the resource key of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @return the registered leggings item
     */
    default ItemHandle<Item> registerLeggings(ResourceKey<Item> key, ArmorMaterial material)
    {
        return registerArmor(key, material, ArmorType.LEGGINGS, Item::new);
    }

    /**
     * Registers boots with default settings.
     *
     * @param key    the resource key of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @return the registered boots item
     */
    default ItemHandle<Item> registerBoots(ResourceKey<Item> key, ArmorMaterial material)
    {
        return registerArmor(key, material, ArmorType.BOOTS, Item::new);
    }

    /**
     * Registers body armor with default settings.
     *
     * @param key    the resource key of the armor set (will have "_body" appended)
     * @param material the armor material
     * @return the registered body armor item
     */
    default ItemHandle<Item> registerBody(ResourceKey<Item> key, ArmorMaterial material)
    {
        return registerArmor(key, material, ArmorType.BODY, Item::new);
    }

    /**
     * Registers an armor item with custom settings and a material.
     *
     * @param key    the resource key of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param settings        the custom settings for the armor item
     * @param factory         the factory used to create instances of the tool item
     * @return the registered armor item
     */
    default <R extends Item> ItemHandle<R> registerArmor(ResourceKey<Item> key, ArmorMaterial material, ArmorType equipment, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return register(key, settings.humanoidArmor(material, equipment), factory);
    }

    /**
     * Registers a helmet with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered helmet item
     */
    default <R extends Item> ItemHandle<R> registerHelmet(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.HELMET, factory);
    }

    /**
     * Registers a chestplate with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered chestplate item
     */
    default <R extends Item> ItemHandle<R> registerChestplate(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.CHESTPLATE, factory);
    }

    /**
     * Registers leggings with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered leggings item
     */
    default <R extends Item> ItemHandle<R> registerLeggings(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.LEGGINGS, factory);
    }

    /**
     * Registers boots with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered boots item
     */
    default <R extends Item> ItemHandle<R> registerBoots(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.BOOTS, factory);
    }

    /**
     * Registers body armor with custom settings and a custom factory.
     *
     * @param <R>      the concrete item type
     * @param key    the resource key of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered body armor item
     */
    default <R extends Item> ItemHandle<R> registerBody(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings, Function<Item.Properties, ? extends R> factory)
    {
        return registerArmor(key, material, ArmorType.BODY, factory);
    }

    /**
     * Registers an armor item with custom settings and a material.
     *
     * @param key    the resource key of the armor item
     * @param material        the armor material for the armor item
     * @param equipment   the type of armor (e.g., helmet, chestplate)
     * @param settings        the custom settings for the armor item
     * @return the registered armor item
     */
    default ItemHandle<Item> registerArmor(ResourceKey<Item> key, ArmorMaterial material, ArmorType equipment, Item.Properties settings)
    {
        return register(key, settings.humanoidArmor(material, equipment), Item::new);
    }

    /**
     * Registers a helmet with custom settings.
     *
     * @param key    the resource key of the armor set (will have "_helmet" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered helmet item
     */
    default ItemHandle<Item> registerHelmet(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(key, material, ArmorType.HELMET, Item::new);
    }

    /**
     * Registers a chestplate with custom settings.
     *
     * @param key    the resource key of the armor set (will have "_chestplate" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered chestplate item
     */
    default ItemHandle<Item> registerChestplate(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(key, material, ArmorType.CHESTPLATE, Item::new);
    }

    /**
     * Registers leggings with custom settings.
     *
     * @param key    the resource key of the armor set (will have "_leggings" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered leggings item
     */
    default ItemHandle<Item> registerLeggings(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(key, material, ArmorType.LEGGINGS, Item::new);
    }

    /**
     * Registers boots with custom settings.
     *
     * @param key    the resource key of the armor set (will have "_boots" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered boots item
     */
    default ItemHandle<Item> registerBoots(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(key, material, ArmorType.BOOTS, Item::new);
    }

    /**
     * Registers body armor with custom settings.
     *
     * @param key    the resource key of the armor set (will have "_body" appended)
     * @param material the armor material
     * @param settings the custom item properties
     * @return the registered body armor item
     */
    default ItemHandle<Item> registerBody(ResourceKey<Item> key, ArmorMaterial material, Item.Properties settings)
    {
        return registerArmor(key, material, ArmorType.BODY, Item::new);
    }
    //endregion
    //endregion

    //region FOOD
    /**
     * Registers a snack food item with default settings.
     *
     * @param key    the resource key of the food item
     * @param stackCount      the maximum stack size for the food item
     * @param nutrition       the nutritional value of the food item
     * @param saturation      the saturation modifier of the food item
     * @return the registered snack food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, int nutrition, float saturation, boolean alwaysEdibale)
    {
        return registerFood(key, stackCount, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale));
    }

    /**
     * Registers a food item with specified nutrition and saturation with default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int nutrition, float saturation, boolean alwaysEdibale)
    {
        return registerFood(key, 64, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale));
    }

    /**
     * Registers a consumable food item with specified stack count, nutrition, saturation, and consumable effect.
     *
     * @param key    the resource key of the food item
     * @param stackCount    the maximum stack size
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @param consumable    the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, int nutrition, float saturation, boolean alwaysEdibale, Consumable consumable)
    {
        return registerFood(key, stackCount, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale), consumable);
    }

    /**
     * Registers a consumable food item with specified nutrition, saturation, and consumable effect with default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param nutrition     the nutritional value
     * @param saturation    the saturation modifier
     * @param alwaysEdibale whether the item can always be eaten even when full
     * @param consumable    the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int nutrition, float saturation, boolean alwaysEdibale, Consumable consumable)
    {
        return registerFood(key, 64, BaseHelper.Foods.getProperties(nutrition, saturation, alwaysEdibale), consumable);
    }

    /**
     * Registers a food item with given FoodProperties and custom stack count.
     *
     * @param key    the resource key of the food item
     * @param stackCount the maximum stack size
     * @param properties the food properties
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, FoodProperties properties)
    {
        return register(key, stackCount,
                        new Item.Properties()
                                .food(properties));
    }

    /**
     * Registers a food item with given FoodProperties and default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param properties the food properties
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, FoodProperties properties)
    {
        return registerFood(key, 64, properties);
    }

    /**
     * Registers a food item with given FoodProperties, custom stack count, and consumable component.
     *
     * @param key    the resource key of the food item
     * @param stackCount the maximum stack size
     * @param properties the food properties
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, FoodProperties properties, Consumable consumable)
    {
        return register(key, stackCount,
                        new Item.Properties()
                                .food(properties, consumable));
    }

    /**
     * Registers a food item with given FoodProperties and consumable component with default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param properties the food properties
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, FoodProperties properties, Consumable consumable)
    {
        return registerFood(key, 64, properties, consumable);
    }

    /**
     * Registers a food item with default settings.
     *
     * @param key    the resource key of the food item
     * @param stackCount      the maximum stack size for the food item
     * @param nutrition       the nutritional value of the food item
     * @param saturation      the saturation modifier of the food item
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, int nutrition, float saturation)
    {
        return registerFood(key, stackCount, nutrition, saturation, false);
    }

    /**
     * Registers a food item with specified nutrition and saturation with default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int nutrition, float saturation)
    {
        return registerFood(key, 64, nutrition, saturation, false);
    }

    /**
     * Registers a food item with specified nutrition, saturation, stack count, and consumable component.
     *
     * @param key    the resource key of the food item
     * @param stackCount the maximum stack size
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int stackCount, int nutrition, float saturation, Consumable consumable)
    {
        return registerFood(key, stackCount, nutrition, saturation, false, consumable);
    }

    /**
     * Registers a food item with specified nutrition, saturation, and consumable component with default max stack of 64.
     *
     * @param key    the resource key of the food item
     * @param nutrition  the nutritional value
     * @param saturation the saturation modifier
     * @param consumable the consumable component behavior
     * @return the registered food item
     */
    default ItemHandle<Item> registerFood(ResourceKey<Item> key, int nutrition, float saturation, Consumable consumable)
    {
        return registerFood(key, 64, nutrition, saturation, false, consumable);
    }
    //endregion
    //endregion

    //region Main Overloads
    /**
     * Registers an item with a ResourceKey and custom factory using default properties.
     *
     * @param <R>     the concrete item type
     * @param key     the resource key for the item registry
     * @param factory the factory creating the item
     * @return the registered item instance
     */
    <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Function<Item.Properties, ? extends R> factory);

    /**
     * Registers an item with a ResourceKey, specified stack count, and custom factory.
     *
     * @param <R>        the concrete item type
     * @param key        the resource key for the item registry
     * @param stackCount the maximum stack size
     * @param factory    the factory creating the item
     * @return the registered item instance
     */
    <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Function<Item.Properties, ? extends R> factory);

    /**
     * Registers an item with a ResourceKey, custom properties, and custom factory.
     *
     * @param <R>      the concrete item type
     * @param key      the resource key for the item registry
     * @param settings the custom item properties
     * @param factory  the factory creating the item
     * @return the registered item instance
     */
    <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, Item.Properties settings, Function<Item.Properties, ? extends R> factory);


    /**
     * Registers an item with a ResourceKey, stack count, custom properties, and custom factory.
     *
     * @param <R>        the concrete item type
     * @param key        the resource key for the item registry
     * @param stackCount the maximum stack size
     * @param settings   the custom item properties
     * @param factory    the factory creating the item
     * @return the registered item instance
     */
    <R extends Item> ItemHandle<R> register(ResourceKey<Item> key, int stackCount, Item.Properties settings, Function<Item.Properties, ? extends R> factory);
    //endregion
}