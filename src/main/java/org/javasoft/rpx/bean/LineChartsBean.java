/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author ayojava
 */
@Named("lineChartsBean")
@RequestScoped
public class LineChartsBean implements Serializable {

    private FacesContext facesContext;

    private ResourceBundle bundle;
    
    private Calendar calObj;

    @Getter
    private LineChartModel cpuUtilizationModel, diskReadsModel, diskReadOperationsModel;

    @Getter
    private LineChartModel diskWritesModel, diskWritesOperationsModel, networkInModel;

    @Getter
    private LineChartModel networkOutModel, networkPacketsInModel;
    
    @Getter @Setter
    private String timeDifference;
    
    private double time1,time2,time3,time4,time5,time6,time7;

    @PostConstruct
    public void init() {
        initMsgBundle();
        initTimeValues();
        initChartModels();
        initCpuUtilizationModel();
        initDiskReadsModel();
        initDiskReadOperationsModel();
        initDiskWritesModel();
        initDiskWritesOperationsModel();
        initNetworkInModel();
        initNetworkOutModel();
        initNetworkPacketsInModel();
    }

    void initTimeValues(){
       calObj =  Calendar.getInstance();
       time7 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, -60);
       time1 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, 10);
       time2 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, 10);
       time3 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, 10);
       time4 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, 10);
       time5 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
       
       calObj.add(Calendar.MINUTE, 10);
       time6 = Double.parseDouble(calObj.get(Calendar.HOUR_OF_DAY) + "."+calObj.get(Calendar.MINUTE));
      
    }
    
    void initMsgBundle() {
        facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String baseName = "org.javasoft.rpx.resource.rpxMsg";
        bundle = ResourceBundle.getBundle(baseName, locale, loader);
    }

    private void initChartModels() {
        cpuUtilizationModel = new LineChartModel();
        diskReadsModel = new LineChartModel();
        diskReadOperationsModel = new LineChartModel();
        diskWritesModel = new LineChartModel();
        diskWritesOperationsModel = new LineChartModel();
        networkInModel = new LineChartModel();
        networkOutModel = new LineChartModel();
        networkPacketsInModel = new LineChartModel();
    }

    private void initCpuUtilizationModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(time1, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time2, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time3, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time4, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time5, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time6, RandomUtils.nextDouble(0.0, 3.5));
        series.set(time7, RandomUtils.nextDouble(0.0, 3.5));

        cpuUtilizationModel.addSeries(series);
        cpuUtilizationModel.setTitle(bundle.getString("label.cpuUtilization"));
        cpuUtilizationModel.setAnimate(true);
        Axis y_axis = cpuUtilizationModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(3.5);
        y_axis.setTickInterval("0.5");
        y_axis.setTickCount(8);

        Axis x_axis = cpuUtilizationModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initDiskReadsModel() {
        LineChartSeries series = new LineChartSeries();
        double val = RandomUtils.nextDouble(0.0, 1.0);
        series.set(time1, val);
        series.set(time2, val);
        series.set(time3, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time4, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time5, val);
        series.set(time6, val);
        series.set(time7, val);

        diskReadsModel.addSeries(series);
        diskReadsModel.setTitle(bundle.getString("label.diskReads"));
        diskReadsModel.setAnimate(true);
        Axis y_axis = diskReadsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskReadsModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initDiskReadOperationsModel() {
        LineChartSeries series = new LineChartSeries();
        double val = RandomUtils.nextDouble(0.0, 1.0);
        series.set(time1, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time2, val);
        series.set(time3, val);
        series.set(time4, val);
        series.set(time5, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time6, 0.2);
        series.set(time7, 0.2);

        diskReadOperationsModel.addSeries(series);
        diskReadOperationsModel.setTitle(bundle.getString("label.diskReadOperations"));
        diskReadOperationsModel.setAnimate(true);
        Axis y_axis = diskReadOperationsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskReadOperationsModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initDiskWritesModel() {
        LineChartSeries series = new LineChartSeries();
        double val = RandomUtils.nextDouble(0.0, 1.0);
        series.set(time1, val);
        series.set(time2, val);
        series.set(time3, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time4, val);
        series.set(time5, val);
        series.set(time6, val);
        series.set(time7, RandomUtils.nextDouble(0.0, 1.0));

        diskWritesModel.addSeries(series);
        diskWritesModel.setTitle(bundle.getString("label.diskWrites"));
        diskWritesModel.setAnimate(true);
        Axis y_axis = diskWritesModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskWritesModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initDiskWritesOperationsModel() {
        LineChartSeries series = new LineChartSeries();
        double val = RandomUtils.nextDouble(0.0, 1.0);
        series.set(time1, val);
        series.set(time2, val);
        series.set(time3, RandomUtils.nextDouble(0.0, 1.0));
        series.set(time4, val);
        series.set(time5, val);
        series.set(time6, val);
        series.set(time7, RandomUtils.nextDouble(0.0, 1.0));

        diskWritesOperationsModel.addSeries(series);
        diskWritesOperationsModel.setTitle(bundle.getString("label.diskWriteOperations"));
        diskWritesOperationsModel.setAnimate(true);
        Axis y_axis = diskWritesOperationsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskWritesOperationsModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initNetworkInModel() {
        LineChartSeries series = new LineChartSeries();
        int val = RandomUtils.nextInt(0, 50000);
        series.set(time1, RandomUtils.nextInt(0, 50000));
        series.set(time2, RandomUtils.nextInt(0, 50000));
        series.set(time3, RandomUtils.nextInt(0, 50000));
        series.set(time4, RandomUtils.nextInt(0, 50000));
        series.set(time5, RandomUtils.nextInt(0, 50000));
        series.set(time6, RandomUtils.nextInt(0, 50000));
        series.set(time7, RandomUtils.nextInt(0, 50000));

        networkInModel.addSeries(series);
        networkInModel.setTitle(bundle.getString("label.networkIn"));
        networkInModel.setAnimate(true);
        Axis y_axis = networkInModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(50000);
        y_axis.setTickInterval("10000");
        y_axis.setTickCount(6);

        Axis x_axis = networkInModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initNetworkOutModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(time1, RandomUtils.nextInt(0, 1500000));
        series.set(time2, RandomUtils.nextInt(0, 1500000));
        series.set(time3, RandomUtils.nextInt(0, 1500000));
        series.set(time4, RandomUtils.nextInt(0, 1500000));
        series.set(time5, RandomUtils.nextInt(0, 1500000));
        series.set(time6, RandomUtils.nextInt(0, 1500000));
        series.set(time7, RandomUtils.nextInt(0, 1500000));

        networkOutModel.addSeries(series);
        networkOutModel.setTitle(bundle.getString("label.networkOut"));
        networkOutModel.setAnimate(true);
        Axis y_axis = networkOutModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(1500000);
        y_axis.setTickInterval("500000");
        y_axis.setTickCount(4);

        Axis x_axis = networkOutModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }

    private void initNetworkPacketsInModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(time1, RandomUtils.nextInt(0, 600));
        series.set(time2, RandomUtils.nextInt(0, 600));
        series.set(time3, RandomUtils.nextInt(0, 600));
        series.set(time4, RandomUtils.nextInt(0, 600));
        series.set(time5, RandomUtils.nextInt(0, 600));
        series.set(time6, RandomUtils.nextInt(0, 600));
        series.set(time7, RandomUtils.nextInt(0, 600));

        networkPacketsInModel.addSeries(series);
        networkPacketsInModel.setTitle(bundle.getString("label.networkPacketsIn"));
        networkPacketsInModel.setAnimate(true);
        Axis y_axis = networkPacketsInModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(600);
        y_axis.setTickInterval("200");
        y_axis.setTickCount(4);

        Axis x_axis = networkPacketsInModel.getAxis(AxisType.X);
        x_axis.setMin(time1);
        x_axis.setMax(time7);
        x_axis.setTickFormat("%4.2f");
        x_axis.setTickCount(2);
        x_axis.setLabel(bundle.getString("label.time"));
    }
}
