package com.liferay.test;

import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portlet.wiki.util.WikiUtil;
import com.liferay.portal.util.PortalUtil;

public class AssetPubliserUtilTest {

    public void assetPubliserUtilTest() {
    	AssetPublisherUtil.getEntries(new HitsImpl());
    	AssetPublisherUtil.foo();
    }

}
