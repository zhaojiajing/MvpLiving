package com.pick.library.utils;

import android.os.CountDownTimer;
import android.widget.Button;

public class TimeCount extends CountDownTimer {
	private Button btSend;
	private static long millisLast = 100000;
	public TimeCount(long millisInFuture, long countDownInterval, Button btn) {
		super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		btSend = btn;
	}
	/**
	 *  
	 * @param countDownInterval 计时时间间隔
	 * @param btn  button
	 */

	public TimeCount(long countDownInterval, Button btn) {
	//	super(millisLast, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		super(countDownInterval*1000, countDownInterval);
		btSend = btn;
	}

	/**
	 * 计时完毕
	 */
	@Override
	public void onFinish() {// 计时完毕时触发
		btSend.setText("重新获取");
		btSend.setAlpha(1.0f);
		btSend.setClickable(true);
	}
	/**
	 * 计时过程显示
	 */
	@Override
	public void onTick(long millisUntilFinished) {// 计时过程显示
		btSend.setAlpha(0.5f);
		btSend.setClickable(false);
		btSend.setText(millisUntilFinished / 1000 + "秒");
	}
}