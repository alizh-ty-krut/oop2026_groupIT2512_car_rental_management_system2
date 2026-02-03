/**
 * ▄█▀█▄
 * ▄█▀▀▀▀    ▀█▄▄▄▄▄▄▄
 * █▀                ▀█
 * ▀▄ ▄              ▄█
 * █████▄▄▄▄▄██▄▄▄█▀▀█
 * █▀█    ▀     ▀    █▀▀▀▀▀█
 * █ ███▄▄▄▄   ▄▄▄▄▄██▀▀██ █
 * █ ███ ████▀████ ███  █  █
 * █▄███ ████ ████ ███  █ █▀
 * ███ ████ ████ ███  █ █
 * ███ ████ ████ ███▄▄█ █
 * ███ ████ ████ ███   ▄█
 * ███ ████ ████ ███▀▀▀▀
 * ▄███▄████ ████▄███▄
 * ███▀███████████▀███
 * ▀▀▀██▄▄▄▄▄██▀▀▀
 */

package models;

public class Car {
    private Integer id;
    private String model;
    private boolean isAvailable;

    public Car(Integer id, String model, boolean isAvailable) {
        setId(id);
        setModel(model);
        setIsAvailable(isAvailable);
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return this.model;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
}
