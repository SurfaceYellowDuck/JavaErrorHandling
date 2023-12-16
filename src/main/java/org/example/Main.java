package org.example;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, InvalidInputException {
        Data data = new Data();
        // ******* test date *********
//        Date test = data.ParseDateOfBirth("AlexAAA 23.12.2023");
//        System.out.println(test);
        // ******** end test date ********
        // ******** test phone input *****
//        String input = "sgsg 324352 fsgsg";
//        int test = data.ParsePhone(input);s
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(input);
//        if(matcher.find()){
//            String test = matcher.group(0);
//            System.out.println(test);
//        }
//        System.out.println(test);
        // ******* end test phone input **********
        // ******* test gender input ********
//        String test = "MMM MMMM";
//        String res = data.ParseGender(test);
//        System.out.println(res);
//        System.out.println("Hello world!");
        //******* end test gender input ******
        // ***** test FIO input ******
//        String input1 = "Текст с последовательностью символов TUV внутри и F M где-то ещё";
//        String input = "AlexAAA 23.12.2023 F Parfenov Alexeevich";
//
////        String input = "Текст 123 с последовательностью символов T.U.V. внутри и 456 F M где-то ещё";
//        Pattern numberAndDotPattern = Pattern.compile("[0-9.]");  // регулярное выражение для поиска цифр и точек
//        Pattern sequencePattern = Pattern.compile("\\b[^FM\\s]+\\b");  // регулярное выражение для поиска последовательности символов, исключая F, M и пробелы
//
//        // Удаляем все числа и точки из строки
//        Matcher numberAndDotMatcher = numberAndDotPattern.matcher(input);
//        input = numberAndDotMatcher.replaceAll("");
//
//        // Находим последовательности символов
//        Matcher sequenceMatcher = sequencePattern.matcher(input);
//
//        int cnt_params = 0;
//        while (sequenceMatcher.find()) {
//            String sequence = sequenceMatcher.group();  // Получаем найденную последовательность
//            System.out.println(sequence);
//            cnt_params ++;
//        }
//        if (cnt_params > 3){
//            throw new InvalidInputException("Too much input");
//        }
//        if(cnt_params < 3){
//            throw new InvalidInputException("Too small input");
//        }
        // ****** end test FIO input *******
//        String input = "23.06.2004 Obolonsky Alexey Andreevich 43525254 M";
        GetUserInput getInput = new GetUserInput();
        getInput.GetInput();
        String input = getInput.data;
        data.setData(input);
        String message = String.format("%s %s %s %s %s %s", data.surname, data.name, data.patronymic, data.dateOfBirth, data.phone, data.gender);
        System.out.println(message);
        // ***** test write into file *******
        RWdata rw = new RWdata();
        rw.writeDataToFile(data);
    }
}
