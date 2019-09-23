package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Campaign;
import com.lambdaschool.starthere.repository.CampaignRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "campaignService")
public class CampaignServiceImpl implements CampaignService
{
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Campaign> findAll(Pageable pageable) {
        List<Campaign> list = new ArrayList<>();
        campaignRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        if (campaignRepository.findById(id).isPresent())
        {
            campaignRepository.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Campaign findCampaignById(long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public Campaign save(Campaign campaign)
    {

        if (userRepository.findById(campaign.getUserid()) == null)
        {
            throw new ResourceNotFoundException(Long.toString(campaign.getUserid()));
        } else {

            Campaign newCampaign = new Campaign();

            newCampaign.setTitle(campaign.getTitle());
            newCampaign.setDescription(campaign.getDescription());
            newCampaign.setDonations(campaign.getDonations());
            newCampaign.setPhoto(campaign.getPhoto());
            newCampaign.setLocation(campaign.getLocation());
            newCampaign.setSpecies(campaign.getSpecies());
            newCampaign.setUrgency(campaign.getUrgency());
            newCampaign.setFunding_goal(campaign.getFunding_goal());
            newCampaign.setUserid(campaign.getUserid());

            return campaignRepository.save(newCampaign);
        }
    }

    @Override
    public Campaign update(Campaign campaign, long id) {
        Campaign currentCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if (campaign.getTitle() != null)
        {
            currentCampaign.setTitle(campaign.getTitle());
        }
        if (campaign.getPhoto() != null)
        {
            currentCampaign.setPhoto(campaign.getPhoto());
        }
        if (campaign.getLocation() != null)
        {
            currentCampaign.setLocation(campaign.getLocation());
        }
        if (campaign.getDescription() != null)
        {
            currentCampaign.setDescription(campaign.getDescription());
        }
        if (campaign.getSpecies() != null)
        {
            currentCampaign.setSpecies(campaign.getSpecies());
        }
        if (campaign.getUrgency() != null)
        {
            currentCampaign.setUrgency(campaign.getUrgency());
        }
        if (campaign.getDonations() != 0)
        {
            currentCampaign.setDonations(campaign.getDonations());
        }
        if (campaign.getFunding_goal() != 0)
        {
            currentCampaign.setFunding_goal(campaign.getFunding_goal());
        }

        return campaignRepository.save(currentCampaign);
    }
}
