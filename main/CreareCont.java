package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CreareCont extends Shell {
	private Text username;
	private Text parola;
	private Text parolaRescrisa;

	/**
	 * Create the shell.
	 * @param display
	 */
	public CreareCont(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		
		CLabel lblUsername = new CLabel(this, SWT.NONE);
		lblUsername.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblUsername.setBounds(31, 30, 126, 21);
		lblUsername.setText("Username");
		
		CLabel lblParola = new CLabel(this, SWT.NONE);
		lblParola.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblParola.setBounds(31, 67, 126, 21);
		lblParola.setText("Parola");
		
		CLabel lblRescrieParola = new CLabel(this, SWT.NONE);
		lblRescrieParola.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblRescrieParola.setBounds(31, 107, 126, 21);
		lblRescrieParola.setText("Rescrie parola");
		
		username = new Text(this, SWT.BORDER);
		username.setBounds(192, 30, 126, 21);
		
		parola = new Text(this, SWT.BORDER);
		parola.setBounds(192, 67, 126, 21);
		
		parolaRescrisa = new Text(this, SWT.BORDER);
		parolaRescrisa.setBounds(192, 107, 126, 21);
		
		CLabel lblTipUtilizator = new CLabel(this, SWT.NONE);
		lblTipUtilizator.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblTipUtilizator.setBounds(31, 145, 126, 21);
		lblTipUtilizator.setText("Tip Utilizator");
		
		Combo comboTipUtilizator = new Combo(this, SWT.NONE);
		comboTipUtilizator.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		comboTipUtilizator.setBounds(192, 145, 126, 23);
		createContents();
		comboTipUtilizator.add("Student");
		comboTipUtilizator.add("Administrator");
		
		Button btnCreare = new Button(this, SWT.NONE);
		btnCreare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
				MainWindow.main(null);
			}
		});
		btnCreare.setBounds(135, 192, 75, 25);
		btnCreare.setText("Creare");
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Creare Cont");
		setSize(381, 271);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
