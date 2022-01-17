import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Visitor visitor;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    @Before
    public void before() {
        themePark = new ThemePark();
        visitor = new Visitor(20, 180, 150);
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
    }

    @Test
    public void canAddIReviewed() {
        themePark.addIReviewed(dodgems);
        assertEquals(1, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisit() {
        themePark.visit(visitor, dodgems);
        assertEquals(1, dodgems.getVisitCount());
        assertEquals(1, visitor.numberOfVisitedAttractions());
    }

    @Test
    public void canGetAllReviewed() {
        themePark.addIReviewed(dodgems);
        themePark.addIReviewed(park);
        themePark.addIReviewed(playground);
        themePark.addIReviewed(rollerCoaster);
        themePark.addIReviewed(candyflossStall);
        themePark.addIReviewed(iceCreamStall);
        themePark.addIReviewed(tobaccoStall);
        HashMap<String, Integer> reviews = themePark.allReviews();
        int value = reviews.get("Blue Ridge");
        assertEquals(10, value);
    }

    @Test
    public void canGetAllAllowedForVisitor(){
        themePark.addIReviewed(dodgems);
        themePark.addIReviewed(park);
        themePark.addIReviewed(playground);
        themePark.addIReviewed(rollerCoaster);
        themePark.addIReviewed(candyflossStall);
        themePark.addIReviewed(iceCreamStall);
        themePark.addIReviewed(tobaccoStall);
        ArrayList<IReviewed> allowed = themePark.getAllAllowedFor(visitor);
        assertEquals(6, allowed.size());

    }
}
