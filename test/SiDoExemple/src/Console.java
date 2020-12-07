

//Console.java
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

//Redirection des flux System.out et System.err dans une JTextArea

//@author Ronan Martin

public class Console extends JInternalFrame implements InternalFrameListener,
		ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private Thread reader;
	private Thread reader2;
	private boolean quit;

	private final PipedInputStream pin = new PipedInputStream();
	private final PipedInputStream pin2 = new PipedInputStream();
	Thread errorThrower;

	// Constructeur par défaut de Console
	// Le but du jeu est de redirigé les sorties classiques, que ce soit

	// sout ou pour serr.

	// Pour cela nous allons utiliser deux threads indépendants

	// Création de l'objet et de la fenetre

	public Console() {
		setTitle("Console");
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
		JButton button = new JButton("Effacer");
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
		getContentPane().add(button, BorderLayout.SOUTH);
		setVisible(true);
		this.addInternalFrameListener(this);
		button.addActionListener(this);
		redirect();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		
		//setSize(400, 700);
		// this.pack();
		this.setPreferredSize(new Dimension(420, 300));
	}

	// Redirection des flux

	private void redirect() {
		try {
			PipedOutputStream pout = new PipedOutputStream(pin);
			System.setOut(new PrintStream(pout, true));
		} catch (java.io.IOException io) {
			textArea.append("Couldn't redirect STDOUT to this console\n"
					+ io.getMessage());
		} catch (SecurityException se) {
			textArea.append("Couldn't redirect STDOUT to this console\n"
					+ se.getMessage());
		}

		try {
			PipedOutputStream pout2 = new PipedOutputStream(pin2);
			System.setErr(new PrintStream(pout2, true));
		} catch (java.io.IOException io) {
			textArea.append("Couldn't redirect STDERR to this console\n"
					+ io.getMessage());
		} catch (SecurityException se) {
			textArea.append("Couldn't redirect STDERR to this console\n"
					+ se.getMessage());
		}

		quit = false; // signals the Threads that they should exit

		// Starting two seperate threads to read from the PipedInputStreams
		//

		reader = new Thread(this);
		reader.setDaemon(true);
		reader.start();
		reader2 = new Thread(this);
		reader2.setDaemon(true);
		reader2.start();
		errorThrower = new Thread(this);
		errorThrower.setDaemon(true);
		errorThrower.start();
	}

	public synchronized void actionPerformed(ActionEvent evt) {
		textArea.setText("");
	}

	// Lancement des threads

	public synchronized void run() {
		try {
			while (Thread.currentThread() == reader) {
				try {
					this.wait(100);
				} catch (InterruptedException ie) {
				}
				if (pin.available() != 0) {
					String input = this.readLine(pin);
					textArea.append(input);
				}
				if (quit)
					return;
			}

			while (Thread.currentThread() == reader2) {
				try {
					this.wait(100);
				} catch (InterruptedException ie) {
				}
				if (pin2.available() != 0) {
					String input = this.readLine(pin2);
					textArea.append(input);
				}
				if (quit)
					return;
			}
		} catch (Exception e) {
			textArea.append("\nConsole reports an Internal error.");
			textArea.append("The error is: " + e);
		}
	}

	// Lecture de la sortie standard

	protected synchronized String readLine(PipedInputStream in)
			throws IOException {
		String input = "";
		do {
			int available = in.available();
			if (available == 0)
				break;
			byte b[] = new byte[available];
			in.read(b);
			input = input + new String(b, 0, b.length);
		} while (!input.endsWith("\n") && !input.endsWith("\r\n") && !quit);
		return input;
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void internalFrameOpened(InternalFrameEvent e) {
	}

	public void internalFrameClosing(InternalFrameEvent e) {
		setVisible(false);
	}

	// Est appelé automatiquement a la sortie du programme

	public void internalFrameClosed(InternalFrameEvent e) {

		quit = true;
		this.notifyAll(); // stop all threads
		try {
			reader.join(1000);
			pin.close();
		} catch (Exception ex) {
		}
		try {
			reader2.join(1000);
			pin2.close();
		} catch (Exception ex) {
		}
	}

	public void internalFrameIconified(InternalFrameEvent e) {
	}

	public void internalFrameDeiconified(InternalFrameEvent e) {
	}

	public void internalFrameActivated(InternalFrameEvent e) {
	}

	public void internalFrameDeactivated(InternalFrameEvent e) {
	}

}