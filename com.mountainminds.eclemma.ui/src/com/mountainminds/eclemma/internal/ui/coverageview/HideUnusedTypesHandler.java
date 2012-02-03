/*******************************************************************************
 * Copyright (c) 2006, 2012 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *    
 ******************************************************************************/
package com.mountainminds.eclemma.internal.ui.coverageview;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;

/**
 * Handler to toggle hide unused types in the coverage tree.
 */
class HideUnusedTypesHandler extends AbstractHandler implements IElementUpdater {

  public static final String ID = "com.mountainminds.eclemma.ui.hideUnusedTypes"; //$NON-NLS-1$

  private final ViewSettings settings;
  private final CoverageView view;

  public HideUnusedTypesHandler(ViewSettings settings, CoverageView view) {
    this.settings = settings;
    this.view = view;
  }

  public Object execute(ExecutionEvent event) throws ExecutionException {
    settings.setHideUnusedTypes(!settings.getHideUnusedTypes());
    view.refreshViewer();
    return null;
  }

  public void updateElement(UIElement element,
      @SuppressWarnings("rawtypes") Map parameters) {
    element.setChecked(settings.getHideUnusedTypes());
  }

}