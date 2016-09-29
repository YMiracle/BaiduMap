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
		
	
		List<WalkingRouteLine> routeLines = result.getRouteLines();	// 获取到所有的搜索路线，最优化的路线会在集合的前面
		overlay.setData(routeLines.get(0));	// 把搜索结果设置到覆盖物
		overlay.addToMap();					// 把搜索结果添加到地图
		overlay.zoomToSpan();				// 把搜索结果在一个屏幕内显示完
		
	}

	@Override
	public void routePlanSearchInit() {
		routePlanSearch.walkingSearch(getSearchParams());
		
	}
	private WalkingRoutePlanOption getSearchParams() {
		WalkingRoutePlanOption option = new WalkingRoutePlanOption();
		option.from(PlanNode.withCityNameAndPlaceName("武汉", "黄鹤楼"));
		option.to(PlanNode.withCityNameAndPlaceName("武汉", "武昌江滩"));
		return option;
	}

}
