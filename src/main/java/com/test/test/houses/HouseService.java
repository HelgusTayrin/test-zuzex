package com.test.test.houses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    private Long generateId(){
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public House create(String address, Long ownerId) {
        House newHouse = new House();
            newHouse.setId(generateId());
            newHouse.setAddress(address);
            newHouse.setOwner(ownerId);
        houseRepository.save(newHouse);
        return newHouse;
    }
    public Optional<House> getById(Long id) {
        return houseRepository.findById(id);
    }

    public List<House> getList() {
       return houseRepository.findAll();
    }

    public void delete(Long id) {
        houseRepository.deleteById(id);
    }

    public House update(Long id, String newAddress, long newOwner) {
        House updHouse = new House();
            updHouse.setId(id);
            updHouse.setAddress(newAddress);
            updHouse.setOwner(newOwner);
            houseRepository.save(updHouse);
        return updHouse;
    }
}
