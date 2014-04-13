package net.timothyhahn.Buzzed.database;

/**
 * Created by tim on 4/13/14.
 */
public class Alarm {
    private int _id;
    private String _name;
    private String _alarm;

    public Alarm() {
        this._id = -1;
        this._name = "";
        this._alarm = "";
    }

    public Alarm(int id, String name, String alarm) {
        this._id = id;
        this._name = name;
        this._alarm = alarm;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getAlarm() {
        return _alarm;
    }

    public void setAlarm(String alarm) {
        this._alarm = alarm;
    }
}
