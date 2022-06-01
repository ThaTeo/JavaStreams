
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    // Gestione di una lista di oggetti di tipo Persona
    // con approccio imperativo e funzionale(dichiarativo)

    List<Persona> lista = List.of(
        new Persona("Franco L.", 24),
        new Persona("Chiara F.", 38),
        new Persona("Luca M.", 72),
        new Persona("Carlo C.", 18),
        new Persona("Giovanni G.", 11),
        new Persona("Alice A.", 16),
        new Persona("Marco M.", 53));

    // Stampa a schermo tutte le persone che hanno eta minore di 18

      // Approccio imperativo
        for (Persona p : lista) {                           // ciclo for per ogni elemento della lista
          if (p.getEta() < 18) {                            // se l'eta' della persona e' minore di 18
            System.out.println(p);                          // stampa a schermo la persona
          }
        }

      // Approccio funzionale
        lista.stream()                                      // serializzo la lista
            .filter(p -> p.getEta() < 18)                   // filtro per eta minore di 18
            .forEach(System.out::println);                  // stampo a schermo tutte le persone filtrate

    // Ordina le persone per eta e inseriscile in una nuova lista

      // Approccio imperativo
        List<Persona> listaOrdinata = List.of();            // creo una lista vuota

        for (Persona p : lista) {                           // ciclo for per ogni elemento della lista
          listaOrdinata.add(p);                             // aggiungo la persona alla lista
        }

        listaOrdinata.sort(
            (p1, p2) -> p1.getEta() - p2.getEta()           // ordino la lista per eta'
        );

        for (Persona p : listaOrdinata) {                   // stampo a schermo tutte le persone ordinate
          System.out.println(p);
        }

      // Approccio funzionale
        List<Persona> listaOrdinata2 = lista.stream()       // serializzo la lista
            .sorted(  
                (p1, p2) -> p1.getEta() - p2.getEta()       // ordino la lista per eta'
            )
            .collect(Collectors.toList());                  // raccolgo la stream in una nuova lista

        listaOrdinata2.forEach(System.out::println);        // stampo a schermo tutte le persone ordinate
  }
}