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

package com.liferay.commerce.context;

import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.product.model.CPRule;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;

import java.io.Serializable;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco Leo
 */
public interface CommerceContext extends Serializable {

	public CommerceCurrency getCommerceCurrency() throws PortalException;

	public CommerceOrder getCommerceOrder() throws PortalException;

	public Optional<CommercePriceList> getCommercePriceList()
		throws PortalException;

	public long[] getCommerceUserSegmentEntryIds() throws PortalException;

	public String getCouponCode() throws PortalException;

	public List<CPRule> getCPRules() throws PortalException;

	public Organization getOrganization() throws PortalException;

	public long getSiteGroupId() throws PortalException;

	public long getUserId();

}