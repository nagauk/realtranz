package com.unr.realtranz.controller;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Role;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.models.PlotStatus;
import com.unr.realtranz.repository.PlotRepository;
import com.unr.realtranz.repository.VentureRepository;
import com.unr.realtranz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:20
 **/

@Controller
public class VentureController {

    @Autowired
    private VentureService ventureService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RoleService roleService;

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
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            Long count = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().filter(r -> r.getAuthority().equalsIgnoreCase("ROLE_ADMIN")).count();
            if(count > 0){
                String userName  = SecurityContextHolder.getContext().getAuthentication().getName();
                Users user = userService.getUsersByUserName(userName);
                List<Venture> ventures = ventureService.getAllVenturesByUser(user);
                ModelMap modelMap = new ModelMap();
                modelMap.addAttribute("userVentures",ventures);
                ModelAndView modelAndView = new ModelAndView("dashboard",modelMap);
                return modelAndView;
            }
        }
        ModelMap modelMap = new ModelMap("ventures",ventureService.getAllVentures());
        ModelAndView modelAndView = new ModelAndView("searchresults",modelMap);
        return modelAndView;
    }

    @Autowired
    private VentureRepository ventureRepository;

    @Autowired
    private PlotRepository plotRepository;
    @GetMapping({"/availableplots/{venture}"})
    @Transactional
    public ModelAndView getAvailablePlotsByVenture(@PathVariable("venture") String venture,@RequestParam(required = false) String keyword,
                                                   @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){


        List<Plot> plotList = new ArrayList<>();

        Pageable paging = PageRequest.of(page - 1, size);

        Page<Plot> pageTuts;
        if (keyword == null) {
            pageTuts = plotRepository.findByVenture(ventureRepository.findByVentureName(venture),paging);
        } else {
            pageTuts = plotRepository.findByPltStatusAndPlotIdContainingIgnoreCaseOrPlotSizeContainingIgnoreCaseOrFacingContainingIgnoreCase(PlotStatus.AVAILABLE,keyword,keyword,keyword,paging);

        }

        plotList = pageTuts.getContent();
        ModelMap modelMap = new ModelMap("availablePlots",plotList);

        modelMap.addAttribute("keyword", keyword);
        modelMap.addAttribute("availablePlots",plotList);
        modelMap.addAttribute("currentPage", pageTuts.getNumber() + 1);
        modelMap.addAttribute("totalItems", pageTuts.getTotalElements());
        modelMap.addAttribute("totalPages", pageTuts.getTotalPages());
        modelMap.addAttribute("pageSize", size);
        modelMap.addAttribute("ventureName",venture);
        modelMap.addAttribute("ventureName",venture);
        modelMap.addAttribute("venture", ventureService.getVentureByName(venture));
        ModelAndView modelAndView = new ModelAndView("availableplots",modelMap);

        return modelAndView;
    }

}
