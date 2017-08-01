package com.minedogg.seriouscraft.items;

import net.minecraft.creativetab.CreativeTabs;

public class ScItem extends net.minecraft.item.Item
{
	public ScItem(String name, CreativeTabs tab)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	public ScItem(String name, CreativeTabs tab, int stacksize)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(stacksize);
	}
	
}
