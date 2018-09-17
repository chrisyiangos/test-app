package com.jhipcon.repository.search;

import com.jhipcon.domain.RfbUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the RfbUser entity.
 */
public interface RfbUserSearchRepository extends ElasticsearchRepository<RfbUser, Long> {
}
