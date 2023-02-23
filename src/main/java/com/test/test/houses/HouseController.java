package com.test.test.houses;

import com.test.test.lodgers.Lodger;
import com.test.test.lodgers.LodgersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private LodgersService lodgersService;

    @PostMapping(path="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody House addNewHouse(@RequestParam String address, @RequestParam Long ownerId) {
        return houseService.create(address, ownerId);
    }

    @GetMapping(path="/getList", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<House> getHousesList() {
        return houseService.getList();
    }

    @GetMapping(path="/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<House> getHouseById(@RequestParam Long id) {
        return houseService.getById(id);
    }

    @DeleteMapping(path="/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteHouse(@RequestParam Long id) {
        houseService.delete(id);
        return "House with id: " + id + "was be deleted";
    }

    @PostMapping(path="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody House updateHouse(@RequestParam Long id, @RequestParam String newAddress, @RequestParam Long newOwner) {
        return houseService.update(id, newAddress, newOwner);
    }

    @PostMapping(path="/addLodger", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Lodger addLodger(@RequestParam Long houseId, @RequestParam Long userId) {
        return lodgersService.addLodger(houseId, userId);
    }

    @GetMapping(path="/getListLodgers", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Lodger> getList(@RequestParam Long houseId) {
        return lodgersService.findAllByHouse(houseId);
    }

    @GetMapping(path = "/getLodger", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Lodger> getLodger(@RequestParam Long id) {
        return lodgersService.getById(id);
    }

    @DeleteMapping(path="/deleteLodger", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String banishedLodger(@RequestParam Long lodgerId) {
        lodgersService.deleteLodger(lodgerId);
        return "lodger with id: " + lodgerId + "was be banished from house";
    }
}
