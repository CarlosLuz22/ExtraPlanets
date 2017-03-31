package com.mjr.extraplanets.handlers;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BoneMealHandler {
	@SubscribeEvent
	public void usedBonemeal(BonemealEvent event) {
		if (event.getBlock() == ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING) {
			if (!event.getWorld().isRemote) {
				// ((BlockKepler22bMapleTreeSapling) ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				// event.setResult(Result.ALLOW);
			}
		}
	}
}
