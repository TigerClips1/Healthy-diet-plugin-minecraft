/*
 * **************************************************************************
 *    healthyDiet.java                                                    *
 **************************************************************************
 *                         This file is part of:                          *
 *                          Diet Plugin                                   *
 *                      https://github.com/TigerClips1                    *
 **************************************************************************
 *                                                                        *
 * Copyright (c) 2025 TigerClips1.                                        *
 *                                                                        *
 * Permission is hereby granted, free of charge, to any person obtaining  *
 * a copy of this software and associated documentation files (the        *
 * "Software"), to deal in the Software without restriction, including    *
 * without limitation the rights to use, copy, modify, merge, publish,    *
 * distribute, sublicense, and/or sell copies of the Software, and to     *
 * permit persons to whom the Software is furnished to do so, subject to  *
 * the following conditions:                                              *
 *                                                                        *
 * The above copyright notice and this permission notice shall be         *
 * included in all copies or substantial portions of the Software.        *
 *                                                                        *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,        *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF     *
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. *
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY   *
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,   *
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE      *
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.                 *
 */


// Package this class to a jar.
package me.tigerclips1.healthyDietPlugin;

// Import the required classes.
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

// Main class.
public class healthyDiet implements Listener {
    private final HealthyDietPlugin plugin;
    private final HashMap<UUID, Integer> foodConsumption = new HashMap<>();

    public healthyDiet(HealthyDietPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    // Make a function.
    public void handleDiet(PlayerItemConsumeEvent event) {
        // Make a player variable will automatically use get player with just the player variables.
        Player player = event.getPlayer();
        if (player.hasPermission("healthy.diet")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        // List the potion effects.
                        PotionEffectType effect = getPotionEffectType();
                        // Check if any of  these foods that the player chose to eat  is ate then add a boost.
                        if (event.getItem().getType().isEdible()) {
                            UUID playerId = player.getUniqueId();
                            int newCount = foodConsumption.getOrDefault(playerId, 0) + 1;
                            foodConsumption.put(playerId, newCount);
                            if (newCount == 20) {
                                switch (event.getItem().getType()) {
                                    case APPLE, POTATO, BAKED_POTATO, CARROT, BREAD:
                                        player.addPotionEffect(new PotionEffect( effect, 300, 2, false, false, false));
                                        break;
                                    case GLOW_BERRIES:
                                        player.addPotionEffect(new PotionEffect(effect, 300, 0, false, false, false));
                                        break;
                                    case MELON_SLICE:
                                        player.addPotionEffect(new PotionEffect(effect, 300, 3, false, false, false));
                                        player.addPotionEffect(new PotionEffect(effect, 300, 3, false, false, false));
                                        break;
                                    case SWEET_BERRIES:
                                        player.addPotionEffect(new PotionEffect(effect, 300, 2, false, false, true));
                                        break;
                                    case CAKE, PUMPKIN_PIE, COOKIE:
                                        player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 100, 2, false, false, false));
                                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 2, false, false, false));
                                        player.sendMessage("I had too much sweets  and now i am very Sick/ hyper");
                                        break;
                                    case GOLDEN_CARROT:
                                        player.addPotionEffect(new PotionEffect(effect, 200, 2, false, false, true));
                                        player.addPotionEffect(new PotionEffect(effect, 200, 2, false, false, true));
                                        player.addPotionEffect(new PotionEffect(effect, 200, 2, false, false, true));
                                        player.addPotionEffect(new PotionEffect(effect, 200, 2, false, false, true));
                                        player.addPotionEffect(new PotionEffect(effect, 200, 2, false, false, true));
                                        break;
                                    default:
                                        break;
                                }
                                foodConsumption.put(playerId, 0);
                            }
                        }
                    }
                    // evey 5ticks you wi;; have the effect of the sweet berries if eat
                }.runTaskLater(plugin, 3);
            }
        }
    }

    // Create a private static array that has all the potion effects, and  it will randomize the effects you will get.
    private static PotionEffectType getPotionEffectType() {
        // List of potions effects that will be applying if the player chose to eat it.
        PotionEffectType[] effects = {
                PotionEffectType.SPEED,
                PotionEffectType.STRENGTH,
                PotionEffectType.LUCK,
                PotionEffectType.POISON,
                PotionEffectType.ABSORPTION,
                PotionEffectType.HASTE,
                PotionEffectType.FIRE_RESISTANCE,
                PotionEffectType.NIGHT_VISION,
                PotionEffectType.WITHER,

        };
        // Initialize the random java module to it can randomize it.
        Random random = new Random();
        // Handle the randomise system.
        return effects[random.nextInt(effects.length)];
    }
}
