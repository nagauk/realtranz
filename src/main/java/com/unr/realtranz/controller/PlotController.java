package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:08-12-2022 07:41
 **/

@RestController
public class PlotController {

    @Autowired
    PlotService plotService;
    @RequestMapping(value="/plot/{venture}",method = RequestMethod.POST)
    public ResponseEntity createPlots(@PathVariable("venture") String venture){
       plotService.savePlotsDetails(venture);
       return new ResponseEntity<>("Created Plots",HttpStatus.CREATED);
    }

    @RequestMapping(value="/plotstatus/{venture}",method = RequestMethod.GET)
    public ModelAndView getVenturePlots(@PathVariable("venture") String venture){
        ModelMap modelMap = new ModelMap("plots",plotService.getAllPlotsByVenture(venture));
        ModelAndView modelAndView = new ModelAndView("layoutstatus",modelMap);
        return modelAndView;
    }

    @RequestMapping(value="/update1234",method = RequestMethod.PUT)
    public String updatePlot(){
        plotService.updatePlotA1();
        return "UpdateA1";
    }

    @RequestMapping(value="/plots/{venture}",method = RequestMethod.GET)
    public List<Plot> getAllVenturePlots(@PathVariable("venture") String venture){
        return plotService.getAllPlotsByVenture(venture);
    }

    @RequestMapping(value="/plot/{venture}",method = RequestMethod.GET)
    public ModelAndView getPlotById(@PathVariable("venture") String venture, @Param("plotid") String plotid){
        ModelMap modelMap = new ModelMap("plot",plotService.getPlotsByVentureAndPlotId(venture,plotid));
        ModelAndView modelAndView = new ModelAndView("updateplot",modelMap);
        return modelAndView;
    }

    @RequestMapping(value="/{venture}",method = RequestMethod.POST)
    public RedirectView updatePlots(@PathVariable("venture") String venture, @ModelAttribute Plot model){
        Plot plot = plotService.getPlotsByVentureAndId(venture,model.getId());
        plot.setOwner(model.getOwner());
        plot.setPltStatus(model.getPltStatus());
        plotService.updatePlot(plot);
        RedirectView redirectView = new RedirectView("/plotstatus/"+plot.getVenture());
        return redirectView;
    }
/*
    @RequestMapping(value="/plot/{venture}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ModelAndView updatePlot(@RequestBody Plot plot,@PathVariable("venture") String venture){
        plotService.updatePlot(plot);
        ModelMap modelMap = new ModelMap("plots",plotService.getAllPlotsByVenture(venture));
        ModelAndView modelAndView = new ModelAndView("layoutstatus",modelMap);
        return modelAndView;
    }*/
}
