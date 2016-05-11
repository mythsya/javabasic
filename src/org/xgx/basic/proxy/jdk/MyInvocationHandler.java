package org.xgx.basic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.xgx.basic.proxy.UserService;
import org.xgx.basic.proxy.UserServiceImpl;

public class MyInvocationHandler implements InvocationHandler {

	public static void main(final String[] args) {
		UserService userService = new UserServiceImpl();
		MyInvocationHandler invocatioHandler = new MyInvocationHandler(userService);
		UserService proxy = (UserService) invocatioHandler.getProxy();
		proxy.add();
	}

	private Object target;

	public MyInvocationHandler(final Object target) {
		this.target = target;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		System.out.println("-------- before ---------");
		Object result = method.invoke(target, args);
		System.out.println("--------   end  ---------");
		return result;
	}
}
