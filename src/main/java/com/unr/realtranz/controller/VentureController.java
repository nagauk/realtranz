package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.models.PlotStatus;
import com.unr.realtranz.repository.VentureRepository;
import com.unr.realtranz.service.OrganizationService;
import com.unr.realtranz.service.UserService;
import com.unr.realtranz.service.VentureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:20
 **/

@RestController
public class VentureController {

    @Autowired
    VentureService ventureService;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/venture",method = RequestMethod.POST)
    public ResponseEntity saveVenture(@RequestBody Venture venture){
        ventureService.saveVenture(venture);
        return new ResponseEntity<>("Created Venture",HttpStatus.CREATED);
    }

    @RequestMapping(value="/venture/{venture}",method = RequestMethod.GET)
    public Venture getVenture(@PathVariable("venture") String ventureName){
        return ventureService.getVentureByName(ventureName);
    }

    @RequestMapping(value="/plotstatus/{venture}",method = RequestMethod.GET)
    public ModelAndView getVentureStatus(@PathVariable("venture") String ventureName){
        ModelMap modelMap = new ModelMap("venture",ventureService.getVentureByName(ventureName));
        ModelAndView modelAndView = new ModelAndView("layoutstatus",modelMap);
        return modelAndView;
    }


    @GetMapping({"/ventures","/"})
    public ModelAndView getAllVentures(){
        ModelMap modelMap = new ModelMap("ventures",ventureService.getAllVentures());
        ModelAndView modelAndView = new ModelAndView("searchresults",modelMap);
        return modelAndView;
    }

    @Autowired
    private VentureRepository ventureRepository;
    @GetMapping({"/availableplots/{venture}"})
    public ModelAndView getAvailablePlotsByVenture(@PathVariable("venture") String venture, @RequestParam(defaultValue = "0") int page){
        List<Plot> plotList = new ArrayList<>();
        if (null != ventureRepository.findAll(PageRequest.of(page,10))){
            plotList = ventureService.getVentureByName(venture).getPlotList().stream().filter(p -> (p.getVenture().getVentureName().equals(venture) && p.getPltStatus() == PlotStatus.AVAILABLE)).collect(Collectors.toList());
        }
        ModelMap modelMap = new ModelMap("availablePlots",plotList);
        modelMap.addAttribute("ventureName",venture);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("venture", ventureService.getVentureByName(venture));
        ModelAndView modelAndView = new ModelAndView("availableplots",modelMap);
        return modelAndView;
    }

}
