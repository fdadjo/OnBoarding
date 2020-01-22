package com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration;


public enum UserType {

    USER(0),
    MANAGER(1);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public static UserType forValue(int value) {
        for (UserType mediaType : values()) {
            if (mediaType.getValue() == value) {
                return mediaType;
            }
        }
        return null;
    }
}
