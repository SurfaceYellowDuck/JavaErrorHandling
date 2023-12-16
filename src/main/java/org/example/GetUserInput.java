package org.example;

import java.util.Scanner;

public class GetUserInput {
    String data;
    public void GetInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите через пробел: фамилию, имя, отчество дату рождения, номер телефона, пол\n: ");
        this.data = scanner.nextLine();
    }
}
