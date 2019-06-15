package com.javaprojects.virtualelection.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Voter implements Serializable {

    private String voterId;
    private String aadhaarId;
    private String firstName;
    private String lastName;
    private Constituency constituencyName;
    private boolean hasVoted;

    public Voter() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @GenericGenerator(
            name = "id_seq",
            strategy = "com.javaprojects.virtualelection.model.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Voter_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(nullable = false, unique=true, columnDefinition="VARCHAR(64)")
    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    @Column(unique = true)
    public String getAadhaarId() {
        return aadhaarId;
    }

    public void setAadhaarId(String aadhaarId) {
        this.aadhaarId = aadhaarId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setConstituencyName(Constituency constituencyName) {
        this.constituencyName = constituencyName;
    }

    @JoinColumn(name = "CONSTITUENCY_NAME")
    @ManyToOne(fetch = FetchType.LAZY)
    public Constituency getConstituencyName() {
        return constituencyName;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}