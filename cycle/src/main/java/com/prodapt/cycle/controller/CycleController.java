package com.prodapt.cycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.prodapt.cycle.Cycle;
import com.prodapt.cycle.CycleService;

import java.util.List;

@Controller
@RequestMapping("/cycles")
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @GetMapping
    public String getAllCycles(Model model) {
        List<Cycle> cycles = cycleService.getAllCycles();
        model.addAttribute("cycles", cycles);
        return "cycles"; 
    }

    @PostMapping("/borrow/{id}")
    public String borrowCycle(@PathVariable Integer id, Model model) {
        Cycle cycle = cycleService.borrowCycleById(id);
        return "redirect:/cycles"; }

    @PostMapping("/return/{id}")
    public String returnCycle(@PathVariable Integer id, Model model) {
        Cycle cycle = cycleService.returnCycleById(id);
        return "redirect:/cycles"; 
    }
    
    
    @GetMapping("/stock")
    public String stockManagement(Model model) {
        List<Cycle> cycles = cycleService.getAllModelsAndStock();
        model.addAttribute("cycles", cycles);
        return "stock";
    }

    @PostMapping("/incrementStock/{id}")
    public String incrementStock(@PathVariable Integer id, @RequestParam int incrementAmount, Model model) {
        Cycle cycle = cycleService.incrementStockById(id, incrementAmount);
        return "redirect:/cycles/stock";
    }

    @GetMapping("/add")
    public String showAddCycleForm() {
        return "addCycle";
    }

    @PostMapping("/add")
    public String addCycle(@ModelAttribute Cycle cycle) {
        // Save the cycle to the database
        cycleService.saveCycle(cycle);
        return "redirect:/cycles"; // Redirect to the list of cycles
    }
}





//package com.prodapt.cycle.controller;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.prodapt.cycle.Cycle;
//import com.prodapt.cycle.CycleService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Controller
//@RequestMapping("/cycles")
//public class CycleController {
//    @Autowired
//    private CycleService cycleService;
//
//    @GetMapping
//    public String getAllCycles(Model model) {
//        List<Cycle> cycles = cycleService.getAllCycles();
//        model.addAttribute("cycles", cycles);
//        return "cycles";
//    }
//
//    @PostMapping("/borrow/{id}")
//    public String borrowCycle(@PathVariable long id, Model model) {
//        Cycle cycle = cycleService.borrowCycleById(id);
//        return "redirect:/cycles"; // Redirect back to the list
//    }
//
//    @PostMapping("/return/{id}")
//    public String returnCycle(@PathVariable long id, Model model) {
//        Cycle cycle = cycleService.returnCycleById(id);
//        return "redirect:/cycles"; // Redirect back to the list
//    }
//}
//





