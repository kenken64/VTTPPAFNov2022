package sg.edu.nus.iss.sqlmg.workshop.sqlmg.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RSVPTotalCntMapper implements RowMapper<RSVP> {
    @Override
    public RSVP mapRow(ResultSet rs, int rowNum) throws SQLException {
        RSVP r = new RSVP();
        r.setTotalCnt(rs.getInt("total"));
        return r;
    }
}
