package com.target.interview.metro.transit.api;

import java.util.List;

import com.target.interview.metro.transit.api.components.Departure;
import com.target.interview.metro.transit.api.components.Direction;
import com.target.interview.metro.transit.api.components.Place;
import com.target.interview.metro.transit.api.components.Route;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class BusTransitApp 
{
    public static void main(final String[] args )
    {
        final int argsLength = args.length;
        if(argsLength <1 || argsLength > 3)
        {
            // Log/Trace
        }
        
        timeForNextDeparture(args);
    }

    static String timeForNextDeparture(final String[] args)
    {
        final String routeName = args[0];
        final String direction = args[1];
        final String stopName = args[2];
        
        if(routeName == null)
        {
            // Log/Trace
            return "Route not found.";
        }
        
        final Route route = MetroTransitAPI.getRoutesMap().get(routeName);
        
        if(route == null)
        {
            // Log/Trace
            return "Route not found.";
        }
        
        final Integer directionID = Direction.getDirectionId(direction.toUpperCase());
        
        if(directionID == null)
        {
            // Log/Trace
            return "Direction not found.";
        }
        
        final Place place = MetroTransitAPI.getPlaceMap(route.getRouteId(), directionID).get(stopName);
        
        if(place == null)
        {
            // Log/Trace
            return "Destination not found.";
        }
        
        final List<Departure> departures = MetroTransitAPI.getDepartures(route.getRouteId(), directionID, place.getPlaceCode());
        
        for(final Departure departure: departures)
        {
            if(departure.getDepartureTime() > 0)
            {
                final long currentTime = System.currentTimeMillis(); 
                final long departureTime = departure.getDepartureTime();
                final long differenceMinutes = departureTime - currentTime / (60 * 1000) % 60;
                if(differenceMinutes > 0)
                {
                    return String.valueOf(differenceMinutes) + " Minutes";
                }
            }
        }
        
        return "Nothing available";
    }
}
