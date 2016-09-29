package com.baidu.baidumap;

import java.util.List;

import android.widget.Toast;

import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;

public class DrivingSearchActivity extends RoutePlanSearchBaseActivity {


	@Override
	public void routePlanSearchInit() {
		// TODO Auto-generated method stub
		routePlanSearch.drivingSearch(getSearchParam());
	}

	private DrivingRoutePlanOption getSearchParam() {
		DrivingRoutePlanOption option = new DrivingRoutePlanOption();
		option.from(PlanNode.withCityNameAndPlaceName("�人", "�ƺ�¥"));
		option.to(PlanNode.withCityNameAndPlaceName("�人", "�����̲"));
		return option;
	}

	@Override
	public void onGetBikingRouteResult(BikingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult result) {
		if (result == null || result.error != DrivingRouteResult.ERRORNO.NO_ERROR) {  
            Toast.makeText(getApplicationContext(), "��Ǹ��δ�ҵ����", Toast.LENGTH_SHORT).show();  
		}
		if (result.error == DrivingRouteResult.ERRORNO.NO_ERROR) {
		DrivingRouteOverlay overlay = new DrivingRouteOverlay(baiduMap);
		baiduMap.setOnMarkerClickListener(overlay);
		List<DrivingRouteLine> routeLines = result.getRouteLines();	// ��ȡ�����е�����·�ߣ����Ż���·�߻��ڼ��ϵ�ǰ��
		overlay.setData(routeLines.get(0));	// ������������õ�������
		overlay.addToMap();					// �����������ӵ���ͼ
		overlay.zoomToSpan();				// �����������һ����Ļ����ʾ��
		}
	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

}
