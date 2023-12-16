package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Data {
    String name;
    String surname;
    String patronymic;
    Date dateOfBirth;
    int phone;
    String gender;

    public Date ParseDateOfBirth(String input) throws ParseException, InvalidInputException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        Pattern pattern = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            String StringDate = matcher.group(0);
            try {
                return dateFormat.parse(StringDate);
            } catch (ParseException e) {
                System.out.println("You entered the wrong date");
            }
        }
        else {
            throw new InvalidInputException("No DateOfBirth in input");
        }
        return null;
    }

    public int ParsePhone(String input) throws NumberFormatException, InvalidInputException {
        int parsedPhone = -1;
        input = input.replaceAll("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b", "");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            String phone = matcher.group(0);
            try {
                parsedPhone = Integer.parseInt(phone);
                return parsedPhone;
            } catch (NumberFormatException e){
                System.out.println("Invalid phone number");
            }
        }
        else {
            throw new InvalidInputException("No telephone in input");
        }
        return parsedPhone;
    }

    public ArrayList<String> ParseNameSurnamePatronymic(String input) throws InvalidInputException {
        Pattern numberAndDotPattern = Pattern.compile("[0-9.]");  // регулярное выражение для поиска цифр и точек
        Pattern sequencePattern = Pattern.compile("\\b[^FM\\s]+\\b");  // регулярное выражение для поиска последовательности символов, исключая F, M и пробелы

        // Удаляем все числа и точки из строки
        Matcher numberAndDotMatcher = numberAndDotPattern.matcher(input);
        input = numberAndDotMatcher.replaceAll("");

        // Находим последовательности символов
        Matcher sequenceMatcher = sequencePattern.matcher(input);
        int cnt_params = 0;
        ArrayList<String> dataList = new ArrayList<String>();
        while (sequenceMatcher.find()) {
            String sequence = sequenceMatcher.group();  // Получаем найденную последовательность
            dataList.add(sequence);
            System.out.println(sequence);
            cnt_params ++;
        }
        if (cnt_params > 3){
            throw new InvalidInputException("Too much input");
        }
        else if(cnt_params < 3){
            throw new InvalidInputException("Too small input");
        }
        else {
            return dataList;
        }
    }

    public String ParseGender(String input) throws InvalidInputException{
        String gender = "";
        Pattern pattern = Pattern.compile("\\b[FM]\\b");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            gender = matcher.group();
            return gender;
        }
        else {
            throw new InvalidInputException("No gender in input");
        }
    }

    public int setData(String input){
        String ParsedGender;
        Date ParsedDateOfBirth;
        int ParsedPhone;
        String ParsedSurname;
        String ParsedName;
        String ParsedPatronymic;
        try {
            ParsedGender = ParseGender(input);
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
            return -1;
        }
        try {
            ParsedDateOfBirth = ParseDateOfBirth(input);
        } catch (InvalidInputException | ParseException e){
            System.out.println(e.getMessage());
            return -2;
        }
        try {
            ParsedPhone = ParsePhone(input);
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
            return -3;
        }
        try {
            ArrayList<String> SNP = ParseNameSurnamePatronymic(input);
            ParsedSurname = SNP.get(0);
            ParsedName = SNP.get(1);
            ParsedPatronymic = SNP.get(2);
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
            return -4;
        }
        this.gender = ParsedGender;
        this.dateOfBirth = ParsedDateOfBirth;
        this.phone = ParsedPhone;
        this.name = ParsedName;
        this.surname = ParsedSurname;
        this.patronymic = ParsedPatronymic;
        return 0;
    }
}

