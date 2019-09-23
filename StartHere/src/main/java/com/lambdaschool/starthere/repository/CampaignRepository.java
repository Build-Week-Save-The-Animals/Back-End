package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Campaign;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Long>
{
}
