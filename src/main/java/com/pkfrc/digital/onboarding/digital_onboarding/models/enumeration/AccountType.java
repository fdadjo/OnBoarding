package com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration;

public enum AccountType {

    BANK(0),
    INSURANCE(1);

    private int value;

    AccountType(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public static AccountType forValue(int value) {
        for (AccountType mediaType : values()) {
            if (mediaType.getValue() == value) {
                return mediaType;
            }
        }
        return null;
    }
}