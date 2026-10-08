# Cista - Mod Architecture Knowledge Base

## Overview

Cista is the storage-focused mod of the [Ars Mundi](https://chatgpt.com/c/Ars%20Mundi) ecosystem.

Name:

Cista

Pronunciation:

KIS-ta

Meaning:

Cista comes from Latin and refers to:

- chest
    
- box
    
- basket
    
- container
    
- storage receptacle
    

Historically, a cista was a container used to store and carry objects.

The name represents the purpose of this mod:

> Providing dedicated storage systems for the materials and items collected by the player.

Cista focuses on **stationary storage**.

It provides:

- chests
    
- tanks
    
- expanded storage systems
    

Cista answers:

> Where can the player's accumulated resources be stored?

---

# Role in Ars Mundi

Ars Mundi is divided into different disciplines.

Each mod represents a specific area of mastery.

Cista represents:

> The discipline of storage and organization.

[Materia](https://chatgpt.com/c/Materia) provides:

- materials
    
- gems
    
- exotic resources
    

Cista provides:

- chests
    
- tanks
    
- storage capacity
    
- organized storage
    

Cista answers:

> How can the player store the resources they have gathered and produced?

---

# Core Philosophy

## Storage Should Be A System

Minecraft already provides basic storage through:

- chests
    
- barrels
    
- shulker boxes
    
- other vanilla containers
    

Cista expands this concept.

Storage becomes more than simply having a larger inventory.

Different storage systems can serve different purposes.

Some are intended for:

- large quantities of items
    
- specialized resources
    
- fluids
    
- production systems
    
- long-term storage
    
- organization
    

The purpose of Cista is therefore not simply to add larger containers.

It is to provide a broader **storage infrastructure** for Ars Mundi.

---

# Cista Is Not Peram

A critical design separation exists between Cista and [Peram](https://chatgpt.com/c/Peram).

Cista provides:

- stationary storage
    
- chests
    
- tanks
    
- large storage capacity
    

Peram provides:

- portable storage
    
- backpacks
    
- storage that travels with the player
    

The distinction is:

> Cista stores things in the world.

> Peram stores things with the player.

This keeps stationary and portable storage as separate systems.

---

# Cista Is Not Vas

Another important separation exists between Cista and [Vas](https://chatgpt.com/c/Vas).

Vas is responsible for **containers as vessels for materials**.

Cista is responsible for **storage systems**.

This distinction allows the two mods to work together.

For example:

Vas defines the concept of containing a particular material.

Cista can provide a storage block designed to hold large quantities of such material.

The relationship is:

> Vas provides containment functionality.

> Cista provides storage infrastructure.

---

# Chest Philosophy

Chests are the primary item-storage system of Cista.

A Cista chest should provide a clear and understandable way to store large quantities of items.

The chest system can expand upon the vanilla concept while maintaining the familiar interaction model.

The player should immediately understand:

> This is a place where my items go.

---

# Chest Progression

Cista can provide different tiers of chests.

The progression should be based on the existing materials of Ars Mundi rather than introducing unnecessary new resources.

Possible progression can make use of:

- wood
    
- stone
    
- iron
    
- copper
    
- gold
    
- Carminis
    
- Glaucus
    
- Flavum
    
- amethyst
    
- diamond
    
- emerald
    
- Exodium
    

The exact statistics and tier relationships should be defined separately from the core architecture.

The important principle is:

> Higher-tier materials provide more capable storage.

---

# Material Identity

Each advanced chest should retain the visual identity of its material.

A Carminis chest should look like Carminis.

A Glaucus chest should look like Glaucus.

A Flavum chest should look like Flavum.

An Exodium chest should clearly communicate its exotic nature.

This allows storage itself to become part of the material progression of Ars Mundi.

---

# Exodium Storage

Exodium represents one of the highest levels of material progression in Ars Mundi.

Because of this, Exodium is particularly suitable for advanced storage.

Exodium-based storage can represent:

- extremely high capacity
    
- advanced organization
    
- late-game storage
    
- exotic containment technology
    

The purpose is not simply to make a larger chest.

It should feel like the culmination of the storage progression.

---

# Tank Philosophy

Cista also provides **tanks**.

Tanks are the storage equivalent of chests for fluids and other appropriate materials.

While chests store items:

> Tanks store fluids.

This gives Cista two major storage categories:

- item storage
    
- fluid storage
    

The player should be able to recognize the difference immediately.

---

# Tank Storage

Tanks can store materials such as:

- water
    
- lava
    
- other fluids
    
- future ecosystem fluids
    

Their primary purpose is long-term storage rather than extraction.

A tank should not automatically become a pump.

It should not generate its contents.

It should simply provide a large, persistent storage location.

---

# Relationship Between Tanks and Vas

Vas provides the broader containment concept.

Cista provides dedicated large-scale storage infrastructure.

A Cista tank can therefore use the containment systems established by Vas while focusing on storage capacity and accessibility.

For example:

Tractus:

> extracts the fluid.

Vas:

> provides containment.

Cista:

> provides large-scale storage.

Fistula:

> transports it.

This creates a clear division of responsibility.

---

# Tank Progression

Like chests, tanks can progress through the established Ars Mundi materials.

Higher-tier tanks can provide:

- greater capacity
    
- stronger construction
    
- improved interaction
    
- more advanced storage
    

The progression should remain connected to the existing material hierarchy.

Exodium should represent one of the highest levels of tank progression.

---

# Relationship With Tractus

[Tractus](https://chatgpt.com/c/Tractus) is responsible for extraction.

Cista is responsible for storage.

The relationship is:

> Tractus extracts.

> Cista stores.

For example:

A fluid exists in the world.

↓

Tractus extracts the fluid.

↓

Cista tank stores the fluid.

The tank should not perform the extraction itself.

---

# Relationship With Fistula

[Fistula](https://chatgpt.com/c/Fistula) is responsible for transportation through pipes and cables.

Cista provides storage endpoints for those networks.

A Fistula network can potentially:

- fill a Cista tank
    
- extract from a Cista tank
    
- move materials between Cista storage systems
    

The relationship is:

> Cista = where the material waits.

> Fistula = how the material travels.

---

# Relationship With Machinum

[Machinum](https://chatgpt.com/c/Machinum) provides machines and processing systems.

Cista can provide storage for:

- machine inputs
    
- machine outputs
    
- intermediate resources
    
- processed materials
    

A production system may therefore look like:

Cista

↓

Machinum

↓

Cista

Storage provides the resources.

Machinum performs the operation.

Storage receives the result.

---

# Relationship With Potestas

[Potestas](https://chatgpt.com/c/Potestas) provides energy generation and energy storage.

Cista should not replace Potestas' dedicated energy storage system.

Potestas uses:

- Reservoirs
    
- energy storage mechanics
    

Cista uses:

- chests
    
- tanks
    
- material storage
    

The distinction remains:

> Cista stores materials.

> Potestas stores energy.

---

# Relationship With Materia

Materia provides the materials used throughout the Ars Mundi ecosystem.

Cista uses those materials to construct progressively more advanced storage.

This allows storage to participate naturally in the broader material progression.

Example:

Materia:

Exodium exists.

Cista:

Exodium storage exists.

The same material therefore becomes useful for:

- tools
    
- armor
    
- decoration
    
- storage
    
- other ecosystem systems
    

---

# Storage Philosophy

## Capacity Should Have Meaning

Higher-tier storage should not simply exist as a larger number attached to a block.

The progression should provide meaningful reasons to upgrade.

An advanced storage block can improve:

- capacity
    
- organization
    
- accessibility
    
- material compatibility
    
- interaction with automated systems
    

The exact benefits depend on the storage type.

---

# Stationary Storage

Cista storage is fundamentally **stationary**.

The player places it in the world.

It becomes part of their base, factory, workshop, warehouse, or other structure.

This differentiates it from portable storage.

The physical presence of storage should matter.

A large warehouse built from advanced Cista storage should feel like part of the player's progression.

---

# Storage Organization

Cista should encourage organization.

A player's resources can be separated according to:

- material
    
- function
    
- production stage
    
- rarity
    
- mod
    
- personal preference
    

The storage system should make large resource collections manageable rather than overwhelming.

---

# Storage and Automation

Cista storage should be designed to interact naturally with automation.

Automated systems may need places to:

- deposit items
    
- retrieve items
    
- store fluids
    
- buffer production
    
- hold intermediate resources
    

Cista can therefore act as the storage layer beneath automated systems.

For example:

Machinum produces an item.

↓

Cista stores it.

Fistula or another transportation system moves it elsewhere.

---

# What Does Not Belong in Cista

The following systems intentionally do not belong in Cista.

---

## Portable Storage

Belongs to:

Peram

---

## Material Containment

Belongs to:

Vas

---

## Fluid Extraction

Belongs to:

Tractus

---

## Material Processing

Belongs to:

Machinum

---

## Transportation Networks

Belongs to:

Fistula

---

## Energy Storage

Belongs to:

Potestas

---

## Tools

Belongs to:

Arma

---

## Armor

Belongs to:

Lorica

---

## Player Abilities

Belongs to:

Praxis

---

## Decorative Blocks

Belongs to:

Cultus

---

## Upgrade Systems

Belongs to:

Augmentum

---

# Ars Vitae Relationship

Cista is one of the important utility modules of [Ars Vitae](https://chatgpt.com/c/Ars%20Vitae).

Storage is useful regardless of whether the player uses the technological side of Ars Mundi.

A player can use Cista alongside:

- Arma
    
- Lorica
    
- Peram
    
- Praxis
    
- Mutare
    
- Cultus
    

without requiring the complete machinery ecosystem.

Cista therefore provides practical storage infrastructure for both survival-focused and technology-focused gameplay.

---

# Ars Mundi Relationship

In the complete Ars Mundi ecosystem, Cista provides the **storage layer**.

Materia provides resources.

Arma uses them.

Lorica protects the player.

Machinum processes them.

Fistula transports them.

Tractus extracts them.

Vas contains them.

Potestas stores energy.

Cista stores the physical resources that move through these systems.

---

# Long-Term Philosophy

Cista should remain focused on storage.

Whenever a new storage feature is proposed, the question should be:

> Is this fundamentally a stationary storage mechanic?

If yes:

It may belong in Cista.

If it instead focuses on:

- portability
    
- extraction
    
- processing
    
- transportation
    
- energy
    
- player abilities
    

it should belong to another mod.

This keeps Cista from becoming a generic utility mod.

---

# Final Philosophy

Cista represents the place where the player's accumulated world becomes organized.

Resources are gathered.

Materials are processed.

Items are produced.

Fluids are extracted.

Machines operate.

And eventually, everything needs somewhere to go.

Cista provides that place.

Chests hold the player's items.

Tanks hold the player's fluids.

Together they form the stationary storage infrastructure of Ars Mundi.

**Cista — The Storage of the World.**