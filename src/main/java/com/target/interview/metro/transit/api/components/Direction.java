package com.target.interview.metro.transit.api.components;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class Direction
{
    private static final Map<String,Integer> directionMap = new HashMap<>();
    
    static
    {
        directionMap.put("NB", Integer.valueOf(0));
        directionMap.put("NORTH", Integer.valueOf(0));
        directionMap.put("NORTHBOUND", Integer.valueOf(0));
        directionMap.put("N", Integer.valueOf(0));
        directionMap.put("SB", Integer.valueOf(1));
        directionMap.put("SOUTH", Integer.valueOf(1));
        directionMap.put("SOUTHBOUND", Integer.valueOf(1));
        directionMap.put("S", Integer.valueOf(1));
        directionMap.put("EB", Integer.valueOf(2));
        directionMap.put("EAST", Integer.valueOf(2));
        directionMap.put("EASTBOUND", Integer.valueOf(2));
        directionMap.put("E", Integer.valueOf(2));
        directionMap.put("WB", Integer.valueOf(3));
        directionMap.put("WEST", Integer.valueOf(3));
        directionMap.put("WESTBOUND", Integer.valueOf(3));
        directionMap.put("W", Integer.valueOf(3));
    }

    public static Integer getDirectionId(final String directionName)
    {
        return directionMap.get(directionName);
    }

    public static void setDirectionId(final String directionName, final Integer directionID)
    {
        directionMap.putIfAbsent(directionName, directionID);
    }
}
