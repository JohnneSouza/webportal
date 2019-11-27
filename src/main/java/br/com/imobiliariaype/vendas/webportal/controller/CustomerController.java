package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.service.CustomerService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/create")
    public String create(Customer customer) {
        return "/customers/register";
    }

    @GetMapping("/search")
    public String search(final Model model){
        model.addAttribute("customers", new ReactiveDataDriverContextVariable(customerService.findAll()));
        return "/customers/search";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes attributes){
        customerService.saveCustomer(customer);
        attributes.addFlashAttribute("success", "Cliente Inserido com Sucesso!");

        return "redirect:/customers/create";
    }

    @GetMapping("/edit/{id}")
    public String beforeEdit(@PathVariable("id") String id, Model model){
        model.addAttribute("customer", new ReactiveDataDriverContextVariable(customerService.findById(id).flux()));
        return "customers/register";
    }

    @PostMapping("/edit")
    public String edit(Customer customer, RedirectAttributes attributes){
        customerService.saveCustomer(customer);
        attributes.addFlashAttribute("success", "Cliente alterado com Sucesso!");

        return "redirect:/customers/create";
    }
}