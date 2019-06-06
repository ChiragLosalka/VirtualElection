package com.javaprojects.virtualelection.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="votertable111")
public class Voter implements Serializable {

    private String voterId;
    private String firstName;
    private String lastName;
    private Constituency constituencyId;
    private boolean hasVoted;

    public Voter() {}
    public Voter(String voterId, String firstName, String lastName, Constituency constituencyId) {
        this.voterId = voterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.constituencyId = constituencyId;
        this.hasVoted = false;
    }

    @Id
    @Column(name="VOTER_ID", nullable = false, unique=true, columnDefinition="VARCHAR(64)")
    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setConstituencyId(Constituency constituencyId) {
        this.constituencyId = constituencyId;
    }

    @JoinColumn(name = "CONSTITUENCY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Constituency getConstituencyId() {
        return constituencyId;
    }

    @Column(name = "HAS_VOTED")
    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
