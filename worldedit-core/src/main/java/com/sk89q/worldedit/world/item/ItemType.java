/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.world.item;

import com.sk89q.worldedit.registry.NamespacedRegistry;
import com.sk89q.worldedit.world.block.BlockType;
import com.sk89q.worldedit.world.block.BlockTypes;
import com.sk89q.worldedit.world.registry.BundledItemData;

import javax.annotation.Nullable;

public class ItemType {

    public static final NamespacedRegistry<ItemType> REGISTRY = new NamespacedRegistry<>("item type");

    private String id;

    public ItemType(String id) {
        // If it has no namespace, assume minecraft.
        if (!id.contains(":")) {
            id = "minecraft:" + id;
        }
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    /**
     * Gets the name of this item, or the ID if the name cannot be found.
     *
     * @return The name, or ID
     */
    public String getName() {
        BundledItemData.ItemEntry entry = BundledItemData.getInstance().findById(this.id);
        if (entry == null) {
            return getId();
        } else {
            return entry.localizedName;
        }
    }


    /**
     * Gets whether this item type has a block representation.
     *
     * @return If it has a block
     */
    public boolean hasBlockType() {
        return getBlockType() != null;
    }

    /**
     * Gets the block representation of this item type, if it exists.
     *
     * @return The block representation
     */
    @Nullable
    public BlockType getBlockType() {
        return BlockTypes.get(this.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemType && this.id.equals(((ItemType) obj).id);
    }
}