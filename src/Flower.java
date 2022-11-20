import java.util.ArrayList;

public class Flower {
    private final String name;
    private final String flowerColor;
    private final String country;
    private final double cost;
    private double lifeSpan;

    public Flower(String name, String flowerColor, String country, double cost, double lifeSpan) {
        if (name == null || name.equals(""))
            this.name = "цветок";
        else
            this.name = name;
        if (flowerColor == null || flowerColor.equals(""))
            this.flowerColor = "белый";
        else
            this.flowerColor = flowerColor;
        if (country == null || country.equals(""))
            this.country = "Россия";
        else
            this.country = country;
        if (cost <= 0)
            this.cost = 1;
        else
            this.cost = cost;
        if (lifeSpan <= 0)
            this.lifeSpan = 3;
        else
            this.lifeSpan = Math.round(lifeSpan);
    }

    public String getName() {
        return name;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public String getCountry() {
        return country;
    }

    public double getCost() {
        return cost;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        if (lifeSpan <= 0)
            this.lifeSpan = 3;
        else
            this.lifeSpan = Math.round(lifeSpan);

    }

    public void createBouquet(ArrayList<Flower> bouquet) {
        double sum = 0;
        double bouquetLifeSpan = Double.MAX_VALUE;
        for (Flower flower : bouquet) {
            sum += flower.getCost() * 1.1;
            if (bouquetLifeSpan > flower.getLifeSpan()) {
                bouquetLifeSpan = flower.getLifeSpan();
            }
        }
        bouquetCounter(bouquet);
        System.out.printf("Будет стоить %.2f рублей и простоит %.0f суток", sum, bouquetLifeSpan);
    }
    public void bouquetCounter(ArrayList<Flower> bouquet) {
        int rose = 0;
        int hrizantema = 0;
        int pion = 0;
        int hipsofila = 0;
        for (Flower flower : bouquet) {
            if (flower.getName().equals("Роза обыкновенная")) rose++;
            if (flower.getName().equals("Хризантема")) hrizantema++;
            if (flower.getName().equals("Пион")) pion++;
            if (flower.getName().equals("Гипсофила")) hipsofila++;
        }
        bouquetPrinter(rose, hrizantema, pion, hipsofila);
    }
    public void bouquetPrinter (int flower1, int flower2, int flower3, int flower4) {
        System.out.printf("Состав букета: Роза обыкновенная: %dшт, " +
                "Хризантема %dшт, Пион %dшт, Гипсофила %dшт.\n", flower1, flower2, flower3, flower4);
    }
    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", flowerColor='" + flowerColor + '\'' +
                ", country='" + country + '\'' +
                ", cost=" + cost +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
