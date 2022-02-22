import hu.godrok.model.controller.PitService;
import hu.godrok.model.domain.DataApi;
import hu.godrok.model.domain.DataParser;
import hu.godrok.model.domain.FileReader;

public class App {

    private final PitService pitService;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        pitService = new PitService(dataApi.getData("melyseg.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat");
        System.out.println("A fájl adatainak száma: " + pitService.size());
    }
}
