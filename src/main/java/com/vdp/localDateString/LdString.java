package com.vdp.localDateString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LdString {

    private String value;
    private final DateTimeFormatter formatter;
    
    public LdString(String value, DateTimeFormatter formatter) {
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
            LocalDate.parse(dateTimeStr, formatter);
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
        LdString other = (LdString) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public LocalDate toLocalDate() {
        return LocalDate.parse(value, formatter);
    }

    public String getValue() {
        return value;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

}
