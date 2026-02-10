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

    public static class Builder {
        private Integer id;
        private String model;
        private boolean isAvailable;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Car build() {
            return new Car(id, model, isAvailable);
        }
    }
}
