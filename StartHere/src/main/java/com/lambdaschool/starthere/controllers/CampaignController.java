package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Campaign;
import com.lambdaschool.starthere.models.Donation;
import com.lambdaschool.starthere.services.CampaignService;
import com.lambdaschool.starthere.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/campaigns")
public class CampaignController
{
    @Autowired
    private CampaignService campaignService;

    @Autowired
    private DonationService donationService;

    // http://localhost:2019/campaigns/campaigns/?page=0&size=1
    // http://localhost:2019/campaigns/campaigns/?sort=title
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCampaigns(@PageableDefault(page = 0, size = 10) Pageable pageable) throws ResourceNotFoundException
    {
        List<Campaign> myCampaigns = campaignService.findAll(pageable);
        return new ResponseEntity<>(myCampaigns, HttpStatus.OK);
    }

    // http://localhost:2019/campaigns/campaign/add
    @PostMapping(value = "campaign/add",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addCampaign(@Valid @RequestBody Campaign newCampaign) throws ResourceNotFoundException
    {

        campaignService.save(newCampaign);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/campaign/delete/{id}")
    public ResponseEntity<?> deleteCampaignById(@PathVariable long id)
    {
        campaignService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/campaign/update/{id}")
    public ResponseEntity<?> updateStudent(
            @RequestBody
                    Campaign updateCampaign,
            @PathVariable
                    long id)
    {
        campaignService.update(updateCampaign, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/campaigns/campaign/donate
    @PostMapping(value = "campaign/donate",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> donate(@Valid @RequestBody Donation newDonation) throws ResourceNotFoundException
    {

        donationService.save(newDonation);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
