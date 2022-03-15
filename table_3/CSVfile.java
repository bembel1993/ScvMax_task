package table_3;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVfile {

    public static void main(String[] args) throws IOException {
        List<City> citys = addData();
        StringWriter writer = new StringWriter();

        System.out.println("///////////////////TABLE ONE//////////////////////////////////");
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        String[] header = new String[]{"city", "temp2", "temp"};
        //create Title
        csvBeanWriter.writeHeader(header);

        for (City city : citys) {
            csvBeanWriter.write(city, header);
        }

        csvBeanWriter.close();
        System.out.println(writer.toString());
        //Method max column mass
        table_3.CSVfile.minValueInColumnMass();
    }
    ///////////////////////////////////////////////////////////////////
    private static List<City> addData() {
        List<City> cities = new ArrayList<>();
        City city1 = new City("Minsk", 6, -9);
        City city2 = new City("Brest", 4, -7);
        City city3 = new City("Gomel", -3, -1);

        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

        return cities;
    }

    public static int minValueInColumnMass(){
        int number = 0;
        int max = -1000;
        for (City str : addData()){
            number = str.getTemp();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column temp: " + max);
        return max;
    }

}
