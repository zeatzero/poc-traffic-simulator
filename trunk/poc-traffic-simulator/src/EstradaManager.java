import java.util.HashMap;

public class EstradaManager {

	private HashMap<String, Carro> carros = new HashMap<String, Carro>();

	private static EstradaManager INSTANCE;

	public static EstradaManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EstradaManager();
		}
		return INSTANCE;
	}

	public void move(String enderecoAnterior, Carro carro) {
		carros.put(enderecoAnterior, null);
		carros.put(carro.getEnderecoAtual(), carro);
	}

	public boolean isEmpty(String endereco) {
		return carros.get(endereco) == null;
	}

	public Carro getCarro(Carro carro, String endereco) {
		Carro outroCarro = carros.get(endereco);
		if(outroCarro.equals(carro)){
			return null;
		}
		return outroCarro;
	}
}
