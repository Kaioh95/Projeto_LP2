package br.imd.Model;

import java.util.List;

public class Distance {

    public Distance() {}

    public double euclidean(String[] img, List<Float> x) {
        double distance = 0;
        for(int i=0; i < x.size(); i++){
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            distance += Math.pow(xi - yi, 2);
        }
        return Math.sqrt(distance);
    }

    public double manhattan(String[] img, List<Float> x) {
        double distance = 0;
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            distance += Math.abs(xi - yi);
        }
        return distance;
    }

    public static double chebychev(String[] img, List<Float> x) {
        double distance = 0;
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            if( (xi - yi) > distance)
                distance = xi - yi;
        }
        return distance;
    }
}
