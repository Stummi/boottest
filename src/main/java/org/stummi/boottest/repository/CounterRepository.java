package org.stummi.boottest.repository;

import org.springframework.data.repository.CrudRepository;
import org.stummi.boottest.model.Counter;

public interface CounterRepository extends CrudRepository<Counter, Long> {
	Counter findByName(String name);
}
