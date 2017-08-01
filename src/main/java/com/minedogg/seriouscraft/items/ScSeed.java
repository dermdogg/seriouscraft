package com.minedogg.seriouscraft.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;

public class ScSeed extends ItemSeeds
{

	public ScSeed(String name, Block crops, Block soil) 
	{

		super(crops, soil);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
	}
	
}
