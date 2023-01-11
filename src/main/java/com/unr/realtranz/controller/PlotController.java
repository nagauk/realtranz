package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.service.PlotService;
import com.unr.realtranz.service.VentureService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:08-12-2022 07:41
 **/

@RestController
public class PlotController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    PlotService plotService;

    @Autowired
    VentureService ventureService;
    @RequestMapping(value="/plot/{venture}",method = RequestMethod.POST)
    public ResponseEntity createPlots(@PathVariable("venture") String venture,@Param("file-path") String filePath){
       plotService.savePlotsDetails(ventureService.getVentureByName(venture),filePath);
       return new ResponseEntity<>("Created Plots",HttpStatus.CREATED);
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


    @RequestMapping(value="/plot",method = RequestMethod.GET)
    public Plot getPlotById( @Param("plotid") Long plotid){
        return plotService.getPlotId(plotid);
    }
    @RequestMapping(value="/plot",method = RequestMethod.POST)
    public RedirectView updatePlots(@ModelAttribute Plot model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Plot plot = plotService.getPlotId(model.getId());
        Users users = plot.getVenture().getOwner();
        if(!users.getUsername().equalsIgnoreCase(username)){
            throw new InvalidDataAccessResourceUsageException("Logged in user don't have access to update this plot:::"+model.getId());
        }
        plot.setOwner(model.getOwner());
        plot.setPltStatus(model.getPltStatus());
        plotService.updatePlot(plot);
        RedirectView redirectView = new RedirectView("/plotstatus/"+plot.getVenture().getVentureName());
        return redirectView;
    }

}
