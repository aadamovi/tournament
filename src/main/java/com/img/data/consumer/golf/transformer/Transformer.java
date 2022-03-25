package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public interface Transformer {
    TournamentEvent transform(Map<String, Object> event);

    default String formatDateToIso(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    default String fromEpoch(String millis) {
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(millis)), ZoneId.systemDefault());
        return localDateTime.toLocalDate().format(DateTimeFormatter.ISO_DATE);
    }
}
