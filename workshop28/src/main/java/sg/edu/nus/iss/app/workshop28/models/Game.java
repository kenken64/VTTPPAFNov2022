package sg.edu.nus.iss.app.workshop28.models;

import java.util.LinkedList;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private String _id;
    private String name;
    private String image;

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
        Document id = d.get("_id", Document.class);
        Game g = new Game();
        g.setName(id.getString("name"));
        g.setImage(id.getString("image"));
        return g;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("_id", this.get_id())
                .add("name", getName())
                .add("image", getImage())
                .build();
    }
}