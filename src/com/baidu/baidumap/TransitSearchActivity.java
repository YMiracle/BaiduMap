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
		option.city("武汉");
		option.policy(TransitPolicy.EBUS_TIME_FIRST);
		option.from(PlanNode.withCityNameAndPlaceName("武汉", "黄鹤楼"));
		option.to(PlanNode.withCityNameAndPlaceName("武汉", "武昌江滩"));

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
			Toast.makeText(getApplicationContext(), "抱歉，未找到结果",
					Toast.LENGTH_SHORT).show();
		}
		if (result.error == TransitRouteResult.ERRORNO.NO_ERROR) {
			TransitRouteOverlay overlay = new TransitRouteOverlay(baiduMap) ;
			baiduMap.setOnMarkerClickListener(overlay);
			List<TransitRouteLine> routeLines = result.getRouteLines(); // 获取到所有的搜索路线，最优化的路线会在集合的前面
			overlay.setData(routeLines.get(0)); // 把搜索结果设置到覆盖物
			overlay.addToMap(); // 把搜索结果添加到地图
			overlay.zoomToSpan(); // 把搜索结果在一个屏幕内显示完
		}

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

}
