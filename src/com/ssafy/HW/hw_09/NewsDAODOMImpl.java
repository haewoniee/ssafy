package com.ssafy.HW.hw_09;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class NewsDAODOMImpl implements INewsDAO {
	
	List<News> list;
	URL newsURL;

	@Override
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
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
