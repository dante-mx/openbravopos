//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.ticket;

import java.awt.image.BufferedImage;
import java.util.Properties;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.ImageUtils;
import com.openbravo.data.loader.SerializerRead;
import com.openbravo.format.Formats;
import com.openbravo.pos.config.Constants;

/**
 *
 * @author adrianromero
 *
 */
public class ProductInfoExt {

    private static final long serialVersionUID = 7587696873036L;

    protected Long m_ID;
    protected Long thirdpartyid;
    protected Long m_sRef;
    protected String m_sCode;
    protected String m_sName;
    protected boolean m_bCom;
    protected boolean m_bScale;
    protected Long categoryid;
    protected Long taxcategoryid;
    protected Long attributesetid;
    protected double m_dPriceBuy;
    protected double m_dPriceSell;
    protected BufferedImage m_Image;
    protected Properties attributes;
    
    /** Creates new ProductInfo */
    public ProductInfoExt() {
        m_ID = null;
        thirdpartyid = null;
        m_sRef = Constants.PRODUCT_ZERO;
        m_sCode = "0000";
        m_sName = null;
        m_bCom = false;
        m_bScale = false;
        categoryid = null;
        taxcategoryid = null;
        attributesetid = null;
        m_dPriceBuy = 0.0;
        m_dPriceSell = 0.0;
        m_Image = null;
        attributes = new Properties();
    }

    public final Long getID() {
        return m_ID;
    }

    public final void setID(Long id) {
        m_ID = id;
    }

    public Long getThirdPartyId() {
      return thirdpartyid;
    }

    public void setThirdPartyId(Long thirdpartyid) {
      this.thirdpartyid = thirdpartyid;
    }

    public final Long getReference() {
        return m_sRef;
    }

    public final void setReference(Long sRef) {
        m_sRef = sRef;
    }

    public final String getCode() {
        return m_sCode;
    }

    public final void setCode(String sCode) {
        m_sCode = sCode;
    }

    public final String getName() {
        return m_sName;
    }

    public final void setName(String sName) {
        m_sName = sName;
    }

    public final boolean isCom() {
        return m_bCom;
    }

    public final void setCom(boolean bValue) {
        m_bCom = bValue;
    }

    public final boolean isScale() {
        return m_bScale;
    }

    public final void setScale(boolean bValue) {
        m_bScale = bValue;
    }

    public final Long getCategoryID() {
        return categoryid;
    }

    public final void setCategoryID(Long sCategoryID) {
        categoryid = sCategoryID;
    }

    public final Long getTaxCategoryID() {
        return taxcategoryid;
    }

    public final void setTaxCategoryID(Long value) {
        taxcategoryid = value;
    }

    public final Long getAttributeSetID() {
        return attributesetid;
    }
    public final void setAttributeSetID(Long value) {
        attributesetid = value;
    }

    public final double getPriceBuy() {
        return m_dPriceBuy;
    }

    public final void setPriceBuy(double dPrice) {
        m_dPriceBuy = dPrice;
    }

    public final double getPriceSell() {
        return m_dPriceSell;
    }

    public final void setPriceSell(double dPrice) {
        m_dPriceSell = dPrice;
    }

    public final double getPriceSellTax(TaxInfo tax) {
        return m_dPriceSell * (1.0 + tax.getRate());
    }

    public String printPriceSell() {
        return Formats.CURRENCY.formatValue(new Double(getPriceSell()));
    }

    public String printPriceSellTax(TaxInfo tax) {
        return Formats.CURRENCY.formatValue(new Double(getPriceSellTax(tax)));
    }
    
    public BufferedImage getImage() {
        return m_Image;
    }
    public void setImage(BufferedImage img) {
        m_Image = img;
    }
    
    public String getProperty(String key) {
        return attributes.getProperty(key);
    }
    public String getProperty(String key, String defaultvalue) {
        return attributes.getProperty(key, defaultvalue);
    }
    public void setProperty(String key, String value) {
        attributes.setProperty(key, value);
    }
    public Properties getProperties() {
        return attributes;
    }

    public static SerializerRead getSerializerRead() {
        return new SerializerRead() { public Object readValues(DataRead dr) throws BasicException {
            ProductInfoExt product = new ProductInfoExt();
            product.m_ID = dr.getLong(1);
            product.thirdpartyid= dr.getLong(2);
            product.m_sRef = dr.getLong(3);
            product.m_sCode = dr.getString(4);
            product.m_sName = dr.getString(5);
            product.m_bCom = dr.getBoolean(6).booleanValue();
            product.m_bScale = dr.getBoolean(7).booleanValue();
            product.m_dPriceBuy = dr.getDouble(8).doubleValue();
            product.m_dPriceSell = dr.getDouble(9).doubleValue();
            product.taxcategoryid = dr.getLong(10);
            product.categoryid = dr.getLong(11);
            product.attributesetid = dr.getLong(12);
            product.m_Image = ImageUtils.readImage(dr.getBytes(13));
            product.attributes = ImageUtils.readProperties(dr.getBytes(14));
            return product;
        }};
    }

    @Override
    public final String toString() {
        return m_sRef + " - " + m_sName;
    }
}