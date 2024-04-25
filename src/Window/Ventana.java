package Window;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ventana extends JFrame implements MouseListener, KeyListener{
	JPanel btn_panel = new JPanel();
	
	public Ventana() {

		this.setSize(520,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		this.setResizable(false);
		this.setTitle("ActionListener");
		this.setMinimumSize(new Dimension(250,250));
		this.setMaximumSize(new Dimension(1000,750));
		this.setLocationRelativeTo(null);
		this.iniciarComponentes();
		addMouseListener(this);
		addKeyListener(this);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	//Metodo iniciar los componentes del panel
	public void iniciarComponentes() {
		//this.registro();
		this.login();
		//this.botones();
		//this.calculoInteres();
		//this.calculadora();
		this.repaint();
	}
	//Metodo del registro
	public void registro() {
			JPanel registro = new JPanel();
			registro.setSize(this.getWidth(),this.getHeight());
			registro.setBackground(Color.cyan);
			registro.setLayout(null);

			JLabel register_tag = new JLabel("Registro",0);
			register_tag.setSize(300, 80);
			register_tag.setFont(new Font ("Arial",Font.BOLD,24));
			register_tag.setForeground(Color.black);
			register_tag.setLocation(780, 20);
			register_tag.setOpaque(true);//Fondo a la etiqueta
			register_tag.setBackground(Color.orange);
			registro.add(register_tag);

			//Registro de usuario
			JLabel userName = new JLabel(" Nombre de usuario:");
			userName.setBounds(860,120,180,40);
			userName.setFont(new Font ("Agency FB", Font.BOLD, 25));
			registro.add(userName);

			JTextField userField = new JTextField();
			userField.setBounds(845, 159, 180, 40);
			userField.setFont(new Font("Arial",Font.BOLD,20));
			userField.setOpaque(true);
			userField.setBackground(Color.white);
			registro.add(userField);

			JLabel bioTag = new JLabel("Biografia",0);
			bioTag.setBounds(730, 209, 400, 40);
			bioTag.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(bioTag);

			JTextArea bioText = new JTextArea();
			bioText.setBounds(740, 250, 400, 80);
			bioText.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(bioText);

			JLabel pref = new JLabel("Preferencias",0);
			pref.setBounds(730, 330, 400, 40);
			pref.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(pref);

			JCheckBox itemBox = new JCheckBox("Papas");
			itemBox.setBounds(750, 360, 90, 40);
			itemBox.setFont(new Font("Arial",Font.BOLD,18));
			itemBox.setOpaque(false);
			itemBox.setBackground(Color.magenta);
			registro.add(itemBox);

			JCheckBox itemBox2 = new JCheckBox("Dulces");
			itemBox2.setBounds(880, 360, 100, 40);
			itemBox2.setFont(new Font("Arial",Font.BOLD,18));
			itemBox2.setOpaque(false);
			registro.add(itemBox2);

			JCheckBox itemBox3 = new JCheckBox("Refresco");
			itemBox3.setBounds(1000, 360, 130, 40);
			itemBox3.setFont(new Font("Arial",Font.BOLD,18));
			itemBox3.setOpaque(false);
			registro.add(itemBox3);

			JLabel termsTag = new JLabel("Terminos",0);
			termsTag.setBounds(880, 410, 100, 40);
			termsTag.setFont(new Font("Arial",Font.BOLD,20));
			termsTag.setOpaque(false);
			termsTag.setBackground(Color.red);
			registro.add(termsTag);

			JRadioButton acceptRadio = new JRadioButton("Acepto los terminos");
			acceptRadio.setBounds(670, 450, 220, 40);
			acceptRadio.setFont(new Font("Arial",Font.BOLD,16));
			acceptRadio.setOpaque(false);
			acceptRadio.setBackground(Color.red);
			registro.add(acceptRadio);

			JRadioButton noAcceptRadio = new JRadioButton("No acepto los terminos");
			noAcceptRadio.setBounds(1000, 450, 220, 40);
			noAcceptRadio.setFont(new Font("Arial",Font.BOLD,16));
			noAcceptRadio.setOpaque(false);
			noAcceptRadio.setBackground(Color.red);
			registro.add(noAcceptRadio);

			ButtonGroup terms = new ButtonGroup();
			terms.add(acceptRadio);
			terms.add(noAcceptRadio);

			String colony[] = {"Centro","Camino real","Ayuntamiento"};

			JComboBox locations = new JComboBox(colony);
			locations.setBounds(750, 500, 350, 40);
			locations.setFont(new Font("Arial",Font.BOLD,19));
			registro.add(locations);

			JButton registerButton = new JButton("Crear cuenta");
			registerButton.setBounds(820, 620, 200, 40);
			registerButton.setFont(new Font("Arial",Font.BOLD,19));
			registro.add(registerButton);
			
			registerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String usr = userField.getText();
					String bio = bioText.getText();
						if(usr.length()<=0) {
							userField.setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						else {
							userField.setBorder(BorderFactory.createLineBorder(Color.green,2));
						}
						
						if(bio.length()<=0) {
							bioText.setBorder(BorderFactory.createLineBorder(Color.red,2));

						}
						else {
							bioText.setBorder(BorderFactory.createLineBorder(Color.green,2));

						}
						
						if(!acceptRadio.isSelected()) {
							acceptRadio.setBorderPainted(true);
							acceptRadio.setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						else {
							acceptRadio.setBorder(BorderFactory.createLineBorder(Color.green,2));

						}
				}
				
			});
			
			this.add(registro);
		}
	
	public void login() {
		JPanel login = new JPanel();
		login.setSize(this.getWidth(),this.getHeight());
		login.setBackground(Color.decode("#30508f"));
		login.setLayout(null);

		//User Login
		JLabel login_tag = new JLabel("User Login",0);
		login_tag.setSize(300, 80);
		login_tag.setFont(new Font ("Segoe UI Black",Font.BOLD,32));
		login_tag.setForeground(Color.white);
		login_tag.setLocation(105, 12);
		login.add(login_tag);

		//MyAccount
		JLabel myAccount = new JLabel("My Account",0);
		myAccount.setBounds(150,120,220,40);
		myAccount.setFont(new Font ("Segoe UI Black", Font.BOLD, 35));
		myAccount.setForeground(Color.decode("#D9C943"));
		login.add(myAccount);

		//Titulo
		JLabel userName = new JLabel("Enter Your Username");
		userName.setBounds(100,170,180,40);
		userName.setFont(new Font ("Agency FB", Font.BOLD, 20));
		userName.setForeground(Color.white);
		login.add(userName);

		//Textbox del username

		JTextField typeUser = new JTextField();
		typeUser.setBounds(100,210,300,35);
		typeUser.setOpaque(true);
		typeUser.setBackground(Color.white);
		login.add(typeUser);

		//Icono persona
		/*JLabel person = new JLabel();
		person.setIcon(new ImageIcon(getClass().getResource("persona.png")));
		person.setBounds(60, 218, 20, 20);
		login.add(person);/*/

		//personFrame
		JLabel iconFrame = new JLabel();
		iconFrame.setBounds(55,212,30,30);
		iconFrame.setOpaque(true);
		iconFrame.setBackground(Color.decode("#D9C943"));
		login.add(iconFrame);

		//Contraseña
		JLabel pwd = new JLabel("Enter Your Password:");
		pwd.setBounds(100,260,180,40);
		pwd.setFont(new Font("Agency FB",Font.BOLD,20));
		pwd.setForeground(Color.white);
		login.add(pwd);

		//Campo para la contraseña
		JPasswordField typePwd = new JPasswordField();
		typePwd.setBounds(100,300,300,35);
		typePwd.setFont(new Font ("Agency FB", Font.BOLD, 25));
		login.add(typePwd);

		//Locker icon
		/*JLabel locker = new JLabel();
		locker.setIcon(new ImageIcon(getClass().getResource("candado.png")));
		locker.setBounds(60, 305, 20, 20);
		login.add(locker);/*/

		//lockerFrame
		JLabel lockerFrame = new JLabel();
		lockerFrame.setBounds(55,300,30,30);
		lockerFrame.setOpaque(true);
		lockerFrame.setBackground(Color.decode("#D9C943"));
		login.add(lockerFrame);

		//Boton de acceso
		JButton accessButton = new JButton("Login");
		accessButton.setBounds(160,370,170,50);
		accessButton.setBackground(Color.decode("#D9C943"));
		accessButton.setFont(new Font("Segoe UI Black",Font.BOLD,25));
		login.add(accessButton);
		
		accessButton.addActionListener(new ActionListener() {
			
			 @Override
			    public void actionPerformed(ActionEvent e) {
			       
			        if (e.getActionCommand().equals("Login")) {
			            
			            String usuario = typeUser.getText();
			            String pwd = new String(typePwd.getPassword());
			            
			            if (usuario.isEmpty()) {
			                typeUser.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			            } else {
			                typeUser.setBorder(BorderFactory.createLineBorder(Color.green, 2));
			            }

			            if (pwd.isEmpty()) {
			                typePwd.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			            } else {
			                typePwd.setBorder(BorderFactory.createLineBorder(Color.green, 2));
			            }

			            if (!usuario.isEmpty() && !pwd.isEmpty()) {
			                Usuario usuarioObj = new Usuario(usuario, pwd);

			                ObjectMapper objectMapper = new ObjectMapper();
			                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

			                try {
			                   
			                    objectMapper.writeValue(new File("usuario.json"), usuarioObj);
			                    System.out.println("Archivo JSON creado exitosamente.");

			                    System.out.println("Datos del usuario:");
			                    System.out.println("Usuario: " + usuarioObj.getUsuario());
			                    System.out.println("Contraseña: " + usuarioObj.getContraseña());
			                } catch (IOException ex) {
			                    ex.printStackTrace();
			                }
			            }
			        }
			    }
		});

		//Recuadro
		JLabel frame = new JLabel();
		frame.setSize(450,350 );
		frame.setOpaque(true);
		frame.setBackground(Color.decode("#22396c"));
		frame.setLocation(25,100);
		login.add(frame);

		this.add(login);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
