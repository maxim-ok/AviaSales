import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {


    private int id;
    private int price;
    private String departurePort;
    private String arrivalPort;
    private int duration;

    public Ticket(int id, int price, String departurePort, String arrivalPort, int duration) {
        this.id = id;
        this.price = price;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.duration = duration;
    }


    @Override
    public int compareTo(Ticket flight) {
        if (price < flight.price) {
            return -1;

        }
        if (price > flight.price) {
            return 1;

        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && duration == ticket.duration && Objects.equals(departurePort, ticket.departurePort) && Objects.equals(arrivalPort, ticket.arrivalPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departurePort, arrivalPort, duration);
    }
}
