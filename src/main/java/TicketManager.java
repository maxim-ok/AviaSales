public class TicketManager {


    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public void add(Ticket ticket) {
        repository.save(ticket);
    }


    public Ticket[] findAll(String from, String to) {
        return repository.findTickets(from, to);
    }


}
