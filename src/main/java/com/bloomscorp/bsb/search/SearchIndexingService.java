package com.bloomscorp.bsb.search;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class SearchIndexingService {

	private final EntityManager entityManager;

	@Transactional(readOnly = true)
	public void index(Class<?>... types) {
		try {
			SearchSession searchSession = Search.session((Session) this.entityManager);
			MassIndexer massIndexer = searchSession.massIndexer(types);
			massIndexer.startAndWait();
		} catch (InterruptedException exception) {
			throw new RuntimeException("Search indexing interrupted!");
		}
	}

	@Transactional(readOnly = true)
	public void trigger(Class<?>... types) {
		this.index(types);
	}
}
