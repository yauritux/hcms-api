package com.abminvestama.hcms.rest.api.dto.response;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ArrayData<D> {

	private D[] items;
	
	public ArrayData() {
		super();
	}
	
	public ArrayData(D[] items) {
		this.items = items;
	}
	
	public D[] getItems() {
		return items;
	}
	
	public void setItems(D[] items) {
		this.items = items;
	}
}