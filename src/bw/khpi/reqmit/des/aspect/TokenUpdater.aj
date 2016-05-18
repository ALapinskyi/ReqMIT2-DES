package bw.khpi.reqmit.des.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;
import bw.khpi.reqmit.des.utils.XMLUtils;

public aspect TokenUpdater {

	private ServerService service = new ServerServiceImpl();

	@Before("execution(* bw.khpi.reqmit.des.service.ServerServiceImpl.*(..))"
			+ "&& !execution(* bw.khpi.reqmit.des.service.ServerServiceImpl.getAuthentication(..))"
			+ "&& !execution(* bw.khpi.reqmit.des.service.ServerServiceImpl.saveUser(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("method : " + joinPoint.getSignature().getName());
		User user = XMLUtils.loadUser();
		if (user != null) {
			user = service.getAuthentication(new User(user.getUsername(), user.getPassword()));
			XMLUtils.saveUser(user);
		}
	}
}
