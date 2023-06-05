package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.CriptografiaAES;
import utils.UsuarioJsonUtil;

public class TelaDeLoginController implements Initializable {

	List<Usuario> listaDeUsuarios;
	Usuario usuario;

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnErrorOk;

	@FXML
	private HBox hBoxErro;

	@FXML
	private Label txtErro;

	@FXML
	private PasswordField txtSenhaLogin;

	@FXML
	private TextField txtUsuarioLogin;

	@FXML
	void actEntrar(ActionEvent event) {

		if (!isCamposVazios()) {
			validarCredenciais();
		}
	}

	@FXML
	void actErroOk(ActionEvent event) {
		esconderErro();
	}
	
	@FXML
	public void abrirTelaDeCadastro(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/TelaDeCadastro.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	// -----> METODOS SEM EVENTOS <-----
	public void aoIniciar() {
		limparCampos();
		esconderErro();
	}

	public void limparCampos() {
		txtUsuarioLogin.setText("");
		txtSenhaLogin.setText("");
		txtUsuarioLogin.requestFocus();
	}

	public void habilitarErro(String erro) {
		if (hBoxErro.isVisible()) {
			txtErro.setText(erro);
		} else {
			hBoxErro.setVisible(true);
			txtErro.setText(erro);
		}
	}

	public void esconderErro() {
		txtErro.setText("Nenhuma mensagem passada de erro...");
		hBoxErro.setVisible(false);
	}

	public boolean isCamposVazios() {
		if (txtUsuarioLogin.getText().isBlank()) {
			habilitarErro("Campo de Login vazio...");
			txtUsuarioLogin.requestFocus();
			return true;
		} else if (txtSenhaLogin.getText().isBlank()) {
			habilitarErro("Campo de Senha vazio...");
			txtSenhaLogin.requestFocus();
			return true;
		} else if (txtUsuarioLogin.getText().isBlank() && txtSenhaLogin.getText().isBlank()) {
			habilitarErro("Campos de Login e Senha estão vazios...");
			txtUsuarioLogin.requestFocus();
			return true;
		} else {
			return false;
		}

	}

	public void validarCredenciais() {
		listaDeUsuarios = UsuarioJsonUtil.carregarUsuarios();
		usuario = new Usuario();

		for (Usuario u : listaDeUsuarios) {
			if (CriptografiaAES.descriptografar(u.getLogin()).equals(txtUsuarioLogin.getText())
					&& CriptografiaAES.descriptografar(u.getSenha()).equals(txtSenhaLogin.getText())) {
				habilitarErro("Usuário e senha encontrados!");
				break;
			} else {
				habilitarErro("Usuário e/ou Senha não encontrados!");
			}
		}
	}

	// -----> AO INICIALIZAR <-----
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		aoIniciar();
	}

}
