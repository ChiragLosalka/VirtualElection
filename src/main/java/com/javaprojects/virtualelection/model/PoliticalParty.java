package com.javaprojects.virtualelection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PoliticalParty implements Serializable {

    private String partyName;
    private String partySymbol;

    @Id
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public void setPartySymbol(String partySymbol) {
        this.partySymbol = partySymbol;
    }
}