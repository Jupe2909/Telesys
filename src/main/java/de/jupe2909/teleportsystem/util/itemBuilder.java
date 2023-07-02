package de.jupe2909.teleportsystem.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class itemBuilder {
    private ItemMeta itemMeta;
    private ItemStack itemStack;
    public itemBuilder(Material mat){
        itemStack = new ItemStack(mat);
        itemMeta = itemStack.getItemMeta();
    }
    public itemBuilder setDisplayname(String s){
        itemMeta.setDisplayName(s);
        return this;
    }
    public itemBuilder setLocalizedName(String s){
        itemMeta.setLocalizedName(s);
        return this;
    }
    public itemBuilder setLore(String... s){
        itemMeta.setLore(Arrays.asList(s));
        return this;
    }
    public itemBuilder setUnbreakable(boolean s){
        itemMeta.setUnbreakable(s);
        return this;
    }
    public itemBuilder addItemFlags(ItemFlag... s){
        itemMeta.addItemFlags(s);
        return this;
    }

    @Override
    public String toString() {
        return "itemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}