//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008-2009 Openbravo, S.L.
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

package com.openbravo.pos.inventory;

import java.io.Serializable;

import com.openbravo.data.loader.IKeyed;

/**
 *
 * @author  adrianromero
 * @version 
 */
public class TaxCategoryInfo implements Serializable, IKeyed {
    
    private static final long serialVersionUID = 8959679342805L;
    private Long m_sID;
    private String m_sName;
       
    public TaxCategoryInfo(Long sID, String sName) {
        m_sID = sID;
        m_sName = sName;      
    }
    
    public Long getKey() {
        return m_sID;
    }
    
    public void setID(Long sID) {
        m_sID = sID;
    }
    
    public Long getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }
    
    public void setName(String sName) {
        m_sName = sName;
    }
   
    @Override
    public String toString(){
        return m_sName;
    }
}