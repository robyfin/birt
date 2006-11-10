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

package org.eclipse.birt.report.engine.layout.pdf;

import java.util.Iterator;

import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IRowContent;
import org.eclipse.birt.report.engine.content.IStyle;
import org.eclipse.birt.report.engine.executor.IReportItemExecutor;
import org.eclipse.birt.report.engine.layout.IInlineStackingLayoutManager;
import org.eclipse.birt.report.engine.layout.ILayoutManager;
import org.eclipse.birt.report.engine.layout.IPDFTableLayoutManager;
import org.eclipse.birt.report.engine.layout.area.IArea;
import org.eclipse.birt.report.engine.layout.area.impl.AbstractArea;
import org.eclipse.birt.report.engine.layout.area.impl.AreaFactory;
import org.eclipse.birt.report.engine.layout.area.impl.CellArea;
import org.eclipse.birt.report.engine.layout.area.impl.RowArea;

public class PDFRowLM extends PDFInlineStackingLM
		implements
			IInlineStackingLayoutManager
{
	protected IPDFTableLayoutManager tbl;
	protected int rowID;

	protected boolean clear = false;

	public PDFRowLM( PDFLayoutEngineContext context, PDFStackingLM parent,
			IContent content, IReportItemExecutor executor )
	{
		super( context, parent, content, executor );
		tbl = getTableLayoutManager( );
		rowID = ( (IRowContent) content ).getRowID( );
		calculateSpecifiedHeight( );
		tbl.startRow( (IRowContent) content );

	}
	
	public boolean layout()
	{
		boolean childBreak = super.layout( );
		if ( childBreak )
		{
			if ( tbl != null )
			{
				if ( !isFinished( ) && needPageBreakBefore(null ) )
				{
					tbl.setTableCloseStateAsForced( );
				}
				else if ( isFinished( ) && needPageBreakAfter(null ) )
				{
					tbl.setTableCloseStateAsForced( );
				}
			}
		}
		return childBreak;
	}
	
	protected boolean checkAvailableSpace( )
	{
		boolean availableSpace = super.checkAvailableSpace( );
		if(availableSpace && tbl != null)
		{
			tbl.setTableCloseStateAsForced( );
		}
		return availableSpace;
	}

	protected void calculateSpecifiedHeight( )
	{
		super.calculateSpecifiedHeight( );
		if ( specifiedHeight == 0 )
		{
			IStyle style = content.getComputedStyle( );
			int fontSize = getDimensionValue( style
					.getProperty( IStyle.STYLE_FONT_SIZE ) );
			specifiedHeight = fontSize;
		}
	}

	protected void createRoot( )
	{
		root = AreaFactory.createRowArea( (IRowContent) content );
	}

	protected void initialize( )
	{
		if(root==null)
		{
			createRoot( );
		}
		maxAvaWidth = parent.getCurrentMaxContentWidth( );
		root.setWidth( getCurrentMaxContentWidth( ) );
		root.setAllocatedHeight( parent.getCurrentMaxContentHeight( ));
		maxAvaHeight = root.getContentHeight( );

	}

	protected boolean traverseChildren( )
	{
		boolean childBreak = false;
		// first loop
		if ( children.size( ) == 0 )
		{
			while ( executor.hasNextChild( ) )
			{
				IReportItemExecutor childExecutor = executor.getNextChild( );
				IContent childContent = childExecutor.execute( );
				PDFAbstractLM childLM = getFactory( ).createLayoutManager(
						this, childContent, childExecutor );
				addChild( childLM );
				if ( childLM.layout( ) && !childBreak )
				{
					childBreak = true;
				}
			}
		}
		else
		{
			if ( !isRowFinished( ) )
			{
				for ( int i = 0; i < children.size( ); i++ )
				{
					ILayoutManager childLM = (ILayoutManager) children.get( i );
					if ( childLM.layout( ) && !childBreak )
					{
						childBreak = true;
					}
				}
			}
		}
		return childBreak;
	}

	protected void closeLayout( )
	{
		if(root!=null)
		{
			tbl.updateRow( (RowArea) root, specifiedHeight );
		}
	}

	protected boolean isHidden( )
	{
		return isHiddenByVisibility( );
	}

	public boolean addArea( IArea area, boolean keepWithPrevious, boolean keepWithNext )
	{
		submit((AbstractArea)area);
		return true;
	}

	protected boolean isRowFinished( )
	{
		for ( int i = 0; i < children.size( ); i++ )
		{
			PDFAbstractLM lm = (PDFAbstractLM) children.get( i );
			if ( lm != null )
			{
				if ( !lm.isFinished( ) )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean hasNextChild()
	{
		if(children.size( )>0)
		{
			return !isRowFinished( );
		}
		return true;
				
	}

	protected boolean isRootEmpty()
	{

		if(pageBreakInsideAvoid( ))
		{
			if(this.isRowFinished( ))
			{
				return false;
			}
			if(!context.isAutoPageBreak( ))
			{
				return false;
			}
			return true;
		}
		else
		{
			Iterator iter = root.getChildren( );
			while(iter.hasNext( ))
			{
				CellArea cell = (CellArea)iter.next();
				if(cell.getChildrenCount( )>0)
				{
					return false;
				}
			}
			if(this.isRowFinished( ))
			{
				return false;
			}
			return true;
		}
	}
	
	public void submit(AbstractArea area)
	{
		CellArea cArea = (CellArea) area;
		root.addChild( area );
		cArea.setPosition( tbl.getXPos( cArea.getColumnID( ) ), 0 );
	}

	protected boolean clearCache( )
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	

}