package poc.trafficsimulator.model;
import java.util.ArrayList;
import java.util.List;

public class Percurso {

	private List<Trecho> trechos = new ArrayList<Trecho>();

	public Percurso() {
	}

	public void add(Trecho trecho) {
		trechos.add(trecho);
	}

	public List<Trecho> getTrechos() {
		return trechos;
	}
}
