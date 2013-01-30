import java.util.ArrayList;
import java.util.List;

public class CarroManager{

	private List<Carro> carros;
	private boolean execute;
	private ControleEndereco controleEnd;

	public CarroManager(ControleEndereco controle) {
		carros = new ArrayList<Carro>();
		controleEnd = controle;
	}

	public void add(Carro carro) {
		synchronized (carros) {
			carros.add(carro);
		}
	}

	public void andar() {
		synchronized (carros) {
			int count = 1;
			for (Carro c : carros) {
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
					for (Carro c : carros) {
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

	public List<Carro> getCarros() {
		return carros;
	}
}
