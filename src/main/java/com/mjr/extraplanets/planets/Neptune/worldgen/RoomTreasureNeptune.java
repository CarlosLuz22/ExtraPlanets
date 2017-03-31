package com.mjr.extraplanets.planets.Neptune.worldgen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.BlockTier1TreasureChest;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.RoomTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.tile.treasureChests.TileEntityT8TreasureChest;

public class RoomTreasureNeptune extends RoomTreasure {
	public RoomTreasureNeptune() {
	}

	public RoomTreasureNeptune(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, rand.nextInt(4) + 6, configuration.getRoomHeight(), rand.nextInt(4) + 6, entranceDir);
	}

	public RoomTreasureNeptune(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
	}

	@Override
	public boolean addComponentParts(World worldIn, Random random, StructureBoundingBox boundingBox) {
		for (int i = 0; i <= this.sizeX; i++) {
			for (int j = 0; j <= this.sizeY; j++) {
				for (int k = 0; k <= this.sizeZ; k++) {
					if (i == 0 || i == this.sizeX || j == 0 || j == this.sizeY || k == 0 || k == this.sizeZ) {
						boolean placeBlock = true;
						if (getDirection().getAxis() == EnumFacing.Axis.Z) {
							int start = (this.boundingBox.maxX - this.boundingBox.minX) / 2 - 1;
							int end = (this.boundingBox.maxX - this.boundingBox.minX) / 2 + 1;
							if (i > start && i <= end && j < 3 && j > 0) {
								if (getDirection() == EnumFacing.SOUTH && k == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.NORTH && k == this.sizeZ) {
									placeBlock = false;
								}
							}
						} else {
							int start = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 - 1;
							int end = (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 + 1;
							if (k > start && k <= end && j < 3 && j > 0) {
								if (getDirection() == EnumFacing.EAST && i == 0) {
									placeBlock = false;
								} else if (getDirection() == EnumFacing.WEST && i == this.sizeX) {
									placeBlock = false;
								}
							}
						}
						if (placeBlock) {
							this.setBlockState(worldIn, this.configuration.getBrickBlock(), i, j, k, boundingBox);
						} else {
							this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), i, j, k, boundingBox);
						}
					} else if ((i == 1 && k == 1) || (i == 1 && k == this.sizeZ - 1) || (i == this.sizeX - 1 && k == 1) || (i == this.sizeX - 1 && k == this.sizeZ - 1)) {
						this.setBlockState(worldIn, Blocks.GLOWSTONE.getDefaultState(), i, j, k, boundingBox);
					} else if (i == this.sizeX / 2 && j == 1 && k == this.sizeZ / 2) {
						this.setBlockState(worldIn, ExtraPlanets_Blocks.TREASURE_CHEST_TIER_8.getDefaultState().withProperty(BlockTier1TreasureChest.FACING, this.getDirection().getOpposite()), i, j, k, boundingBox);
						BlockPos blockpos = new BlockPos(this.getXWithOffset(i, k), this.getYWithOffset(j), this.getZWithOffset(i, k));
						if (worldIn.getTileEntity(blockpos) == null) {
							worldIn.setTileEntity(blockpos, new TileEntityT8TreasureChest(8));
						}
					} else {
						this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), i, j, k, boundingBox);
					}
				}
			}
		}

		return true;
	}
}