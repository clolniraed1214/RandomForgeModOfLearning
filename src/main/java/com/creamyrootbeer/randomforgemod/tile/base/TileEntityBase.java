package com.creamyrootbeer.randomforgemod.tile.base;

import java.util.UUID;

import javax.annotation.Nullable;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.BaseContent;
import com.creamyrootbeer.randomforgemod.init.ModContent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class TileEntityBase extends TileEntity implements BaseContent<TileEntity> {
	
	protected String customName;
    protected UUID owner;
    public final String ID;

    public TileEntityBase(String name) {
        customName = "";
        owner = null;
        ID = name;
        
        ModContent.addContent(this);
    }

    public boolean hasCustomName() {
        return customName != null && !customName.isEmpty();
    }

    @Nullable
    public String getCustomName() {
        return customName;
    }
    
    @Override
    public void register() {
    	GameRegistry.registerTileEntity(this.getClass(), ID);
    	System.out.println("Registering " + ID + ":" + this.getClass().getName());
    }
    
    @Override
    public void initAssets() {}
    @Override
    public String getUnlocalizedName() {return ID;}
	@Override
	public TileEntity setRegistryName(ResourceLocation name) {return this;}
	@Override
	public ResourceLocation getRegistryName() {return null;}

	@Override
	public Class<? super TileEntity> getRegistryType() {
		return null;
	}
    
    
    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean hasOwner() {
        return owner != null;
    }

    @Nullable
    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public void setOwner(EntityPlayer entityPlayer) {
        if (entityPlayer != null) {
            setOwner(entityPlayer.getUniqueID());
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Constants.Names.NBT.CUSTOM_NAME)) {
            this.customName = nbtTagCompound.getString(Constants.Names.NBT.CUSTOM_NAME);
        }

        if (nbtTagCompound.hasUniqueId(Constants.Names.NBT.OWNER)) {
            this.owner = nbtTagCompound.getUniqueId(Constants.Names.NBT.OWNER);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
    	
    	
        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName()) {
            nbtTagCompound.setString(Constants.Names.NBT.CUSTOM_NAME, customName);
        }

        if (this.hasOwner()) {
            nbtTagCompound.setUniqueId(Constants.Names.NBT.OWNER, owner);
        }

        return nbtTagCompound;
    }
	
}
