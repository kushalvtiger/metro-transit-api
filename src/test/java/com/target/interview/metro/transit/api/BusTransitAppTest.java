package com.target.interview.metro.transit.api;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Kushal Venkategowda
 *
 */
class BusTransitAppTest
{
    @Test
    void BusTransitAppNextDepatureTimeLeftTest()
    {
        final BusTransitApp transitApp = new BusTransitApp();
        final String timeTillNextDeparture = transitApp.timeForNextDeparture(new String[] {"METRO Blue Line", "north", "Warehouse District/ Hennepin Ave Station"});
        assertTrue(timeTillNextDeparture.contains("Minutes"));
    }

}
