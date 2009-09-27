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
package com.xpn.xwiki.plugin.watchlist;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.plugin.XWikiDefaultPlugin;
import com.xpn.xwiki.plugin.XWikiPluginInterface;
import com.xpn.xwiki.web.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xwiki.observation.ObservationManager;

/**
 * Plugin that offers WatchList features to XWiki. These feature allow users to build lists of pages and spaces they
 * want to follow. At a frequency choosen by the user XWiki will send an email notification to him with a list of the
 * elements that has been modified since the last notification.
 * 
 * @version $Id$
 */
public class WatchListPlugin extends XWikiDefaultPlugin implements XWikiPluginInterface
{
    /**
     * Plugin name.
     */
    public static final String ID = "watchlist";   
    
    /**
     * Prefix used in ApplicationResources for this plugin.
     */
    public static final String APP_RES_PREFIX = "watchlist.";

    /**
     * Default XWiki Administrator.
     */
    public static final String DEFAULT_DOC_AUTHOR = "superadmin";

    /**
     * Default parent to use for class pages.
     */
    public static final String DEFAULT_CLASS_PARENT = "XWiki.XWikiClasses";
    
    /**
     * Logger.
     */
    private static final Log LOG = LogFactory.getLog(WatchListPlugin.class);
        
    /**
     * Job manager instance.
     */
    private final WatchListJobManager jobManager = new WatchListJobManager();
    
    /** 
     * Store instance.
     */
    private WatchListStore store = new WatchListStore();
    
    /**
     * Notifier instance.
     */
    private WatchListNotifier notifier = new WatchListNotifier();
    
    /**
     * Feed manager instance.
     */
    private WatchListEventFeedManager feedManager = new WatchListEventFeedManager(this);

    /**
     * {@inheritDoc}
     * 
     * @see XWikiDefaultPlugin#XWikiDefaultPlugin(String,String,com.xpn.xwiki.XWikiContext)
     */
    public WatchListPlugin(String name, String className, XWikiContext context)
    {
        super(name, className, context);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.plugin.XWikiDefaultPlugin#getName()
     */
    public String getName()
    {
        return ID;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.plugin.XWikiDefaultPlugin#init(XWikiContext)
     */
    public void init(XWikiContext context)
    {
        super.init(context);               
        
        try {
            jobManager.init(context);
            store.init(context);
            Utils.getComponent(ObservationManager.class).addListener(store);
        } catch (XWikiException e) {
            LOG.error("init", e);
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.plugin.XWikiDefaultPlugin#virtualInit(XWikiContext)
     */
    public void virtualInit(XWikiContext context)
    {
        super.virtualInit(context);
        try {            
            store.virtualInit(context);
        } catch (XWikiException e) {
            LOG.error("virtualInit", e);
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.plugin.XWikiDefaultPlugin#getPluginApi(XWikiPluginInterface, XWikiContext)
     */
    public WatchListPluginApi getPluginApi(XWikiPluginInterface plugin, XWikiContext context)
    {
        return new WatchListPluginApi((WatchListPlugin) plugin, context);
    }
    
    /**
     * @return the job manager instance.
     */
    public WatchListJobManager getJobManager()
    {
        return jobManager;
    }

    /**
     * @return the store instance.
     */
    public WatchListStore getStore()
    {
        return store;
    }
    
    /**
     * @return the notifier instance.
     */    
    public WatchListNotifier getNotifier()
    {
        return notifier;
    }
    
    /**
     * @return the feed manager instance.
     */    
    public WatchListEventFeedManager getFeedManager()
    {
        return feedManager;
    }
}
