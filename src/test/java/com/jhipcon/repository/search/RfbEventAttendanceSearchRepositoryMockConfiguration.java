package com.jhipcon.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of RfbEventAttendanceSearchRepository to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class RfbEventAttendanceSearchRepositoryMockConfiguration {

    @MockBean
    private RfbEventAttendanceSearchRepository mockRfbEventAttendanceSearchRepository;

}
