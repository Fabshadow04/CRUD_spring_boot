/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controlador;

import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Fabshadow0404
 */
@Controller
@RequestMapping
public class Controlador {
    @Autowired
    private IpersonaService service;
    
    @GetMapping("/listar")
    public String listar (Model model)
    {
       List<Persona>personas=service.listar();
       model.addAttribute("personas",personas);
        return "index";
    }
    
    
    @GetMapping("/new")
    public String agregar (Model model)
    {
model.addAttribute("persona",new Persona ());
        return "form";
    }
    
    
    @PostMapping("/save")
    public String save( Persona p, Model model)
    {
        service.save(p);
                return "redirect:/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar (@PathVariable int id,Model model)
    {
        Optional <Persona>persona=service.listarId(id);
        model.addAttribute("persona",persona);
    return "form";
    }
    
    @GetMapping ("/eliminar/{id}")
    public String delete (Model model,@PathVariable int id)
    {
service.delete(id);
        return "redirect:/listar";
    }
    
    
    
}
