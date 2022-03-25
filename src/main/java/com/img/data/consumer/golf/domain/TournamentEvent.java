package com.img.data.consumer.golf.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Objects;

@Document
public class TournamentEvent {
    @Id
    private String id;
    private String name;
    private String course;
    private String countryCode;
    private String startDate;
    private String endDate;
    private String roundCount;
    private String playerCount;
    private String forecast;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(String roundCount) {
        this.roundCount = roundCount;
    }

    public String getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(String playerCount) {
        this.playerCount = playerCount;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentEvent that = (TournamentEvent) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(course, that.course) &&
            Objects.equals(countryCode, that.countryCode) &&
            Objects.equals(startDate, that.startDate) &&
            Objects.equals(endDate, that.endDate) &&
            Objects.equals(roundCount, that.roundCount) &&
            Objects.equals(playerCount, that.playerCount) &&
            Objects.equals(forecast, that.forecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course, countryCode, startDate, endDate, roundCount, playerCount, forecast);
    }
}
