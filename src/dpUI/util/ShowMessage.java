package dpUI.util;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowMessage {
	private static JFrame errhandler = new JFrame();
	private static boolean errorIsBeingShown = false, warnIsBeingShown = false;

	public static void showError(String error, boolean critical) {
		errhandler.setVisible(true);
		if (errorIsBeingShown)
			return;
		errorIsBeingShown = true;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(errhandler, error + (critical ? ". The application will now close." : ""),
						"Error", JOptionPane.ERROR_MESSAGE);
				errhandler.setVisible(false);
				errorIsBeingShown = false;
				if (critical)
					System.exit(1);
			}
		});
	}

	public static void showWarning(String error) {
		errhandler.setVisible(true);
		if (warnIsBeingShown)
			return;
		warnIsBeingShown = true;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(errhandler, error, "Warning", JOptionPane.WARNING_MESSAGE);
				errhandler.setVisible(false);
				warnIsBeingShown = false;
			}
		});
	}

	public static void showInfo(String info) {
		errhandler.setVisible(true);
		if (warnIsBeingShown)
			return;
		warnIsBeingShown = true;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(errhandler, info, "Message", JOptionPane.PLAIN_MESSAGE);
				errhandler.setVisible(false);
				warnIsBeingShown = false;
			}
		});
	}
}
