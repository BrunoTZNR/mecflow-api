package com.mecflow.restapi.model.id;

import java.util.Objects;

public class OsServicesId {
	private Long os;
	private Long service;
	
	public OsServicesId() {
	}
	
	public OsServicesId(Long os, Long service) {
		this.os = os;
		this.service = service;
	}

	public Long getOs() {
		return os;
	}

	public void setOs(Long os) {
		this.os = os;
	}

	public Long getService() {
		return service;
	}

	public void setService(Long service) {
		this.service = service;
	}

	@Override
	public int hashCode() {
		return Objects.hash(os, service);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OsServicesId other = (OsServicesId) obj;
		return Objects.equals(os, other.os) && Objects.equals(service, other.service);
	}

	@Override
	public String toString() {
		return "OsServicesId [os=" + os + ", service=" + service + "]";
	}
}
