package poc.trafficsimulator.control;
import jef.AbstractControl;
import poc.trafficsimulator.model.Address;

public class AddressControl extends AbstractControl<Address> {

	public AddressControl() {
		super();
		nomeArquivoDados = "enderecos.dat";
		this.carregarDados();
	}

	@Override
	public Address procurarPorParametros(Address objetoPesquisa) {
		Address endereco = data.get(objetoPesquisa.getObjetoChave());
		if (endereco == null) {
			try {
				String end = objetoPesquisa.getEndereco();
				endereco = Geocoder.geocode(end);
				adicionar(endereco);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return endereco;
	}

	@Override
	public String getMensagemDadoDuplicado(Address objeto) {
		return null;
	}

	@Override
	protected String getCabelhalhoRelatorio() {
		// TODO Auto-generated method stub
		return null;
	}

}