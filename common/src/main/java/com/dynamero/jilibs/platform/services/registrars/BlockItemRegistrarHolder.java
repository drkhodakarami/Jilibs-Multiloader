package com.dynamero.jilibs.platform.services.registrars;

import com.dynamero.jilibs.contracts.exceptions.Exceptions;
import com.dynamero.jilibs.platform.services.registrars.utils.ModBlock;

import java.util.ArrayList;
import java.util.List;

final class BlockItemRegistrarHolder
{
    static final List<ModBlock<?, ?>> LIST = new ArrayList<>();

    private BlockItemRegistrarHolder()
    {
        Exceptions.throwCtorAssertion();
    }
}