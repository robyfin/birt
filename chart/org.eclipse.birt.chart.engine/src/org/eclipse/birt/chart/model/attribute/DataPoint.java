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

package org.eclipse.birt.chart.model.attribute;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Point</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			This type represents the data value being displayed in the plot area for each data value.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.birt.chart.model.attribute.DataPoint#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.birt.chart.model.attribute.DataPoint#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.birt.chart.model.attribute.DataPoint#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.birt.chart.model.attribute.DataPoint#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.birt.chart.model.attribute.AttributePackage#getDataPoint()
 * @model extendedMetaData="name='DataPoint' kind='elementOnly'"
 * @generated
 */
public interface DataPoint extends EObject
{

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list. The list contents are of
	 * type {@link org.eclipse.birt.chart.model.attribute.DataPointComponent}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Specifies the components (values) being shown in the data label.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eclipse.birt.chart.model.attribute.AttributePackage#getDataPoint_Components()
	 * @model type="org.eclipse.birt.chart.model.attribute.DataPointComponent" containment="true" resolveProxies="false"
	 *        required="true"
	 * @generated
	 */
	EList<DataPointComponent> getComponents( );

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					Specifies the prefix for the data label.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.birt.chart.model.attribute.AttributePackage#getDataPoint_Prefix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Prefix'"
	 * @generated
	 */
	String getPrefix( );

	/**
	 * Sets the value of the '{@link org.eclipse.birt.chart.model.attribute.DataPoint#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix( String value );

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 					Specifies the suffix for the data label.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.eclipse.birt.chart.model.attribute.AttributePackage#getDataPoint_Suffix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Suffix'"
	 * @generated
	 */
	String getSuffix( );

	/**
	 * Sets the value of the '{@link org.eclipse.birt.chart.model.attribute.DataPoint#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix( String value );

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc -->
	 * 
	 * Specifies the separator used in the data label.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #setSeparator(String)
	 * @see org.eclipse.birt.chart.model.attribute.AttributePackage#getDataPoint_Separator()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	String getSeparator( );

	/**
	 * Sets the value of the '{@link org.eclipse.birt.chart.model.attribute.DataPoint#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator( String value );

} // DataPoint
