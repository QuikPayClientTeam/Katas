package friday13.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtils {

	private static HashMap<String, ResourceBundle> resourceBundles = new HashMap<String, ResourceBundle>();

	private ResourceBundleUtils(){}

	/**
	 * Returns a resourceBundle object from the current directory.
	 * If the file is in a folder,
	 * use getResourceBundle(String path, String name) instead.
	 * @param name Name of the file (assumed .properties extension)
	 * @return ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String name) {
		return getResourceBundle(getCurrentDirectory(), name);
	}

	/**
	 * Returns a resourceBundle object from a directory located
	 * inside the current directory.
	 * @param filePath Name of the directory (i.e. dir1/dir2)
	 * @param name Name of the file (assumed .properties extension)
	 * @return ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String filePath, String name) {
		ResourceBundle resourceBundle = resourceBundles.get(name);
		if (resourceBundle == null){
			if (filePath.substring(filePath.length() - 1) != Constants.SEPARATOR){
				filePath += Constants.SEPARATOR;
			}
			resourceBundle = loadResourceBundle(getCurrentDirectory() + filePath, name);
			resourceBundles.put(name, resourceBundle);
		}
		return resourceBundle;
	}

	private static ResourceBundle loadResourceBundle(String filePath, String fileName) {
		try {
			File file = new File(filePath);
			URL[] urls = {file.toURI().toURL()};
			ClassLoader loader = new URLClassLoader(urls);
			ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName, Locale.getDefault(), loader);
			return resourceBundle;
		} catch (Exception exception) {
			//logger.error("Error loading file " + fileName);
		}
		return null;
	}

	private static String getCurrentDirectory() {
		return System.getProperty(Constants.SYSTEM_USER_DIRECTORY) + Constants.SEPARATOR;
	}

}
