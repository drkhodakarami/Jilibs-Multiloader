package com.dynamero.jilibs.platform.services.registrars.utils;

import net.neoforged.bus.api.IEventBus;

public interface INeoForgeRegistrar
{
    void register(IEventBus eventBus);
}