package com.united.tests.mytrips;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.united.tests.components.MyTripsComponent;
import com.united.tests.framework.TestBase;

public class Flights extends TestBase {
    
    private MyTripsComponent myTrips;
    
    @Before
    public void testSetup() {
        super.testSetup();
        mainPage.selectMyTrips();
        myTrips = mainPage.getMyTripsTile();
        assertTrue("My trips tile is not loaded.", myTrips.isLoaded());
    }
    
    @Test
    public void testSearch() {
        myTrips.setConfNum("12345");
        myTrips.setLastName("low");
        myTrips.search();
        // Verify passing criteria here
    }
    
    
    

}
