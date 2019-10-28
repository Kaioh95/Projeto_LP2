package br.imd.View;

import br.imd.Control.CSVDataReader;
import br.imd.Control.FeatureExtraction;
import br.imd.Model.HeapTree;
import br.imd.Model.Node;
import org.opencv.core.Core;

import java.util.List;

public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void k_nn(List<String[]> imgs, List<Float> imgx, int k){
        int x = 1;
        HeapTree rankedImgs = new HeapTree();

        for(String[] img: imgs){
            rankedImgs.addNode(euclideanDistance(img, imgx), img);
            System.out.println(x + " distance: " + euclideanDistance(img, imgx) + " " + img[img.length-1]);
            x += 1;
        }

        rankedImgs.heapSort();
        System.out.println(rankedImgs.toString());
        Node[] rank = new Node[3];
        rank = rankedImgs.peek(k);
        rankedImgs.fillNa();
        for(Node node: rank){
            System.out.println(node.toString());
            node = null;
        }
    }

    public static double euclideanDistance(String[] img, List<Float> x){
        double distance = 0;
        for(int i=0; i < x.size(); i++){
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            distance += Math.pow(xi - yi, 2);
        }
        return Math.sqrt(distance);
    }

    public static double manhattanDistance(String[] img, List<Float> x) {
        double distance = 0;
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            distance += Math.abs(xi - yi);
        }
        return distance;
    }

    public static double chebychevDistance(String[] img, List<Float> x) {
        double distance = 0;
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            if( (xi - yi) > distance)
                distance = xi - yi;
        }
        return distance;
    }

    public static void main(String[] args) {
        CSVDataReader data = new CSVDataReader();
        data.readAllData(data.getCsv_path());

        FeatureExtraction fext = new FeatureExtraction();
        List<Float> imgFeatures = fext.extract("data/img2.png");

        k_nn(data.getDataset(), imgFeatures, 3);
    }
/*
    public static void main(String[] args) {
        HOGDescriptor hog = new HOGDescriptor();
        Mat img = new Mat();
        MatOfFloat features = new MatOfFloat();

        img = Imgcodecs.imread("C:\\Users\\Usuario\\Pictures\\img1.png", Imgcodecs.IMREAD_GRAYSCALE);
        Imgproc.resize(img, img, new Size(64, 128), 0.5, 0.5, Imgproc.INTER_LINEAR);
        hog.compute(img, features);
        List<Float> arrayOfFeatures = features.toList();
        System.out.println(arrayOfFeatures.toString());
    }

 */
}
