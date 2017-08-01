package com.minedogg.seriouscraft.handlers;

import com.minedogg.seriouscraft.SeriousCraft;
import com.minedogg.seriouscraft.items.ScItem;
import com.minedogg.seriouscraft.items.ScSeed;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemHandler 
{
	public static Item sc_steel = new ScItem("sc_steel",CreativeTabs.MATERIALS,64);
	public static Item sc_carbon = new ScItem("sc_carbon",CreativeTabs.MATERIALS,64);
	public static Item sc_steel_ingot = new ScItem("sc_steel_ingot",CreativeTabs.MATERIALS,64);
	public static Item sc_herb_seeds = new ScSeed("sc_herb_seeds",Blocks.WHEAT, Blocks.FARMLAND);
	
	public static void init() 
	{
		System.out.println("#SC - ITEM HANDLER init");
		
		System.out.println("#SC - ITEM HANDLER init done");
	}
		
	public static void registerRenders() 
	{
		System.out.println("#SC - registering renders");
		System.out.println("#SC - registering "+sc_steel.getUnlocalizedName());
		registerRender(sc_steel);
		System.out.println("#SC - registering "+sc_carbon.getUnlocalizedName());
		registerRender(sc_carbon);		
		System.out.println("#SC - registering "+sc_steel.getUnlocalizedName());
		registerRender(sc_steel_ingot);
		System.out.println("#SC - registering "+sc_herb_seeds.getUnlocalizedName());
		registerRender(sc_herb_seeds);
		System.out.println("#SC - registering renders done");
	}
	
	public static void registerRender(Item item)
	{
		System.out.println(("#SC - Set ModelResourceLocation to " + SeriousCraft.MODID + ":" + item.getUnlocalizedName().substring(5)));
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(SeriousCraft.MODID + ":" + item.getUnlocalizedName().substring(5)));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		System.out.println("#SC - " + event + " - registering items");
		System.out.println("#SC - registering "+sc_steel.getUnlocalizedName());
		event.getRegistry().register(sc_steel);
		System.out.println("#SC - registering "+sc_carbon.getUnlocalizedName());
		event.getRegistry().register(sc_carbon);
		System.out.println("#SC - registering "+sc_steel_ingot.getUnlocalizedName());
		event.getRegistry().register(sc_steel_ingot);
		System.out.println("#SC - registering "+sc_herb_seeds.getUnlocalizedName());
		event.getRegistry().register(sc_herb_seeds);
		System.out.println("#SC - " + event + " - registering items done");
	}
}
