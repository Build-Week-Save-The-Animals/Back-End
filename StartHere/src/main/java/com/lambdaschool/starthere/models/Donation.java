package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "donations")
public class Donation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long donationid;

    private double amount;
    private long userid;
    private long campaignid;

    public Donation()
    {
    }

    public Donation(double amount, long userid, long campaignid)
    {
        this.amount = amount;
        this.userid = userid;
        this.campaignid = campaignid;
    }

    public long getDonationid()
    {
        return donationid;
    }

    public void setDonationid(long donationid)
    {
        this.donationid = donationid;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public long getCampaignid()
    {
        return campaignid;
    }

    public void setCampaignid(long campaignid)
    {
        this.campaignid = campaignid;
    }
}
