package MVC;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class AuthController {
	
	private JFrame frame;
	private AuthView view;
	
	public AuthController() {
		
		//Se crea el frame
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100,100,520,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0,1,0,0));
		
		view = new AuthView();
	}
	
	public void login() {
		
		//Se llama la funcion login de view 
		frame.add(view.login());
		
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
}
