package com.dotkntrell.mc.terraformer.generation;

import com.dotkntrell.mc.terraformer.io.reader.ChunkReader;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import java.util.Random;

interface Merger {

    void mergeLand(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkGenerator.ChunkData chunkData);
    void mergeBiomes(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, AugmentedChunkData chunkData);
}
