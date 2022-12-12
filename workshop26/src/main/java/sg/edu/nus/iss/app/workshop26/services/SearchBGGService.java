package sg.edu.nus.iss.app.workshop26.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop26.models.Comment;
import sg.edu.nus.iss.app.workshop26.models.Game;
import sg.edu.nus.iss.app.workshop26.repository.CommentRepository;
import sg.edu.nus.iss.app.workshop26.repository.GameRepository;

@Service
public class SearchBGGService {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private CommentRepository commentRepo;

    public List<Game> searchGame(Integer limit, Integer offset) {
        return (List<Game>) gameRepo.search(limit, offset);
    }

    public List<Game> getGamesByRank() {
        return (List<Game>) gameRepo.getGamesByRank();
    }

    public Game getGameDetailsById(Integer gameId) {
        return gameRepo.getGameDetailsById(gameId);
    }

    public List<Comment> searchComment(String q, Float score, Integer limit, Integer offset) {
        List<String> include = new LinkedList<>();
        List<String> exclude = new LinkedList<>();

        for (String w : q.split(" "))
            if (w.startsWith("-"))
                exclude.add(w);
            else
                include.add(w);

        return commentRepo.search(include, exclude, limit, offset);
    }
}
