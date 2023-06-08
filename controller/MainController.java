package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

	// Chamar tela de login de outros controladores
	public void abrirTelaDeLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/TelaDeLogin.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	// Chamar tela de cadastro de outros controladores
	public void abrirTelaDeCadastro(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/TelaDeCadastro.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	// Chamar tela de Menu Principal de outros controladores
	public void abrirTelaMenuPrincipal(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/TelaMenuPrincipal.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

}
