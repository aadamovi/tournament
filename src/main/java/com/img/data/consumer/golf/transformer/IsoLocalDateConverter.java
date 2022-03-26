package com.img.data.consumer.golf.transformer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.UnaryOperator;

public enum IsoLocalDateConverter {

    FORMAT_SLASH_DELIMITED_DATE_TO_ISO(date -> {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        final LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }),
    EPOCH_TO_LOCAL_DATE_IN_ISO(millis -> {
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(millis)), ZoneId.systemDefault());
        return localDateTime.toLocalDate().format(DateTimeFormatter.ISO_DATE);
    });

    private final UnaryOperator<String> converter;

    IsoLocalDateConverter(UnaryOperator<String> converter) {
        this.converter = converter;
    }

    public UnaryOperator<String> getConverter() {
        return converter;
    }
}
