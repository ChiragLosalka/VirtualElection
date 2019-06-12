package com.javaprojects.virtualelection.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidate implements Serializable {
    private String CandidateId;
    private String FirstName;
    private String LastName;
    private Constituency constituencyName;
    private PoliticalParty partyName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @GenericGenerator(
            name = "id_seq",
            strategy = "com.javaprojects.virtualelection.model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Candidate_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    public String getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(String candidateId) {
        CandidateId = candidateId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @JoinColumn(name = "CONSTITUENCY_NAME")
    @ManyToOne(fetch = FetchType.LAZY)
    public Constituency getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(Constituency constituencyName) {
        this.constituencyName = constituencyName;
    }

    @JoinColumn(name = "PARTY_NAME")
    @ManyToOne(fetch = FetchType.LAZY)
    public PoliticalParty getPartyName() {
        return partyName;
    }

    public void setPartyName(PoliticalParty partyName) {
        this.partyName = partyName;
    }
}