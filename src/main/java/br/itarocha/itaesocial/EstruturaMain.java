package br.itarocha.itaesocial;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class EstruturaMain {
	
	public static void main(String[] args) throws JDOMException, IOException {
		EstruturaMain e = new EstruturaMain();
	}
	
	public EstruturaMain() throws JDOMException, IOException {
		lerExemplo();
	}
	
	private void lerExemplo() throws JDOMException, IOException{
		String fileName = "exemplo.xml";
		ClassLoader cl = getClass().getClassLoader();
		File file = new File(cl.getResource(fileName).getFile());
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		Element root = (Element)doc.getRootElement();
		List pessoas = root.getChildren();
		Iterator i = pessoas.iterator();
		while (i.hasNext()) {
			Element pessoa = (Element) i.next();
	        System.out.println("Nome: " + pessoa.getChildText("nome"));
	        System.out.println("Sobrenome: " + pessoa.getChildText("sobrenome"));
	        System.out.println("Sexo: " + pessoa.getAttributeValue("sexo"));
	        System.out.println("Nota( teste1 ): "+pessoa.getChild("notas").getChildText("teste1"));
	        System.out.println("Nota( teste2 ): "+pessoa.getChild("notas").getChildText("teste2"));
	        System.out.println("Nota( prova ): "+pessoa.getChild("notas").getChildText("prova"));
	        System.out.println();
		}
	}

}
