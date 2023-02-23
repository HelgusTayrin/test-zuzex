package com.test.test.lodgers;

import com.test.test.houses.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LodgersService {
    @Autowired
    private LodgersRepository lodgersRepository;

    private Long generateId(){
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Lodger addLodger(Long houseId, Long userId) {
        Lodger newLodger = new Lodger();
            newLodger.setLodgerId(generateId());
            newLodger.setUserId(userId);
            newLodger.setHouseId(houseId);
            lodgersRepository.save(newLodger);
            return newLodger;
    }

    public List<Lodger> findAllByHouse(Long houseId) {
        return lodgersRepository.findByHouseId(houseId);
    }

    public Optional<Lodger> getById(Long id) {
        return lodgersRepository.findById(id);
    }

    public void deleteLodger(Long lodgerId) {
        lodgersRepository.deleteById(lodgerId);
    }
}
