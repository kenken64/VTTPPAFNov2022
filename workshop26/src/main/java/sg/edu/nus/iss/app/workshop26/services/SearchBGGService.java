package sg.edu.nus.iss.app.workshop26.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop26.models.Game;
import sg.edu.nus.iss.app.workshop26.repository.GameRepository;

@Service
public class SearchBGGService {

    @Autowired
    private GameRepository gameRepo;

    public List<Game> searchGame(Integer limit, Integer offset) {
        return (List<Game>) gameRepo.search(limit, offset);
    }

    public List<Game> getGamesByRank() {
        return (List<Game>) gameRepo.getGamesByRank();
    }

    public Game getGameDetailsById(Integer gameId) {
        return gameRepo.getGameDetailsById(gameId);
    }
}
