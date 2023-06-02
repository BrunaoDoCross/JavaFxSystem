package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.CriptografiaAES;
import utils.UsuarioJsonUtil;

public class LoginController implements Initializable {

	@FXML
	private Button btnEntrar;

	@FXML
	private TextArea txtArea;

	@FXML
	private TextField txtIdade;

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtLoginRemover;

	@FXML
	private TextField txtSenha;


	List<Usuario> listaDeUsuarios = UsuarioJsonUtil.carregarUsuarios();
	Usuario usuario;

	@FXML
	void actCadastrar(ActionEvent event) {
		if (txtLogin.getText().isBlank() || txtSenha.getText().isBlank() || txtNome.getText().isBlank() || txtIdade.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de todos os campos no formulário...");
			if (txtSenha.getText().isBlank()) {
				txtSenha.requestFocus();
			}
			if (txtLogin.getText().isBlank()) {
				txtLogin.requestFocus();
			}
			if (txtIdade.getText().isBlank()) {
				txtIdade.requestFocus();
			}
			if (txtNome.getText().isBlank()) {
				txtNome.requestFocus();
			}
		}
		else {
			usuario = new Usuario();
			usuario.setLogin(CriptografiaAES.criptografar(txtLogin.getText()));
			usuario.setSenha(CriptografiaAES.criptografar(txtSenha.getText()));
			usuario.setNome(CriptografiaAES.criptografar(txtNome.getText()));
			usuario.setIdade(CriptografiaAES.criptografar(txtIdade.getText()));
			UsuarioJsonUtil.persistirUsuario(usuario);
			limparCampos();
			atualizarTabela();
			txtNome.requestFocus();
		}
	}

    @FXML
    void actRemover(ActionEvent event) {
    	UsuarioJsonUtil.removerUsuario(txtLoginRemover.getText());
    	atualizarTabela();
    }

	public void atualizarTabela() {
		listaDeUsuarios = UsuarioJsonUtil.carregarUsuarios();
		String texto = "";
		for (Usuario usuario : listaDeUsuarios) {
			texto += usuario.toString() + "\n";
		}
		txtArea.setText(texto);
	}

	public void limparCampos() {
		txtLogin.setText("");
		txtIdade.setText("");
		txtNome.setText("");
		txtSenha.setText("");
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizarTabela();
		txtNome.requestFocus();
	}
}