package hostbundle;

import java.io.InputStream;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("hello hostbundle" );
		
		InputStream inputStream = Activator.class.getResourceAsStream("/META-INF/frgment-config.properties");
		Properties properties = new Properties();
		if (inputStream == null) {
			inputStream = Activator.class.getResourceAsStream("/META-INF/default-config.properties");
		}
		properties.load(inputStream);
		
		System.out.println("hello "+properties.getProperty("name"));
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
