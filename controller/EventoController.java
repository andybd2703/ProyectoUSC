package com.example.BackendDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendDemo.model.Evento;
import com.example.BackendDemo.services.Eventoservice;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private Eventoservice eventoService;

    // Obtener todos los eventos
    @GetMapping
    public List<Evento> getAllEvents() {
        return eventoService.selectAllEvents();
    }

    // Obtener un evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventById(@PathVariable int id) {
        return eventoService.selectById(id)
                .map(evento -> ResponseEntity.ok().body(evento))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo evento
    @PostMapping
    public Evento createEvent(@RequestBody Evento nuevoEvento) {
        return eventoService.createEvent(nuevoEvento);
    }

    // Actualizar un evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvent(@PathVariable int id, @RequestBody Evento eventoActualizado) {
        return eventoService.selectById(id)
                .map(evento -> ResponseEntity.ok().body(eventoService.updateEvent(id, eventoActualizado)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
        if (eventoService.selectById(id).isPresent()) {
            eventoService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
