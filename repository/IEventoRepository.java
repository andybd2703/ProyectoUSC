package com.example.BackendDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendDemo.model.Evento;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
}
