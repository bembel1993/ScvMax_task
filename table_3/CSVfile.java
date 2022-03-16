package table_3;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import table_1.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfile {
    public static File writeTable = new File("table3.txt");
    public static File writesolution= new File("solution3.txt");
    public static char[] buf;
    public static void main(String[] args) throws IOException {
        List<City> citys = addData();
        StringWriter writer = new StringWriter();

        System.out.println("///////////////////TABLE THREE//////////////////////////////////");
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
    private static List<City> addData() throws IOException {
        List<City> cities = new ArrayList<>();
        City city1 = new City("Minsk", 6, -9);
        City city2 = new City("Brest", 4, -7);
        City city3 = new City("Gomel", -3, -1);

        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        //WRITE IN FILE
        writeAddWordInFile(cities);
        //READE IN FILE
        showWriteAddWordInFile();
        return cities;
    }

    public static int minValueInColumnMass() throws IOException {
        int number = 0;
        int max = -1000;
        for (City str : addData()){
            number = str.getTemp();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column temp: " + max);
        FileWriter fileWriter = new FileWriter(writesolution, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date result out solution");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(max)+"\n");
        writeWordInFile.flush();
        showWriteAddWordInFileSolut();
        return max;
    }
    public static void writeAddWordInFile(List<City> cities) throws IOException {
        FileWriter fileWriter = new FileWriter(writeTable, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date is Write");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(cities));
        writeWordInFile.flush();
    }

    public static void showWriteAddWordInFile() throws IOException {
        FileReader fileReadAddToVocabulary = new FileReader(writeTable);
        buf = new char[10000];
        int c; //- by character reading
        try {
            c = fileReadAddToVocabulary.read(buf);
            buf = Arrays.copyOf(buf, c);
            System.out.print(buf);
            System.out.print("\n");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public static void showWriteAddWordInFileSolut() throws IOException {
        FileReader fileReadAddToVocabulary = new FileReader(writesolution);
        buf = new char[10000];
        int c; //- by character reading
        try {
            c = fileReadAddToVocabulary.read(buf);
            buf = Arrays.copyOf(buf, c);
            System.out.print(buf);
            System.out.print("\n");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
