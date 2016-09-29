package com.baidu.baidumap;

import com.baidu.mapapi.map.TextOptions;

public class TextOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		TextOptions options = new TextOptions();
		options.position(hhl);
		options.fontSize(30);
		options.text("»Æº×Â¥");
		options.fontColor(0XFFFF0000);
		options.rotate(30);
		baiduMap.addOverlay(options);
	}

}
