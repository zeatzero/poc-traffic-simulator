package poc.trafficsimulator.control;
import java.util.HashMap;

import poc.trafficsimulator.model.Car;

public class EstradaManager {

	private HashMap<String, Car> carros = new HashMap<String, Car>();

	private static EstradaManager INSTANCE;

	public static EstradaManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EstradaManager();
		}
		return INSTANCE;
	}

	public void move(String enderecoAnterior, Car carro) {
		carros.put(enderecoAnterior, null);
		carros.put(carro.getEnderecoAtual(), carro);
	}

	public boolean isEmpty(String endereco) {
		return carros.get(endereco) == null;
	}

	public Car getCarro(Car carro, String endereco) {
		Car outroCarro = carros.get(endereco);
		if(outroCarro.equals(carro)){
			return null;
		}
		return outroCarro;
	}
}
