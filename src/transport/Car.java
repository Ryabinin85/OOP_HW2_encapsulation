package transport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private final String carBodyType;
    private final int numberOfSeats;
    private double engineVolume;
    private String colour;
    private String transmission;
    private String registrationNumber;
    private String tyresType;
    private Insurance insurance;
    private Key key;

    public Car(String brand, String model, double engineVolume, String colour, int year,
               String country, String transmission, String carBodyType, String registrationNumber,
               int numberOfSeats, String tyresType, Key key, Insurance insurance) {

        this.brand = Validator.validateString(brand);
        this.model = Validator.validateString(model);
        this.colour = Validator.validateString(colour);
        this.country = Validator.validateString(country);
        this.carBodyType = Validator.validateString(carBodyType);
        this.registrationNumber = validateRegNumber(registrationNumber);

        if (engineVolume <= 0) this.engineVolume = 1.5;
        else this.engineVolume = engineVolume;

        if (year <= 0) this.year = 2000;
        else this.year = year;

        if (transmission == null || transmission.isEmpty() || transmission.isBlank())
            this.transmission = "manual transmission";
        else this.transmission = transmission;

        if (numberOfSeats <= 3 || numberOfSeats > 7) this.numberOfSeats = 5;
        else this.numberOfSeats = numberOfSeats;

        if (tyresType == null || tyresType.isEmpty() || tyresType.isBlank())
            this.tyresType = "winter";
        else this.tyresType = tyresType;

        this.key = key;
        this.insurance = insurance;
    }
    private String validateRegNumber(String registrationNumber) {  //Y023HE999
        String checkedString = registrationNumber.trim();
        Pattern pattern = Pattern
                .compile("^[авекмнорстухАВЕКМНОРСТУХ\\-\\s][0-9]{3}(?<!0{3})[авекмнорстухАВЕКМНОРСТУХ\\-\\s]{2}[0-9]{2,3}$");
        Matcher matcher = pattern.matcher(checkedString);
        if (matcher.matches())
            return checkedString.toUpperCase() + "RUS";
        else
            return "Invalid input";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getTyresType() {
        return tyresType;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Key getKey() {
        return key;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) this.engineVolume = 1.5;
        else this.engineVolume = engineVolume;
    }

    public void setColour(String colour) {
        this.colour = Validator.validateString(colour);
    }

    public void setTransmission(String transmission) {
        if (transmission == null || transmission.equals("")) this.transmission = "manual transmission";
        else this.transmission = transmission;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateRegNumber(registrationNumber);
    }

    public void setWinterTyres() {
        this.tyresType = "winter";
    }
    public void setSummerTyres() {
        this.tyresType = "summer";
    }
    @Override
    public String toString() {
        return String.format ("%s %s:\n%d год выпуска, сборка: %s, цвет: %s, объем двигателя: %.01f л.\n" +
                        "Коробка передач: %s, кузов: %s, регистрационный номер: %s, число сидений %d, тип шин: %s",
                brand, model, year, country, colour, engineVolume, transmission,
                carBodyType, registrationNumber, numberOfSeats, tyresType + getKey() + getInsurance());
    }
    public static class Key {
        private final Boolean remoteStart;
        private final Boolean keylessAccess;
        private final String enabled = "доступна";
        private final String disabled = "недоступна";
        public Key(Boolean remoteStart, Boolean keylessAccess) {
            this.remoteStart = Validator.validateBoolean(remoteStart);
            this.keylessAccess = Validator.validateBoolean(keylessAccess);
        }

        public Boolean getRemoteStart() {
            return remoteStart;
        }

        public Boolean getKeylessAccess() {
            return keylessAccess;
        }
        private String remoteStart(Boolean remoteStart) {
            return remoteStart ? enabled: disabled;
        }
        private String keylessAccess(Boolean keylessAccess) {
            return keylessAccess ? enabled: disabled;
        }

        @Override
        public String toString() {
            return String.format("\nОпция автозапуска: %s\nОпция бесключевого доступа: %s\n",
                    remoteStart(remoteStart),keylessAccess(keylessAccess));
        }
    }
    public static class Insurance {
        private final int validityPeriodInMonth; //«Срок действия» страховки, по количеству месяцев
        private final double insurancePriceForOneMonth; //«Стоимость» страховки
        private final String insuranceID; //«Номер» страховки

        public Insurance(int validityPeriodInMonth, double insurancePriceForOneMonth, String insuranceID) {

            if (validityPeriodInMonth > 0)
                this.validityPeriodInMonth = validityPeriodInMonth;
            else
                this.validityPeriodInMonth = 1;
            if (insurancePriceForOneMonth > 1000)
                this.insurancePriceForOneMonth = insurancePriceForOneMonth * this.validityPeriodInMonth;
            else
                this.insurancePriceForOneMonth = 1000.0;

            this.insuranceID = validateInsuranceID(insuranceID);
        }
        private String validateInsuranceID(String insuranceID) {  //Y023HE999
            String checkedString = insuranceID.trim();

            if (Pattern.matches("^[a-zA-Z0-9]{9}$", checkedString))
                return checkedString.toUpperCase();
            else
                return "Invalid input";
        }

        public int getValidityPeriodInMonth() {
            return validityPeriodInMonth;
        }

        public double getInsurancePriceForOneMonth() {
            return insurancePriceForOneMonth;
        }

        public String getInsuranceID() {
            return insuranceID;
        }

        @Override
        public String toString() {
            return String.format("\nСтраховка выдана на %d месяцев\nСтоимость страховки: %.2f рублей\nНомер страховки: %s\n\n",
                    validityPeriodInMonth, insurancePriceForOneMonth, insuranceID);
        }
    }
}
