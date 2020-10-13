package com.example.demo.controllers;

import com.example.demo.model.City;
import com.example.demo.model.Nation;
import com.example.demo.service.CityService;
import com.example.demo.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
@RequestMapping("/city")
public class Controller {
    @Autowired
    private NationService nationService;

    @Autowired
    private CityService cityService;

    @ModelAttribute("nations")
    public Iterable<Nation> nations(){
        return nationService.findAll();
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("city", new City());
        return "create";
    }

    @PostMapping("/create")
    public String saveNewCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, Model model, RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("message", "Add new city unsuccessful");
            return "create";
        }
        cityService.save(city);
        redirect.addFlashAttribute("message", "Add new city success");
        return "redirect:/city/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "edit";
    }
    @PostMapping("/{id}/edit")
    public String editOk(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, Model model, RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("message", "Update city unsuccessful");
            return "edit";
        }
        cityService.save(city);
        redirect.addFlashAttribute("message", "Update city success");
        return "redirect:/city/index";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id, Model model){
        model.addAttribute("city", cityService.findById(id));
        return "delete";
    }
    @GetMapping("/{id}/delete-ok")
    public String deleteOK(@PathVariable("id") long id, RedirectAttributes redirectAttributes){
       cityService.remove(id);
       redirectAttributes.addFlashAttribute("message", "Delete success");
       return "redirect:/city/index";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") long id, Model model){
        model.addAttribute("city", cityService.findById(id));
        return "view";
    }
}
