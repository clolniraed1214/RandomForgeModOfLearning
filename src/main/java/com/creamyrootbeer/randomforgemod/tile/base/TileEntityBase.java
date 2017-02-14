package com.creamyrootbeer.randomforgemod.tile.base;

import java.util.UUID;

import javax.annotation.Nullable;

import com.creamyrootbeer.randomforgemod.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityBase extends TileEntity {
	
	protected String customName;
    protected UUID owner;

    public TileEntityBase() {
        customName = "";
        owner = null;
    }

    public boolean hasCustomName() {
        return customName != null && !customName.isEmpty();
    }

    @Nullable
    public String getCustomName() {
        return customName;
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

        if (nbtTagCompound.hasKey(Constants.NBT.CUSTOM_NAME)) {
            this.customName = nbtTagCompound.getString(Constants.NBT.CUSTOM_NAME);
        }

        if (nbtTagCompound.hasUniqueId(Constants.NBT.OWNER)) {
            this.owner = nbtTagCompound.getUniqueId(Constants.NBT.OWNER);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName()) {
            nbtTagCompound.setString(Constants.NBT.CUSTOM_NAME, customName);
        }

        if (this.hasOwner()) {
            nbtTagCompound.setUniqueId(Constants.NBT.OWNER, owner);
        }

        return nbtTagCompound;
    }
	
}
