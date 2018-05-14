import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
class FolderPath implements ActionListener,ChangeListener
{
	JFrame frame;
	JButton browse,reset,ok;
	JRadioButton hide,show;
	
	ButtonGroup bg=new ButtonGroup();

	JPanel panel,panel1,panel2,panel3;
	JLabel label1;

	JTextField tf;

	JFileChooser jfc;

	String path,str;
	
	Process p;
	
	File f;
	FolderPath()
	{
		frame=new JFrame("Hide & Seek");
		try
  		{
   			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  		}catch(Exception e){}
		hide=new JRadioButton("Hide");
		show=new JRadioButton("Show");
		bg.add(hide);
		bg.add(show);
		label1=new JLabel();
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel1=new JPanel();
		panel1.add(new JLabel("Select :    "));
		panel1.add(hide);
		panel1.add(show);
		tf=new JTextField(25);
		browse=new JButton("Browse");
		reset=new JButton("Reset");
		ok=new JButton("OK");
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(label1,BorderLayout.CENTER);
		panel2=new JPanel();
		panel2.add(tf);
		panel2.add(browse);
		panel3=new JPanel();	
		panel3.add(ok);
		panel3.add(reset);
		frame.add(panel,BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		browse.addActionListener(this);
		hide.addActionListener(this);
		show.addActionListener(this);
		reset.addActionListener(this);
		hide.addChangeListener(this);
		ok.addActionListener(this);
		show.addChangeListener(this);
		browse.addChangeListener(this);
		reset.addChangeListener(this);
		/* browse.setEnabled(false);
		tf.setEnabled(false);
		ok.setEnabled(false);
		reset.setEnabled(false); */
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==hide)
		{
			frame.add(panel2,BorderLayout.CENTER);
			frame.add(panel3,BorderLayout.SOUTH);
			resize(frame);
			label1.setText("  Select any file or directory to hide : ");
			str="hide";
			ok.setEnabled(true);
			reset.setEnabled(true);
			browse.setEnabled(true);
			tf.setEnabled(false);
		}
		if(e.getSource()==show)
		{
			frame.add(panel2,BorderLayout.CENTER);
			frame.add(panel3,BorderLayout.SOUTH);
			resize(frame);
			label1.setText("  Enter absolute path of hidden file or folder to show :");
			path=tf.getText();
			str="show";
			browse.setEnabled(false);
			tf.setEnabled(true);
			ok.setEnabled(true);
			reset.setEnabled(true);
		}
		if(e.getSource()==browse)
		{
			jfc=new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int x=jfc.showDialog(null,"Select");
			if(x==JFileChooser.APPROVE_OPTION)
			{
				f=jfc.getSelectedFile();
				path=f.getPath();
				tf.setText(path);
				System.out.println(path);
			}
		}
		if(e.getSource()==ok)
		{
			System.out.println(str);
			if(str.equals("hide"))
			{
				try{
				path=f.getPath();
				p=Runtime.getRuntime().exec("cmd /c attrib +s +h "+path);
				System.out.println("Hidden successfully !!");
				}catch(Exception e1){System.out.println(e1);}
			}
			if(str.equals("show"))
			{
				try{
				path=tf.getText();
				p=Runtime.getRuntime().exec("cmd /c attrib -s -h "+path);
				System.out.println("Shown successfully !!");
				}catch(Exception e2){System.out.println(e2);}
			}
		}
		if(e.getSource()==reset)
		{
			frame.remove(panel2);
			frame.remove(panel3);
			resize(frame);
			path="";
			tf.setText("");
			label1.setText("");
			browse.setEnabled(false);
			tf.setEnabled(false);
			ok.setEnabled(false);
		}
	}
	public void stateChanged(ChangeEvent e)
	{
		if(e.getSource()==hide)
		{
			hide.setToolTipText("Hide file or folder");
		}
		if(e.getSource()==show)
		{
			show.setToolTipText("Show hidden file of folder");
		}
		if(e.getSource()==reset)
		{
			reset.setToolTipText("Clear data");
		}
		if(e.getSource()==browse)
		{
			browse.setToolTipText("Select any file or directory to hide");
		}
	}
	public static void resize(Component c)
	{
		c.validate();
		c.repaint();
		if(c instanceof JFrame)
		{
			JFrame f=(JFrame)c;
			f.pack();
			
		}
	}
	public static void main(String... ww)
	{	
		new FolderPath();
	}
}
