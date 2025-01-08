# 2.0.0

## Features / Bug fix
- **Custom biomes are fully supported**. Structures will be generate correctly in custom biomes !
- **Caves biomes can be merge inside the final world** without needing an extra cavesWorld. And they are merged only under the world surface.
- **Carvers **can be run before world merging or after world merging. It is now possible to have carvers caves but still have a **clean surface without holes**. This option can be configure for each biome.
- **Chunks outside** of the surface world are now generated **empty**.
- **Cleaning step after the world generation**: Blocks can be replace from the custom world or on the final world. Entity can be remove in the final world.
- **Full process include.** Underilla will configure the server & download it's dependency, then start chunky when the server start, then clean the world. Each of the 3 generation steps can be restarted.

## Other major or breaking changes
- Complete reorganization of the configuration.
- Underilla now need Paper 1.21.3+. Spigot is no longer supported.
- RELATIVE strategy have been removed. (It was deprecated since months because it create random stone blocks & does not support fluid in caves from surface world)