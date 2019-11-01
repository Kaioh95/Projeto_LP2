package br.imd.Model;

import java.util.List;

public class KNNAlgorithm {

    public KNNAlgorithm() {}

    public void k_nn(List<String[]> imgs, List<Float> imgx, int k){
        int x = 1;
        HeapTree rankedImgs = new HeapTree();
        EuclideanDistance euclidean = new EuclideanDistance();

        for(String[] img: imgs){
            rankedImgs.addNode(euclidean.distance(img, imgx), img);
            System.out.println(x + " distance: " + euclidean.distance(img, imgx) + " " + img[img.length-1]);
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
}
