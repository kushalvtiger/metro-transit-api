package com.target.interview.metro.transit.api.components;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
public class Place
{
    private String place_code;

    private String description;

    public String getPlaceCode()
    {
        return this.place_code;
    }

    public void setPlaceCode(final String place_code)
    {
        this.place_code = place_code;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }
}
