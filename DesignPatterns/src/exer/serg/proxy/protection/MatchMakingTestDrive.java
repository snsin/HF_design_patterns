package exer.serg.proxy.protection;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {
	
	HashMap<String, PersonBean> datingDB = new HashMap<>();
	
	public static void main(String[] args) {
		new MatchMakingTestDrive().drive();
	}
	
	public MatchMakingTestDrive() {
		initializeDatabase();
	}

	private void drive() {
		PersonBean joe = getPersonFromDatabase("Joe Javabean"); 
		PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
		
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
	
	PersonBean getPersonFromDatabase(String name) {
		return (PersonBean)datingDB.get(name);
	}

	void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}

}
