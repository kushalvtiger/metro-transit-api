package com.target.interview.metro.transit.api.components;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class Route
{
    private String route_label;

    private int agency_id;

    private String route_id;

    public String getRouteLabel()
    {
        return this.route_label;
    }

    public void setRouteLabel(final String route_label)
    {
        this.route_label = route_label;
    }

    public int getAgencyId()
    {
        return this.agency_id;
    }

    public void setAgencyId(final int agency_id)
    {
        this.agency_id = agency_id;
    }

    public String getRouteId()
    {
        return this.route_id;
    }

    public void setRouteId(final String route_id)
    {
        this.route_id = route_id;
    }
    
    @Override
    public String toString()
    {
        return this.route_label;
    }

}
