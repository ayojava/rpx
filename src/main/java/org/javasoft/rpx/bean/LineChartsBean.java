/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author ayojava
 */
@Named("lineChartsBean")
@ViewScoped
public class LineChartsBean implements Serializable {

    private FacesContext facesContext;

    private ResourceBundle bundle;

    @Getter
    private LineChartModel cpuUtilizationModel, diskReadsModel, diskReadOperationsModel;

    @Getter
    private LineChartModel diskWritesModel, diskWritesOperationsModel, networkInModel;

    @Getter
    private LineChartModel networkOutModel, networkPacketsInModel;
    
    @Getter @Setter
    private String timeDifference;

    @PostConstruct
    public void init() {
        initMsgBundle();
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
        series.set(8.00, 1.3);
        series.set(8.05, 0.2);
        series.set(8.10, 0.6);
        series.set(8.25, 0.1);
        series.set(8.40, 0.1);
        series.set(8.48, 3.3);

        cpuUtilizationModel.addSeries(series);
        cpuUtilizationModel.setTitle(bundle.getString("label.cpuUtilization"));
        cpuUtilizationModel.setAnimate(true);
        Axis y_axis = cpuUtilizationModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(3.5);
        y_axis.setTickInterval("0.5");
        y_axis.setTickCount(8);

        Axis x_axis = cpuUtilizationModel.getAxis(AxisType.X);
        x_axis.setMin(8.0);
        x_axis.setMax(8.5);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initDiskReadsModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 0.2);
        series.set(8.05, 0.2);
        series.set(8.10, 0.2);
        series.set(8.25, 0.2);
        series.set(8.40, 0.2);
        series.set(8.48, 0.2);

        diskReadsModel.addSeries(series);
        diskReadsModel.setTitle(bundle.getString("label.diskReads"));
        diskReadsModel.setAnimate(true);
        Axis y_axis = diskReadsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskReadsModel.getAxis(AxisType.X);
        x_axis.setMin(8.0);
        x_axis.setMax(8.5);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initDiskReadOperationsModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 0.2);
        series.set(8.05, 0.2);
        series.set(8.10, 0.2);
        series.set(8.25, 0.2);
        series.set(8.40, 0.2);
        series.set(8.48, 0.2);

        diskReadOperationsModel.addSeries(series);
        diskReadOperationsModel.setTitle(bundle.getString("label.diskReadOperations"));
        diskReadOperationsModel.setAnimate(true);
        Axis y_axis = diskReadOperationsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskReadOperationsModel.getAxis(AxisType.X);
        x_axis.setMin(8.0);
        x_axis.setMax(8.5);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initDiskWritesModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 0.2);
        series.set(8.05, 0.2);
        series.set(8.10, 0.2);
        series.set(8.25, 0.2);
        series.set(8.40, 0.2);
        series.set(8.48, 0.2);

        diskWritesModel.addSeries(series);
        diskWritesModel.setTitle(bundle.getString("label.diskWrites"));
        diskWritesModel.setAnimate(true);
        Axis y_axis = diskWritesModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskWritesModel.getAxis(AxisType.X);
        x_axis.setMin(8.0);
        x_axis.setMax(8.5);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initDiskWritesOperationsModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 0.2);
        series.set(8.05, 0.2);
        series.set(8.10, 0.2);
        series.set(8.25, 0.2);
        series.set(8.40, 0.2);
        series.set(8.48, 0.2);

        diskWritesOperationsModel.addSeries(series);
        diskWritesOperationsModel.setTitle(bundle.getString("label.diskWriteOperations"));
        diskWritesOperationsModel.setAnimate(true);
        Axis y_axis = diskWritesOperationsModel.getAxis(AxisType.Y);
        y_axis.setMin(0.0);
        y_axis.setMax(1.0);
        y_axis.setTickInterval("0.25");
        y_axis.setTickCount(5);

        Axis x_axis = diskWritesOperationsModel.getAxis(AxisType.X);
        x_axis.setMin(8.00);
        x_axis.setMax(8.50);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initNetworkInModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 8000);
        series.set(8.05, 6500);
        series.set(8.10, 3200);
        series.set(8.25, 9500);
        series.set(8.40, 6600);
        series.set(8.48, 49000);

        networkInModel.addSeries(series);
        networkInModel.setTitle(bundle.getString("label.networkIn"));
        networkInModel.setAnimate(true);
        Axis y_axis = networkInModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(50000);
        y_axis.setTickInterval("10000");
        y_axis.setTickCount(6);

        Axis x_axis = networkInModel.getAxis(AxisType.X);
        x_axis.setMin(8.00);
        x_axis.setMax(8.50);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initNetworkOutModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 8000);
        series.set(8.05, 6500);
        series.set(8.10, 3200);
        series.set(8.25, 9500);
        series.set(8.40, 6600);
        series.set(8.48, 49000);

        networkOutModel.addSeries(series);
        networkOutModel.setTitle(bundle.getString("label.networkOut"));
        networkOutModel.setAnimate(true);
        Axis y_axis = networkOutModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(1500000);
        y_axis.setTickInterval("500000");
        y_axis.setTickCount(4);

        Axis x_axis = networkOutModel.getAxis(AxisType.X);
        x_axis.setMin(8.00);
        x_axis.setMax(8.50);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }

    private void initNetworkPacketsInModel() {
        LineChartSeries series = new LineChartSeries();
        series.set(8.00, 180);
        series.set(8.05, 120);
        series.set(8.10, 200);
        series.set(8.25, 135);
        series.set(8.40, 110);
        series.set(8.48, 550);

        networkPacketsInModel.addSeries(series);
        networkPacketsInModel.setTitle(bundle.getString("label.networkPacketsIn"));
        networkPacketsInModel.setAnimate(true);
        Axis y_axis = networkPacketsInModel.getAxis(AxisType.Y);
        y_axis.setMin(0);
        y_axis.setMax(600);
        y_axis.setTickInterval("200");
        y_axis.setTickCount(4);

        Axis x_axis = networkPacketsInModel.getAxis(AxisType.X);
        x_axis.setMin(8.00);
        x_axis.setMax(8.50);
        x_axis.setTickInterval("0.25");
        x_axis.setTickCount(3);
    }
}
