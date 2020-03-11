package mainbundle;



import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ff.ffutil.FFUtil;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
		
		System.out.println("class loader:"+Thread.currentThread().getContextClassLoader().getSystemClassLoader());
		System.out.println("getContextClassLoader :"+Thread.currentThread().getContextClassLoader());
		/*org.eclipse.osgi.internal.framework.ContextFinder
		org.eclipse.osgi.internal.loader.EquinoxClassLoader  SystemModuleClassLoader  EquinoxClassLoade
		*/
		System.out.println("class loader:"+this.getClass().getClassLoader());
		ClassLoader loader = this.getClass().getClassLoader();
		System.out.println("---------------1------------------");

		while(loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
		
		
		System.out.println("---------------2------------------");
		System.out.println(Integer.class.getClassLoader());

		Set set = new HashSet();
		set.add("cornyu");
		System.out.println(set.getClass());
		System.out.println(set.getClass().getClassLoader());

		/*org.eclipse.osgi.internal.loader.EquinoxClassLoader@6dce272d[standardBundle:1.0.0.qualifier(id=1)]
        org.eclipse.osgi.internal.framework.EquinoxContainerAdaptor$1@a6a2534*/
		
		//org.eclipse.osgi.internal.framework.EquinoxContainerAdaptor
		
		System.out.println(FFUtil.sayHello());
		
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
