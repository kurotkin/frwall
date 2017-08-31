package com.kurotkin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitesRepository extends CrudRepository<Site, Long> {
}
