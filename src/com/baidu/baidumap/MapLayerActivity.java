package com.baidu.baidumap;

import com.baidu.mapapi.map.BaiduMap;

public class MapLayerActivity extends BaseActivity {

	@Override
	public void init() {
		// TODO Auto-generated method stub

		// ��ʾ����ͼ
				baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
			    baiduMap.setTrafficEnabled(false);
	}
	
				

}
