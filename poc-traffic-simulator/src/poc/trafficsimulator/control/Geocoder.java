package poc.trafficsimulator.control;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import poc.trafficsimulator.model.Address;

public class Geocoder {

	// URL prefix to the geocoder
	private static final String GEOCODER_REQUEST_PREFIX_FOR_XML = "http://maps.google.com/maps/api/geocode/xml";

	private static List<Float> lats = new ArrayList<Float>();
	private static List<Float> longits = new ArrayList<Float>();

	public static JLabel labelMap = new JLabel();

	public static Address geocode(String end) throws Exception {
		System.out.println("GEOCODE: " + end);
		URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address="
				+ URLEncoder.encode(end, "UTF-8") + "&sensor=false");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Document geocoderResultDocument = null;
		try {
			conn.connect();
			InputSource geocoderResultInputSource = new InputSource(conn
					.getInputStream());

			// read the result and parse into XML Document
			geocoderResultDocument = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(geocoderResultInputSource);
		} finally {
			conn.disconnect();
		}

		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList resultNodeList = null;

		resultNodeList = (NodeList) xpath.evaluate(
				"/GeocodeResponse/result/formatted_address",
				geocoderResultDocument, XPathConstants.NODESET);

		// extract the locality for the first result
		resultNodeList = (NodeList) xpath
				.evaluate(
						"/GeocodeResponse/result[1]/address_component[type/text()='locality']/long_name",
						geocoderResultDocument, XPathConstants.NODESET);

		// extract the coordinates of the first result
		resultNodeList = (NodeList) xpath.evaluate(
				"/GeocodeResponse/result[1]/geometry/location/*",
				geocoderResultDocument, XPathConstants.NODESET);
		float latit = 0;
		float longi = 0;
		for (int i = 0; i < resultNodeList.getLength(); ++i) {
			Node node = resultNodeList.item(i);
			if ("lat".equals(node.getNodeName())) {
				latit = Float.parseFloat(node.getTextContent());
			}
			if ("lng".equals(node.getNodeName())) {
				longi = Float.parseFloat(node.getTextContent());
			}
		}
		return new Address(end, latit, longi);
	}

	public static void addEnderecoMapa(AddressControl controle, String endereco) {
		Address end = controle
				.procurarPorParametros(new Address(endereco, 0, 0));
		lats.add(end.getLatitude());
		longits.add(end.getLongitude());
	}

	public static Image createImageMap() throws MalformedURLException,
			IOException {
		String params = "";
		int count = 0;
		for (Float f : lats) {
			params += "|" + f + "," + longits.get(count);
			count++;
		}
		URLConnection con = new URL(
				"http://maps.googleapis.com/maps/api/staticmap?size=10240x768&sensor=true&markers=color:0x0000ff"
						+ params).openConnection();
		InputStream is = con.getInputStream();
		ByteBuffer bb = ByteBuffer.allocate(con.getContentLength());
		int readed = 0;
		byte[] b = new byte[1];
		while (readed < bb.capacity()) {
			readed += is.read(b);
			bb.put(b);
		}
		System.out.println(readed);
		is.close();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image map = tk.createImage(bb.array());
		// tk.prepareImage(map, 400, 400, null);

		return map;
	}

	public static void clear() {
		lats.clear();
		longits.clear();
	}
}
