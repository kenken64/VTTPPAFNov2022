package sg.edu.nus.iss.app.workshop28.repositories;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop28.models.EditedComment;
import sg.edu.nus.iss.app.workshop28.models.Game;
import sg.edu.nus.iss.app.workshop28.models.Review;

@Repository
public class ReviewRepository {

    private static final String REVIEWS_COL = "reviews";

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review insertReview(Review r) {
        return mongoTemplate.insert(r, REVIEWS_COL);
    }

    public Review getReview(String _id) {
        ObjectId docId = new ObjectId(_id);
        return mongoTemplate.findById(docId, Review.class, REVIEWS_COL);
    }

    public Review updateEdits(String _id, EditedComment c) {
        ObjectId docId = new ObjectId(_id);
        Review r = mongoTemplate.findById(docId, Review.class, REVIEWS_COL);
        if (r != null) {
            EditedComment e = new EditedComment();
            e.setComment(c.getComment());
            e.setRating(c.getRating());
            e.setPosted(LocalDateTime.now());
            if (r.getEdited() != null) {
                r.getEdited().add(e);
            } else {
                List<EditedComment> ll = new LinkedList<EditedComment>();
                ll.add(e);
                r.setEdited(ll);
            }

            mongoTemplate.save(r, REVIEWS_COL);
        }
        return r;
    }

    public Optional<Game> aggregateGame(String gid) {
        // $Match operation
        MatchOperation matchName = Aggregation.match(
                Criteria.where("gid").is(Integer.parseInt(gid)));
        // $lookup
        LookupOperation findReviews = Aggregation.lookup("reviews", "gameId", "gid", "reviewsDocs");

        ProjectionOperation selectFields = Aggregation.project("_id", "gid", "name", "year", "ranking", "users_rated",
                "url", "image", "game");

        Aggregation pipeline = Aggregation.newAggregation(
                matchName, findReviews, selectFields);

        // Query the collection
        AggregationResults<Document> results = mongoTemplate.aggregate(pipeline, "game", Document.class);
        System.out.println(results);
        if (!results.iterator().hasNext())
            return Optional.empty();
        System.out.println("xxxx");
        // Get one result only
        Document doc = results.iterator().next();
        Game g = Game.create(doc);
        System.out.println(g);
        return Optional.of(g);
    }
}
