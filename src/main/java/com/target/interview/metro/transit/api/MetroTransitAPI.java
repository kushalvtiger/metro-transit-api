package com.target.interview.metro.transit.api;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.target.interview.metro.transit.api.components.Departure;
import com.target.interview.metro.transit.api.components.Place;
import com.target.interview.metro.transit.api.components.Route;
import com.target.interview.metro.transit.api.utils.MetroTransitUtil;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class MetroTransitAPI
{
    /**
     * 
     * @return
     */
    public static Map<String,Route> getRoutesMap()
    {
        final List<Route> routes = MetroTransitUtil.getResultsList(MetroTransitUtil.ROUTES_ENDPOINT, Route[].class, null);
        if(routes == null || routes.isEmpty())
        {
            return null;
        }
        return routes.parallelStream().collect(Collectors.toMap(Route::getRouteLabel, route -> route));
    }
    
    /**
     * 
     * @param routeID
     * @param directionID
     * 
     * @return
     */
    public static Map<String,Place> getPlaceMap(final String routeID, final Integer directionID)
    {
        final List<Place> places = MetroTransitUtil.getResultsList(new StringJoiner("/").add(MetroTransitUtil.STOPS_ENDPOINT).add(routeID).add(directionID.toString()).toString(), Place[].class, null);
        if(places == null || places.isEmpty())
        {
            return null;
        }
        return places.parallelStream().collect(Collectors.toMap(Place::getDescription, place -> place));
    }

    /**
     * 
     * @param routeId
     * @param directionID
     * @param placeCode
     * 
     * @return
     */
    public static List<Departure> getDepartures(final String routeId, final Integer directionID, final String placeCode)
    {
        final String departurePath = new StringJoiner("/", "/", "").add(routeId).add(directionID.toString()).add(placeCode).toString();
        //TODO: Create a Json Parser to parse inner elements.
        final GsonBuilder gsonBuilder = new GsonBuilder();
        return MetroTransitUtil.getResultsList(departurePath, Departure[].class, gsonBuilder);
    }
}
