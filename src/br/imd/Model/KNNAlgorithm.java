package br.imd.Model;

import java.util.List;

public class KNNAlgorithm {
    private Node[] neighbours;

    public KNNAlgorithm() {}

    public void k_nn(List<String[]> allImages, List<Float> imageX, int k, int option){
        Distance similarityMeasure;

        //Setting the Distance
        if(option == 1)
            similarityMeasure = new EuclideanDistance();
        else if(option == 2)
            similarityMeasure = new ManhattanDistance();
        else
            similarityMeasure = new ChebychevDistance();

        //Ranking Process Ahead
        int x = 1;
        HeapTree rankedImgs = new HeapTree();

        //Calculating the distance of the input image
        //from each image in the dataset.
        for(String[] img: allImages){
            rankedImgs.addNode(similarityMeasure.distance(img, imageX), img);
            System.out.println(x + " distance: " + similarityMeasure.distance(img, imageX) + " " + img[img.length-1]);
            x += 1;
        }

        //Ranking images by distance
        rankedImgs.heapSort();
        System.out.println(rankedImgs.toString());

        //Catching the K images
        neighbours = new Node[k];
        neighbours = rankedImgs.peek(k);
        //rankedImgs.fillNa();
    }

    public boolean makePrediction(){
        int person = 0;
        int noPerson = 0;
        //String results = "";
        //line break that can be used on linux or windowns
        //String lineBreak = System.getProperty("line.separator");

        //results.concat("Showing neighbours and making predictions: " + lineBreak);
        for(Node node: neighbours){
            System.out.println(node.toString());
            //results.concat(node.toString() + lineBreak);

            if(node.getContent()[node.getContent().length-1].equals("person"))
                person += 1;
            else
                noPerson += 1;
        }

        //Making predictions
        if(person > noPerson){
            //results.concat("There are people in the picture!" + lineBreak);
            System.out.println("There are people in the picture!");
            return true;
        }
        else {
            //results.concat("There are no people in the picture!" + lineBreak);
            System.out.println("There are no people in the picture!");
            return false;
        }

        //return results;
    }

}
