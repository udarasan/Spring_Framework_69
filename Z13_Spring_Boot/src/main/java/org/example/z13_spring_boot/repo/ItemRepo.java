package org.example.z13_spring_boot.repo;

import org.example.z13_spring_boot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
