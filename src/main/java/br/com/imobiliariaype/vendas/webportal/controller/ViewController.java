package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class ViewController {

    private CustomerRepository customerRepository;

    @Autowired
    public ViewController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/")
    public String index(final Model model){
        IReactiveDataDriverContextVariable context =
                new ReactiveDataDriverContextVariable(customerRepository.findAll());

        model.addAttribute("customer", context);

        return "index";
    }

}
