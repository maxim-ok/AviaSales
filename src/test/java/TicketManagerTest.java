import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket flight1 = new Ticket(1, 19_000, "LAX", "DME", 600);
    Ticket flight2 = new Ticket(2, 25_000, "JFK", "LHR", 420);
    Ticket flight3 = new Ticket(3, 5_000, "LED", "SVO", 90);
    Ticket flight4 = new Ticket(4, 180_000, "LAX", "DME", 480);
    Ticket flight5 = new Ticket(5, 14_000, "LAX", "DME", 180);


    @Test

    public void shouldFindAndSortIfConsist() {

        manager.add(flight1);
        manager.add(flight2);
        manager.add(flight3);
        manager.add(flight4);
        manager.add(flight5);

        manager.findAll("LAX", "DME");

        Ticket[] actual = manager.findAll("LAX", "DME");
        Ticket[] expected = {flight5, flight1, flight4};

        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldFindAndSortIfEmpty() {

        manager.add(flight1);
        manager.add(flight2);
        manager.add(flight3);
        manager.add(flight4);
        manager.add(flight5);

        manager.findAll("OMS", "SVO");

        Ticket[] actual = manager.findAll("OMS", "SVO");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);


    }
}