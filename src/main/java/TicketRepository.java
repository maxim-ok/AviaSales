import java.util.Arrays;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;

    }


    public Ticket[] findAll() {
        return tickets;
    }


    public Ticket[] findTickets(String departurePort, String arrivalPort) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : tickets) {
            if ((departurePort.equals(ticket.getDeparturePort())) && (arrivalPort.equals(ticket.getArrivalPort()))) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];

                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        // System.out.println(Arrays.toString(ans));
        return ans;
    }


}
