/***********************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/
package org.eclipse.birt.report.engine.layout.area;

import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IStyle;

public interface IArea
{
	/**
	 * get content object.
	 * @return
	 */
	IContent getContent();
	
	IStyle getStyle();
	
	int getX();
	
	int getY();
	
	int getWidth();
	
	int getHeight();
	
	void accept(IAreaVisitor visitor);
	
	float getScale();

}
