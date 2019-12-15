import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import org.apache.commons.io.IOUtils;

public class URLinformation {
	public static void main(String[] args)
	{
		getSkillLevels("Hello");
	}
	/*
	 * URL class simply holds a static method which opens up a URL to connect to and search a players name
	 * Object is not needed to use this method
	 * Uses the org.apache IOUtils in order to parse the encoding to a string
	 * the text is then split by a new line since the newline is not needed.
	 */
	public static String[] getSkillLevels(String theName)
	{
		String[] arr = {};
		try
		{
			URL webpage = new URL("https://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + theName);
			URLConnection con = webpage.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String text = IOUtils.toString(in, encoding);
			System.out.println(text);
			arr = text.split("\n");
			in.close();
		}
		catch(MalformedURLException e)
		{
			System.out.println("Error");
		}
		catch(IOException e)
		{
			System.out.println("Username not found.");
		}
		return arr;
	}
}
