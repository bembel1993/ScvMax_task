package table_1;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVfile {

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
        CSVfile.maxValueInColumnMass();
    }
///////////////////////////////////////////////////////////////////
    private static List<Employee> addData() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(3, "Jon", 89, "T", 18, 13);
        Employee employee1 = new Employee(2, "Alex", 101, "F", 18, 4);

        employees.add(employee);
        employees.add(employee1);

        return employees;
    }

    public static int maxValueInColumnMass(){
        int number = 0;
        int max = 0;
        for (Employee str : addData()){
            number = str.getMass();
            if (max < number){
                max = number;
            }
        }
        System.out.println("Method 1. Max Value in column mass: " + max);
        return max;
    }

}