package main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import database.SQLiteJDBC;
import model.LoginUtils;

import org.eclipse.swt.custom.CLabel;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {

	static SQLiteJDBC db=new SQLiteJDBC();
	protected Shell shell;
	private Text username;
	private Text parola;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		db.connectToDB();
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	public void createContents() {
		shell = new Shell();
		shell.setSize(355, 328);
		shell.setToolTipText("");
		
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		shell.setText("LogIN");
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblNewLabel.setBounds(25, 50, 124, 21);
		lblNewLabel.setText("Username");
		
		CLabel lblParola = new CLabel(shell, SWT.NONE);
		lblParola.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblParola.setBounds(25, 93, 124, 21);
		lblParola.setText("Parola");
		
		username = new Text(shell, SWT.BORDER);
		username.setBounds(155, 50, 162, 21);
		
		parola = new Text(shell, SWT.BORDER);
		parola.setBounds(155, 93, 162, 21);
		
		Combo comboTipUtilizator = new Combo(shell, SWT.READ_ONLY);
		comboTipUtilizator.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		comboTipUtilizator.setBounds(155, 137, 162, 23);
		comboTipUtilizator.add("Student");
		comboTipUtilizator.add("Administrator");
		
		Button btnLogIn = new Button(shell, SWT.NONE);
		btnLogIn.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnLogIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(LoginUtils.verifLogIn(username.getText(), parola.getText(), comboTipUtilizator.getText())==true){
					Display display = Display.getDefault();
					Chestionar shell = new Chestionar(display);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte", "ERORR", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnLogIn.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnLogIn.setBounds(93, 196, 124, 25);
		btnLogIn.setText("Log In");
		
		Button btnCreareContNou = new Button(shell, SWT.NONE);
		btnCreareContNou.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				CreareCont Creare = new CreareCont(display);
				Creare.open();
				Creare.layout();
				while (!Creare.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				shell.dispose();
				}
			}	
		}
		);
		btnCreareContNou.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnCreareContNou.setBounds(93, 240, 124, 25);
		btnCreareContNou.setText("Creare Cont Nou");
		
		CLabel lblTipUtilizator = new CLabel(shell, SWT.NONE);
		lblTipUtilizator.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblTipUtilizator.setBounds(25, 139, 124, 21);
		lblTipUtilizator.setText("Tip Utilizator");

	}
	
}
