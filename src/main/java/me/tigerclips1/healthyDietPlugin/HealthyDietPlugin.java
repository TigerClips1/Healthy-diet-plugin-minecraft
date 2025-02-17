/*
 * **************************************************************************
 *    HealthyDietPlugin.java                                                *
 *                                                                          *
 ****************************************************************************
 *                        This file is part of:                             *
 *                          Diet Plugin                                     *
 *                      https://github.com/TigerClips1                      *
 ****************************************************************************
 *                                                                          *
 * Copyright (c) 2025 TigerClips1.                                          *
 *                                                                          *
 * Permission is hereby granted, free of charge, to any person obtaining    *
 * a copy of this software and associated documentation files (the          *
 * "Software"), to deal in the Software without restriction, including      *
 * without limitation the rights to use, copy, modify, merge, publish,      *
 * distribute, sublicense, and/or sell copies of the Software, and to       *
 * permit persons to whom the Software is furnished to do so, subject to    *
 * the following conditions:                                                *
 *                                                                          *
 * The above copyright notice and this permission notice shall be           *
 * included in all copies or substantial portions of the Software.          *
 *                                                                          *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,          *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF       *
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.   *
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY     *
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,     *
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE        *
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.                   *
 */


// Package this class to a jar.
package me.tigerclips1.healthyDietPlugin;

// Import the required classes.

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// The main plugin class.
public final class HealthyDietPlugin extends JavaPlugin {

    // Make it where if the plugin start it will load the diet class.
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new healthyDiet(this), this);
    }
}
