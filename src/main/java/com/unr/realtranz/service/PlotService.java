package com.unr.realtranz.service;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.models.PlotStatus;
import com.unr.realtranz.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:08-12-2022 07:41
 **/
@Service
public class PlotService {

    @Autowired
    PlotRepository plotRepository;

    public int savePlotsDetails(String venture){

        String line = "";
        String splitBy = ",";
        List<Plot>  plotList = new ArrayList<>();
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("wrweW:\\aptshome\\docs\\udyana.csv"));

            while ((line = br.readLine()) != null)
            {
                String[] plots = line.split(splitBy);
                Plot plot = new Plot();
                plot.setPlotId(plots[0]);
                plot.setLeftPos(plots[2]);
                plot.setTop(plots[1]);
                plot.setFacing(plots[3]);
                plot.setPlotSize(Integer.parseInt(plots[4]));
                plot.setPltStatus(PlotStatus.AVAILABLE);
                plot.setIncludeGovtCharges(Boolean.TRUE);
                plot.setVenture(venture);
                plotList.add(plot);
            }
            plotRepository.saveAll(plotList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plotList.size();
    }

    public List<Plot> getAllPlotsByVenture(String venture){
        return plotRepository.findByVenture(venture);
    }

    public Plot getPlotsByVentureAndPlotId(String venture, String plotId){
        return plotRepository.findByVentureAndPlotId(venture,plotId);
    }

    public Plot getPlotsByVentureAndId(String venture, Long id){
        return plotRepository.findByVentureAndId(venture,id);
    }

    public void updatePlot(Plot plot){
        plotRepository.save(plot);
    }

    public void updatePlotA1(){
       Plot plot = plotRepository.findByVentureAndId("udyana",(long)1);
       plot.setPlotId("A1");
       plotRepository.save(plot);
    }


}
