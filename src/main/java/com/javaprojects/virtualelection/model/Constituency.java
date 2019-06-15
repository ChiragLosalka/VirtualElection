package com.javaprojects.virtualelection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class Constituency implements Serializable {
    private String constituencyName;
    private String winningPary;
    private String state;
    private boolean countingCompleted = false;

    public Constituency() {}

    @Id
    @Column(nullable = false, unique=true, columnDefinition="VARCHAR(64)")
    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public String getWinningPary() {
        return winningPary;
    }

    public void setWinningPary(String winningPary) {
        this.winningPary = winningPary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Column(nullable = false)
    public boolean isCountingCompleted() {
        return countingCompleted;
    }

    public void setCountingCompleted(boolean countingCompleted) {
        this.countingCompleted = countingCompleted;
    }
}
