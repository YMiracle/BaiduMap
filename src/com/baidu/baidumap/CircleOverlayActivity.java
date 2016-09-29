package com.baidu.baidumap;

import android.graphics.Color;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;

public class CircleOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		CircleOptions options = new CircleOptions();
		options.center(hhl);
		options.radius(1000);
		options.fillColor(0X6600DD00);
		options.stroke(new Stroke(20, Color.BLUE));
		baiduMap.addOverlay(options);

	}

}
