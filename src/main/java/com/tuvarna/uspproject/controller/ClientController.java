package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.model.Client;
import com.tuvarna.uspproject.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/clients")
public final class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    protected ModelAndView findClients(ModelAndView modelAndView) {
        Collection<Client> clients = clientService.findAll();
        modelAndView.addObject("clients", clients).setViewName("view-clients");
        return modelAndView;
    }

    @GetMapping("/add")
    protected ModelAndView addClient(ModelAndView modelAndView) {
        modelAndView.addObject("client", new Client()).setViewName("add-employee");
        return modelAndView;
    }

    @PostMapping("/add")
    protected ModelAndView processAddClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("add-employee");
            return modelAndView;
        }
        clientService.save(client);
        modelAndView.setViewName("redirect:/clients");
        return modelAndView;
    }
}
