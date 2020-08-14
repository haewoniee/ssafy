package com.ssafy.HW.hw_09;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	
	StringBuilder b = new StringBuilder();
	boolean itemFlag;
	boolean titleFlag;
	boolean descFlag;
	boolean linkFlag;
	News n;
	List<News> list = new ArrayList<News>();

	public List<News> getNews() {
		return list;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		if (qName.equals("item"))
		{
			itemFlag = true;
			n = new News();
		}
		else if (itemFlag && qName.equals("title"))
		{
			titleFlag = true;
		}
		else if (itemFlag && qName.equals("description"))
		{
			descFlag = true;
		}
		else if (itemFlag && qName.equals("link"))
		{
			linkFlag = true;
		}
		b = new StringBuilder();
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		b.append(new String(ch, start, length));									
	}
	

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (itemFlag)
		{
			if (titleFlag)
			{
				n.setTitle(b.toString());
				titleFlag = false;
			}
			else if (linkFlag)
			{
				n.setLink(b.toString());
				linkFlag = false;
			}
			else if (descFlag)
			{
				n.setDesc(b.toString());
				descFlag = false;
				itemFlag = false;
				list.add(n);
			}

		}
	}


}
