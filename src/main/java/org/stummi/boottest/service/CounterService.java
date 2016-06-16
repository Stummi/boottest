package org.stummi.boottest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stummi.boottest.model.Counter;
import org.stummi.boottest.repository.CounterRepository;

@Component
public class CounterService {
	private final CounterRepository repository;

	@Autowired
	public CounterService(CounterRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public long incrementAndGet(String name) {
		Counter counter = repository.findByName(name);

		if (counter == null) {
			counter = new Counter();
			counter.setName(name);
		}

		long value = counter.getValue();
		counter.setValue(value + 1);

		repository.save(counter);
		return value;

	}
}
