package com.minedogg.seriouscraft.handlers;

import com.minedogg.seriouscraft.SeriousCraft;
import com.minedogg.seriouscraft.items.ScFertilizer;
import com.minedogg.seriouscraft.items.ScItem;
import com.minedogg.seriouscraft.items.ScSeed;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemHandler 
{
	public static Item sc_token = new ScItem("sc_token",SeriousCraft.TAB,1);
	public static Item sc_steel = new ScItem("sc_steel",SeriousCraft.TAB,64);
	public static Item sc_carbon = new ScItem("sc_carbon",SeriousCraft.TAB,64);
	public static Item sc_steel_ingot = new ScItem("sc_steel_ingot",SeriousCraft.TAB,64);
	public static Item sc_diorite_dust = new ScItem("sc_diorite_dust",SeriousCraft.TAB,64);
	public static Item sc_acid = new ScItem("sc_acid",SeriousCraft.TAB,64);
	public static Item sc_sulphur = new ScItem("sc_sulphur",SeriousCraft.TAB,64);
	public static Item sc_andesite_dust = new ScItem("sc_andesite_dust",SeriousCraft.TAB,64);
	public static Item sc_base = new ScItem("sc_base",SeriousCraft.TAB,64);
	public static Item sc_mucus = new ScItem("sc_mucus",SeriousCraft.TAB,64);
	public static Item sc_super_seed_wheat = new ScSeed("sc_super_seed_wheat",Blocks.WHEAT, Blocks.FARMLAND,SeriousCraft.TAB);
	public static Item sc_super_seed_carrot = new ScSeed("sc_super_seed_carrot",Blocks.CARROTS, Blocks.FARMLAND,SeriousCraft.TAB);
	public static Item sc_super_seed_potato = new ScSeed("sc_super_seed_potato",Blocks.POTATOES, Blocks.FARMLAND,SeriousCraft.TAB);
	public static Item sc_super_seed_beetroot = new ScSeed("sc_super_seed_beetroot",Blocks.BEETROOTS, Blocks.FARMLAND,SeriousCraft.TAB);
	public static Item sc_super_seed_nwart = new ScSeed("sc_super_seed_nwart",Blocks.NETHER_WART, Blocks.SOUL_SAND,SeriousCraft.TAB);
	public static Item sc_fertilizer = new ScFertilizer("sc_fertilizer",SeriousCraft.TAB);
	
	
	public static void init() 
	{
		System.out.println("#SC - ITEM HANDLER init");		
		System.out.println("#SC - ITEM HANDLER init done");
	}
		
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
		System.out.println("#SC - registering renders");
		registerRender(sc_token);
		registerRender(sc_steel);
		registerRender(sc_carbon);		
		registerRender(sc_steel_ingot);
		registerRender(sc_diorite_dust);
		registerRender(sc_acid);
		registerRender(sc_sulphur);
		registerRender(sc_andesite_dust);
		registerRender(sc_base);
		registerRender(sc_mucus);
		registerRender(sc_super_seed_wheat);
		registerRender(sc_super_seed_carrot);
		registerRender(sc_super_seed_potato);
		registerRender(sc_super_seed_beetroot);
		registerRender(sc_super_seed_nwart);
		registerRender(sc_fertilizer);
		System.out.println("#SC - registering renders done");
	}
	
	public static void registerRender(Item item)
	{
		System.out.println("#SC - Set ModelResourceLocation to " + item.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(),"inventory"));
		System.out.println("#SC - "+item.getRegistryName()+" location set"); 
	}
	
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		System.out.println("#SC - " + event + " - registering items");
		System.out.println("#SC - registering "+sc_token.getRegistryName());
		event.getRegistry().register(sc_token);
		System.out.println("#SC - registering "+sc_steel.getRegistryName());
		event.getRegistry().register(sc_steel);
		System.out.println("#SC - registering "+sc_carbon.getRegistryName());
		event.getRegistry().register(sc_carbon);
		System.out.println("#SC - registering "+sc_steel_ingot.getRegistryName());
		event.getRegistry().register(sc_steel_ingot);
		System.out.println("#SC - registering "+sc_diorite_dust.getRegistryName());
		event.getRegistry().register(sc_diorite_dust);
		System.out.println("#SC - registering "+sc_acid.getRegistryName());
		event.getRegistry().register(sc_acid);
		System.out.println("#SC - registering "+sc_sulphur.getRegistryName());
		event.getRegistry().register(sc_sulphur);
		System.out.println("#SC - registering "+sc_andesite_dust.getRegistryName());
		event.getRegistry().register(sc_andesite_dust);
		System.out.println("#SC - registering "+sc_base.getRegistryName());
		event.getRegistry().register(sc_base);
		System.out.println("#SC - registering "+sc_mucus.getRegistryName());
		event.getRegistry().register(sc_mucus);
		System.out.println("#SC - registering "+sc_super_seed_wheat.getRegistryName());
		event.getRegistry().register(sc_super_seed_wheat);
		System.out.println("#SC - registering "+sc_super_seed_carrot.getRegistryName());
		event.getRegistry().register(sc_super_seed_carrot);
		System.out.println("#SC - registering "+sc_super_seed_potato.getRegistryName());
		event.getRegistry().register(sc_super_seed_potato);
		System.out.println("#SC - registering "+sc_super_seed_beetroot.getRegistryName());
		event.getRegistry().register(sc_super_seed_beetroot);
		System.out.println("#SC - registering "+sc_super_seed_nwart.getRegistryName());
		event.getRegistry().register(sc_super_seed_nwart);
		System.out.println("#SC - registering "+sc_fertilizer.getRegistryName());
		event.getRegistry().register(sc_fertilizer);
		System.out.println("#SC - " + event + " - registering items done");
	}
}
