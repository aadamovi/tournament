package com.img.data.consumer.golf.transformer;

import org.junit.jupiter.api.Test;

import static com.img.data.consumer.golf.domain.IsoLocalDateConverter.EPOCH_TO_LOCAL_DATE_IN_ISO;
import static com.img.data.consumer.golf.domain.IsoLocalDateConverter.FORMAT_SLASH_DELIMITED_DATE_TO_ISO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IsoLocalDateConverterTest {
    @Test
    void shouldFormatSlashDelimitedDateToIso() {
        assertThat(FORMAT_SLASH_DELIMITED_DATE_TO_ISO.getConverter().apply("09/08/22"), is("2022-08-09"));
    }

    @Test
    void shouldConvertEpochToLocalDate() {
        assertThat(EPOCH_TO_LOCAL_DATE_IN_ISO.getConverter().apply("1638349200"), is("2021-12-01"));
    }
}