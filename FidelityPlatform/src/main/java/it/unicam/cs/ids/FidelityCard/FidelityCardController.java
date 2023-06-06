package it.unicam.cs.ids.FidelityCard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import it.unicam.cs.ids.Model.Points;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fidelity-cards")
public class FidelityCardController {

    private final FidelityCardService fidelityCardService;

    @Autowired
    public FidelityCardController(FidelityCardService fidelityCardService) {
        this.fidelityCardService = fidelityCardService;
    }
    @PostMapping("/create/{shopId}/{cardOwnerId}")
    @Operation(summary = "Create a fidelity card")
    public ResponseEntity<FidelityCard> createFidelityCard(@PathVariable String cardOwnerId, @PathVariable String shopId) {
        FidelityCard fidelityCard = fidelityCardService.createFidelityCard(cardOwnerId, shopId);
        return ResponseEntity.ok(fidelityCard);
    }

    @GetMapping("/{cardId}")
    @Operation(summary = "Get a fidelity card by ID")
    public ResponseEntity<FidelityCard> getFidelityCard(@PathVariable String cardId) {
        FidelityCard fidelityCard = fidelityCardService.getFidelityCard(cardId);
        if (fidelityCard != null) {
            return ResponseEntity.ok(fidelityCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get a fidelity card by user ID")
    public ResponseEntity<FidelityCard> getFidelityCardByUserId(@PathVariable String userId) {
        FidelityCard fidelityCard = fidelityCardService.getFidelityCardByUserId(userId);
        if (fidelityCard != null) {
            return ResponseEntity.ok(fidelityCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cardId}/expire-date")
    @Operation(summary = "Update the expiration date of a fidelity card")
    public ResponseEntity<?> updateExpireDate(@PathVariable String cardId, @RequestBody Date newExpireDate) {
        boolean success = fidelityCardService.updateExpireDate(cardId, newExpireDate);
        if (success) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{cardId}/points")
    @Operation(summary = "Get the fidelity points of a fidelity card")
    public ResponseEntity<Integer> getFidelityPoints(@PathVariable String cardId) {
        int points = fidelityCardService.getFidelityPoints(cardId);
        return ResponseEntity.ok(points);
    }

    @PutMapping("/{cardId}/update-points")
    @Operation(summary = "Update the fidelity points of a fidelity card")
    public ResponseEntity<Integer> updatePoints(@PathVariable String cardId, @RequestBody String points) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(points);
        int point = jsonNode.get("points").asInt();

        boolean success = fidelityCardService.updatePoints(cardId, point);

        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/points-history")
    @Operation(summary = "Get the points history of a fidelity card")
    public List<Points> getPointsHistory(@PathVariable String id) {
        return fidelityCardService.getPointsHistory(id);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete a fidelity card")
    public void deleteFidelityCard(@PathVariable String id) {
        this.fidelityCardService.deleteFidelityCard(id);
    }

    @GetMapping("/{shopID}/fidelitycards")
    @Operation(summary = "Get every fidelity card from a shopId")
    public List<FidelityCard> getFidelityCardByShopID(@PathVariable String shopID){
        return this.fidelityCardService.getFidelityCardByShopID(shopID);
    }

}
