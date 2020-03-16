package com.biblioteket.site;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

  @Value("${spring.application.name}")
  String appname;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("appname", appname);
    return "index";
  }
}
