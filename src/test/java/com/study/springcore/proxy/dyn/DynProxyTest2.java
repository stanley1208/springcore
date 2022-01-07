package com.study.springcore.proxy.dyn;

import java.net.Proxy;

import com.study.springcore.proxy.sta.Man;
import com.study.springcore.proxy.sta.Person;
import com.study.springcore.proxy.sta.Woman;

public class DynProxyTest2 {
	public static void main(String[] args) {

		Calc calc = (Calc) new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));
		System.out.println("---------------------------");
		// 自行可以維護錯誤
		Calc calc2 = (Calc) new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc2.div(10, 0));
	}
}
