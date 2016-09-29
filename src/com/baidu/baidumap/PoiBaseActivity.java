package com.baidu.baidumap;

import android.widget.Toast;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

public class PoiBaseActivity extends BaseActivity implements OnGetPoiSearchResultListener {
	protected PoiSearch mPoiSearch;
	@Override
	public void init() {
		mPoiSearch = PoiSearch.newInstance();
		mPoiSearch.setOnGetPoiSearchResultListener(this);

	}

	@Override
	public void onGetPoiDetailResult(PoiDetailResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetPoiIndoorResult(PoiIndoorResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetPoiResult(PoiResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			showToast("没有搜索到结果");
			return;
		}
		PoiOverlay poiOverlay = new PoiOverlay(baiduMap){
			@Override
			public boolean onPoiClick(int i) {
				PoiInfo poiInfo = getPoiResult().getAllPoi().get(i);
				Toast.makeText(getApplicationContext(), poiInfo.name+","+poiInfo.address, Toast.LENGTH_SHORT).show();
				return true;
			}
		};
		baiduMap.setOnMarkerClickListener(poiOverlay);
		poiOverlay.setData(result);
		poiOverlay.addToMap();
		poiOverlay.zoomToSpan();
		
	}

}
