package com.jhipcon.repository.search;

import com.jhipcon.domain.RfbEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the RfbEvent entity.
 */
public interface RfbEventSearchRepository extends ElasticsearchRepository<RfbEvent, Long> {
}
