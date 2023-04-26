import java.util.Scanner;

public class ToyRaffle {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        Toy toy1 = new Toy(1, "Плюшевая игрушка", 100, 50);
        Toy toy2 = new Toy(2, "Футбольный мяч", 60, 40);
        Toy toy3 = new Toy(3, "Конструктор", 50, 30);
        Toy toy4 = new Toy(3, "Пазл", 40, 20);
        Toy toy5 = new Toy(3, "Радиоуправляемая машинка", 40, 15);
        Toy toy6 = new Toy(3, "PlayStation 5", 10, 10);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
        store.addToy(toy5);
        store.addToy(toy6);
        Scanner sc = new Scanner(System.in, "cp866");
        boolean filter = true;
        while (filter) {
            Show1230();  
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    store.PrintStore();
                    break;
                case "2":
                    System.out.println("Введите ID игрушки, у которой вы хотите поменять шанс выпадения:");
                    int toyid = sc.nextInt();
                    System.out.println("Введите новый шанс выпадения игрушки");
                    Double frequency = sc.nextDouble();
                    store.changeToyFrequency(toyid, frequency);
                    break;
                case "3":
                    store.organizeRaffle();
                    break;
                case "4":
                    store.PrintPrizeStore();
                    break;
                case "5":
                    Toy prizeToy = store.getPrizeToy();
                    if (prizeToy != null) {
                        System.out.println("\nВы забрали выигрышную игрушку: " + prizeToy.getName());
                };
                    break;
                case "0":
                    System.out.println("До новых встреч!");
                    filter = false;
                    break;
                default:
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                    break;
            }

        }
    }



    public static void Show1230(){
        System.out.println("\nПосмотреть список игрушек - 1\n" +
                    "Поменять шанс выпадения игрушки - 2\n" +
                    "Сыграть лотерею - 3\n" +
                    "Посмотреть список выигранных игрушек на выдачу - 4\n" +
                    "Забрать выигранную игрушку - 5\n" +
                    "Для выхода, введите - 0");
    }
}