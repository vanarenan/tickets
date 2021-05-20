import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<Ticket>(Arrays.asList(
                        new Ticket("Paris", "London", 190),
                        new Ticket("Berlin", "Paris", 190),
                        new Ticket("Kiev", "Vena", 130),
                        new Ticket("Vena", "Berlin", 230)
                )
        );
        List<String> departures = new ArrayList<String>();
        for (int i = 0; i < tickets.size(); i++) {
            departures.add(tickets.get(i).getFrom());
        }

        List<String> arrivals = tickets.stream().map(item -> item.getTo()).collect(Collectors.toList());

        for (int i = 0; i < tickets.size(); i++) {
            if (!departures.contains(arrivals.get(i))){
                System.out.println("to: " + arrivals.get(i));
            }
        }
        departures.stream().filter(item -> !arrivals.contains(item))
                .forEach(item -> System.out.println("from: " + item));
    }
}
