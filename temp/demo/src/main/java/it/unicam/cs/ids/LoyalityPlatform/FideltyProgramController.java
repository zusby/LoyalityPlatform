package it.unicam.cs.ids.LoyalityPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/promos")
public class FideltyProgramController {
    private final FidelityProgramService service;
    @Autowired
    public FideltyProgramController(FidelityProgramService service) {
        this.service = service;
    }




    /**
     * This Java function returns a list of FidelityProgram objects for a given shop ID.
     *
     * @param shopId The shopId is a path variable that is used to identify a specific shop for which the list of
     * FidelityPrograms needs to be retrieved. It is extracted from the URL path of the HTTP GET request.
     * @return A list of FidelityProgram objects is being returned.
     */
    @GetMapping("{shopId}")
    public List<FidelityProgram> getPromos(@PathVariable String shopId){
        return this.service.getPromos(shopId);
    }


}
