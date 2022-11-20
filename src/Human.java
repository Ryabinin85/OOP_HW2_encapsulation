import java.time.LocalDate;

public class Human {
    private String name;
    private final int yearOfBirth;
    private String town;
    private String jobTitle;

    public Human(String name, int age, String town, String jobTitle) {
        if (name == null || name.equals(""))
            this.name = "Информация не указана";
        else
            this.name = name;

        if (age < 0)
            this.yearOfBirth = LocalDate.now().getYear() - Math.abs(age);
        else
            this.yearOfBirth = LocalDate.now().getYear() - age;

        if (town == null || town.equals(""))
            this.town = "Информация не указана";
        else
            this.town = town;

        if (jobTitle == null || jobTitle.equals(""))
            this.jobTitle = "Информация не указана";
        else
            this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) this.name = "Информация не указана";
        else this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town == null || town.equals("")) this.town = "Информация не указана";
        else this.town = town;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.equals("")) this.jobTitle = "Информация не указана";
        else this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s. Я из города %s. Я родился в %d году." +
                " Я работаю на должности %s. Будем знакомы!", name, town, yearOfBirth, jobTitle);
    }
}
