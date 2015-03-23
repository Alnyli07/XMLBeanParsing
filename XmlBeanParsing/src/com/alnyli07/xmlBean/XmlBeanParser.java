package com.alnyli07.xmlBean;

import java.io.IOException;
import java.io.InputStream;

import org.openuri.currency.CurrencyRootDocument;
import org.openuri.currency.CurrencyRootDocument.CurrencyRoot;
import org.apache.xmlbeans.XmlException;



public class XmlBeanParser {
	

	public XmlBeanParser(){
		
	}
	
	public static void main(String[] args) {
		
		CurrencyRoot currroot = new XmlBeanParser().xmlParser();
		for (int i = 0; i < currroot.sizeOfCurrencyArray(); i++) {
			System.out.println(currroot.getCurrencyArray()[i].getCurencyName());
//			System.out.println(currroot.getCurrencyArray()[i].getBanknoteBuying());
//			System.out.println(currroot.getCurrencyArray()[i].getBanknoteSelling());
//			System.out.println(currroot.getCurrencyArray()[i].getFrom());
//			System.out.println(currroot.getCurrencyArray()[i].getTo());
		}
	}
	
	public CurrencyRoot xmlParser(){
		// get xml file from resources.
		 InputStream inptStream = getClass().getClassLoader().getResourceAsStream("resources/Currency.xml");
		CurrencyRootDocument   currencyRootDoc = null;
		try{
			
			currencyRootDoc =  CurrencyRootDocument.Factory.parse(inptStream);
			return currencyRootDoc.getCurrencyRoot();
		}catch(XmlException e){
			System.out.println(" XML exception cathed. ");
		} catch (IOException e){
			System.out.println(" IO  exception cathed. ");
		}
		return null;
	}

}
