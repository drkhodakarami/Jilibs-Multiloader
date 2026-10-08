# Vas - Mod Architecture Knowledge Base

## Overview

Vas is the container and material storage mod of the [Ars Mundi](https://chatgpt.com/c/Ars%20Mundi) ecosystem.

Name:

Vas

Pronunciation:

VAHS

Meaning:

Vas comes from Latin and refers to:

- vessel
    
- container
    
- receptacle
    
- something used to hold another substance
    

The name represents the purpose of this mod:

> Providing vessels for materials that need to be contained and stored.

Vas is not about processing materials.

It is not about generating materials.

It is not about transporting materials.

It is about **containing them**.

---

# Role in Ars Mundi

Ars Mundi is divided into different disciplines.

Each mod represents a specific area of mastery.

Vas represents:

> The discipline of containment and material storage.

[Materia](https://chatgpt.com/c/Materia) provides:

- materials
    
- gems
    
- exotic resources
    

Vas provides the means to contain materials that cannot simply exist as ordinary solid items.

Vas answers:

> How can the materials of the world be stored and contained for later use?

---

# Core Philosophy

## Materials Need Vessels

In Minecraft, ordinary solid materials can simply exist as items inside an inventory.

Fluids and gases are different.

They require specialized containers if they are going to be:

- collected
    
- stored
    
- transported
    
- preserved
    
- used later
    

Vas expands the concept of storage into these materials.

The container itself is not the important part.

The important part is:

> **The material has somewhere to exist.**

---

# Vas Is Not a Processing Mod

Vas does not process the materials it contains.

It does not:

- transform fluids
    
- refine materials
    
- generate gases
    
- convert materials
    
- manufacture resources
    

Those responsibilities belong to other mods.

Vas only provides the vessel.

---

# Vas Is Not Tractus

A critical design separation exists between Vas and [Tractus](https://chatgpt.com/c/Tractus).

Tractus provides:

- extraction
    
- fluid collection
    
- world interaction
    

Vas provides:

- containment
    
- material storage
    

Tractus takes material from the world.

Vas gives that material somewhere to stay.

---

# Container Philosophy

Vas containers are intended primarily for materials that require specialized containment.

This includes:

- fluids
    
- gases
    
- other non-solid materials that may be introduced in the future
    

The containers should remain focused on their primary purpose.

They should not become machines simply because other machines can interact with them.

---

# Fluid Containers

Vas provides containers capable of storing fluids.

These may include:

- water
    
- lava
    
- future ecosystem fluids
    

A fluid can therefore be removed from its original location and stored for later use.

For example:

World fluid

↓

Tractus

↓

Vas container

The container does not need to know where the fluid originated.

---

# Gas Containers

Vas also provides containers for gases.

Gas requires specialized containment because it cannot simply be treated as a normal solid item.

Vas provides the vessel.

Other systems determine:

- how the gas is generated
    
- how it is extracted
    
- how it is processed
    
- how it is transported
    
- how it is consumed
    

---

# Future Material Containers

Vas should not be permanently restricted to only the fluids and gases that exist when the mod is first released.

If Ars Mundi introduces another non-solid material that requires containment, Vas should be the natural location for its container.

The principle is:

> If a material needs a vessel, Vas should provide that vessel.

---

# Container Interaction

Vas containers are designed to interact with other Ars Mundi systems.

A container can potentially act as:

- an input
    
- an output
    
- a storage location
    
- an intermediate location
    

This allows multiple mods to form complete material systems without duplicating storage mechanics.

Example:

Tractus

↓

Vas

↓

Fistula

↓

Machinum

↓

Vas

Each mod performs a different role.

---

# Material Progression

Vas should use the existing material progression of Ars Mundi wherever possible.

The mod should not introduce unnecessary new ores or materials solely to create container tiers.

Existing materials can provide the progression for increasingly advanced containers.

This keeps Vas connected to the broader ecosystem.

---

# Exodium Containers

Exodium represents one of the most advanced materials available in Ars Mundi.

Because of its rarity and exotic properties, it is suitable for advanced containment systems.

Exodium-based containers can represent:

- high capacity
    
- advanced containment
    
- exotic materials
    
- late-game progression
    

However, Exodium should not be used simply for decoration.

Its use should have a meaningful gameplay purpose.

---

# Relationship With Materia

Materia provides:

- materials
    
- gems
    
- exotic resources
    

Vas uses those materials to create:

- containers
    
- vessels
    
- storage systems for non-solid materials
    

Example:

Materia:

Exodium exists.

Vas:

Exodium can be used to create advanced containment.

---

# Relationship With Tractus

Tractus and Vas form a natural material workflow.

Tractus:

> Extracts.

Vas:

> Contains.

For example:

A fluid exists in the world.

↓

Tractus extracts it.

↓

Vas stores it.

This keeps extraction and storage as separate systems.

---

# Relationship With Fistula

[Fistula](https://chatgpt.com/c/Fistula) is responsible for transportation through pipes and cables.

Vas is responsible for containment.

The relationship is:

> Vas = where the material stays.

> Fistula = how the material travels.

A Vas container can therefore serve as:

- a source for a Fistula network
    
- a destination for a Fistula network
    
- an intermediate storage point
    

---

# Relationship With Machinum

[Machinum](https://chatgpt.com/c/Machinum) is responsible for machines and processing.

Machines can consume materials stored in Vas containers.

Machines can also produce materials that can be placed into Vas containers.

Example:

Vas

↓

Machinum

↓

Vas

The machine performs the operation.

The containers provide the material locations.

---

# Relationship With Mutare

[Mutare](https://chatgpt.com/c/Mutare) contains systems that directly manipulate the world.

Several Mutare blocks interact specifically with fluids.

Examples:

Fontis:

- generates water
    

Siccus:

- removes water
    

Calor:

- generates lava
    

Siccatio:

- removes lava
    

Vas can provide containers for the fluids generated or collected through these systems.

The distinction remains:

> Mutare manipulates the world.

> Vas contains the material.

---

# Relationship With Potestas

[Potestas](https://chatgpt.com/c/Potestas) is responsible for energy generation and energy storage in block form.

Vas does not provide:

- batteries
    
- capacitors
    
- energy storage blocks
    
- energy generation
    

Potestas provides:

- generators
    
- Reservoir storage blocks
    

Vas provides:

- material containment
    

This separation prevents Vas from becoming a generic storage system for every resource in the game.

---

# Container Design Philosophy

## A Container Should Remain a Container

Vas should avoid turning containers into complicated machines.

A container may have:

- a capacity
    
- a stored material
    
- a visual representation of its contents
    
- interaction with other systems
    

But these features exist to support containment.

They should not turn the container into:

- a generator
    
- a processor
    
- a pump
    
- a machine
    
- a transportation network
    

---

# What Does Not Belong in Vas

The following systems intentionally do not belong in Vas.

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

## World Manipulation

Belongs to:

Mutare

---

## Energy Storage

Belongs to:

Potestas

---

## Energy Generation

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

## Backpacks

Belongs to:

Peram

---

## Player Abilities

Belongs to:

Praxis

---

# Ars Vitae Relationship

Vas is one of the utility-focused modules that can exist within [Ars Vitae](https://chatgpt.com/c/Ars%20Vitae).

Ars Vitae focuses on the non-tech aspects of the ecosystem.

Vas fits naturally into this environment because material containment does not require the player to use the full technological progression of Ars Mundi.

It can work alongside:

- Arma
    
- Lorica
    
- Peram
    
- Cista
    
- Praxis
    
- Mutare
    

Vas therefore provides useful material storage without requiring machines or industrial systems.

---

# Ars Mundi Relationship

In the complete Ars Mundi ecosystem, Vas becomes part of the larger material infrastructure.

It connects naturally with:

- Materia
    
- Tractus
    
- Fistula
    
- Machinum
    
- Mutare
    
- Potestas
    

Each system has its own responsibility.

Vas provides the place where materials can wait between those systems.

---

# Long-Term Philosophy

Vas should remain focused even as Ars Mundi expands.

Whenever a new feature is proposed, the question should be:

> Is this fundamentally a containment mechanic?

If yes:

It may belong in Vas.

If it instead:

- generates
    
- extracts
    
- processes
    
- transports
    
- transforms
    
- manipulates
    

the material, it should belong to another mod.

This keeps Vas from becoming an oversized storage or technology mod.

---

# Final Philosophy

Vas represents one of the simplest concepts in Ars Mundi.

Materials need somewhere to exist.

Fluids need vessels.

Gases need vessels.

Future non-solid materials may need vessels as well.

Vas provides those vessels.

It does not generate the material.

It does not extract the material.

It does not process the material.

It does not transport the material.

It simply contains it.

**Vas — The Vessels of the World.**