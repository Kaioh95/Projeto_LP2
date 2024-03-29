package br.imd.Controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVDataReader {
    private static final String csv_path = "data/dataset_2019_1.csv";
    private List<String[]> dataset;

    public String getCsv_path(){ return csv_path; }

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

            this.dataset = dataset;

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
