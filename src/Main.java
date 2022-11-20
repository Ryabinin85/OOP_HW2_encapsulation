import transport.Car;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Human maxim = new Human("Максим", 34, "Минск", "бренд-менеджер");
        Human anna = new Human("Аня", 29, "Москва", "методист образовательных программ");
        Human ekaterina = new Human("Катя", 30, "Калининград", "продакт-менеджер");
        Human artyom = new Human("Артем", 27, "Москва", "директор по развитию бизнеса");
        Human vlad = new Human("Владимир", 21, "Казань", "Безработный");

        System.out.println();

        Flower flower1 = new Flower("Роза обыкновенная",null, "Голландия", 35.59,0);
        Flower flower2 = new Flower("Хризантема",null, null, 15,5);
        Flower flower3 = new Flower("Пион",null, "Англия", 69.9,1);
        Flower flower4 = new Flower("Гипсофила","", "Турция", 19.5,10);

        ArrayList<Flower> bouquet = new ArrayList<>(10);
        bouquet.add(flower1);
        bouquet.add(flower1);
        bouquet.add(flower1);
        bouquet.add(flower2);
        bouquet.add(flower2);
        bouquet.add(flower2);
        bouquet.add(flower2);
        bouquet.add(flower2);
        bouquet.add(flower4);

//        flower1.createBouquet(bouquet);


        Car.Key keyOn = new Car.Key(true, true);
        Car.Key keyOff = new Car.Key(false, false);

        Car.Insurance insuranceSixMonth = new Car.Insurance(6,
                2000, "659QWe621");
        Car.Insurance insuranceOneYear = new Car.Insurance(12,
                1800, "659QWe622");

        Car granta = new Car("Lada", "Granta", 1.7,
                "yellow", 2015, "Russia", "automatic", "sedan",
                "   у023не999      ", 5, "winter", keyOff, insuranceSixMonth);

        granta.setRegistrationNumber("к654рС750");
        granta.setSummerTyres();

        transport.Car a8 = new transport.Car("Audi", "A8 50 L TDI quattro", 3.0,
                "black", 2020, "Germany","automatic", "sedan",
                "   у111уу999      ", 5, "winter", keyOn, insuranceOneYear);

        transport.Car z8 = new transport.Car("BMW", "Z8", 3.0,
                "yellow", 2021, "Germany","automatic", "sedan",
                "   х888хр999      ", 5, "winter", keyOn, insuranceOneYear);

        transport.Car sportage = new transport.Car("Kia", "Sportage 4", 1.7,
                "red", 2018, "South Korea","automatic", "sedan",
                "   е681рк071      ", 5, "winter", keyOn, insuranceOneYear);
        sportage.setSummerTyres();

        transport.Car avante = new transport.Car("Hyundai", "Avante", 1.6,
                "orange", 2016, "South Korea","automatic", "sedan",
                "   р030во063      ", 5, "winter", keyOn, insuranceOneYear);
        avante.setWinterTyres();

        System.out.println(granta);
        System.out.println(a8);
        System.out.println(z8);
        System.out.println(sportage);
        System.out.println(avante);

    }
}
