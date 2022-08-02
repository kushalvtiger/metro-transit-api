package com.target.interview.metro.transit.api.components;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class Departure
{
    private boolean actual;

    private String trip_id;

    private String stop_id;

    private String departure_text;

    private int departure_time;

    private String description;

    private String gate;

    private String route_id;

    private String route_short_name;

    private int direction_id;

    private String direction_text;

    private String terminal;

    private String schedule_relationship;

    public boolean isActual()
    {
        return this.actual;
    }

    public void setActual(final boolean actual)
    {
        this.actual = actual;
    }

    public String getTripID()
    {
        return this.trip_id;
    }

    public void setTripID(final String trip_id)
    {
        this.trip_id = trip_id;
    }

    public String getDepatureText()
    {
        return this.departure_text;
    }

    public void setDepatureText(String depatureText)
    {
        this.departure_text = depatureText;
    }

    public int getDepartureTime()
    {
        return this.departure_time;
    }

    public void setDepartureTime(final int departureTime)
    {
        this.departure_time = departureTime;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getGate()
    {
        return this.gate;
    }

    public void setGate(String gate)
    {
        this.gate = gate;
    }

    public String getRoute()
    {
        return this.route_id;
    }

    public void setRoute(String route)
    {
        this.route_id = route;
    }

    public String getRouteDirection()
    {
        return this.route_short_name;
    }

    public void setRouteDirection(String routeDirection)
    {
        this.route_short_name = routeDirection;
    }

    public int getDirectionId()
    {
        return this.direction_id;
    }

    public void setDirectionId(int direction_id)
    {
        this.direction_id = direction_id;
    }

    public String getDirectionText()
    {
        return this.direction_text;
    }

    public void setDirectionText(String direction_text)
    {
        this.direction_text = direction_text;
    }

    public String getTerminal()
    {
        return this.terminal;
    }

    public void setTerminal(String terminal)
    {
        this.terminal = terminal;
    }

    public String getScheduleRelationship()
    {
        return this.schedule_relationship;
    }

    public void setScheduleRelationship(String schedule_relationship)
    {
        this.schedule_relationship = schedule_relationship;
    }

    public String getStopId()
    {
        return this.stop_id;
    }

    public void setStopId(String stop_id)
    {
        this.stop_id = stop_id;
    }
}
