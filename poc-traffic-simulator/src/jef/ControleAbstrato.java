package jef;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public abstract class ControleAbstrato<CLASSE_VALOR extends DadoAbstrato> {
	protected HashMap<Object, CLASSE_VALOR> data = new HashMap<Object, CLASSE_VALOR>();
	protected String nomeArquivoDados;
	private String path = "data";

	public void adicionar(CLASSE_VALOR objeto) {
		CLASSE_VALOR pesquisa = procurarPeloCodigo(objeto.getCodigo());
		if (pesquisa != null) {
			throw new IllegalArgumentException(
					getMensagemDadoDuplicado(pesquisa));
		}
		objeto.setCodigo(gerarCodigo());
		data.put(objeto.getObjetoChave(), objeto);
	}

	private int gerarCodigo() {
		return data.size() + 1;
	}

	/**
	 * Pesquisa pelo código se não encontrar pesquisa por parâmetros específicos
	 * de cada dado
	 * 
	 * @param objetoPesquisa
	 * @return
	 */
	public CLASSE_VALOR procurar(CLASSE_VALOR objetoPesquisa) {
		CLASSE_VALOR encontrado = null;
		if (objetoPesquisa.getCodigo() != 0) {
			encontrado = procurarPeloCodigo(objetoPesquisa.getCodigo());
		}
		if (encontrado == null) {
			encontrado = procurarPorParametros(objetoPesquisa);
		}
		return encontrado;
	}

	public abstract CLASSE_VALOR procurarPorParametros(
			CLASSE_VALOR objetoPesquisa);

	public CLASSE_VALOR procurarPeloCodigo(int codigoPesquisa) {
		for (CLASSE_VALOR da : data.values()) {
			if (da.getCodigo() == codigoPesquisa) {
				return da;
			}
		}
		return null;
	}

	public abstract String getMensagemDadoDuplicado(CLASSE_VALOR objeto);

	public void loadCache() {
		if (data == null || data.isEmpty()) {
			carregarDados();
		}
	}

	@SuppressWarnings("unchecked")
	public void carregarDados() {
		if (nomeArquivoDados == null) {
			throw new RuntimeException("O nome do arquivo nao foi configurado!");
		}
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		if (!file.exists()) {
			System.out.println("Diretório não encontrado, criando "
					+ file.getAbsolutePath());
			try {
				Runtime.getRuntime().exec("cmd /c cd " + path);
				Runtime.getRuntime().exec("cmd /c mkdir data");
			} catch (IOException e) {
				JOptionPane
						.showMessageDialog(
								null,
								"O diretório dos dados não foi encontrado e não foi possível criá-lo, crie o diretório e tente novamente: "
										+ new File("").getAbsolutePath()
										+ "\\data\n");
			}
		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(getFilePath());
			ois = new ObjectInputStream(fis);
			data = (HashMap<Object, CLASSE_VALOR>) ois.readObject();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null,
					"O arquivo dos dados não foi encontrado, criando novo arquivo para os dados: "
							+ getFilePath());
			data = new HashMap<Object, CLASSE_VALOR>();
			salvarDados();
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Ocorreu um erro desconhecido ao carregar um arquivo de dados! \nO sistema será finalizado!\nArquivo: "
									+ getFilePath() + "\nErro: " + e,
							"Erro ao carregar os dados",
							JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} finally {
			close(fis);
			close(ois);
		}
	}

	private void close(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo. " + c);
			}
		}
	}

	public void salvarDados() {
		System.out.println("salvando dados.");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(getFilePath());
			oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao salvar os dados para arquivo "
							+ getFilePath() + "\n" + e);
		} finally {
			close(fos);
			close(oos);
		}
	}

	private String getFilePath() {
		return path + "\\" + nomeArquivoDados;
	}

	public String getRelatorio() {
		String str = getCabelhalhoRelatorio();
		for (CLASSE_VALOR da : data.values()) {
			str += da;
		}
		return str;
	}

	public List<CLASSE_VALOR> getData() {
		return new ArrayList<CLASSE_VALOR>(data.values());
	}

	protected abstract String getCabelhalhoRelatorio();
}
