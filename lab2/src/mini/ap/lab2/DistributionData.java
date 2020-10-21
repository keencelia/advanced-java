package mini.ap.lab2;

import org.apache.commons.math3.distribution.RealDistribution;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.DoubleStream;

public class DistributionData<T extends RealDistribution>  {

    private  T dist;
    private Thread t;
    private ArrayBlockingQueue <Tuple2<Double,Double>> buffer;
    private double [] x;

    public DistributionData(T dist) {
        this.dist = dist;
        buffer = new ArrayBlockingQueue <Tuple2<Double,Double>>(100);

    }

    public Tuple2 <Double,Double> next() {

        try {
            return buffer.take();
        } catch (InterruptedException e) {
            return null;
        }

    }


    /**
     * this method is for version2 - multithreaded
     * @param left
     * @param right
     * @param size
     */
    public void points2(double left, double right, int size) {

        double [] x = domain(left, right, size);

        t = new Thread() {
            @Override
            public void run() {
                generatePoints(x);
            }
        };
        t.start();

    }


    /**
     * this method is for version1 (no threads)
     * @param left
     * @param right
     * @param size
     * @return
     */
    public List <Tuple2 <Double,Double>> points(double left, double right, int size) {

        double [] x = domain(left, right, size);
        double [] y = value(x);

        List<Tuple2<Double,Double>> list = new ArrayList <Tuple2<Double,Double>>();

        for (int i = 0; i < size; i++) {
            Tuple2<Double,Double> tuple = new Tuple2<Double,Double> (x[i], y[i]);
            list.add(tuple);
        }

        return list;

    }

    /**
     * this method is for version2
     * @param x
     */
    private void generatePoints(double [] x) {
        // @TODO: init output file
        for (int i = 0; i < x.length; i++) {
            Tuple2<Double,Double> tuple = new Tuple2<Double,Double> (x[i], dist.density(x[i]));
            // @TODO: write  x,y in a file
            try {
                buffer.put(tuple);  // put will block, add will not
            } catch (InterruptedException e) {
                continue;
            }
        }

    }

    /**
     * used only in version 1
     * @param xarr
     * @return
     */
    private double [] value (double [] xarr) {
        DoubleStream stream = Arrays.stream(xarr);

        DoubleStream y = stream.map(x->dist.density(x));

        return y.toArray();

    }

    private double [] domain(double left, double right, int size) {
        double [] x = new double [size];

        double step = (right-left)/size;

        x[0]=left;

        for (int i = 1; i < size; i++) {
            x[i]=x[i-1]+step;
        }

        return x;

    }
}
