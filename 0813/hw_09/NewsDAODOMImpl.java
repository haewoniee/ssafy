package com.ssafy.HW.hw_09;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	
	List<News> list = new ArrayList<News>();
	News n;
	Document doc;

	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		try
		{
			Element rss = doc.getDocumentElement();
			NodeList items = rss.getElementsByTagName("item");

			for (int i = 0; i < items.getLength(); i++)
			{
				Element item = (Element)(items.item(i));
				n = new News();
				
				NodeList attrs = item.getChildNodes();
				for (int j = 0; j < attrs.getLength(); j++)
				{
					Node node = attrs.item(j);
					if (node.getNodeType() == Node.ELEMENT_NODE)
					{
						Element attr = (Element)node;
						if (attr.getNodeName().equals("title"))
						{
							n.setTitle(attr.getTextContent());
						}
						else if (attr.getNodeName().equals("link"))
						{
							n.setLink(attr.getTextContent());
						}
						else if (attr.getNodeName().equals("description"))
						{
							n.setDesc(attr.getTextContent());
						}
					}
				}
				list.add(n);
			}
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
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}


}
