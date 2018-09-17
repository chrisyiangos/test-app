package com.jhipcon.repository.search;

import com.jhipcon.domain.RfbEventAttendance;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the RfbEventAttendance entity.
 */
public interface RfbEventAttendanceSearchRepository extends ElasticsearchRepository<RfbEventAttendance, Long> {
}
