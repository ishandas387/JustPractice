package com.hashcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class HashCode {
    public static void main(String[] args) {

        String filePath ="C:/Users/ishan/Downloads/a_example.txt";
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input =  contentBuilder.toString();

        String[] inputArray = input.split("\n");

        String mainInput = inputArray[0];
        String [] mainInputArray = mainInput.split(" ");

        String numberOfBooks = mainInputArray[0];
        String numberOfLib = mainInputArray[1];
        String numberOfDays = mainInputArray[2];

        List<Book> listOfBooks = new ArrayList<>();
        
        String bookScores = inputArray[1];
        String []  bookScoresArray = bookScores.split(" ");
        for(int i =0 ; i<Integer.parseInt(numberOfBooks); i++){
            Book book = new Book(String.valueOf(i), bookScoresArray[i]);
            listOfBooks.add(book);
        }

        listOfBooks.forEach(b -> System.out.println(b.getBookNumber()+"-"+b.getBookScore()));

        ///get the lib

        List<Library> libs = new ArrayList<>();
        int index = 2;
        for(int j=0 ; j< Integer.parseInt(numberOfLib) ; j++){
             

                 Library lib = new Library();
                String firstLine = inputArray[index++];
                String secondLine = inputArray[index++];
                String[] libProp = firstLine.split(" ");
                String[] bookIndex = secondLine.split(" ");
                lib.setLibName("L"+j);
                lib.setNumberOfBooksPerDay(Integer.parseInt(libProp[2]));
                lib.setNumberOfDaysForSignUp(Integer.parseInt(libProp[1]));
                List<Book> listOfBooksInLib = new ArrayList<>();
                for(String ind: bookIndex){
                    listOfBooksInLib.add(listOfBooks.get(Integer.parseInt(ind)));
                }
                lib.setBookList(listOfBooksInLib);
                System.out.println("my lib");
                
                System.out.println(lib.toString());

                libs.add(lib);
        }


        /// I have the list of libraries with all the lib details.


        // LOOP through the list , for each lib. based on the book limit calculate the max score

        // Keep tab of the books scanned.
        libs.removeIf(lib -> lib.getNumberOfDaysForSignUp() > Integer.parseInt(numberOfDays));
        Set<String> bookName = new  HashSet<>();

        int days = Integer.parseInt(numberOfDays);
        if(!libs.isEmpty()){
            while(days > 0){
                
                
                days -- ;

            }
            
        }




    }
}