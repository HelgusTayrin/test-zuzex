package com.test.test.lodgers;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LodgersRepository extends CrudRepository<Lodger, Long> {
    List<Lodger> findByHouseId(Long houseId);
}
