package com.baidu.baidumap;

import com.baidu.mapapi.SDKInitializer;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DemoListActivity extends ListActivity {
	private BroadcastReceiver receiver;
	private ClassAndName[] datas = {
			new ClassAndName(HelloBaiduMapActivity.class, "HelloBaiduMap"),
			new ClassAndName(MapLayerActivity.class, "卫星图层"),
			new ClassAndName(CircleOverlayActivity.class, "圆形覆盖物"),
			new ClassAndName(TextOverlayActivity.class, "文字覆盖物"),
			new ClassAndName(MarkerOverlayActivity.class, "标注覆盖物"),
			new ClassAndName(SearchInBoundActivity.class, "在范围内搜索"),
			new ClassAndName(SearchInCityActivity.class, "在城市内搜索"),
			new ClassAndName(SearchInNearbyActivity.class, "在周边搜索"),
			new ClassAndName(DrivingSearchActivity.class, "驾车路线图"),
			new ClassAndName(TransitSearchActivity.class, "换乘路线图"),
			new ClassAndName(WalkingSearchActivity.class, "步行路线图"),
			new ClassAndName(LocationActivity.class, "定位")};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		registerSDKCheckReceiver();
		ArrayAdapter<ClassAndName> adapter = new ArrayAdapter<ClassAndName>(
				this,android.R.layout.simple_list_item_1,
				datas);

		this.setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		ClassAndName classAndName = (ClassAndName) l
				.getItemAtPosition(position);
		startActivity(new Intent(this, classAndName.clazz));

	}

	public void registerSDKCheckReceiver() {
		receiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				String action = intent.getAction();
				if (action == SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR) {
					Toast.makeText(getApplicationContext(), "网络错误",
							Toast.LENGTH_SHORT);
				}
				if (action == SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR) {
					Toast.makeText(getApplicationContext(), "key验证失败",
							Toast.LENGTH_SHORT);
				}

			}
		};
		IntentFilter filter = new IntentFilter();
		filter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
		filter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
		registerReceiver(receiver, filter);

	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		super.onDestroy();
	}

	class ClassAndName {
		/** 用于保存Activity的字节码 */
		public Class<?> clazz;
		/** 用于保存Activity对应的名字 */
		public String name;

		public ClassAndName(Class<?> cls, String name) {
			this.clazz = cls;
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}
}
