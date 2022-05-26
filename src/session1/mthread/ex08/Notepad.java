package session1.mthread.ex08;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;


public class Notepad extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu mFile,mEdit,mHelp;
	private JMenuItem itemNew, itemOpen, itemSave, itemPrint, itemExit;
	
	private JTextArea taContent;
	private JLabel lblStatus;
	
	public Notepad() {
		super("Simple Notepad");
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		menuBar = new JMenuBar();
		mFile = new JMenu("File");
		mEdit = new JMenu("Edit");
		mHelp = new JMenu("Help");
		
		itemNew = new JMenuItem("Tập tin mới");
		//itemNew.setMnemonic(KeyEvent.VK_N);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		
		itemOpen = new JMenuItem("Mở tập tin");
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		
		itemSave = new JMenuItem("Lưu tập tin");
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		
		itemPrint = new JMenuItem("In ra máy tin");
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_DOWN_MASK));
		
		itemExit = new JMenuItem("Thoát");
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.ALT_DOWN_MASK));
		
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemPrint.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		
		mFile.add(itemNew);
		mFile.add(itemOpen);
		mFile.add(itemSave);
		mFile.add(itemPrint);
		mFile.add(itemExit);
		
		menuBar.add(mFile);
		menuBar.add(mEdit);
		menuBar.add(mHelp);
		setJMenuBar(menuBar);
		
		Font font = new Font("Time New Romans",Font.PLAIN,14);
		taContent = new JTextArea();
		taContent.setFont(font);
		JScrollPane jScrollPane = new JScrollPane(taContent);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jScrollPane);
		
		lblStatus = new JLabel("Ready...");
		lblStatus.setBorder(BorderFactory.createEtchedBorder());
		add(lblStatus,BorderLayout.SOUTH);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		new Notepad();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String recomand = e.getActionCommand();
		if (recomand.equals("Tập tin mới")) {
			taContent.setText("");
		}
		else if (recomand.equalsIgnoreCase("Mở tập tin")) {
			JFileChooser chooser = new JFileChooser("E:");
			int r = chooser.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION ) {
				File f = new File(chooser.getSelectedFile().getAbsolutePath());
				try {
					String s1 = "", sl = "";
					FileReader fr = new FileReader(f);
					
					BufferedReader br = new BufferedReader(fr);
					sl = br.readLine();
					
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}
					
					taContent.setText(sl);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
			/*else {
				JOptionPane.showMessageDialog(null, "");
			}*/
		}
		else if (recomand.equals("Lưu tập tin")) {
			JFileChooser chooser = new JFileChooser("E:");
			int r = chooser.showSaveDialog(null);
			
			if (r == JFileChooser.APPROVE_OPTION) {
				File f = new File(chooser.getSelectedFile().getAbsolutePath());
				/*File f = new File("*.txt");
				chooser.setSelectedFile(f);*/
				try {
					FileWriter wr = new FileWriter(f,false);
					
					BufferedWriter bw = new BufferedWriter(wr);
					
					bw.write(taContent.getText());
					bw.flush();
					bw.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		}
		else if (recomand.equalsIgnoreCase("In ra máy tin")) {
			try {
				taContent.print();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
		else if (recomand.equalsIgnoreCase("Thoát")) {
			System.exit(0);
		}
	}
}
