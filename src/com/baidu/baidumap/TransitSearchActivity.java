package com.baidu.baidumap;

import java.util.List;

import android.widget.Toast;

import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRoutePlanOption.TransitPolicy;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;

public class TransitSearchActivity extends RoutePlanSearchBaseActivity {

	@Override
	public void routePlanSearchInit() {
		routePlanSearch.transitSearch(getSearchParam());

	}

	private TransitRoutePlanOption getSearchParam() {
		TransitRoutePlanOption option = new TransitRoutePlanOption();
		option.city("�人");
		option.policy(TransitPolicy.EBUS_TIME_FIRST);
		option.from(PlanNode.withCityNameAndPlaceName("�人", "�ƺ�¥"));
		option.to(PlanNode.withCityNameAndPlaceName("�人", "�����̲"));

		return option;
	}

	@Override
	public void onGetBikingRouteResult(BikingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {
		if (result == null
				|| result.error != TransitRouteResult.ERRORNO.NO_ERROR) {
			Toast.makeText(getApplicationContext(), "��Ǹ��δ�ҵ����",
					Toast.LENGTH_SHORT).show();
		}
		if (result.error == TransitRouteResult.ERRORNO.NO_ERROR) {
			TransitRouteOverlay overlay = new TransitRouteOverlay(baiduMap) ;
			baiduMap.setOnMarkerClickListener(overlay);
			List<TransitRouteLine> routeLines = result.getRouteLines(); // ��ȡ�����е�����·�ߣ����Ż���·�߻��ڼ��ϵ�ǰ��
			overlay.setData(routeLines.get(0)); // ������������õ�������
			overlay.addToMap(); // �����������ӵ���ͼ
			overlay.zoomToSpan(); // �����������һ����Ļ����ʾ��
		}

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

}
