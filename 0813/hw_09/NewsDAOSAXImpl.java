package com.ssafy.HW.hw_09;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class NewsDAOSAXImpl implements INewsDAO {

	List<News> list;
	URL newsURL;
	
	@Override
	public List<News> getNewsList(String url) {
		try {
			connectNews(url);
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
			InputStream input = newsURL.openStream();
			
			SAXParser parser = spf.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(input, handler);
			
			list = handler.getNews();
			input.close();
			
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}
	
	void connectNews(String url)
	{
		try {
			newsURL = new URL(url);
			URLConnection connection = newsURL.openConnection();
			connection.setRequestProperty("CONNECT-TYPE", "text/xml");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
