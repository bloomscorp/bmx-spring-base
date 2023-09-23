package com.bloomscorp.bsb.search;

import jakarta.persistence.EntityManager;

public interface SearchIndexConfiguration {
	SearchIndexingService searchIndexingService(EntityManager entityManager);
}
