package org.stummi.boottest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Counter {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private Long version;

	private String name;
	private long value;

	@Override
	public int hashCode() {
		return id == null ? -1 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		return obj != null && obj.getClass() == this.getClass() && id != null && id.equals(((Counter) obj).id);
	}
}
