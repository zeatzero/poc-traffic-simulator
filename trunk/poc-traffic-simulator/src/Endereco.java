import jef.DadoAbstrato;

public class Endereco extends DadoAbstrato{

	private String endereco;
	private float latitude;
	private float longitude;
	
	public Endereco(String endereco, float latitude, float longitude) {
		super();
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public Object getObjetoChave() {
		return endereco;
	}
	
}
