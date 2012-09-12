/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.model.internal;

import org.xwiki.model.*;
import org.xwiki.model.Object;
import org.xwiki.model.reference.EntityReference;

import java.util.Locale;
import java.util.Map;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.doc.XWikiDocument;

/**
 * @since 4.3M1
 */
public class BridgedDocument extends AbstractBridgedEntity implements Document
{
    private XWikiDocument document;

    public BridgedDocument(XWikiDocument document, XWikiContext xcontext)
    {
        super(xcontext);
        this.document = document;
    }

    public Version getVersion()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public EntityIterator<Entity> getChildren(EntityType type)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public org.xwiki.model.Object addObject(String objectName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public ObjectDefinition addObjectDefinition(String objectDefinitionName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public Content getContent()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public Locale getLocale()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public Object getObject(String objectName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public ObjectDefinition getObjectDefinition(String objectDefinitionName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public EntityIterator<ObjectDefinition> getObjectDefinitions()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public EntityIterator<Object> getObjects()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public boolean hasObject(String objectName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public boolean hasObjectDefinition(String objectDefinitionName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public void removeObject(String objectName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public void removeObjectDefinition(String objectDefinitionName)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public void setContent(Content content)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public String getIdentifier()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public Entity getParent()
    {
        throw new ModelRuntimeException("Not supported");
    }

    public EntityReference getReference()
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public EntityReference getLinkReference()
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public void setLinkReference(EntityReference linkedReference)
    {
        throw new ModelRuntimeException("Not supported");
    }

    public EntityType getType()
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public void save(String comment, boolean isMinorEdit, Map<String, String> extraParameters)
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public void discard()
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public boolean isModified()
    {
        throw new ModelRuntimeException("Not supported");
    }

    @Override
    public boolean isNew()
    {
        return this.document.isNew();
    }

    @Override
    public void setNew(boolean isNew)
    {
        this.document.setNew(isNew);
    }

    @Override
    public boolean isRemoved()
    {
        throw new ModelRuntimeException("Not supported");
    }
}