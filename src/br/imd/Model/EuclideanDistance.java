package br.imd.Model;

import java.util.List;

public class EuclideanDistance implements Distance {

    public EuclideanDistance() {
    }

    @Override
    public double distance(String[] img, List<Float> x) {
        double distance = 0;
        for(int i=0; i < x.size(); i++){
            double xi = x.get(i).doubleValue();
            double yi = Double.parseDouble(img[i]);
            distance += Math.pow(xi - yi, 2);
        }
        return Math.sqrt(distance);
    }
}
