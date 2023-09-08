package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.hotel.controller.ReservaController;
import com.hotel.conversor.ConversorValores;
import com.hotel.modelo.Reserva;
import com.toedter.calendar.JDateChooser;

import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.beans.PropertyChangeEvent;

@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtTipoDeHabitacion;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	private BigDecimal valorPorDia;
	private Reserva reserva;
	private ReservaController reservaController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservasView() {
		reservaController = new ReservaController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(68, 20, 350, 42);
		panel.add(lblTitulo);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 26));
		panel.setComponentZOrder(lblTitulo, 0);
		
		JLabel lblTipoDeHabitacion = new JLabel("TIPO DE HABITACION");
		lblTipoDeHabitacion.setForeground(SystemColor.textInactiveText);
		lblTipoDeHabitacion.setBounds(68, 71, 200, 20);
		lblTipoDeHabitacion.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblTipoDeHabitacion);
		
		JSeparator separatorTipoHabitacion = new JSeparator();
		separatorTipoHabitacion.setForeground(SystemColor.textHighlight);
		separatorTipoHabitacion.setBounds(68, 370, 289, 2);
		separatorTipoHabitacion.setBackground(SystemColor.textHighlight);
		panel.add(separatorTipoHabitacion);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 161, 220, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 137, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);

		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 243, 225, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 221, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(68, 321, 289, 24);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 303, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 455, 289, 2);
		panel.add(separator_1_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));

		// Componentes para dejar la interfaz con estilo Material Design
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));

		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);

		// Campos que guardaremos en la base de datos
		txtTipoDeHabitacion = new JComboBox();
		txtTipoDeHabitacion.setBounds(68, 101, 289, 35);
		txtTipoDeHabitacion.setBackground(SystemColor.text);
		txtTipoDeHabitacion.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtTipoDeHabitacion.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTipoDeHabitacion.setModel(new DefaultComboBoxModel(
				new String[] { "Familiar -- 200 $", "Individual -- 75 $", "Matrimonial -- 120 $", "Simple -- 50 $"}));
		txtTipoDeHabitacion.setBackground(Color.WHITE);
		txtTipoDeHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarValorReserva();
			}
		});
		panel.add(txtTipoDeHabitacion);
		
		
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 186, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton()
				.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 267, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent ev) {
		        txtFechaEntrada.getDateEditor().addPropertyChangeListener(e -> actualizarValorReserva());
		        txtFechaSalida.getDateEditor().addPropertyChangeListener(e -> actualizarValorReserva());
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);

		txtValor = new JTextField( "0");
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(68, 342, 289, 25);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 20));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);

		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(
				new String[] { "Tarjeta de CrÈdito", "Tarjeta de DÈbito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);

		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {
					Boolean reservaExitosa = registrarReservacion();
					if (reservaExitosa) {
						JOptionPane.showMessageDialog(contentPane, "Reserva guardada con exito, id: " + reserva.getId());
						RegistroHuesped.setReserva(reserva.getId());
						RegistroHuesped registro = new RegistroHuesped();
						registro.setVisible(true);
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos \ne ingresar en fechas permitidas");
				}
			}
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(235, 492, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnsiguiente.add(lblSiguiente);
	}
	
	private Boolean fechaPermitida(Date fechaEntrada) {
		Date fechaHoy = new Date();
		Boolean fechaPermitida = fechaEntrada.compareTo(fechaHoy) >= -1;
		return fechaPermitida;
	}
	
	private void actualizarValorReserva() {
        Date fechaEntrada = txtFechaEntrada.getDate();
        Date fechaSalida = txtFechaSalida.getDate();
        valorPorDia = getTarifaTipoDeHabitacionSeleccionada();
   
        Boolean esValido = fechaEntrada != null && fechaSalida != null ;
        if (esValido) {
            BigDecimal valor = calcularValorReservaValor(fechaEntrada, fechaSalida, valorPorDia);
            txtValor.setText(valor.toString() + " $.");
        }
    }
	
	private BigDecimal getTarifaTipoDeHabitacionSeleccionada() {
		String tarifa = txtTipoDeHabitacion.getSelectedItem().toString();
		switch (tarifa) {
		case "Familiar -- 200 $":
			return new BigDecimal("200");
		case "Individual -- 75 $":
			return new BigDecimal("75");
		case "Matrimonial -- 120 $":
			return new BigDecimal("120");
		case "Simple -- 50 $":
			return new BigDecimal("50");
		}
		return new BigDecimal("0");
	}
	
	private BigDecimal calcularValorReservaValor(Date fechaEntrada, Date fechaSalida, BigDecimal tarifa) {
        LocalDate fechaEntradaLD = fechaEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalidaLD = fechaSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ConversorValores.calcularPorFechaTarifa(fechaEntradaLD, fechaSalidaLD, tarifa);
	}
	
	private Boolean registrarReservacion() {
		String tipoDeHabitacion = txtTipoDeHabitacion.getSelectedItem().toString().split(" --")[0];
        Date fechaEntrada = txtFechaEntrada.getDate();
        Date fechaSalida = txtFechaSalida.getDate();
        BigDecimal valor = calcularValorReservaValor(fechaEntrada, fechaSalida, valorPorDia);
        String formaDePago = (String) txtFormaPago.getSelectedItem();
        
        Boolean valorPermitido =  valor.intValue() > 0;
		Boolean fechaPermitida = fechaPermitida(fechaEntrada);
        if(valorPermitido && fechaPermitida) {
            reserva = new Reserva(tipoDeHabitacion, ConversorValores.fechaUtilDateToFechaSqlDate(fechaEntrada),
					ConversorValores.fechaUtilDateToFechaSqlDate(fechaSalida),
					valor, formaDePago);
             reserva.setId(guardarReservacion(reserva));
             return true;
        }
        return false;
	}
	
	private Integer guardarReservacion(Reserva reserva) {
		return reservaController.guardar(reserva);
	}
	

	// C√≥digo que permite mover la ventana por la pantalla seg√∫n la posici√≥n de
	// "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	
}















