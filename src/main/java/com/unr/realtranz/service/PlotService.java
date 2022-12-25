package com.unr.realtranz.service;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Venture;
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

    @Autowired
    VentureService ventureService;
    public int savePlotsDetails(Venture venture,String filePath){
        String line = "";
        String splitBy = ",";
        List<Plot>  plotList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null)
            {
                String[] plots = line.split(splitBy);
                Plot plot = new Plot();
                plot.setPlotId(plots[5]);
                plot.setLeftPos(plots[2]);
                plot.setTop(plots[10]);
                plot.setFacing(plots[0]);
                if(!"NULL".equals(plots[4])){plot.setOwner(plots[4]);}
                plot.setPlotSize(Integer.parseInt(plots[7]));
                if("0".equals(plots[8])){
                    plot.setPltStatus(PlotStatus.AVAILABLE);
                }else if("2".equals(plots[8])){
                    plot.setPltStatus(PlotStatus.BLOCKED);
                }else if("3".equals(plots[8])){
                    plot.setPltStatus(PlotStatus.BOOKED);
                }else if("5".equals(plots[8])){
                    plot.setPltStatus(PlotStatus.SOLD);
                }


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
        return plotRepository.findByVenture(ventureService.getVentureByName(venture));
    }

    public Plot getPlotsByVentureAndPlotId(String venture, String plotId){
        return plotRepository.findByVentureAndPlotId(ventureService.getVentureByName(venture),plotId);
    }

    public Plot getPlotId(long id){
        return plotRepository.findById(id);
    }

    public Plot getPlotsByVentureAndId(Venture venture, Long id){
        return plotRepository.findByVentureAndId(venture,id);
    }

    public void updatePlot(Plot plot){
        plotRepository.save(plot);
    }


}
