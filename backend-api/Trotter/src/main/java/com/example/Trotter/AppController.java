package com.example.Trotter;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    
    @GetMapping({ "", "/", "/home", "dashboard", "/services/" })
  public String showDashBoard() {
    return "redirect:/services";
  }
}
