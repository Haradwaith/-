/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Clelia
 */
public class ImcPlot {
    
    public ImcPlot(Stage primaryStage, GridPane pane){
       
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        int imctest[] = {0,12,67,45,90,0,0,0,0,0,0,0,0};

        xAxis.setLabel("Number of Month");

        final LineChart<Number,Number> 
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("IMC");
        
        XYChart.Series series = new XYChart.Series();
        series.setName("My Imc");
         
        try {
            for(int i = 0; i < imctest.length ; i++){
                for(int j = 0; j < 12; j++){
                series.getData().add(new XYChart.Data(j, imctest[j]));

                }
             }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Scene scene  = new Scene(lineChart,400,550);
        lineChart.getData().add(series);
        
        Button back = new Button("Back");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(back);
        pane.add(hbox, 1,1);
      
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               new NHFC().start(primaryStage);
            }
        });
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
}
