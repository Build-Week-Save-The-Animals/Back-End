package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Campaign;
import com.lambdaschool.starthere.models.Donation;
import com.lambdaschool.starthere.repository.CampaignRepository;
import com.lambdaschool.starthere.repository.DonationRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "donationService")
public class DonationServiceImpl implements DonationService
{
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CampaignService campaignService;

    @Override
    public Donation save(Donation donation) {

        if (userRepository.findById(donation.getUserid()) == null || campaignRepository.findById(donation.getCampaignid()) == null)
        {
            throw new ResourceNotFoundException(Long.toString(donation.getUserid()) + "HELLO");
        }
        else
        {
            Donation newDonation = new Donation();
            Campaign currentCampaign = new Campaign();

            newDonation.setAmount(donation.getAmount());
            newDonation.setCampaignid(donation.getCampaignid());
            newDonation.setUserid(donation.getUserid());

            currentCampaign = campaignRepository.findById(donation.getCampaignid()).get();
//            currentCampaign.setDonations(currentCampaign.getDonations() + donation.getAmount());

            campaignService.updateDonation(currentCampaign, donation.getAmount());

            return donationRepository.save(newDonation);
        }

    }
}

//else if(campaignRepository.findById(donation.getCampaignid()) == null)
//        {
//        throw new ResourceNotFoundException(Long.toString(donation.getCampaignid()));
//        }