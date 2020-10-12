package mini.ap.lab2;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import scala.Tuple2;

import java.util.List;

public class DynLineGraphics extends Application {


    private void init(Stage stage) {

    }


    @Override public void start(Stage stage) {

        stage.setTitle("");

        NumberAxis xAxis = new NumberAxis(-5,5,1);
        xAxis.setLabel("x");

        NumberAxis yAxis = new NumberAxis(0,0.45,0.05);
        yAxis.setLabel("y");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();
        series.setName("Standard Normal Distribution");

        GaussianData data = new GaussianData(0.0, 1.0);
        final int size = 1000;
        double leftbound = -5;
        double rightbound = 5;

        List <Tuple2 <Double,Double>> list = data.points(leftbound, rightbound, size);

        lineChart.getData().add(series);

        Scene scene  = new Scene(lineChart,1000,800);
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.show();


        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(30000));
            }

            protected void interpolate(double frac) {

                int points = series.getData().size();

                if (points < size) {
                    series.getData().add(new XYChart.Data(list.get(points)._1, list.get(points)._2));
                }

            }

        };

        animation.play();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

