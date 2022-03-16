package last_task;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfile {
    public static File writeTable = new File("table.txt");
    public static File writesolution= new File("solution.txt");
    public static char[] buf;
    public static void main(String[] args) throws IOException {

        List<Field> fields = addData();
        StringWriter writer = new StringWriter();

        System.out.println("///////////////////last_task//////////////////////////////////");
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        String[] header = new String[]{"fieldA", "fieldB"};
        //create Title
        csvBeanWriter.writeHeader(header);

        for (Field field : fields) {
            csvBeanWriter.write(field, header);
        }

        csvBeanWriter.close();
        System.out.println(writer.toString());

        CSVfile.solution();

    }

    ///////////////////////////////////////////////////////////////////
    private static List<Field> addData() throws IOException {
        List<Field> fields = new ArrayList<>();
        Field field1 = new Field("abcd", 1);
        Field field2 = new Field("dcba", 3);
        Field field3 = new Field("bcaa", 5);

        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        //WRITE IN FILE
        writeAddWordInFile(fields);
        //READE IN FILE
        showWriteAddWordInFile();
        return fields;
    }

    public static int solution() throws IOException {
        int number = 0;
        int max = 0;
        for (Field str : addData()) {
            number = str.getFieldB();
            if (max < number) {
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column fieldB: " + max);
        FileWriter fileWriter = new FileWriter(writesolution, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date result out solution");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(max)+"\n");
        writeWordInFile.flush();
        showWriteAddWordInFileSolut();
        return max;
    }

    public static void writeAddWordInFile(List<Field> fields) throws IOException {
        FileWriter fileWriter = new FileWriter(writeTable, true);
        BufferedWriter writeWordInFile = new BufferedWriter(fileWriter);
        System.out.println("Date is Write");
        System.out.println("      -       ");
        writeWordInFile.write(String.valueOf(fields));
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

