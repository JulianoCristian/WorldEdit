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

package com.sk89q.worldedit.function;

import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseItem;
import com.sk89q.worldedit.function.RegionFunction;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.util.Direction;
import com.sk89q.worldedit.world.World;

public final class ItemUseFunction implements RegionFunction {
    private final World world;
    private final BaseItem item;

    public ItemUseFunction(World world, BaseItem item) {
        this.world = world;
        this.item = item;
    }

    @Override
    public boolean apply(BlockVector3 position) throws WorldEditException {
        return world.useItem(position, item, Direction.UP);
    }
}
