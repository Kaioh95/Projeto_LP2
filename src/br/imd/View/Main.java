package br.imd.View;

import br.imd.Controller.CSVDataReader;
import br.imd.Controller.FeatureExtraction;
import br.imd.Model.KNNAlgorithm;
import org.opencv.core.Core;

import java.util.List;

public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        CSVDataReader data = new CSVDataReader();
        data.readAllData(data.getCsv_path());

        FeatureExtraction fext = new FeatureExtraction();
        List<Float> imgFeatures = fext.extract("data/sampleimage.png");

        KNNAlgorithm k_nn = new KNNAlgorithm();
        k_nn.k_nn(data.getDataset(), imgFeatures, 3, 1);
    }

}
