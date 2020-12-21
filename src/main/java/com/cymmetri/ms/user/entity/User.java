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
package com.cymmetri.ms.user.entity;

import com.cymmetri.ms.user.dto.Status;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class User.
 *
 * @author unotech .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@QueryEntity
@Document(collection = "user")
public class User {

	/** The id. */
	@Id
	private String id;

	/** The display name. */
	private String displayName;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The country. */
	private String country;

	/** The city. */
	private String city;

	/** The country code. */
	private String countryCode;

	/** The mobile. */
	private String mobile;

	/** The email. */
	private String email;

	/** The landline. */
	private String landline;

	/** The address 1. */
	@Field("address_1")
	private String address1;

	/** The address 2. */
	@Field("address_2")
	private String address2;

	/** The manager id. */
	private String managerId;

	/** The user type. */
	private String userType;

	/** The org unit id. */
	private String orgUnitId;

	/** The employee id. */
	private String employeeId;

	/** The department. */
	private String department;

	/** The designation. */
	private String designation;

	/** The status. */
	private Status status;

	/** The date of birth. */
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateOfBirth;

	/** The start date. */
	@Field("start_date")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime startDate;

	/** The end date. */
	@Field("end_date")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime endDate;

	@CreatedDate
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@ApiModelProperty(value = "Create timestamp", name = "created", dataType = "LocalDateTime", hidden = true)
	private LocalDateTime created;

	@LastModifiedDate
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@ApiModelProperty(value = "Update timestamp", name = "updated", dataType = "LocalDateTime", hidden = true)
	private LocalDateTime updated;

	/** The created by. */
	@CreatedBy
	@Field("created_by")
	@ApiModelProperty(value = "Create By", name = "createdBy", dataType = "String", hidden = true)
	private String createdBy;

	/** The updated by. */
	@LastModifiedBy
	@Field("updated_by")
	@ApiModelProperty(value = "Updated By", name = "updatedBy", dataType = "String", hidden = true)
	private String updatedBy;

	/** The associated partner. */
	private String associatedPartner;

	/** The assigned groups. */
	private List<String> assignedGroups;

	/** The provisioned apps. */
	private Map<String, ProvisionedApps> provisionedApps;

	/** The attributes. */
	private Map<String, String> attributes;

	/* The RBAC Roles. */
	private Set<String> rbacRoles;

	@Version
	@ApiModelProperty(value = "version", name = "version", dataType = "Long", hidden = true)
	private Long version;

}
