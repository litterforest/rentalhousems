package com.cobee.rentalhousems.entity.logical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.util.CollectionUtils;

import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.util.NumericUtils;

public class SecureResourcesLogic extends SecureResources {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2960481826987742692L;

	private List<SecureResources> menuList;

	public List<SecureResources> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SecureResources> menuList) {
		this.menuList = menuList;
	}

	public void addMenu(SecureResources secureResources) {
		if (secureResources != null) {
			if (menuList == null) {
				menuList = new ArrayList<SecureResources>();
			}
			menuList.add(secureResources);
		}
	}

	public String getWebContent() {
		StringBuilder sbuff = new StringBuilder();
		buildWebContent(sbuff);
		return sbuff.toString();
	}

	private void buildWebContent(StringBuilder sbuff) {
		if (!NumericUtils.equal(super.getId(), 0)) {
			sbuff.append("<ul>");
			sbuff.append("<li><a href=\"/rentalhousems" + super.getSrcurl() + "\" >" + super.getName() + "</a></li>");
		}
		if (!CollectionUtils.isEmpty(menuList)) {
			for (SecureResources po : menuList) {
				((SecureResourcesLogic) po).buildWebContent(sbuff);
			}
		}
		if (!NumericUtils.equal(super.getId(), 0)) {
			sbuff.append("</ul>");
		}
	}
	
	public static void buildMenuTree(SecureResources menu, List<SecureResources> secureResourcesList)
	{
		Iterator<SecureResources> iter = secureResourcesList.iterator();
		while(iter.hasNext())
		{
			SecureResources po = iter.next();
			if (NumericUtils.equal(po.getParentId(), menu.getId()))
			{
				((SecureResourcesLogic) menu).addMenu(po);
				iter.remove();
				buildMenuTree(po, secureResourcesList);
			}
		}
	}

}
