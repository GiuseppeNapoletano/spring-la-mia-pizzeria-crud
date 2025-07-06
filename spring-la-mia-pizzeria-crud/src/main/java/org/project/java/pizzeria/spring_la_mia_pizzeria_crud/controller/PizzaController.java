package org.project.java.pizzeria.spring_la_mia_pizzeria_crud.controller;


import org.project.java.pizzeria.spring_la_mia_pizzeria_crud.model.Pizza;
import org.project.java.pizzeria.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("pizzas", pizzaRepository.findAll());
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        Pizza pizza = pizzaRepository.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("pizza", new Pizza());
        return "pizzas/create";
    }

    @PostMapping
    public String store( @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "pizzas/create";
        }

        pizzaRepository.save(formPizza);
        return "redirect:/pizzas";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        return "pizzas/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "pizzas/edit";
        }

        pizzaRepository.save(formPizza);
        return "redirect:/pizzas";
    }

}
