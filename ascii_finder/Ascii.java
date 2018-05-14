import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Ascii extends KeyAdapter {
	JFrame jf;
	JTextField tf;
	Ascii() {
		jf=new JFrame("ASCII Code Finder");
		tf=new JTextField();
		tf.addKeyListener(this);
		jf.add(tf,BorderLayout.NORTH);
		jf.setSize(250,60);
		jf.setVisible(true);
	}
	public void keyTyped(KeyEvent e) {
		char ch=e.getKeyChar();
		tf.setText("");
		String sch=Character.toString(ch);
		int code=sch.codePointAt(0);
		String codes=Integer.toString(code);
		tf.setText(codes+" is ASCII code of : ");
	}
	public static void main(String... w) {
		new Ascii();
	}
}
