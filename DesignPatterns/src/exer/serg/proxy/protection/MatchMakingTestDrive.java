package exer.serg.proxy.protection;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
	
	public static void main(String[] args) {
		new MatchMakingTestDrive().drive();
	}

	private void drive() {
		// TODO Auto-generated method stub
		
	}
	
	PersonBean getOwnerProxy(PersonBean person) {
		Class<? extends PersonBean> personClass = person.getClass();
		return (PersonBean) Proxy.newProxyInstance(personClass.getClassLoader(), 
				personClass.getInterfaces(), new OwnerInvocationHandler(person));
	}
	
	PersonBean getNonOwnerProxy(PersonBean person) {
		Class<? extends PersonBean> personClass = person.getClass();
		return (PersonBean) Proxy.newProxyInstance(personClass.getClassLoader(), 
				personClass.getInterfaces(), new NonOwnerInvocationHandler(person));
	}

}
