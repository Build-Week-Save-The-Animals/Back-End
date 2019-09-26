package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Campaign;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface CampaignService
{
    List<Campaign> findAll(Pageable pageable);

    void delete(long id);

    Campaign findCampaignById(long id);

    Campaign save(Campaign campaign);

    Campaign update(Campaign campaign, long id);

    Campaign updateDonation(Campaign campaign, double amount);

    ArrayList<Campaign> findCampaignsByUser(long id);

    ArrayList<Campaign> filterBySpecies(String string);

    ArrayList<Campaign> filterByLocation(String string);
}
