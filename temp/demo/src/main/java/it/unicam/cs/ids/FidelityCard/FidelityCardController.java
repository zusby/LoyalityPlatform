package it.unicam.cs.ids.FidelityCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fidelity-cards")
public class FidelityCardController {

    private final FidelityCardService fidelityCardService;

    @Autowired
    public FidelityCardController(FidelityCardService fidelityCardService) {
        this.fidelityCardService = fidelityCardService;
    }

    @PostMapping
    public ResponseEntity<FidelityCard> createFidelityCard(@RequestBody String cardOwnerId) {
        FidelityCard fidelityCard = fidelityCardService.createFidelityCard(cardOwnerId);
        return ResponseEntity.ok(fidelityCard);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<FidelityCard> getFidelityCard(@PathVariable String cardId) {
        FidelityCard fidelityCard = fidelityCardService.getFidelityCard(cardId);
        if (fidelityCard != null) {
            return ResponseEntity.ok(fidelityCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FidelityCard> getFidelityCardByUserId(@PathVariable String userId) {
        FidelityCard fidelityCard = fidelityCardService.getFidelityCard(userId);
        if (fidelityCard != null) {
            return ResponseEntity.ok(fidelityCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cardId}/expire-date")
    public ResponseEntity<?> updateExpireDate(@PathVariable String cardId, @RequestBody Date newExpireDate) {
        boolean success = fidelityCardService.updateExpireDate(cardId.toString(), newExpireDate);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cardId}/points")
    public ResponseEntity<Integer> getFidelityPoints(@PathVariable String cardId) {
        int points = fidelityCardService.getFidelityPoints(cardId);
        return ResponseEntity.ok(points);
    }
}
