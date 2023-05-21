package it.unicam.cs.ids.FidelityCard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/fidelity-cards")
public class FidelityCardController {

    private final FidelityCardService fidelityCardService;

    public FidelityCardController(FidelityCardService fidelityCardService) {
        this.fidelityCardService = fidelityCardService;
    }

    @PostMapping
    public ResponseEntity<FidelityCard> createFidelityCard(@RequestBody UUID cardOwner) {
        FidelityCard fidelityCard = fidelityCardService.createFidelityCard(cardOwner);
        return ResponseEntity.ok(fidelityCard);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<FidelityCard> getFidelityCard(@PathVariable UUID cardId) {
        FidelityCard fidelityCard = fidelityCardService.getFidelityCard(cardId.toString());
        if (fidelityCard != null) {
            return ResponseEntity.ok(fidelityCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cardId}/expire-date")
    public ResponseEntity<?> updateExpireDate(@PathVariable UUID cardId, @RequestBody Date newExpireDate) {
        boolean success = fidelityCardService.updateExpireDate(cardId.toString(), newExpireDate);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cardId}/points")
    public ResponseEntity<Integer> getFidelityPoints(@PathVariable UUID cardId) {
        int points = fidelityCardService.getFidelityPoints(cardId);
        return ResponseEntity.ok(points);
    }
}
