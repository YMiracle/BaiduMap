package com.baidu.baidumap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;



import android.view.KeyEvent;

public class HelloBaiduMapActivity extends BaseActivity {

	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		MapStatusUpdate statusUpdate = null;
		switch (keyCode) {
		case KeyEvent.KEYCODE_1:
			statusUpdate = MapStatusUpdateFactory.zoomOut();
			break;
		case KeyEvent.KEYCODE_2:
			statusUpdate = MapStatusUpdateFactory.zoomIn();
			break;
		case KeyEvent.KEYCODE_3:
			MapStatus currentMapStatus = baiduMap.getMapStatus();
			float rotate = currentMapStatus.rotate + 30;
			MapStatus mapStatus = new MapStatus.Builder().rotate(rotate)
					.build();
			statusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
			break;
		case KeyEvent.KEYCODE_5:
			// 5) ÒÆ¶¯
			statusUpdate = MapStatusUpdateFactory.newLatLng(hhld);
			baiduMap.animateMapStatus(statusUpdate, 2000);
			return super.onKeyDown(keyCode, event);
		default:
			break;
		}
		baiduMap.setMapStatus(statusUpdate);
		return super.onKeyDown(keyCode, event);
	}


}
