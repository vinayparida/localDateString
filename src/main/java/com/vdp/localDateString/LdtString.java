package com.vdp.localDateString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LdtString {

    private String value;
    private final DateTimeFormatter formatter;

    public LdtString(String value, DateTimeFormatter formatter) {
        this.formatter = formatter;
        setDateTime(value);
    }

    public void setDateTime(String dateTimeStr) {
        validateDateTime(dateTimeStr);
        this.value = dateTimeStr;
    }

    private void validateDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            throw new IllegalArgumentException("DateTime string cannot be null or empty");
        }
        try {
            LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid datetime format. Expected format: "
                    + formatter.toString(), e);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LdtString other = (LdtString) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public LocalDateTime toLocalDateTime() {
        return LocalDateTime.parse(value, formatter);
    }

    public String getValue() {
        return value;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

}
