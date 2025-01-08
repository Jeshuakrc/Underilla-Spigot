package com.jkantrell.mc.underilla.core.generation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.jkantrell.mc.underilla.core.api.ChunkData;
import com.jkantrell.mc.underilla.core.reader.ChunkReader;

interface Merger {

    // void merge(ChunkReader reader, ChunkData chunkData);
    void mergeLand(@Nonnull ChunkReader reader, @Nonnull ChunkData chunkData, @Nullable ChunkReader cavesReader);
}
