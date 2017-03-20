package com.mjr.extraplanets.moons.Phobos.worldgen;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import com.mjr.extraplanets.Config;

public class PhobosBiomes extends BiomeGenBase {

	public static final BiomeGenBase phobos = new BiomeGenPhobos(Config.phobosBiomeID).setBiomeName("phobos");

	@SuppressWarnings("unchecked")
	PhobosBiomes(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		this.rainfall = 0F;
	}

	@Override
	public PhobosBiomes setColor(int var1)
	{
		return (PhobosBiomes) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
