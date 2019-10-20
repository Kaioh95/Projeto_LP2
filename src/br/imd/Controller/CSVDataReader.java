package br.imd.Controller;

import java.io.FileReader;
import java.util.List;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
import com.opencsv.*;

public class CSVDataReader {
    private static final String csv_path = "C:\\Users\\Usuario\\Documents\\Projeto_LP2\\dataset.csv";

    public static void readAllData(String file){
        try{
            //Create an object with the path
            //of the CSV file as a parameter
            FileReader filereader = new FileReader(file);

            //Now with the CSVReader is possible
            //to read a CSV file ignoring the header
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> dataset = csvReader.readAll();

            //Just to text we going to print data
            for(String[] row: dataset){
                for(String cell: row){
                    System.out.print(cell + ", ");
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("print the DateSet without the header");
        readAllData(csv_path);
        System.out.println("_____________________________________________________");
    }
}
