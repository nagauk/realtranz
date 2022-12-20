package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Enquiry;
import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.models.PlotStatus;
import com.unr.realtranz.repository.EnquiryRepository;
import com.unr.realtranz.service.EnquiryService;
import com.unr.realtranz.service.VentureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:17-12-2022 22:27
 **/

@RestController
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    private VentureService ventureService;

    @RequestMapping(value="/enquiry", method = RequestMethod.POST)
    public RedirectView saveEnquiry( Enquiry enquiry){
        enquiryService.saveEnquiry(enquiry);
        RedirectView redirectView = new RedirectView("/ventures");
        return redirectView;
    }

    @RequestMapping(value="/enquiry/plot", method = RequestMethod.GET)
    public String getEnquiry(@ModelAttribute("enquiryObj") Enquiry enquiry,Model model){
        return "Enquiry Created";
    }

    @Autowired
    EnquiryRepository enquiryRepository;
    @RequestMapping(value="/enquiry", method = RequestMethod.GET)
    public List<Enquiry> getEnquiries(){
        return enquiryRepository.findAll();
    }


    @RequestMapping(value="/enquiry/{venture}", method = RequestMethod.GET)
    public List<Plot> getEnquiryForm(@PathVariable("venture") String venture, Model model){
        List<Plot> plotList = new ArrayList<>();
        if (null != ventureService.getVentureByName(venture).getPlotList()){
            plotList = ventureService.getVentureByName(venture).getPlotList().stream().filter(p -> p.getPltStatus() == PlotStatus.AVAILABLE).collect(Collectors.toList());
        }
        model.addAttribute("availablePlots",plotList);
        model.addAttribute("ventureName",venture);
        return plotList;
    }
}
