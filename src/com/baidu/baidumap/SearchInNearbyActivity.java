package com.baidu.baidumap;

import com.baidu.mapapi.search.poi.PoiNearbySearchOption;

public class SearchInNearbyActivity extends PoiBaseActivity {

	@Override
	public void init() {
		
		super.init();
		mPoiSearch.searchNearby(getSearchParams());
	}

	private PoiNearbySearchOption getSearchParams() {
		PoiNearbySearchOption option = new PoiNearbySearchOption();
		option.location(hhl);
		option.radius(1000);
		option.keyword("…Ã≥°");
		return option;
	}
}
