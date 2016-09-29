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
			new ClassAndName(MapLayerActivity.class, "����ͼ��"),
			new ClassAndName(CircleOverlayActivity.class, "Բ�θ�����"),
			new ClassAndName(TextOverlayActivity.class, "���ָ�����"),
			new ClassAndName(MarkerOverlayActivity.class, "��ע������"),
			new ClassAndName(SearchInBoundActivity.class, "�ڷ�Χ������"),
			new ClassAndName(SearchInCityActivity.class, "�ڳ���������"),
			new ClassAndName(SearchInNearbyActivity.class, "���ܱ�����"),
			new ClassAndName(DrivingSearchActivity.class, "�ݳ�·��ͼ"),
			new ClassAndName(TransitSearchActivity.class, "����·��ͼ"),
			new ClassAndName(WalkingSearchActivity.class, "����·��ͼ"),
			new ClassAndName(LocationActivity.class, "��λ")};

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
					Toast.makeText(getApplicationContext(), "�������",
							Toast.LENGTH_SHORT);
				}
				if (action == SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR) {
					Toast.makeText(getApplicationContext(), "key��֤ʧ��",
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
		/** ���ڱ���Activity���ֽ��� */
		public Class<?> clazz;
		/** ���ڱ���Activity��Ӧ������ */
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
