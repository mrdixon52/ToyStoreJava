import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> prizeToys;
    private String prizeFilePath;

    public ToyStore() {
        toys = new ArrayList<Toy>();
        prizeToys = new ArrayList<Toy>();
        prizeFilePath = "prize_toys.txt";
    }

    public void PrintStore() {
        for (Toy toy : toys){
            System.out.println(toy.toString());
        }
    }
    public void PrintPrizeStore() {
        if (prizeToys.isEmpty()){
            System.out.println("Список выигранных игрушек пуст!");
        }
        else{
            for (Toy toy : prizeToys){
                System.out.println(toy.getName());
            }
        }
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeToyFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
            }
        }
    }

    public void organizeRaffle() {

        for (Toy toy : toys) {
            double random = Math.random() * 100;
            if (random < toy.getFrequency()) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
                System.out.println("\n Вы выиграли: " + toy.getName() + "\n Не забудьте забрать ее!");
                break;
            }
        }
    }
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);

            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл игрушки");
            }

            return prizeToy;
        } else {
            System.out.println("Все игрушки кончились");
            return null;
        }
    }
}