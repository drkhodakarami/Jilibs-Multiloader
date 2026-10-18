package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.platform.services.registrars.utils.CommonStrippables;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;

public class FabricStrippableRegistrar implements IStrippableRegistrar
{
    public static void applyRuntime()
    {
        for (CommonStrippables.StrippableEntry entry : CommonStrippables.getEntries())
            BlockTransformerHelper.registerStripping(entry.input().get(), entry.output().get());
    }
}