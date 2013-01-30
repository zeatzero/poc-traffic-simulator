import jef.ControleAbstrato;

public class ControleEndereco extends ControleAbstrato<Endereco> {

	public ControleEndereco() {
		super();
		nomeArquivoDados = "enderecos.dat";
		this.carregarDados();
	}

	@Override
	public Endereco procurarPorParametros(Endereco objetoPesquisa) {
		Endereco endereco = data.get(objetoPesquisa.getObjetoChave());
		if (endereco == null) {
			try {
				String end = objetoPesquisa.getEndereco();
				endereco = GeoSample.geocode(end);
				adicionar(endereco);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return endereco;
	}

	@Override
	public String getMensagemDadoDuplicado(Endereco objeto) {
		return null;
	}

	@Override
	protected String getCabelhalhoRelatorio() {
		// TODO Auto-generated method stub
		return null;
	}

}