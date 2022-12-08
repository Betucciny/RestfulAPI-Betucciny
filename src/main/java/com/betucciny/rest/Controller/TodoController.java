package com.betucciny.rest.Controller;

import com.betucciny.rest.Model.Genero;
import com.betucciny.rest.Repository.TodoRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holamundo(){
        return "Hola Mundo!!!";
    }

    @GetMapping(value = "/generos")
    public List <Genero> getGeneros(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savegenero")
    public String saveGenero(@RequestBody Genero genero){
        todoRepository.save(genero);
        return "Saved Genero";
    }

    @PutMapping(value = "/update/{id}")
    public String updateGenero(@PathVariable long id, @RequestBody Genero genero){
        Genero updatedGenero = todoRepository.findById(id).get();
        updatedGenero.setNombre(genero.getNombre());
        updatedGenero.setDescripcion(genero.getDescripcion());
        todoRepository.save(updatedGenero);
        return "Updated Genero";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteGenero(@PathVariable long id){
        Genero updatedGenero = todoRepository.findById(id).get();
        todoRepository.delete(updatedGenero);
        return "Deleted Genero";
    }

}
