package com.jhipcon.service.impl;

import com.jhipcon.service.RfbUserService;
import com.jhipcon.domain.RfbUser;
import com.jhipcon.repository.RfbUserRepository;
import com.jhipcon.repository.search.RfbUserSearchRepository;
import com.jhipcon.service.dto.RfbUserDTO;
import com.jhipcon.service.mapper.RfbUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing RfbUser.
 */
@Service
@Transactional
public class RfbUserServiceImpl implements RfbUserService {

    private final Logger log = LoggerFactory.getLogger(RfbUserServiceImpl.class);

    private final RfbUserRepository rfbUserRepository;

    private final RfbUserMapper rfbUserMapper;

    private final RfbUserSearchRepository rfbUserSearchRepository;

    public RfbUserServiceImpl(RfbUserRepository rfbUserRepository, RfbUserMapper rfbUserMapper, RfbUserSearchRepository rfbUserSearchRepository) {
        this.rfbUserRepository = rfbUserRepository;
        this.rfbUserMapper = rfbUserMapper;
        this.rfbUserSearchRepository = rfbUserSearchRepository;
    }

    /**
     * Save a rfbUser.
     *
     * @param rfbUserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RfbUserDTO save(RfbUserDTO rfbUserDTO) {
        log.debug("Request to save RfbUser : {}", rfbUserDTO);
        RfbUser rfbUser = rfbUserMapper.toEntity(rfbUserDTO);
        rfbUser = rfbUserRepository.save(rfbUser);
        RfbUserDTO result = rfbUserMapper.toDto(rfbUser);
        rfbUserSearchRepository.save(rfbUser);
        return result;
    }

    /**
     * Get all the rfbUsers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RfbUserDTO> findAll() {
        log.debug("Request to get all RfbUsers");
        return rfbUserRepository.findAll().stream()
            .map(rfbUserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one rfbUser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RfbUserDTO> findOne(Long id) {
        log.debug("Request to get RfbUser : {}", id);
        return rfbUserRepository.findById(id)
            .map(rfbUserMapper::toDto);
    }

    /**
     * Delete the rfbUser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbUser : {}", id);
        rfbUserRepository.deleteById(id);
        rfbUserSearchRepository.deleteById(id);
    }

    /**
     * Search for the rfbUser corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RfbUserDTO> search(String query) {
        log.debug("Request to search RfbUsers for query {}", query);
        return StreamSupport
            .stream(rfbUserSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(rfbUserMapper::toDto)
            .collect(Collectors.toList());
    }
}
