package sg.edu.nus.iss.app.workshop28.models;

import java.util.LinkedList;

import org.bson.Document;
import org.bson.types.ObjectId;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private String _id;
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer users_rated;
    private String url;
    private String image;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getUsers_rated() {
        return users_rated;
    }

    public void setUsers_rated(Integer users_rated) {
        this.users_rated = users_rated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Game create(Document d) {
        ObjectId id = d.get("_id", ObjectId.class);
        Game g = new Game();
        g.set_id(id.toString());
        g.setGid(d.getInteger("gid"));
        g.setName(d.getString("name"));
        g.setYear(d.getInteger("year"));
        g.setRanking(d.getInteger("ranking"));
        g.setUsers_rated(d.getInteger("users_rated"));
        g.setUrl(d.getString("url"));
        g.setImage(d.getString("image"));
        return g;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("_id", this.get_id())
                .add("gid", getGid())
                .add("name", getName())
                .add("year", getYear() != null ? "" + getYear() : "")
                .add("ranking", getRanking() != null ? "" + getRanking() : "")
                .add("users_rated", getUsers_rated() != null ? "" + getUsers_rated() : "")
                .add("url", getUrl() != null ? "" + getUrl() : "")
                .add("image", getImage() != null ? "" + getImage() : "")
                .build();
    }
}