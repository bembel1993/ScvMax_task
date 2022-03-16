package table_1;

import last_task.Field;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfile {
    public static File writeTable = new File("table1.txt");
    public static File writesolution= new File("solution1.txt");
    public static char[] buf;
    public static void main(String[] args) throws IOException {
        List<Employee> employees = addData();
        StringWriter writer = new StringWriter();

        System.out.println("///////////////////TABLE ONE//////////////////////////////////");
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        String[] header = new String[]{"id", "name", "mass", "single", "room", "dep"};
        //create Title
        csvBeanWriter.writeHeader(header);

        for (Employee employee : employees) {
            csvBeanWriter.write(employee, header);
        }

        csvBeanWriter.close();
        System.out.println(writer.toString());
        //Method max column mass
        CSVfile.solution();
    }
///////////////////////////////////////////////////////////////////
    private static List<Employee> addData() throws IOException {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(3, "Jon", 89, "T", 18, 13);
        Employee employee1 = new Employee(2, "Alex", 101, "F", 18, 4);

        employees.add(employee);
        employees.add(employee1);
        //WRITE IN FILE
        writeAddWordInFile(employees);
        //READE IN FILE
        showWriteAddWordInFile();
        return employees;
    }

    public static int solution() throws IOException {
        int number = 0;
        int max = 0;
        for (Employee str : addData()){
            number = str.getMass();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column mass: " + max);
        FileWriter fileWriter = new FileWriter(writesolution, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date result out solution");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(max)+"\n");
        writeWordInFile.flush();
        showWriteAddWordInFileSolut();
        return max;
    }

    public static void writeAddWordInFile(List<Employee> employees) throws IOException {
        FileWriter fileWriter = new FileWriter(writeTable, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date is Write");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(employees));
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