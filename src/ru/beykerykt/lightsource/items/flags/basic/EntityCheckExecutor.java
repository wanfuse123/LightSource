/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 - 2016
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ru.beykerykt.lightsource.items.flags.basic;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import ru.beykerykt.lightsource.items.Item;
import ru.beykerykt.lightsource.items.flags.RequirementFlagExecutor;

public class EntityCheckExecutor implements RequirementFlagExecutor {

	@Override
	public boolean onCheckRequirement(Entity entity, ItemStack itemStack, Item item, String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				String entityType = args[i];
				if (entity.getType() == EntityType.valueOf(entityType.toUpperCase())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void onCheckingSuccess(Entity entity, ItemStack itemStack, Item item, String[] args) {
	}

	@Override
	public void onCheckingFailure(Entity entity, ItemStack itemStack, Item item, String[] args) {
	}

	@Override
	public String getDescription() {
		return "entity:[entity type 1]:[entity type2]:[more entity types]:...";
	}

	@Override
	public int getMaxArgs() {
		return -1;
	}
}
