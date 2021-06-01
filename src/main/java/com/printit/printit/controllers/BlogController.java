package com.printit.printit.controllers;

import com.printit.printit.OrderNotFoundException;
import com.printit.printit.models.OrderD;
import com.printit.printit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Optional;

@EnableSwagger2
@Controller
public class BlogController {
    @Autowired
    private OrderRepository orderRepository;

    public BlogController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<OrderD> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam String imageurl, @RequestParam String color,  @RequestParam String material,  @RequestParam String parameters, @RequestParam String stlFile, @RequestParam String phoneNumber, Model model){
        OrderD order = new OrderD(title, description, imageurl,color, material, parameters, stlFile, phoneNumber);
        orderRepository.save(order);
        return "redirect:/blog";
    }

    @PutMapping("/blog/add")
    public String blogPostAdd1(@RequestParam String title, @RequestParam String description, @RequestParam String imageurl, @RequestParam String color,  @RequestParam String material,  @RequestParam String parameters, @RequestParam String stlFile, @RequestParam String phoneNumber, Model model){
        OrderD order = new OrderD(title, description, imageurl,color, material, parameters, stlFile, phoneNumber);
        orderRepository.save(order);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!orderRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<OrderD> order = orderRepository.findById(id);
        ArrayList<OrderD> result = new ArrayList<>();
        order.ifPresent(result::add);
        model.addAttribute("order", result);
        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        if(!orderRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<OrderD> order = orderRepository.findById(id);
        ArrayList<OrderD> result = new ArrayList<>();
        order.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String imageurl, @RequestParam String color,  @RequestParam String material,  @RequestParam String parameters, @RequestParam String phoneNumber, Model model){
        OrderD order = orderRepository.findById(id).orElseThrow(IllegalStateException::new);
        order.setTitle(title);
        order.setDescription(description);
        order.setImageurl(imageurl);
        order.setColor(color);
        order.setMaterial(material);
        order.setParameters(parameters);
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        OrderD post = orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException(id));
        orderRepository.delete(post);
        return "redirect:/blog";
    }
}
