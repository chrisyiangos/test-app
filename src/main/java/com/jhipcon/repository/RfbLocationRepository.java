package com.jhipcon.repository;

import com.jhipcon.domain.RfbLocation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RfbLocation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbLocationRepository extends JpaRepository<RfbLocation, Long> {

}
