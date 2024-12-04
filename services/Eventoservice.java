package com.example.BackendDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendDemo.model.Evento;
import com.example.BackendDemo.repository.IEventoRepository;

@Service
public class Eventoservice {

    @Autowired
    private IEventoRepository eventoRepository;

    // Listar todos los eventos
    public List<Evento> selectAllEvents() {
        return eventoRepository.findAll();
    }

    // Encontrar un evento por ID
    public Optional<Evento> selectById(int id) {
        return eventoRepository.findById(id);
    }

    // Crear un nuevo evento
    public Evento createEvent(Evento nuevoEvento) {
        return eventoRepository.save(nuevoEvento);
    }

    // Editar un evento
    public Evento updateEvent(int id, Evento eventoActualizado) {
        return eventoRepository.findById(id).map(evento -> {
            evento.setNombre(eventoActualizado.getNombre());
            evento.setLugar(eventoActualizado.getLugar());
            evento.setDescripcion(eventoActualizado.getDescripcion());
            evento.setFecha(eventoActualizado.getFecha());
            evento.setDisponibilidad(eventoActualizado.getDisponibilidad());
            evento.setHora(eventoActualizado.getHora());
            return eventoRepository.save(evento);
        }).orElseGet(() -> {
            eventoActualizado.setId(id);
            return eventoRepository.save(eventoActualizado);
        });
    }

    // Eliminar un evento
    public void deleteEvent(int id) {
        eventoRepository.deleteById(id);
    }
}
