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
		// ��activityִ��onDestroyʱִ��mMapView.onDestroy()��ʵ�ֵ�ͼ�������ڹ���
		mMapView.onDestroy();

	}

	@Override
	protected void onResume() {
		super.onResume();
		// ��activityִ��onResumeʱִ��mMapView. onResume ()��ʵ�ֵ�ͼ�������ڹ���
		mMapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// ��activityִ��onPauseʱִ��mMapView. onPause ()��ʵ�ֵ�ͼ�������ڹ���
		mMapView.onPause();
	}
}
