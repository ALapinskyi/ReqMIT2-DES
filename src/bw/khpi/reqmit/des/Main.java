package bw.khpi.reqmit.des;

import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.utils.XMLUtils;
import bw.khpi.reqmit.des.view.LoginViewController;
import bw.khpi.reqmit.des.view.MainServiceViewController;
import bw.khpi.reqmit.des.view.ProjectViewController;
import bw.khpi.reqmit.des.view.RegistrationViewController;
import bw.khpi.reqmit.des.view.RequirementViewController;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

	private static final String iconImageLoc = "http://icons.iconarchive.com/icons/scafer31000/bubble-circle-3/16/GameCenter-icon.png";

	private Stage stage;
	private Stage stageDialog = new Stage();

	private User user;

	private java.awt.TrayIcon trayIcon;
	private java.awt.MenuItem loginItem;
	private java.awt.MenuItem logoutItem;
	private java.awt.MenuItem openItem;
	private java.awt.MenuItem ideItem;
	private java.awt.MenuItem exitItem;
	private java.awt.PopupMenu popup;
	
	private MainServiceViewController mainServiceViewController;

	@Override
	public void start(final Stage stage) {

		this.stage = stage;
		loadData();

		Platform.setImplicitExit(false);

		javax.swing.SwingUtilities.invokeLater(this::addAppToTray);

		if (user == null) {
			showLoginView();
		}
	}

	private void loadData() {
		user = XMLUtils.loadUser();
	}

	private void addAppToTray() {
		try {
			java.awt.Toolkit.getDefaultToolkit();

			if (!java.awt.SystemTray.isSupported()) {
				System.out.println("No system tray support, application exiting.");
				Platform.exit();
			}

			java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
			URL imageLoc = new URL(iconImageLoc);
			java.awt.Image image = ImageIO.read(imageLoc);
			trayIcon = new java.awt.TrayIcon(image);

			trayIcon.addActionListener(event -> Platform.runLater(this::showMainView));

			loginItem = new java.awt.MenuItem("Login");
			loginItem.addActionListener(event -> Platform.runLater(this::showLoginView));

			logoutItem = new java.awt.MenuItem("Logout");
			logoutItem.addActionListener(event -> Platform.runLater(this::logout));

			openItem = new java.awt.MenuItem("Open");
			openItem.addActionListener(event -> Platform.runLater(this::showMainView));

			ideItem = new java.awt.MenuItem("IDE management");
			ideItem.addActionListener(event -> Platform.runLater(this::showIDEManagement));

			java.awt.Font defaultFont = java.awt.Font.decode(null);
			java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
			openItem.setFont(boldFont);

			exitItem = new java.awt.MenuItem("Exit");
			exitItem.addActionListener(event -> {
				Platform.exit();
				tray.remove(trayIcon);
			});

			popup = new java.awt.PopupMenu();
			popup.add(openItem);
			popup.add(ideItem);
			popup.addSeparator();
			popup.add(exitItem);
			if (user == null)
				popup.add(loginItem);
			else
				popup.add(logoutItem);

			trayIcon.setPopupMenu(popup);

			tray.add(trayIcon);
		} catch (java.awt.AWTException | IOException e) {
			System.out.println("Unable to init system tray");
			e.printStackTrace();
		}
	}

	public void showMainView() {
		if (stage != null) {
			if (user == null) {
				showLoginView();
				return;
			}
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainServiceView.fxml"));

			BorderPane rootLayout;
			try {
				rootLayout = (BorderPane) loader.load();

				mainServiceViewController = loader.getController();
				mainServiceViewController.setMainApp(Main.this);

				Scene scene = new Scene(rootLayout);
				stage.setScene(scene);
				stage.show();
				stage.toFront();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void showIDEManagement() {
		if (stage != null) {
			if (user == null) {
				showLoginView();
				return;
			}
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainServiceView.fxml"));
			BorderPane rootLayout;
			try {
				rootLayout = (BorderPane) loader.load();

				Scene scene = new Scene(rootLayout);
				stage.setScene(scene);
				stage.show();
				stage.toFront();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void showLoginView() {
		if (stage != null) {
			if (user != null) {
				showMainView();
				return;
			}
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/LoginView.fxml"));
			BorderPane rootLayout;
			try {
				rootLayout = (BorderPane) loader.load();

				LoginViewController controller = loader.getController();
				controller.setMainApp(Main.this);

				Scene scene = new Scene(rootLayout);
				stage.setScene(scene);
				stage.show();
				stage.toFront();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void logout() {
		if (XMLUtils.removeUser()) {
			popup.remove(logoutItem);
			popup.add(loginItem);
			user = null;
			stage.hide();
		}
	}

	public void setUser(User user) {
		this.user = user;
		popup.remove(loginItem);
		popup.add(logoutItem);
	}

	public void openRegistration() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RegistrationView.fxml"));
		AnchorPane rootLayout;
		try {
			rootLayout = (AnchorPane) loader.load();

			RegistrationViewController controller = loader.getController();
			controller.setMainApp(Main.this);

			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
			stage.toFront();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openAddProject() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/ProjectView.fxml"));
		BorderPane rootLayout;
		try {
			rootLayout = (BorderPane) loader.load();

			ProjectViewController controller = loader.getController();
			controller.setMainApp(Main.this);

			Scene scene = new Scene(rootLayout);
			stageDialog.setScene(scene);
			stageDialog.show();
			stageDialog.toFront();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openAddRequirement() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RequirementView.fxml"));
		BorderPane rootLayout;
		try {
			rootLayout = (BorderPane) loader.load();

			RequirementViewController controller = loader.getController();
			controller.setMainApp(Main.this);

			Scene scene = new Scene(rootLayout);
			stageDialog.setScene(scene);
			stageDialog.show();
			stageDialog.toFront();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refreshMainService() {
		mainServiceViewController.refreshList();
		stageDialog.hide();
	}

	public static void main(String[] args) throws IOException, java.awt.AWTException {
		launch(args);
	}
}
