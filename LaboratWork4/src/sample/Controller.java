package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller
{
    public RadioButton function1;
    public RadioButton function2;

    public Label func;
    public Label sol;

    public TextField variable;
    public TextField xstart;
    public TextField xfinish;
    public TextField numberOfPoints;

    public LineChart<String, Double> chart;

    double a = 0.05;
    double b = 1.5;
    double x = 0.5;

    Function first = new DiffFunction(new FracFunction(new MultFunction(new PowerFunction(2,new LinearFunction(1)),new SumFunction(new LinearFunction(1),new ConstFunction(1))),new ConstFunction(b)),new PowerFunction(2,new SinFunction(new SumFunction(new LinearFunction(1),new ConstFunction(a)))));;
    Function second = new SumFunction(new PowerFunction(1.0/2,new FracFunction(new LinearFunction(b),new ConstFunction(a))),new PowerFunction(2,new CosFunction(new PowerFunction(3,new SumFunction(new LinearFunction(1),new ConstFunction(b))))));
    Function general = new ConstFunction(0);


    public void initialize()
    {
        this.function1.setText(first.print());
        this.function2.setText(second.print());

        general = first;
        func.setText("y = "+general.print());
    }

    public void derivative(ActionEvent actionEvent)
    {
        general = general.derivative();
        func.setText("y = "+general.print());
    }

    public void calculate(ActionEvent actionEvent)
    {
        sol.setText("y = "+general.calculate(Double.parseDouble(variable.getText())));
    }

    public void DrawChart(ActionEvent actionEvent)
    {
        final XYChart.Series<String, Double> series = new XYChart.Series<>();

        double x0 = Double.parseDouble(xstart.getText());
        double xn = Double.parseDouble(xfinish.getText());
        double n = Double.parseDouble(numberOfPoints.getText());

        if(x0>xn)
        {
            double x = x0;
            x0 = xn;
            xn = x;
        }

        for(double i = x0;i<xn;i+=(xn-x0)/n)
        {
            double x = i;
            double y = general.calculate(x);

            series.getData().add(new XYChart.Data<>(String.format("%.2f",x),y));
        }

        chart.getData().clear();
        chart.getData().add(series);
    }

    public void SetFunction1(ActionEvent actionEvent)
    {
        general = first;
        func.setText("y = "+general.print());
    }

    public void SetFunction2(ActionEvent actionEvent)
    {
        general = second;
        func.setText("y = "+general.print());
    }
}
