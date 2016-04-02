import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainInterface extends JPanel 
					implements ActionListener {

     JFrame frame = new JFrame("Secure Cloud Storage App");
     JMenuBar greenMenuBar = new JMenuBar();
     JMenu menu1 = new JMenu("Upload & Encrypt");
     JMenu menu2 = new JMenu("Download & Decrypt");
	 JButton openButton = new JButton("Select a File...");
	 JFileChooser fc = new JFileChooser(); 
     JTextArea textArea = new JTextArea();
	 JLabel numberOfChunks = new JLabel("File Split Count");
	 JLabel googleDrive = new JLabel("Google Drive Account?");
	 JLabel userName = new JLabel("Username");
	 JTextArea userNameTextArea = new JTextArea("me@gmail.com");
	 JTextArea passWordTextArea = new JTextArea("********");
	 JLabel passWord = new JLabel("Password");
	 JLabel dropBox = new JLabel("Dropbox Account?");
	 JLabel userName2 = new JLabel("Username");
	 JTextArea userNameTextArea2 = new JTextArea("me@yahoo.com");
	 JTextArea passWordTextArea2 = new JTextArea("*****************");
	 JLabel passWord2 = new JLabel("Password");
	 JButton uploadButton = new JButton ("Upload");
	 SpinnerModel model = new SpinnerNumberModel(1, 0, 20, 1);
	 JSpinner chunkSize = new JSpinner(model);
	 JRadioButton yesGoogle = new JRadioButton("Yes");
	 JRadioButton noGoogle = new JRadioButton("No");
	 JRadioButton yesDropbox = new JRadioButton("Yes");
	 JRadioButton noDropbox = new JRadioButton("No");
     JLabel spacer;
	private static JPanel buttonPanel2;
	private static JPanel buttonPanel;
     
	 public MainInterface() {

		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		//create button
		 openButton.addActionListener(this); 
		 menu1.addActionListener(this);
		 menu2.addActionListener(this);
		
		//Create the menu bar.  Make it have a green background.
	     greenMenuBar.setOpaque(true);
	     greenMenuBar.setPreferredSize(new Dimension(200, 40));
 
	     //create menus
	     menu1.setMnemonic(KeyEvent.VK_N);
	     menu1.getAccessibleContext().setAccessibleDescription(
	                "The only menu in this program that has menu items");
	     menu2.setMnemonic(KeyEvent.VK_A);
	     menu2.getAccessibleContext().setAccessibleDescription(
	                "The only menu in this program that has menu items");
		 
		 //Create a label
		 numberOfChunks.setOpaque(true);
		 googleDrive.setOpaque(true);
		 dropBox.setOpaque(true);
		 
		 //TextArea
		 textArea.setPreferredSize(new Dimension(300, 20));
	     textArea.setBackground(new Color(250,250,250));
	     userNameTextArea.setPreferredSize(new Dimension(200, 20));
	     userNameTextArea.setBackground(new Color(250,250,250));
	     passWordTextArea.setPreferredSize(new Dimension(200, 20));
	     passWordTextArea.setBackground(new Color(250,250,250));
	     userNameTextArea2.setPreferredSize(new Dimension(200, 20));
	     userNameTextArea2.setBackground(new Color(250,250,250));
	     passWordTextArea2.setPreferredSize(new Dimension(200, 20));
	     passWordTextArea2.setBackground(new Color(250,250,250));
	     
	     //value chooser
	     chunkSize.setBounds(0, 0, 10, 10);
	 }
	
	public static void main (String[]args) {
		MainInterface main = new MainInterface();
	    
	    //create menus
        main.greenMenuBar.add(main.menu1);
        main.greenMenuBar.add(main.menu2);

        buttonPanel = new JPanel();
        buttonPanel.add(main.textArea);
        buttonPanel.add(main.openButton);

        buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new MigLayout());
        buttonPanel2.setBackground(new Color(248, 213, 131));
        buttonPanel2.add(main.spacer =  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.numberOfChunks);
        buttonPanel2.add(main.chunkSize);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.googleDrive);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.yesGoogle);
        buttonPanel2.add(main.noGoogle);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.userName);
        buttonPanel2.add(main.userNameTextArea);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.passWord);
        buttonPanel2.add(main.passWordTextArea);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.dropBox);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.yesDropbox);
        buttonPanel2.add(main.noDropbox);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.userName2);
        buttonPanel2.add(main.userNameTextArea2);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.passWord2);
        buttonPanel2.add(main.passWordTextArea2);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.uploadButton, BorderLayout.CENTER);
        
        //Set the menu bar and add the label to the content pane.
        main.frame.setJMenuBar(main.greenMenuBar);

    	main.frame.add(buttonPanel, BorderLayout.PAGE_START);
        main.frame.getContentPane().add(buttonPanel2);
      
        //Display the window.
	    main.frame.pack();
	    main.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(MainInterface.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println("Opening: "+fc.getCurrentDirectory() + file.getName() + "." );
                textArea.setText(fc.getCurrentDirectory() + file.getName());
            } else {
            	System.out.println("Open command cancelled by user.");
            }
        //    log.setCaretPosition(log.getDocument().getLength());
// TODO Auto-generated method stub
		
	}
    
    if (e.getSource() == menu1) {

         //Display the window.
	    frame.pack();
	    frame.setVisible(true);
    }
    
    if (e.getSource() == menu2) {
    	buttonPanel.setVisible(false);
    }
    
	}
}
