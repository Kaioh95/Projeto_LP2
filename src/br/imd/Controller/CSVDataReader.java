package br.imd.Controller;

import java.io.FileReader;
import java.util.List;
import com.opencsv.*;

public class CSVDataReader {
    private static final String csv_path = "data&libs\\dataset.csv";
    private List<String[]> dataset;

    public List<String[]> getDataset() {
        return dataset;
    }

    public void setDataset(List<String[]> dataset) {
        this.dataset = dataset;
    }

    public void readAllData(String file){
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
            this.dataset = dataset;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
    public static void main(String[] args) {
        CSVDataReader csv = new CSVDataReader();
        System.out.println("print the DateSet without the header");
        csv.readAllData(csv_path);
        System.out.println("________________________________________________________________________________");
    }
    */
}
