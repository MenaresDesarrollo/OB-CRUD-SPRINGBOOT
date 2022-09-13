package com.ejercicio.DemoOBSB.Repository;

import com.ejercicio.DemoOBSB.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
