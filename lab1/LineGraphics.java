package mini.ap.lab1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class LineGraphics extends Application {

    @Override public void start(Stage stage) {

        stage.setTitle("Gaussian Distribution Test");

        NumberAxis xAxis = new NumberAxis(-10,10,10);
        xAxis.setLabel("x");

        NumberAxis yAxis = new NumberAxis(0,0.5,0.01);
        yAxis.setLabel("y");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();
        series.setName("Gaussian distribution");

	double mean = 0.0; double sd = 1.0;
        GaussianData data = new GaussianData(mean, sd);
        int size = 1000;
        double leftbound = -10;
        double rightbound = 10;

        List <Tuple2 <Double,Double>> list = data.points(leftbound, rightbound, size);

        for (int i = 0; i < size; i++) {
            series.getData().add(new XYChart.Data(list.get(i)._1, list.get(i)._2));
        }

        lineChart.getData().add(series);


        Scene scene  = new Scene(lineChart,1000,800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

