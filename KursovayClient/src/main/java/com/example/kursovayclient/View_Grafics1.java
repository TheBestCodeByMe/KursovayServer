package com.example.kursovayclient;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Employee;
import com.example.entity.Salaries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class View_Grafics1 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("Monitoring");
        lineChart.setLegendSide(Side.LEFT);

        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        ArrayList<Salaries> salaries = interactionsWithServer.viewSalaries();
        ArrayList<Employee> employees = interactionsWithServer.showAllEmployes();
        for(int i = 0; i < salaries.size(); i++) {
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Рабочий: " + employees.get(i).getLastName() + " " + employees.get(i).getName() + " " + employees.get(i).getPatronymic());

            series1.getData().add(new XYChart.Data("Jan", Double.parseDouble(Double.toString(salaries.get(i).getJanuary()))));
            series1.getData().add(new XYChart.Data("Feb", Double.parseDouble(Double.toString(salaries.get(i).getFebruary()))));
            series1.getData().add(new XYChart.Data("Mar", Double.parseDouble(Double.toString(salaries.get(i).getMarch()))));
            series1.getData().add(new XYChart.Data("Apr", Double.parseDouble(Double.toString(salaries.get(i).getApril()))));
            series1.getData().add(new XYChart.Data("May", Double.parseDouble(Double.toString(salaries.get(i).getMay()))));
            series1.getData().add(new XYChart.Data("Jun", Double.parseDouble(Double.toString(salaries.get(i).getJune()))));
            series1.getData().add(new XYChart.Data("Jul", Double.parseDouble(Double.toString(salaries.get(i).getJuly()))));
            series1.getData().add(new XYChart.Data("Aug", Double.parseDouble(Double.toString(salaries.get(i).getAugust()))));
            series1.getData().add(new XYChart.Data("Sep", Double.parseDouble(Double.toString(salaries.get(i).getSeptember()))));
            series1.getData().add(new XYChart.Data("Oct", Double.parseDouble(Double.toString(salaries.get(i).getOctober()))));
            series1.getData().add(new XYChart.Data("Nov", Double.parseDouble(Double.toString(salaries.get(i).getNovember()))));
            series1.getData().add(new XYChart.Data("Dec", Double.parseDouble(Double.toString(salaries.get(i).getDecember()))));

            lineChart.getData().add(series1);
        }

        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view-grafics1.fxml")));
        stage.setTitle("Просмотр графиков и диаграмм");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

     */
}
