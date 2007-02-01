/*
 * Created on 2005-3-25
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.eclipse.birt.core.framework.eclipse;

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.birt.core.framework.IBundle;
import org.osgi.framework.Bundle;


/**
 *
 */
public class EclipseBundle implements IBundle
{

	protected Bundle bundle;
	public EclipseBundle(Bundle bundle)
	{
		this.bundle = bundle;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.birt.core.framework.IBundle#loadClass(java.lang.String)
	 */
	public Class loadClass( String name ) throws ClassNotFoundException
	{
		return bundle.loadClass(name);
	}
	
	public URL getEntry (String name)
	{
		return bundle.getEntry(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.birt.core.framework.IBundle#getEntryPaths(java.lang.String)
	 */
	public Enumeration getEntryPaths(String path) {
		return bundle.getEntryPaths(path);
	}

}
