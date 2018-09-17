package com.jhipcon.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of RfbEventSearchRepository to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class RfbEventSearchRepositoryMockConfiguration {

    @MockBean
    private RfbEventSearchRepository mockRfbEventSearchRepository;

}
