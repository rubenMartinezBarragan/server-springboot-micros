package com.ccsw.tutorialloan.loan.model;

import com.ccsw.tutorialloan.common.pagination.PageableRequest;

/**
 * @author ruben martinez barragan
 *
 */
public class LoanSearchDto {

	private PageableRequest pageable;

	public PageableRequest getPageable() {
		return pageable;
	}

	public void setPageable(PageableRequest pageable) {
		this.pageable = pageable;
	}

}