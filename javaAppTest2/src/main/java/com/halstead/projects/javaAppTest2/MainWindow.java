package com.halstead.projects.javaAppTest2;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class MainWindow {

	private JFrame frmMainApplication;
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMainApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmMainApplication = new JFrame();
		frmMainApplication.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frmMainApplication.getContentPane().setLayout(null);
		

		final JInternalFrame internalFrame = new JInternalFrame("Main Process Window");
		final JInternalFrame iLogin = new JInternalFrame("Login Frame");
		
		// Main Window
		internalFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		internalFrame.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				iLogin.
				iLogin.show();
			}
		});
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setBounds(488, 48, 421, 353);
		frmMainApplication.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		frmMainApplication.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frmMainApplication.setTitle("Main Application");
		frmMainApplication.setBounds(100, 100, 1200, 900);
		frmMainApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		internalFrame.hide();
		
		// Login Frame
		iLogin.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent arg0) {
				iLogin.setLocation(70, 25);
			}
		});
		iLogin.setResizable(false);
		iLogin.setBounds(70, 25, 400, 200);
		
		frmMainApplication.getContentPane().add(iLogin);
		iLogin.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iLogin.hide();
				internalFrame.show();
				lblPassword
			}
		});
		btnLogin.setBounds(232, 136, 142, 23);
		iLogin.getContentPane().add(btnLogin);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(107, 27, 186, 20);
		iLogin.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);
		
		final JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 30, 63, 14);
		iLogin.getContentPane().add(lblUsername);
		
		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 61, 63, 14);
		iLogin.getContentPane().add(lblPassword);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(107, 58, 186, 20);
		iLogin.getContentPane().add(passwordInput);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "example.com", "api.example.com", "workgroup.runtime.com", "localhost"}));
		comboBox.setBounds(107, 89, 186, 20);
		iLogin.getContentPane().add(comboBox);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(20, 92, 63, 14);
		iLogin.getContentPane().add(lblServer);
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Assist for the Next Action
		frmMainApplication.setLocation(dim.width/2-frmMainApplication.getSize().width/2, dim.height/2-frmMainApplication.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		frmMainApplication.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuItem.setMargin(new Insets(2, 10, 2, 4));
		mnFile.add(menuItem);
		
		JMenu mnWindows = new JMenu("Windows");
		menuBar.add(mnWindows);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iLogin.show();
			}
		});
		iLogin.show();
		mnWindows.add(mntmLogin);
	}
}
