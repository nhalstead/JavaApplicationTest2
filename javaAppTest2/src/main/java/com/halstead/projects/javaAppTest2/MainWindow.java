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
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow {

	private JFrame frmMainApplication;

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
	private void initialize() {
		frmMainApplication = new JFrame();
		frmMainApplication.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frmMainApplication.getContentPane().setLayout(null);
		
		final JInternalFrame iLogin = new JInternalFrame("Login Frame");
		iLogin.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent arg0) {
				iLogin.setLocation(70, 25);
			}
		});
		iLogin.setResizable(false);
		iLogin.setBounds(70, 25, 400, 200);
		
		frmMainApplication.getContentPane().add(iLogin);
		frmMainApplication.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frmMainApplication.setTitle("Main Application");
		frmMainApplication.setBounds(100, 100, 1200, 900);
		frmMainApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
