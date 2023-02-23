package com.test.test.houses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House, Long> {
    List<House> findAll();
}
