package webServices;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("bet")
public class KladionicaApplication extends Application{

	/*
	 * 	this configure RestEasy JAX-RS class
	 *  
	 *  by default configuration looks for all classes with @Path annotation
	 *  if you want exclude some you must override getClasses method
	 *  
	//*/	
//		@Override
//		public Set<Class<?>> getClasses() {
//			// return set of classes that you need
//			return new HashSet<Class<?>>(); //return empty set!
//		}
	
}
