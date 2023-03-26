package org.example.Client;

import java.io.IOException;
import java.util.Scanner;

public class InputClireader {
     /* вызываем входящий поток */
     private static Scanner inputReader = new Scanner(System.in);

     public static Scanner getInputReader() {
         return inputReader;
     }
     public static DataInOutStatus openStream() {
         try {
             OutStream.outputIntoCLI("Type commands");
             String inputData = inputReader.nextLine();
             while (inputData != null) {
                 if (!inputData.equals("exit")) {
                     inputData = inputData.trim();
                     DataInOutStatus checkedCommand = new CommandValidator().validate(inputData);
                     if (checkedCommand != DataInOutStatus.SUCCESSFULLY) {
                         OutStream.outputIntoCLI(checkedCommand.getName());
                     }
                 } else {
                     inputReader.close();
                 }
                 inputData = inputReader.nextLine();
             }
             return DataInOutStatus.SUCCESSFULLY;
         } catch (NullPointerException e) {
             return DataInOutStatus.FAILED;
         }
     }
}
