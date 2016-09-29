package com.baidu.baidumap;

import java.util.List;

import android.widget.Toast;

import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;

public class WalkingSearchActivity extends RoutePlanSearchBaseActivity{

	@Override
	public void onGetBikingRouteResult(BikingRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		WalkingRouteOverlay overlay = new WalkingRouteOverlay(baiduMap);
		baiduMap.setOnMarkerClickListener(overlay);
		
	
		List<WalkingRouteLine> routeLines = result.getRouteLines();	// ��ȡ�����е�����·�ߣ����Ż���·�߻��ڼ��ϵ�ǰ��
		overlay.setData(routeLines.get(0));	// ������������õ�������
		overlay.addToMap();					// �����������ӵ���ͼ
		overlay.zoomToSpan();				// �����������һ����Ļ����ʾ��
		
	}

	@Override
	public void routePlanSearchInit() {
		routePlanSearch.walkingSearch(getSearchParams());
		
	}
	private WalkingRoutePlanOption getSearchParams() {
		WalkingRoutePlanOption option = new WalkingRoutePlanOption();
		option.from(PlanNode.withCityNameAndPlaceName("�人", "�ƺ�¥"));
		option.to(PlanNode.withCityNameAndPlaceName("�人", "�����̲"));
		return option;
	}

}
