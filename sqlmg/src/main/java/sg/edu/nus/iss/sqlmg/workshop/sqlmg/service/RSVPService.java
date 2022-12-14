package sg.edu.nus.iss.sqlmg.workshop.sqlmg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.sqlmg.workshop.sqlmg.repository.RSVPRepository;
import sg.edu.nus.iss.sqlmg.workshop.sqlmg.models.RSVP;

@Service
public class RSVPService {

    @Autowired
    private RSVPRepository rsvpRepo;

    public List<RSVP> getAllRSVP(String q) {
        return rsvpRepo.getAllRSVP(q);
    }

    public RSVP insertRSVP(final RSVP rsvp) {
        return rsvpRepo.insertRSVP(rsvp);
    }

    public boolean updateRSVP(final RSVP rsvp) {
        return rsvpRepo.updateRSVP(rsvp);
    }

    public Integer getTotalRSVP() {
        return rsvpRepo.getTotalRSVP();
    }
}
