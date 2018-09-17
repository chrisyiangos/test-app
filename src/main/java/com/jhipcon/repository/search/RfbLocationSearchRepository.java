package com.jhipcon.repository.search;

import com.jhipcon.domain.RfbLocation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the RfbLocation entity.
 */
public interface RfbLocationSearchRepository extends ElasticsearchRepository<RfbLocation, Long> {
}
