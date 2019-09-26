package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepository extends CrudRepository<Donation, Long>
{
}
