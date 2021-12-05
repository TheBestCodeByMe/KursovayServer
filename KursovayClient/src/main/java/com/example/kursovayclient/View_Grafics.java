package com.example.kursovayclient;

import com.example.connection.InteractionsWithServer;
import com.example.entity.Employee;
import com.example.entity.Salaries;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class View_Grafics extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Расходы компании на зарплаты сотрудникам по месяцам");
        stage.setWidth(610);
        stage.setHeight(500);

        InteractionsWithServer interactionsWithServer = new InteractionsWithServer();
        ArrayList<Salaries> salaries = interactionsWithServer.viewSalaries();
        double salJanuary = 0, salFebruary = 0, salMarch = 0, salApril = 0, salMay = 0, salJune = 0;
        double salJuly = 0, salAugust = 0, salSeptember = 0, salOctober = 0, salNovember = 0, salDecember = 0;
        for (Salaries salary : salaries) {
            salJanuary += salary.getJanuary();
            salFebruary += salary.getFebruary();
            salMarch += salary.getMarch();
            salApril += salary.getApril();
            salMay += salary.getMay();
            salJune += salary.getJune();
            salJuly += salary.getJuly();
            salAugust += salary.getAugust();
            salSeptember += salary.getSeptember();
            salOctober += salary.getOctober();
            salNovember += salary.getNovember();
            salDecember += salary.getDecember();
        }

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Январь: " + salJanuary + " руб.", salJanuary),
                        new PieChart.Data("Февраль: " + salFebruary + " руб.", salFebruary),
                        new PieChart.Data("Март: " + salMarch + " руб.", salMarch),
                        new PieChart.Data("Апрель: " + salApril + " руб.", salApril),
                        new PieChart.Data("Май: " + salMay + " руб.", salMay),
                        new PieChart.Data("Июнь: " + salJune + " руб.", salJune),
                        new PieChart.Data("Июль: " + salJuly + " руб.", salJuly),
                        new PieChart.Data("Август: " + salAugust + " руб.", salAugust),
                        new PieChart.Data("Сентябрь: " + salSeptember + " руб.", salSeptember),
                        new PieChart.Data("Октябрь: " + salOctober + " руб.", salOctober),
                        new PieChart.Data("Ноябрь: " + salNovember + " руб.", salNovember),
                        new PieChart.Data("Декабрь: " + salDecember + " руб.", salDecember));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Расходы компании на зарплаты сотрудникам по месяцам");

        chart.setLabelLineLength(10);
        chart.setLegendSide(Side.LEFT);

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();

        /*
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText(data.getPieValue() + " руб.");
            });
        }
        */
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
