package jef;

import java.io.Serializable;

public abstract class DadoAbstrato implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;

	public DadoAbstrato() {
	}

	public DadoAbstrato(int codigo) {
		super();
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Object getObjetoChave() {
		return codigo;
	}
}
