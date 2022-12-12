package sg.edu.nus.iss.app.workshop27.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.app.workshop27.models.EditedComment;
import sg.edu.nus.iss.app.workshop27.models.Review;
import sg.edu.nus.iss.app.workshop27.service.ReviewService;

@RestController
@RequestMapping(path = "/api/review")
public class ReviewRestController {
    @Autowired
    private ReviewService reviewSvc;

    @PutMapping(path = "{_id}")
    public ResponseEntity<String> updateEdits(@PathVariable String _id, @RequestBody EditedComment json) {
        JsonObject result = null;
        Review r = reviewSvc.updateEdits(_id, json);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("review", r.toJSON());
        result = builder.build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }

}
