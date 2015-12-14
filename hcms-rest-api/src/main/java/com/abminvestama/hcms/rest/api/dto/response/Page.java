package com.abminvestama.hcms.rest.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class Page {

	private int size;
	private long totalElements;
	private int totalPages;
	private int number;
	
	public Page() {}
	
	public Page(int size, long totalElements, int totalPages, int number) {
		this.size = size;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.number = number;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	@JsonProperty("total_elements")
	public long getTotalElements() {
		return totalElements;
	}
	
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	
	
}