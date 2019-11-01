package br.imd.Model;

import java.util.List;

public class KNNAlgorithm {

    public KNNAlgorithm() {}

    public void k_nn(List<String[]> imgs, List<Float> imgx, int k, int option){
        int x = 1;
        int person = 0;
        int noPerson = 0;
        Distance similarityMeasure;
        HeapTree rankedImgs = new HeapTree();

        //Setting the Distance
        if(option == 1)
            similarityMeasure = new EuclideanDistance();
        else if(option == 2)
            similarityMeasure = new ManhattanDistance();
        else
            similarityMeasure = new ChebychevDistance();

        //Calculating the distance of the input image
        //from each image in the dataset.
        for(String[] img: imgs){
            rankedImgs.addNode(similarityMeasure.distance(img, imgx), img);
            System.out.println(x + " distance: " + similarityMeasure.distance(img, imgx) + " " + img[img.length-1]);
            x += 1;
        }

        //Ranking images by distance
        rankedImgs.heapSort();
        System.out.println(rankedImgs.toString());

        //Catching the K images
        Node[] rank = new Node[k];
        rank = rankedImgs.peek(k);
        rankedImgs.fillNa();

        for(Node node: rank){
            System.out.println(node.toString());
            if(node.getContent()[node.getContent().length-1].equals("person"))
                person += 1;
            else
                noPerson += 1;
        }

        //Making predictions
        if(person > noPerson){
            System.out.println("There are people in the picture!");
        }
        else
            System.out.println("There are no people in the picture!");
    }
}
