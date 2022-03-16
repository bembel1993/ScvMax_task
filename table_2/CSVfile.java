package table_2;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import table_1.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfile {
    public static File writeTable = new File("table2.txt");
    public static File writesolution= new File("solution2.txt");
    public static char[] buf;
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
    private static List<Land> addData() throws IOException {
        List<Land> lands = new ArrayList<>();
        Land land1 = new Land(1412, "CN");
        Land land2 = new Land(1387, "IN");
        Land land3 = new Land(333, "USA");
        Land land4 = new Land(271, "INA");

        lands.add(land1);
        lands.add(land2);
        lands.add(land3);
        lands.add(land4);
        //WRITE IN FILE
        writeAddWordInFile(lands);
        //READE IN FILE
        showWriteAddWordInFile();
        return lands;
    }

    public static int maxValueInColumnMass() throws IOException {
        int number = 0;
        int max = 0;
        for (Land str : addData()){
            number = str.getId();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column id: " + max);
        FileWriter fileWriter = new FileWriter(writesolution, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date result out solution");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(max)+"\n");
        writeWordInFile.flush();
        showWriteAddWordInFileSolut();
        return max;
    }

    public static void writeAddWordInFile(List<Land> lands) throws IOException {
        FileWriter fileWriter = new FileWriter(writeTable, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date is Write");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(lands));
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
