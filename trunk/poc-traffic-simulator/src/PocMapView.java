import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PocMapView extends JFrameJEF {
	private javax.swing.JButton btAddPercurso;
	private javax.swing.JButton btAddTrecho;
	private javax.swing.JButton btIniciar;
	private javax.swing.JButton btParar;
	private static javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField txtFim;
	private javax.swing.JTextField txtInicio;
	private javax.swing.JTextField txtRua;
	private List<Percurso> percursos;
	private ControleEndereco controleEnd;
	private CarroManager carroManager;

	public PocMapView() {
		super();
		setTitle("POC GMaps - by Jean Victor Zunino");
		init();
		setSize(1200, 700);
		setLocationRelativeTo(null);
		percursos = new ArrayList<Percurso>();
		controleEnd = new ControleEndereco();
		carroManager = new CarroManager(controleEnd);
	}

	@Override
	protected void createComponents() {
		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		btAddPercurso = new JButton();
		jPanel2 = new javax.swing.JPanel();
		txtInicio = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtFim = new javax.swing.JTextField();
		btAddTrecho = new javax.swing.JButton();
		txtRua = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		btIniciar = new javax.swing.JButton();
		btParar = new javax.swing.JButton();
	}

	@Override
	protected void createLayout() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Percurso"));

		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Trecho do Percurso"));

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel3.setText("nº início:");

		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel4.setText("nº fim:");

		btAddTrecho.setText("Adicionar Trecho");

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText("Rua:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																btAddTrecho)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								51,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								51,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								txtInicio,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtFim,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								64,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(114, 114, 114))
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												65,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												txtRua,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												164,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																txtRua,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												15, Short.MAX_VALUE)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtInicio,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtFim,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btAddTrecho)));

		btAddPercurso.setText("Adicionar Percurso");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																btAddPercurso))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btAddPercurso)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		btIniciar.setText("Iniciar");

		btParar.setText("Parar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										741,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						btIniciar)
																				.addComponent(
																						btParar)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(68, 68,
																		68)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		btIniciar)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		btParar)
																.addGap(11, 11,
																		11))
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														543, Short.MAX_VALUE))
								.addContainerGap()));

		pack();
	}

	@Override
	protected void addActionListeners() {
		btAddTrecho.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addTrecho();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btAddPercurso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addPercurso();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btParar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carroManager.stop();
			}

		});
		btIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carroManager.start();
			}

		});
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				controleEnd.salvarDados();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				controleEnd.salvarDados();
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
	}

	private void addPercurso() {
		if (percursos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum trecho foi adicionado");
			return;
		}
		Percurso p = percursos.get(percursos.size() - 1);
		carroManager.add(new Carro(p));
		JOptionPane.showMessageDialog(null, "Adicionado "
				+ carroManager.getCarros().size() + "º percurso!");
		Percurso novo = new Percurso();
		percursos.add(novo);
		GeoSample.clear();
	}

	private void addTrecho() throws Exception {
		GeoSample.clear();
		String rua = txtRua.getText();
		String inicio = txtInicio.getText();
		String fim = txtFim.getText();
		Trecho t = new Trecho(rua, Integer.parseInt(inicio),
				Integer.parseInt(fim));
		repaint();
		final List<String> enderecos = new ArrayList<String>();
		if (t.getInicio() < t.getFim()) {
			for (int i = t.getInicio(); i < t.getFim(); i += 20) {
				enderecos.add(t.getRua() + ", " + i);
			}
		} else {
			for (int i = t.getFim(); i < t.getInicio(); i += 20) {
				enderecos.add(t.getRua() + ", " + i);
			}
		}
		jLabel1.setIcon(null);
		jLabel1.setText("Por favor aguarde,\ncarregando os endereços do mapa...");
		for (String end : enderecos) {
			GeoSample.addEnderecoMapa(controleEnd, end);
		}
		jLabel1.setText("");
		if (percursos.size() == 0) {
			Percurso p = new Percurso();
			percursos.add(p);
		}
		percursos.get(percursos.size() - 1).add(t);
		refreshMap();
	}

	public static void refreshMap() throws Exception {
		jLabel1.setIcon(new ImageIcon(GeoSample.createImageMap()));
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new PocMapView().setVisible(true);
			}
		});
	}
}
