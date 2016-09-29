package com.baidu.baidumap;

import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

public class MarkerOverlayActivity extends BaseActivity {
	private View pop;
	private TextView tv_title;
	

	@Override
	public void init() {
		initMarker();
		baiduMap.setOnMarkerClickListener(markerClickListener);
		baiduMap.setOnMarkerDragListener(mOnMarkerDragListener);

	}
OnMarkerDragListener mOnMarkerDragListener = new OnMarkerDragListener() {
		
		@Override
		public void onMarkerDragStart(Marker marker) {
			// TODO Auto-generated method stub
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
		}
		
		@Override
		public void onMarkerDragEnd(Marker marker) {
			// TODO Auto-generated method stub
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
		}
		
		@Override
		public void onMarkerDrag(Marker marker) {
			// TODO Auto-generated method stub
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
	};


	OnMarkerClickListener markerClickListener = new OnMarkerClickListener() {

		@Override
		public boolean onMarkerClick(Marker marker) {

			if (pop == null) {
				pop = View.inflate(MarkerOverlayActivity.this, R.layout.pop,
						null);
				tv_title = (TextView) pop.findViewById(R.id.tv_title);
				mMapView.addView(pop, createLayoutParams(marker.getPosition()));
			} else {
				mMapView.updateViewLayout(pop,
						createLayoutParams(marker.getPosition()));
			}
			tv_title.setText(marker.getTitle());
			return true;
		}
	};

	private void initMarker() {
		MarkerOptions options = new MarkerOptions();
		options.position(hhl);
		BitmapDescriptor icon = BitmapDescriptorFactory
				.fromResource(R.drawable.agn);
		options.icon(icon);
		options.title("�ƺ�¥");
		options.draggable(true);
		baiduMap.addOverlay(options);
		
		options = new MarkerOptions();
		options.position(wcjt);
		options.icon(icon);
		options.title("�����̲");
		options.draggable(true);
		baiduMap.addOverlay(options);

	}

	private MapViewLayoutParams createLayoutParams(LatLng position) {
		MapViewLayoutParams.Builder buidler = new MapViewLayoutParams.Builder();
		buidler.layoutMode(ELayoutMode.mapMode); // ָ����������Ϊ��γ��
		buidler.position(position); // ���ñ�־��λ��
		buidler.yOffset(-25); // ����View����ƫ��
		MapViewLayoutParams params = buidler.build();
		return params;
	}

}
