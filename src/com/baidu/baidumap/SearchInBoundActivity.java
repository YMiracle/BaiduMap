package com.baidu.baidumap;

import android.widget.Toast;

import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;


public class SearchInBoundActivity extends PoiBaseActivity implements OnGetPoiSearchResultListener {

	
	

	@Override
	public void init() {
		super.init();
		mPoiSearch.searchInBound(getSearchParams());
	}

	private PoiBoundSearchOption getSearchParams() {
		PoiBoundSearchOption params = new PoiBoundSearchOption();
		LatLngBounds bounds = new LatLngBounds.Builder()
				.include(hhl)
				.include(wcjt).build();
		params.bound(bounds); // 
		params.keyword("√¿ ≥"); // 
		return params;
	}


}
