/*
 * Copyright (c) 2020 Unotech Software Pvt. Ltd.
 *
 * All Rights Reserved.
 *
 * The software contained on this media is written by  Unotech Software Pvt. Ltd. and
 * is proprietary to and embodies the confidential technology of Unotech Software.
 *
 * The possession or receipt of this information does not convey any right to disclose
 * its contents, reproduce it, or use, or license the use, for manufacture or sale,
 * the information or anything described therein. Any use, disclosure, or reproduction
 * without prior written permission of Unotech Software is strictly prohibited.
 */
package com.cymmetri.common.userservice;

import com.cymmetri.common.search.Search;
import com.cymmetri.common.search.SortDirection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Sort.Direction;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type User list dto.
 *
 * @author unotech .
 */

@Getter
@Setter
@ToString
@ApiModel(description = "User List Request Body")
@Builder
public class UserListDto {

	/** The keyword. */
	@ApiModelProperty(notes = "Search Keyword", value = "test", example = "test")
	private String keyword;

	/** The page number. */
	@ApiModelProperty(notes = "Page Number", value = "0", example = "0")
	private Integer pageNumber = 0;

	/** The page size. */
	@ApiModelProperty(notes = "Page Size", value = "10", example = "10")
	private Integer pageSize = 10;

	/** The sort. */
	@ApiModelProperty(notes = "Sort By", allowableValues = "FIRST_NAME, EMAIL", example = "FIRST_NAME")
	private UserSortBy sort = UserSortBy.FIRST_NAME;

	/** The direction. */
	@ApiModelProperty(notes = "Sort Direction", allowableValues = "ASC, DESC", example = "ASC")
	private Direction direction = Direction.ASC;

	/** The filters. */
	@ApiModelProperty(notes = "Filters for User List")
	private UserFilterDto filters;

	@JsonIgnore
	public Search<UserSearch> toSearch() {
		Direction direction = ObjectUtils.defaultIfNull(this.getDirection(), Direction.ASC);
		SortDirection sortDirection = direction.isAscending() ? SortDirection.ASC : SortDirection.DESC;

		this.setSort(ObjectUtils.defaultIfNull(this.getSort(), UserSortBy.FIRST_NAME));
		this.setDirection(direction);

		String sortOn = this.getSort().getFieldName();

		Search<UserSearch> search = new Search<UserSearch>();
		search.setPageSize(this.getPageSize());
		search.setPageNumber(this.getPageNumber());
		search.setKeyword(this.getKeyword());

		search.setSortDirection(sortDirection);
		search.setSortOn(ArrayUtils.toArray(sortOn));

		if (Objects.nonNull(this.getFilters())) {
			UserSearch filters = new UserSearch();
			UserFilterDto dtoFilter = this.getFilters();

			filters.setCountry(dtoFilter.getLocation());
			filters.setManagerId(dtoFilter.getReportingManager());
			filters.setDepartment(dtoFilter.getDepartment());
			filters.setDesignation(dtoFilter.getDesignation());
			filters.setAssignedGroup(dtoFilter.getGroup());
			filters.setEmail(dtoFilter.getEmail());
			filters.setMobile(dtoFilter.getMobile());
			filters.setStatus(dtoFilter.getStatus());
			filters.setUserType(dtoFilter.getUserType());
			filters.setLocked(dtoFilter.getLocked());

			search.setFilter(filters);
		}

		return search;
	}

}
