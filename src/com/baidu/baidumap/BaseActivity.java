package com.baidu.baidumap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

import android.app.Activity;

import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends Activity {

	protected MapView mMapView;
	protected BaiduMap baiduMap;
	protected LatLng hhl = new LatLng(30.550239, 114.309052);
	protected LatLng hhld = new LatLng(30.561239, 114.509052);
	protected LatLng wcjt = new LatLng(30.561712, 114.305768);
	private MapStatusUpdate statusUpdate;

	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		mMapView = (MapView) this.findViewById(R.id.bmapView);
		baiduMap = mMapView.getMap();
		statusUpdate = MapStatusUpdateFactory.newLatLng(hhl);
		baiduMap.setMapStatus(statusUpdate);
		statusUpdate = MapStatusUpdateFactory.zoomTo(15);
        baiduMap.setMapStatus(statusUpdate);
		init();
 
	}

	public abstract void init();

	protected void showToast(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
		mMapView.onDestroy();

	}

	@Override
	protected void onResume() {
		super.onResume();
		// 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
	}
}
