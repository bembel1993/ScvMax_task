package table_3;

public class City {

    private String city;
    private int temp2;
    private int temp;

    public City(String city, int temp2, int temp) {
        this.city = city;
        this.temp2 = temp2;
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemp2(int temp2) {
        this.temp2 = temp2;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTemp2() {
        return temp2;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "City{" + "city='" + city + '\'' + ", temp2=" + temp2 +
                ", temp=" + temp + '}';
    }
}
