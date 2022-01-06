package com.study.springcore.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 動態代理
public class DynProxy {
	// 被代理物件
	private Object obj;

	public DynProxy(Object object) {
		this.obj = object;
	}

	// 取得代理物件
	public Object getProxy() {
		// 1. 類別載入器
		ClassLoader loader = obj.getClass().getClassLoader();
		// 2. 目標所實作的介面
		Class[] interfaces = obj.getClass().getInterfaces();
		// 3. 處理代理的實現 (InvocationHandler)
		InvocationHandler handler = (Object proxy, Method method, Object[] args)->{
			
			Object result=null;
			
			// 代理代用被代理物件(目標)的業務方法
			result=method.invoke(obj, args);
			
			return result;
		};
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObject;
	}
}
