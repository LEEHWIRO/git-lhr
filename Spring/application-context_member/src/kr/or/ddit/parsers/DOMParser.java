package kr.or.ddit.parsers;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("D:/A_TeachingMaterial/6.JspSpring/workspace/application-context_member/WebContent/WEB-INF/application-context.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("Element name: " + root.getNodeName());
		
		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
				Element ele = (Element)node;
				String nodeName = ele.getNodeName();
				System.out.print("Element name: " + nodeName + ", ");
				if(nodeName.equals("bean")){
					System.out.print("Id: " + ele.getAttribute("id") + ", ");
					System.out.println("Class: " + ele.getAttribute("class"));
					if(ele.getChildNodes().getLength() >= 1){
						// 이름이 student인 노드는 자식노드가 더 존재함
						NodeList childeren2 = ele.getChildNodes();
						for(int a = 0; a < childeren2.getLength(); a++){
							Node node2 = childeren2.item(a);
							if(node2.getNodeType() == Node.ELEMENT_NODE){
								Element ele2 = (Element)node2;
								String nodeName2 = ele2.getNodeName();
								System.out.print(" Element name: " + nodeName2 + ", ");
								System.out.print(" name: " + ele2.getAttribute("name") + ", ");
								System.out.println(" ref-value: " + ele2.getAttribute("ref-value"));
							}
						}
					}
				}
			}
		}
	}
}