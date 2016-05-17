package exer.serg.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {
	
	private PersonBean person;

	public NonOwnerInvocationHandler(PersonBean person) {
		this.person =  person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
		try {
			if ("setHotOrNotRating".equals(method.getName()) 
					|| method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else {
				throw new IllegalAccessException();
			}
		} catch (IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
