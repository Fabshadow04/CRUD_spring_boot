/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.interfaceService;
import java.util.List;
import com.example.demo.modelo.Persona;
import java.util.Optional;

/**
 *
 * @author Fabshadow0404
 */
public interface IpersonaService {
    public List <Persona>listar();
    public Optional <Persona>listarId(int id);
    public int save(Persona p);
    public void delete (int id);
}
