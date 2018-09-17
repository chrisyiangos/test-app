package com.jhipcon.service.impl;

import com.jhipcon.service.RfbLocationService;
import com.jhipcon.domain.RfbLocation;
import com.jhipcon.repository.RfbLocationRepository;
import com.jhipcon.repository.search.RfbLocationSearchRepository;
import com.jhipcon.service.dto.RfbLocationDTO;
import com.jhipcon.service.mapper.RfbLocationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing RfbLocation.
 */
@Service
@Transactional
public class RfbLocationServiceImpl implements RfbLocationService {

    private final Logger log = LoggerFactory.getLogger(RfbLocationServiceImpl.class);

    private final RfbLocationRepository rfbLocationRepository;

    private final RfbLocationMapper rfbLocationMapper;

    private final RfbLocationSearchRepository rfbLocationSearchRepository;

    public RfbLocationServiceImpl(RfbLocationRepository rfbLocationRepository, RfbLocationMapper rfbLocationMapper, RfbLocationSearchRepository rfbLocationSearchRepository) {
        this.rfbLocationRepository = rfbLocationRepository;
        this.rfbLocationMapper = rfbLocationMapper;
        this.rfbLocationSearchRepository = rfbLocationSearchRepository;
    }

    /**
     * Save a rfbLocation.
     *
     * @param rfbLocationDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RfbLocationDTO save(RfbLocationDTO rfbLocationDTO) {
        log.debug("Request to save RfbLocation : {}", rfbLocationDTO);
        RfbLocation rfbLocation = rfbLocationMapper.toEntity(rfbLocationDTO);
        rfbLocation = rfbLocationRepository.save(rfbLocation);
        RfbLocationDTO result = rfbLocationMapper.toDto(rfbLocation);
        rfbLocationSearchRepository.save(rfbLocation);
        return result;
    }

    /**
     * Get all the rfbLocations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbLocationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbLocations");
        return rfbLocationRepository.findAll(pageable)
            .map(rfbLocationMapper::toDto);
    }


    /**
     * Get one rfbLocation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RfbLocationDTO> findOne(Long id) {
        log.debug("Request to get RfbLocation : {}", id);
        return rfbLocationRepository.findById(id)
            .map(rfbLocationMapper::toDto);
    }

    /**
     * Delete the rfbLocation by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbLocation : {}", id);
        rfbLocationRepository.deleteById(id);
        rfbLocationSearchRepository.deleteById(id);
    }

    /**
     * Search for the rfbLocation corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbLocationDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of RfbLocations for query {}", query);
        return rfbLocationSearchRepository.search(queryStringQuery(query), pageable)
            .map(rfbLocationMapper::toDto);
    }
}
