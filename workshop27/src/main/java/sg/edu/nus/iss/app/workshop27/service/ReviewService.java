package sg.edu.nus.iss.app.workshop27.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop27.models.EditedComment;
import sg.edu.nus.iss.app.workshop27.models.Review;
import sg.edu.nus.iss.app.workshop27.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;

    public Review insertReview(Review r) {
        return reviewRepo.insertReview(r);
    }

    public Review updateEdits(String _id, EditedComment c) {
        return reviewRepo.updateEdits(_id, c);
    }
}
