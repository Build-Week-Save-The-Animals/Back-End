package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Campaign;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Long>
{
    @Query(value = "SELECT * FROM campaigns c WHERE c.userid = :id", nativeQuery = true)
    ArrayList<Campaign> findCampaignsByUser(@Param("id") long id);

    @Query(value = "SELECT * FROM campaigns c WHERE c.species = :string", nativeQuery = true)
    ArrayList<Campaign> filterBySpecies(@Param("string") String string);

    @Query(value = "SELECT * FROM campaigns c WHERE c.location = :string", nativeQuery = true)
    ArrayList<Campaign> filterByLocation(@Param("string") String string);
}
