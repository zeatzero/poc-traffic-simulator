package poc.trafficsimulator.control;

import java.util.ArrayList;
import java.util.List;

import poc.trafficsimulator.model.Car;
import poc.trafficsimulator.view.PocMapView;

public class CarManager{

	private List<Car> carros;
	private boolean execute;
	private AddressControl controleEnd;

	public CarManager(AddressControl controle) {
		carros = new ArrayList<Car>();
		controleEnd = controle;
	}

	public void add(Car carro) {
		synchronized (carros) {
			carros.add(carro);
		}
	}

	public void andar() {
		synchronized (carros) {
			int count = 1;
			for (Car c : carros) {
//				System.out.println("Movimentando carro " + count);
				c.andar();
				GeoSample.addEnderecoMapa(controleEnd, c.getEnderecoAtual());
			}
		}
	}

	public void start() {
		Thread executer = new Thread() {
			public void run() {
				execute = true;
				synchronized (carros) {
					for (Car c : carros) {
						c.iniciar();
						GeoSample.addEnderecoMapa(controleEnd,
								c.getEnderecoAtual());
					}
				}
				while (execute) {

					GeoSample.clear();
					andar();
					try {
						PocMapView.refreshMap();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		executer.start();
	}

	public void stop() {
		execute = false;
	}

	public List<Car> getCarros() {
		return carros;
	}
}
