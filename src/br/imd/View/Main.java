package br.imd.View;

import org.opencv.core.Core;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import java.util.List;

public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
