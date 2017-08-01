package com.minedogg.seriouscraft.handlers;

import com.minedogg.seriouscraft.SeriousCraft;
import com.minedogg.seriouscraft.items.ModItem;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class ItemHandler 
{
	private static ModItem scSteel = new ModItem("sc_steel",CreativeTabs.MATERIALS,64);
	
	public static void init() 
	{
		System.out.println("#SC - ITEM HANDLER init");
		GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BONE, 1), 0.1f);
		System.out.println("#SC - ITEM HANDLER init done");
	}
		
	public static void registerRenders() 
	{
		System.out.println("#SC - registering renders");
		registerRender(scSteel);
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
		System.out.println("#SC - registering items");
		event.getRegistry().register(scSteel);
		System.out.println("#SC - registering items finished");
	}
}
