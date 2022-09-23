package com.ejercicio.DemoOBSB.repository;

import com.ejercicio.DemoOBSB.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
