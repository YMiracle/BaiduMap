package com.baidu.baidumap;

import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiSearch;

public class SearchInCityActivity extends PoiBaseActivity {

	@Override
	public void init() {
		super.init();
		mPoiSearch.searchInCity(getSearchParams());

	}

	private PoiCitySearchOption getSearchParams() {
		PoiCitySearchOption option = new PoiCitySearchOption();
	    option.keyword("中国银行");
		option.city("武汉");
		option.pageCapacity(10);
		return option;
	}

}
