package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "campaign")
public class Campaign
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long campaignid;

    private String title;
    private String photo;
    private String location;

    @Length(max = 2500)
    private String description;

    private String species;
    private String urgency;
    private double donations;
    private double funding_goal;

    private long userid;

//    @ManyToOne
//    @JoinColumn(name = "userid")
//    @JsonIgnoreProperties("campaigns")
//    private User user;

    public Campaign() {
    }

    public Campaign(String title, String photo, String location, String description, String species,
                    String urgency, double donations, double funding_goal, long userid) {
        this.title = title;
        this.photo = photo;
        this.location = location;
        this.description = description;
        this.species = species;
        this.urgency = urgency;
        this.donations = donations;
        this.funding_goal = funding_goal;
        this.userid = userid;
    }

    public long getCampaignid() {
        return campaignid;
    }

    public void setCampaignid(long campaignid) {
        this.campaignid = campaignid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public double getDonations() {
        return donations;
    }

    public void setDonations(double donations) {
        this.donations = donations;
    }

    public double getFunding_goal() {
        return funding_goal;
    }

    public void setFunding_goal(double funding_goal) {
        this.funding_goal = funding_goal;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    //    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
