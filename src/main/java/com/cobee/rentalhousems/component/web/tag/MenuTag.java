package com.cobee.rentalhousems.component.web.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.entity.logical.SecureResourcesLogic;
import com.cobee.rentalhousems.util.NumericUtils;

public class MenuTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8305533908309724598L;
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);
	
	private SecureResources menus;

	public void setMenus(SecureResources menus) {
		this.menus = menus;
	}

	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspTagException {
		
		try {
			JspWriter out = this.pageContext.getOut();
			if(menus != null)
			{
				StringBuilder sbuff = new StringBuilder();
				buildWebContent(sbuff, (SecureResourcesLogic) menus);
				out.print(sbuff.toString());
			}
			else
			{
				out.print("");
			}
			
		} catch (IOException e) {
			logger.error("", e);
		}
		
		return EVAL_PAGE;
	}

	private void buildWebContent(StringBuilder sbuff, SecureResourcesLogic root) {
		String ctxPath = this.pageContext.getServletContext().getContextPath();
		if (!NumericUtils.equal(root.getId(), 0)) {
			sbuff.append("<ul>");
			
			sbuff.append("<li><a href=\"" + ctxPath + root.getSrcurl() + "\" >" + root.getName() + "</a></li>");
		}
		if (!CollectionUtils.isEmpty(root.getMenuList())) {
			for (SecureResources po : root.getMenuList()) {
				buildWebContent(sbuff, (SecureResourcesLogic) po);
			}
		}
		if (!NumericUtils.equal(root.getId(), 0)) {
			sbuff.append("</ul>");
		}
	}
	
}
