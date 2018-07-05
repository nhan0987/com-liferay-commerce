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

package com.liferay.commerce.user.segment.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry;
import com.liferay.commerce.user.segment.model.CommerceUserSegmentEntryModel;
import com.liferay.commerce.user.segment.model.CommerceUserSegmentEntrySoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the CommerceUserSegmentEntry service. Represents a row in the &quot;CommerceUserSegmentEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceUserSegmentEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceUserSegmentEntryImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceUserSegmentEntryImpl
 * @see CommerceUserSegmentEntry
 * @see CommerceUserSegmentEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceUserSegmentEntryModelImpl extends BaseModelImpl<CommerceUserSegmentEntry>
	implements CommerceUserSegmentEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce user segment entry model instance should use the {@link CommerceUserSegmentEntry} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceUserSegmentEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commerceUserSegmentEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "key_", Types.VARCHAR },
			{ "active_", Types.BOOLEAN },
			{ "system", Types.BOOLEAN },
			{ "priority", Types.DOUBLE }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceUserSegmentEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("system", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceUserSegmentEntry (commerceUserSegmentEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name STRING null,key_ VARCHAR(75) null,active_ BOOLEAN,system BOOLEAN,priority DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table CommerceUserSegmentEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceUserSegmentEntry.priority ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceUserSegmentEntry.priority ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.user.segment.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.user.segment.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.user.segment.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry"),
			true);
	public static final long ACTIVE_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long KEY_COLUMN_BITMASK = 4L;
	public static final long PRIORITY_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceUserSegmentEntry toModel(
		CommerceUserSegmentEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceUserSegmentEntry model = new CommerceUserSegmentEntryImpl();

		model.setCommerceUserSegmentEntryId(soapModel.getCommerceUserSegmentEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setKey(soapModel.getKey());
		model.setActive(soapModel.isActive());
		model.setSystem(soapModel.isSystem());
		model.setPriority(soapModel.getPriority());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceUserSegmentEntry> toModels(
		CommerceUserSegmentEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceUserSegmentEntry> models = new ArrayList<CommerceUserSegmentEntry>(soapModels.length);

		for (CommerceUserSegmentEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.user.segment.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry"));

	public CommerceUserSegmentEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceUserSegmentEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceUserSegmentEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceUserSegmentEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceUserSegmentEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceUserSegmentEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceUserSegmentEntryId",
			getCommerceUserSegmentEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("key", getKey());
		attributes.put("active", isActive());
		attributes.put("system", isSystem());
		attributes.put("priority", getPriority());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceUserSegmentEntryId = (Long)attributes.get(
				"commerceUserSegmentEntryId");

		if (commerceUserSegmentEntryId != null) {
			setCommerceUserSegmentEntryId(commerceUserSegmentEntryId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Boolean system = (Boolean)attributes.get("system");

		if (system != null) {
			setSystem(system);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}
	}

	@JSON
	@Override
	public long getCommerceUserSegmentEntryId() {
		return _commerceUserSegmentEntryId;
	}

	@Override
	public void setCommerceUserSegmentEntryId(long commerceUserSegmentEntryId) {
		_commerceUserSegmentEntryId = commerceUserSegmentEntryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@JSON
	@Override
	public boolean getSystem() {
		return _system;
	}

	@JSON
	@Override
	public boolean isSystem() {
		return _system;
	}

	@Override
	public void setSystem(boolean system) {
		_system = system;
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceUserSegmentEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(CommerceUserSegmentEntry.class.getName(),
				getPrimaryKey(), defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CommerceUserSegmentEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceUserSegmentEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceUserSegmentEntryImpl commerceUserSegmentEntryImpl = new CommerceUserSegmentEntryImpl();

		commerceUserSegmentEntryImpl.setCommerceUserSegmentEntryId(getCommerceUserSegmentEntryId());
		commerceUserSegmentEntryImpl.setGroupId(getGroupId());
		commerceUserSegmentEntryImpl.setCompanyId(getCompanyId());
		commerceUserSegmentEntryImpl.setUserId(getUserId());
		commerceUserSegmentEntryImpl.setUserName(getUserName());
		commerceUserSegmentEntryImpl.setCreateDate(getCreateDate());
		commerceUserSegmentEntryImpl.setModifiedDate(getModifiedDate());
		commerceUserSegmentEntryImpl.setName(getName());
		commerceUserSegmentEntryImpl.setKey(getKey());
		commerceUserSegmentEntryImpl.setActive(isActive());
		commerceUserSegmentEntryImpl.setSystem(isSystem());
		commerceUserSegmentEntryImpl.setPriority(getPriority());

		commerceUserSegmentEntryImpl.resetOriginalValues();

		return commerceUserSegmentEntryImpl;
	}

	@Override
	public int compareTo(CommerceUserSegmentEntry commerceUserSegmentEntry) {
		int value = 0;

		if (getPriority() < commerceUserSegmentEntry.getPriority()) {
			value = -1;
		}
		else if (getPriority() > commerceUserSegmentEntry.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof CommerceUserSegmentEntry)) {
			return false;
		}

		CommerceUserSegmentEntry commerceUserSegmentEntry = (CommerceUserSegmentEntry)obj;

		long primaryKey = commerceUserSegmentEntry.getPrimaryKey();

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
		CommerceUserSegmentEntryModelImpl commerceUserSegmentEntryModelImpl = this;

		commerceUserSegmentEntryModelImpl._originalGroupId = commerceUserSegmentEntryModelImpl._groupId;

		commerceUserSegmentEntryModelImpl._setOriginalGroupId = false;

		commerceUserSegmentEntryModelImpl._setModifiedDate = false;

		commerceUserSegmentEntryModelImpl._originalKey = commerceUserSegmentEntryModelImpl._key;

		commerceUserSegmentEntryModelImpl._originalActive = commerceUserSegmentEntryModelImpl._active;

		commerceUserSegmentEntryModelImpl._setOriginalActive = false;

		commerceUserSegmentEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceUserSegmentEntry> toCacheModel() {
		CommerceUserSegmentEntryCacheModel commerceUserSegmentEntryCacheModel = new CommerceUserSegmentEntryCacheModel();

		commerceUserSegmentEntryCacheModel.commerceUserSegmentEntryId = getCommerceUserSegmentEntryId();

		commerceUserSegmentEntryCacheModel.groupId = getGroupId();

		commerceUserSegmentEntryCacheModel.companyId = getCompanyId();

		commerceUserSegmentEntryCacheModel.userId = getUserId();

		commerceUserSegmentEntryCacheModel.userName = getUserName();

		String userName = commerceUserSegmentEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceUserSegmentEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceUserSegmentEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceUserSegmentEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceUserSegmentEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceUserSegmentEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceUserSegmentEntryCacheModel.name = getName();

		String name = commerceUserSegmentEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceUserSegmentEntryCacheModel.name = null;
		}

		commerceUserSegmentEntryCacheModel.key = getKey();

		String key = commerceUserSegmentEntryCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			commerceUserSegmentEntryCacheModel.key = null;
		}

		commerceUserSegmentEntryCacheModel.active = isActive();

		commerceUserSegmentEntryCacheModel.system = isSystem();

		commerceUserSegmentEntryCacheModel.priority = getPriority();

		return commerceUserSegmentEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{commerceUserSegmentEntryId=");
		sb.append(getCommerceUserSegmentEntryId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", active=");
		sb.append(isActive());
		sb.append(", system=");
		sb.append(isSystem());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.commerce.user.segment.model.CommerceUserSegmentEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceUserSegmentEntryId</column-name><column-value><![CDATA[");
		sb.append(getCommerceUserSegmentEntryId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(isActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>system</column-name><column-value><![CDATA[");
		sb.append(isSystem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceUserSegmentEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceUserSegmentEntry.class, ModelWrapper.class
		};
	private long _commerceUserSegmentEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _key;
	private String _originalKey;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private boolean _system;
	private double _priority;
	private long _columnBitmask;
	private CommerceUserSegmentEntry _escapedModel;
}