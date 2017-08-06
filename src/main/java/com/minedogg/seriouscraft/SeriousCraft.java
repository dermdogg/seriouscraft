package com.minedogg.seriouscraft;


import com.minedogg.seriouscraft.handlers.ItemHandler;
import com.minedogg.seriouscraft.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = SeriousCraft.MODID, name=SeriousCraft.NAME, version = SeriousCraft.VERSION)
public class SeriousCraft
{
    public static final String MODID = "seriouscraft";
    public static final String NAME = "SERiOUSCRAFT";
    public static final String VERSION = "0.0.0.3";
    public static final String CLIENT_PROXY = "com.minedogg.seriouscraft.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.minedogg.seriouscraft.proxy.CommonProxy";
    public static final CreativeTabs TAB = new CreativeTabs("SERiOUSCRAFT") {@Override public ItemStack getTabIconItem() {return new ItemStack(ItemHandler.sc_token);};};
        
    @SidedProxy(clientSide=SeriousCraft.CLIENT_PROXY, serverSide=SeriousCraft.SERVER_PROXY)
    public static CommonProxy proxy;
    
    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- PRE-INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        proxy.preInit();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BONE, 1), 0.1f);
        GameRegistry.addSmelting(ItemHandler.sc_steel, new ItemStack(ItemHandler.sc_steel_ingot, 1), 0.1f);
        ItemStack bmeal = new ItemStack(Items.DYE,1);
        bmeal.setItemDamage(15);
        BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM,1), bmeal, new ItemStack(ItemHandler.sc_base,1));
        BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM,1), new ItemStack(Items.APPLE,1), new ItemStack(ItemHandler.sc_acid,1));
        proxy.init();    
        
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!\n<< --- --- POST-INIT --- --->>\n!!!!!!!!!!!!!!!!!!!!!!!");
        proxy.postInit();
    }
}
