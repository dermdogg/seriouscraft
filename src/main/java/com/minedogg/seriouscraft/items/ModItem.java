package com.minedogg.seriouscraft.items;

import net.minecraft.creativetab.CreativeTabs;

public class ModItem extends net.minecraft.item.Item
{
	public ModItem(String name, CreativeTabs tab)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	public ModItem(String name, CreativeTabs tab, int stacksize)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(stacksize);
	}
	
}
