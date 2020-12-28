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
package com.cymmetri.common.passwordpolicy.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Password Policy Entity.
 *
 * @author Roshan Jha.
 */
@Data
public class PasswordPolicyResponse {

	@Id
	@ApiModelProperty(notes = "Id", value = "String", example = "5ebfbd5f3a0f4b757cdb1a2a", hidden = true)
	private String id;

	@Indexed(unique = true)
	@NotBlank(message = "Null or Empty value is not allowed")
	@ApiModelProperty(notes = "Name", value = "Password Policy Name", example = "Password Policy Name", hidden = false)
	private String name;

	@NotBlank(message = "Null or Empty value is not allowed")
	private String description;

	@NotNull(message = "Null value is not allowed")
	@ApiModelProperty(notes = "isDefault", value = "false", example = "true or false", hidden = false)
	private Boolean isDefault;

	@NotNull(message = "Null value is not allowed")
	@ApiModelProperty(notes = "active", value = "false", example = "true or false", hidden = false)
	private Boolean active;

	private PasswordPolicyComposition passwordPolicyComposition;

	private PasswordChangeRule passwordChangeRule;

	@CreatedDate
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@ApiModelProperty(value = "Create timestamp", name = "createdAt", dataType = "LocalDateTime", hidden = true)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@ApiModelProperty(value = "Update timestamp", name = "updatedAt", dataType = "LocalDateTime", hidden = true)
	private LocalDateTime updatedAt;

	@CreatedBy
	@ApiModelProperty(value = "Created By", name = "createdBy", dataType = "String", hidden = true)
	private String createdBy;

	@LastModifiedBy
	@ApiModelProperty(value = "Updated By", name = "updatedBy", dataType = "String", hidden = true)
	private String updatedBy;

	@Version
	@ApiModelProperty(value = "version", name = "version", dataType = "Long", hidden = true)
	private Long version;

}
