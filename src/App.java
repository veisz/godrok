import hu.godrok.model.Console;
import hu.godrok.model.controller.PitService;
import hu.godrok.model.domain.DataApi;
import hu.godrok.model.domain.DataParser;
import hu.godrok.model.domain.FileReader;
import hu.godrok.model.domain.FileWriter;

import java.util.List;
import java.util.Scanner;

public class App {

    private final PitService pitService;
    private final Console console;
    private final FileWriter fileWriter;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        pitService = new PitService(dataApi.getData("melyseg.txt"));
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("godrok.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat");
        System.out.println("A fájl adatainak száma: " + pitService.size());
        System.out.println("2. feladat");
        System.out.print("Adjon meg egy távolsági értéket!");
        int distance = console.read();
        System.out.println("Ezen a helyen a felszín " + pitService.getDepthAtCertainDistance(distance - 1) + " méter mélyen van");
        System.out.println("3. feladat");
        System.out.println("Az érintetlen terület aránya: " + pitService.getUntouchedArea());
        List<String> pits = pitService.getPits();
        fileWriter.writeAll(pits);
        System.out.println("5. feladat");
        System.out.println("A gödrök száma: " + pits.size());
        System.out.println(pitService.getPitDetails(distance));
    }
}
