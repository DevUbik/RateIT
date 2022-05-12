package com.pregatit.rateit.db.entities;

public class PregatItSettings {
    private boolean Location =false;
    private boolean Sound =false;
    private boolean Notifications =false;

    public boolean isLocation() {
        return Location;
    }

    public void setLocation(boolean location) {
        Location = location;
    }

    public boolean isSound() {
        return Sound;
    }

    public void setSound(boolean sound) {
        Sound = sound;
    }

    public boolean isNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }
}
