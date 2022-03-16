package last_task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Field {

    private String fieldA;
    private int fieldB;
    public Field(String fieldA, int fieldB) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
    }

    public String getFieldA() {
        return fieldA;
    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public int getFieldB() {
        return fieldB;
    }

    public void setFieldB(int fieldB) {
        this.fieldB = fieldB;
    }

    @Override
    public String toString() {
        return "Field{" + "fieldA='" + fieldA + '\'' + " fieldB=" + fieldB + '}'+"\n";
    }

}
