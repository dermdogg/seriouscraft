package com.minedogg.seriouscraft.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScSeed extends ItemSeeds
{    
	private final Block pCrops;
	
	public ScSeed(String name, Block crops, Block soil,  CreativeTabs tab) 
	{
		super(crops, soil);
		pCrops = crops;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack itemstack = player.getHeldItem(hand);
		boolean top_left = plantSeed(player,worldIn, pos.add(1, 0, -1), hand, facing, hitX, hitY, hitZ, itemstack); //+x-z
		boolean top_mid = plantSeed(player,worldIn, pos.add(1, 0, 0), hand, facing, hitX, hitY, hitZ, itemstack); //+x
		boolean top_right = plantSeed(player,worldIn, pos.add(1, 0, 1), hand, facing, hitX, hitY, hitZ, itemstack); //+x+z
		boolean left = plantSeed(player,worldIn, pos.add(0, 0, -1), hand, facing, hitX, hitY, hitZ, itemstack); //-z
		boolean center = plantSeed(player,worldIn, pos, hand, facing, hitX, hitY, hitZ, itemstack); //P
		boolean right = plantSeed(player,worldIn, pos.add(0, 0, 1), hand, facing, hitX, hitY, hitZ, itemstack); //+z
		boolean bottom_left = plantSeed(player,worldIn, pos.add(-1, 0, -1), hand, facing, hitX, hitY, hitZ, itemstack); //-x-z
		boolean bottom_mid = plantSeed(player,worldIn, pos.add(-1, 0, 0), hand, facing, hitX, hitY, hitZ, itemstack); //-x
		boolean bottom_right = plantSeed(player,worldIn, pos.add(-1, 0, 1), hand, facing, hitX, hitY, hitZ, itemstack); //-x+z
		
		itemstack.shrink(1);
		
		if (top_left && top_mid && top_right && left && center && right && bottom_left && bottom_mid && bottom_right)
		{
			return EnumActionResult.SUCCESS;
		}
		else
		{
			return EnumActionResult.FAIL;
		}
		
    }
	
	public boolean plantSeed(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ, ItemStack itemstack) 
	{
		net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
        	
        	worldIn.setBlockState(pos.up(), pCrops.getDefaultState());

            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
            }

            return true;
        }
        else
        {
            return false;
        }
	}
	
	
}
