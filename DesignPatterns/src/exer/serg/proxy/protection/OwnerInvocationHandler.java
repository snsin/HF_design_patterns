package exer.serg.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {
	
	private PersonBean person;

	public OwnerInvocationHandler(PersonBean person) {
		this.person =  person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if ("setHotOrNotRating".equals(method.getName())) {
				throw new IllegalAccessException();
			} else {
				return method.invoke(person, args);
			}
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
