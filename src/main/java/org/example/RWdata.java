package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class RWdata {
    public int writeDataToFile(Data data){
        String dataString = String.format("%s %s %s %s %s %s", data.surname, data.name, data.patronymic, data.dateOfBirth, data.phone, data.gender);
        try {
            String FileNameSurname = String.format("%s.txt", data.surname);
            FileWriter writer = new FileWriter(FileNameSurname, true);
            writer.write(dataString);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }
}

