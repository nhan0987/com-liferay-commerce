/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.tax.engine.fixed.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel;
import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRelModel;
import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRelSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceTaxFixedRateAddressRel service. Represents a row in the &quot;CommerceTaxFixedRateAddressRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceTaxFixedRateAddressRelModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceTaxFixedRateAddressRelImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceTaxFixedRateAddressRelImpl
 * @see CommerceTaxFixedRateAddressRel
 * @see CommerceTaxFixedRateAddressRelModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceTaxFixedRateAddressRelModelImpl extends BaseModelImpl<CommerceTaxFixedRateAddressRel>
	implements CommerceTaxFixedRateAddressRelModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce tax fixed rate address rel model instance should use the {@link CommerceTaxFixedRateAddressRel} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceTaxFixedRateAddressRel";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CTaxFixedRateAddressRelId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commerceTaxMethodId", Types.BIGINT },
			{ "CPTaxCategoryId", Types.BIGINT },
			{ "commerceCountryId", Types.BIGINT },
			{ "commerceRegionId", Types.BIGINT },
			{ "zip", Types.VARCHAR },
			{ "rate", Types.DOUBLE }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CTaxFixedRateAddressRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceTaxMethodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPTaxCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceCountryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceRegionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("zip", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rate", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceTaxFixedRateAddressRel (CTaxFixedRateAddressRelId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceTaxMethodId LONG,CPTaxCategoryId LONG,commerceCountryId LONG,commerceRegionId LONG,zip VARCHAR(75) null,rate DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table CommerceTaxFixedRateAddressRel";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceTaxFixedRateAddressRel.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceTaxFixedRateAddressRel.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.tax.engine.fixed.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.tax.engine.fixed.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.tax.engine.fixed.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel"),
			true);
	public static final long CPTAXCATEGORYID_COLUMN_BITMASK = 1L;
	public static final long COMMERCETAXMETHODID_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceTaxFixedRateAddressRel toModel(
		CommerceTaxFixedRateAddressRelSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceTaxFixedRateAddressRel model = new CommerceTaxFixedRateAddressRelImpl();

		model.setCommerceTaxFixedRateAddressRelId(soapModel.getCommerceTaxFixedRateAddressRelId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceTaxMethodId(soapModel.getCommerceTaxMethodId());
		model.setCPTaxCategoryId(soapModel.getCPTaxCategoryId());
		model.setCommerceCountryId(soapModel.getCommerceCountryId());
		model.setCommerceRegionId(soapModel.getCommerceRegionId());
		model.setZip(soapModel.getZip());
		model.setRate(soapModel.getRate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceTaxFixedRateAddressRel> toModels(
		CommerceTaxFixedRateAddressRelSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceTaxFixedRateAddressRel> models = new ArrayList<CommerceTaxFixedRateAddressRel>(soapModels.length);

		for (CommerceTaxFixedRateAddressRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.tax.engine.fixed.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel"));

	public CommerceTaxFixedRateAddressRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceTaxFixedRateAddressRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceTaxFixedRateAddressRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceTaxFixedRateAddressRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceTaxFixedRateAddressRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceTaxFixedRateAddressRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceTaxFixedRateAddressRelId",
			getCommerceTaxFixedRateAddressRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceTaxMethodId", getCommerceTaxMethodId());
		attributes.put("CPTaxCategoryId", getCPTaxCategoryId());
		attributes.put("commerceCountryId", getCommerceCountryId());
		attributes.put("commerceRegionId", getCommerceRegionId());
		attributes.put("zip", getZip());
		attributes.put("rate", getRate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceTaxFixedRateAddressRelId = (Long)attributes.get(
				"commerceTaxFixedRateAddressRelId");

		if (commerceTaxFixedRateAddressRelId != null) {
			setCommerceTaxFixedRateAddressRelId(commerceTaxFixedRateAddressRelId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commerceTaxMethodId = (Long)attributes.get("commerceTaxMethodId");

		if (commerceTaxMethodId != null) {
			setCommerceTaxMethodId(commerceTaxMethodId);
		}

		Long CPTaxCategoryId = (Long)attributes.get("CPTaxCategoryId");

		if (CPTaxCategoryId != null) {
			setCPTaxCategoryId(CPTaxCategoryId);
		}

		Long commerceCountryId = (Long)attributes.get("commerceCountryId");

		if (commerceCountryId != null) {
			setCommerceCountryId(commerceCountryId);
		}

		Long commerceRegionId = (Long)attributes.get("commerceRegionId");

		if (commerceRegionId != null) {
			setCommerceRegionId(commerceRegionId);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		Double rate = (Double)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}
	}

	@JSON
	@Override
	public long getCommerceTaxFixedRateAddressRelId() {
		return _commerceTaxFixedRateAddressRelId;
	}

	@Override
	public void setCommerceTaxFixedRateAddressRelId(
		long commerceTaxFixedRateAddressRelId) {
		_commerceTaxFixedRateAddressRelId = commerceTaxFixedRateAddressRelId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommerceTaxMethodId() {
		return _commerceTaxMethodId;
	}

	@Override
	public void setCommerceTaxMethodId(long commerceTaxMethodId) {
		_columnBitmask |= COMMERCETAXMETHODID_COLUMN_BITMASK;

		if (!_setOriginalCommerceTaxMethodId) {
			_setOriginalCommerceTaxMethodId = true;

			_originalCommerceTaxMethodId = _commerceTaxMethodId;
		}

		_commerceTaxMethodId = commerceTaxMethodId;
	}

	public long getOriginalCommerceTaxMethodId() {
		return _originalCommerceTaxMethodId;
	}

	@JSON
	@Override
	public long getCPTaxCategoryId() {
		return _CPTaxCategoryId;
	}

	@Override
	public void setCPTaxCategoryId(long CPTaxCategoryId) {
		_columnBitmask |= CPTAXCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCPTaxCategoryId) {
			_setOriginalCPTaxCategoryId = true;

			_originalCPTaxCategoryId = _CPTaxCategoryId;
		}

		_CPTaxCategoryId = CPTaxCategoryId;
	}

	public long getOriginalCPTaxCategoryId() {
		return _originalCPTaxCategoryId;
	}

	@JSON
	@Override
	public long getCommerceCountryId() {
		return _commerceCountryId;
	}

	@Override
	public void setCommerceCountryId(long commerceCountryId) {
		_commerceCountryId = commerceCountryId;
	}

	@JSON
	@Override
	public long getCommerceRegionId() {
		return _commerceRegionId;
	}

	@Override
	public void setCommerceRegionId(long commerceRegionId) {
		_commerceRegionId = commerceRegionId;
	}

	@JSON
	@Override
	public String getZip() {
		if (_zip == null) {
			return "";
		}
		else {
			return _zip;
		}
	}

	@Override
	public void setZip(String zip) {
		_zip = zip;
	}

	@JSON
	@Override
	public double getRate() {
		return _rate;
	}

	@Override
	public void setRate(double rate) {
		_rate = rate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceTaxFixedRateAddressRel.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceTaxFixedRateAddressRel toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceTaxFixedRateAddressRel)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceTaxFixedRateAddressRelImpl commerceTaxFixedRateAddressRelImpl = new CommerceTaxFixedRateAddressRelImpl();

		commerceTaxFixedRateAddressRelImpl.setCommerceTaxFixedRateAddressRelId(getCommerceTaxFixedRateAddressRelId());
		commerceTaxFixedRateAddressRelImpl.setGroupId(getGroupId());
		commerceTaxFixedRateAddressRelImpl.setCompanyId(getCompanyId());
		commerceTaxFixedRateAddressRelImpl.setUserId(getUserId());
		commerceTaxFixedRateAddressRelImpl.setUserName(getUserName());
		commerceTaxFixedRateAddressRelImpl.setCreateDate(getCreateDate());
		commerceTaxFixedRateAddressRelImpl.setModifiedDate(getModifiedDate());
		commerceTaxFixedRateAddressRelImpl.setCommerceTaxMethodId(getCommerceTaxMethodId());
		commerceTaxFixedRateAddressRelImpl.setCPTaxCategoryId(getCPTaxCategoryId());
		commerceTaxFixedRateAddressRelImpl.setCommerceCountryId(getCommerceCountryId());
		commerceTaxFixedRateAddressRelImpl.setCommerceRegionId(getCommerceRegionId());
		commerceTaxFixedRateAddressRelImpl.setZip(getZip());
		commerceTaxFixedRateAddressRelImpl.setRate(getRate());

		commerceTaxFixedRateAddressRelImpl.resetOriginalValues();

		return commerceTaxFixedRateAddressRelImpl;
	}

	@Override
	public int compareTo(
		CommerceTaxFixedRateAddressRel commerceTaxFixedRateAddressRel) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commerceTaxFixedRateAddressRel.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceTaxFixedRateAddressRel)) {
			return false;
		}

		CommerceTaxFixedRateAddressRel commerceTaxFixedRateAddressRel = (CommerceTaxFixedRateAddressRel)obj;

		long primaryKey = commerceTaxFixedRateAddressRel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceTaxFixedRateAddressRelModelImpl commerceTaxFixedRateAddressRelModelImpl =
			this;

		commerceTaxFixedRateAddressRelModelImpl._setModifiedDate = false;

		commerceTaxFixedRateAddressRelModelImpl._originalCommerceTaxMethodId = commerceTaxFixedRateAddressRelModelImpl._commerceTaxMethodId;

		commerceTaxFixedRateAddressRelModelImpl._setOriginalCommerceTaxMethodId = false;

		commerceTaxFixedRateAddressRelModelImpl._originalCPTaxCategoryId = commerceTaxFixedRateAddressRelModelImpl._CPTaxCategoryId;

		commerceTaxFixedRateAddressRelModelImpl._setOriginalCPTaxCategoryId = false;

		commerceTaxFixedRateAddressRelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceTaxFixedRateAddressRel> toCacheModel() {
		CommerceTaxFixedRateAddressRelCacheModel commerceTaxFixedRateAddressRelCacheModel =
			new CommerceTaxFixedRateAddressRelCacheModel();

		commerceTaxFixedRateAddressRelCacheModel.commerceTaxFixedRateAddressRelId = getCommerceTaxFixedRateAddressRelId();

		commerceTaxFixedRateAddressRelCacheModel.groupId = getGroupId();

		commerceTaxFixedRateAddressRelCacheModel.companyId = getCompanyId();

		commerceTaxFixedRateAddressRelCacheModel.userId = getUserId();

		commerceTaxFixedRateAddressRelCacheModel.userName = getUserName();

		String userName = commerceTaxFixedRateAddressRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceTaxFixedRateAddressRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceTaxFixedRateAddressRelCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceTaxFixedRateAddressRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceTaxFixedRateAddressRelCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceTaxFixedRateAddressRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceTaxFixedRateAddressRelCacheModel.commerceTaxMethodId = getCommerceTaxMethodId();

		commerceTaxFixedRateAddressRelCacheModel.CPTaxCategoryId = getCPTaxCategoryId();

		commerceTaxFixedRateAddressRelCacheModel.commerceCountryId = getCommerceCountryId();

		commerceTaxFixedRateAddressRelCacheModel.commerceRegionId = getCommerceRegionId();

		commerceTaxFixedRateAddressRelCacheModel.zip = getZip();

		String zip = commerceTaxFixedRateAddressRelCacheModel.zip;

		if ((zip != null) && (zip.length() == 0)) {
			commerceTaxFixedRateAddressRelCacheModel.zip = null;
		}

		commerceTaxFixedRateAddressRelCacheModel.rate = getRate();

		return commerceTaxFixedRateAddressRelCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{commerceTaxFixedRateAddressRelId=");
		sb.append(getCommerceTaxFixedRateAddressRelId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commerceTaxMethodId=");
		sb.append(getCommerceTaxMethodId());
		sb.append(", CPTaxCategoryId=");
		sb.append(getCPTaxCategoryId());
		sb.append(", commerceCountryId=");
		sb.append(getCommerceCountryId());
		sb.append(", commerceRegionId=");
		sb.append(getCommerceRegionId());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", rate=");
		sb.append(getRate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateAddressRel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceTaxFixedRateAddressRelId</column-name><column-value><![CDATA[");
		sb.append(getCommerceTaxFixedRateAddressRelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceTaxMethodId</column-name><column-value><![CDATA[");
		sb.append(getCommerceTaxMethodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPTaxCategoryId</column-name><column-value><![CDATA[");
		sb.append(getCPTaxCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceCountryId</column-name><column-value><![CDATA[");
		sb.append(getCommerceCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceRegionId</column-name><column-value><![CDATA[");
		sb.append(getCommerceRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rate</column-name><column-value><![CDATA[");
		sb.append(getRate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceTaxFixedRateAddressRel.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceTaxFixedRateAddressRel.class, ModelWrapper.class
		};
	private long _commerceTaxFixedRateAddressRelId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceTaxMethodId;
	private long _originalCommerceTaxMethodId;
	private boolean _setOriginalCommerceTaxMethodId;
	private long _CPTaxCategoryId;
	private long _originalCPTaxCategoryId;
	private boolean _setOriginalCPTaxCategoryId;
	private long _commerceCountryId;
	private long _commerceRegionId;
	private String _zip;
	private double _rate;
	private long _columnBitmask;
	private CommerceTaxFixedRateAddressRel _escapedModel;
}