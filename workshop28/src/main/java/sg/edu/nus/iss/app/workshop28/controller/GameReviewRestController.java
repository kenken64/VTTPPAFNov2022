package sg.edu.nus.iss.app.workshop28.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.app.workshop28.models.Game;
import sg.edu.nus.iss.app.workshop28.services.ReviewService;

@RestController
@RequestMapping(path = "/game")
public class GameReviewRestController {
    @Autowired
    private ReviewService reviewSvc;

    @GetMapping("{gameId}/reviews")
    public ResponseEntity<String> getReviewHistory(@PathVariable String gameId) {
        JsonObject result = null;
        Optional<Game> r = reviewSvc.aggregateGame(gameId);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("review", r.get().toJSON());
        result = builder.build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }
}
