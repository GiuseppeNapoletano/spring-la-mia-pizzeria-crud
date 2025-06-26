package org.project.java.pizzeria.spring_la_mia_pizzeria_crud.controller;


import org.project.java.pizzeria.spring_la_mia_pizzeria_crud.model.Pizza;
import org.project.java.pizzeria.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
