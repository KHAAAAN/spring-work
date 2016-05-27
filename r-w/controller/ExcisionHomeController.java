package com.expedia.www.rulestore.common.controller;

import com.expedia.www.rulestore.common.service.RoutesAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcisionHomeController{
  private RoutesAPIService routesAPIService;

  @RequestMapping(value = "/excision_home", method = RequestMethod.GET)
  public ModelAndView excisionHome(@RequestParam(required = false) String error){
      ModelAndView modelAndView = new ModelAndView("excision/excisionHome");
      this.routesAPIService = new RoutesAPIService();

      if (error != null){
        modelAndView.addObject("error", "error");
      }

      modelAndView.addObject("routes", this.routesAPIService.getRoutes());

      return modelAndView;
  }
}
