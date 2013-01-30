package poc.trafficsimulator.model;
public class Trecho {
	private String rua;
	private int inicio;
	private int fim;
	private boolean ordemCrescente = true;

	public Trecho(String rua, int inicio, int fim) {
		super();
		this.rua = rua;
		this.inicio = inicio;
		this.fim = fim;
		if (inicio > fim) {
			ordemCrescente = false;
		}
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua
	 *            the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the inicio
	 */
	public int getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fim
	 */
	public int getFim() {
		return fim;
	}

	/**
	 * @param fim
	 *            the fim to set
	 */
	public void setFim(int fim) {
		this.fim = fim;
	}

	public boolean isOrdemCrescente() {
		return ordemCrescente;
	}
}
