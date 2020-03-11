package standardbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("start success");
		System.out.println("class loader:"+Thread.currentThread().getContextClassLoader().getSystemClassLoader());
		System.out.println("class loader:"+this.getClass().getClassLoader());
		ClassLoader loader = this.getClass().getClassLoader();
		System.out.println("---------------1------------------");

		while(loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}

	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
