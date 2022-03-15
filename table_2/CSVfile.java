package table_2;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVfile {

    public static void main(String[] args) throws IOException {
        List<Land> lands = addData();
        StringWriter writer = new StringWriter();

        System.out.println("///////////////////TABLE TWO//////////////////////////////////");
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        String[] header = new String[]{"id", "name"};
        //create Title
        csvBeanWriter.writeHeader(header);

        for (Land land : lands) {
            csvBeanWriter.write(land, header);
        }

        csvBeanWriter.close();
        System.out.println(writer.toString());
        //Method max column mass
        CSVfile.maxValueInColumnMass();
    }
    ///////////////////////////////////////////////////////////////////
    private static List<Land> addData() {
        List<Land> lands = new ArrayList<>();
        Land land1 = new Land(1412, "CN");
        Land land2 = new Land(1387, "IN");
        Land land3 = new Land(333, "USA");
        Land land4 = new Land(271, "INA");

        lands.add(land1);
        lands.add(land2);
        lands.add(land3);
        lands.add(land4);

        return lands;
    }

    public static int maxValueInColumnMass(){
        int number = 0;
        int max = 0;
        for (Land str : addData()){
            number = str.getId();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column id: " + max);
        return max;
    }
}
