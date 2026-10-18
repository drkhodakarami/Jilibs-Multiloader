package com.dynamero.jilibs.interfaces;

import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.TagKey;

@FunctionalInterface
public interface TagLookup<T> {
    TagAppender<T> tag(TagKey<T> key);
}