package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.CssSamples;

public class TelaMenuPrincipalController implements Initializable {

	/* ------>>>>>>> INSTÂNCIAS <<<<<<< ------ */
	
	private MainController controlador = new MainController();
	
	@FXML
	private AnchorPane anchorMain;

	@FXML
	private AnchorPane anchorMenuPrincipal;

	@FXML
	private AnchorPane anchorNovaTarefa;

	@FXML
	private AnchorPane anchorTarefas;

	@FXML
	private Button btnAbrirMenuTarefa;

	@FXML
	private Button btnNovaTarefa;

	@FXML
	private Button btnVoltar;

	@FXML
	private TextField txtTarefaId;

	@FXML
	private TextField txtTarefaTipo;

	@FXML
	private TextField txtTarefaTitulo;


	/* ------>>>>>>> MÉTODOS COM EVENTOS <<<<<<< ------ */

	/* ------> MENU DE TAREFAS <------ */

	@FXML
	// act Abrir o menu de tarefas
	void actAbrirMenuTarefa(ActionEvent event) {
		anchorMenuPrincipal.setVisible(false);
		anchorTarefas.setVisible(true);
	}

	@FXML
	// act Instânciar uma nova tarefa
	void actNovaTarefa(ActionEvent event) {
		anchorNovaTarefa.setVisible(true);
	}
	
    @FXML
    // act Voltar para a tela de Login / Cadastro
    void actLogoff(ActionEvent event) throws IOException {
    	controlador.abrirTelaDeLogin(event);
    }
	
	@FXML
	// act Voltar do menu de tarefas para o menu principal
	void actVoltar(ActionEvent event) {
		anchorMenuPrincipal.setVisible(true);
		anchorTarefas.setVisible(false);
		anchorNovaTarefa.setVisible(false);
	}
	
    @FXML
    // fx Efeito de aumentar botão ao passar mouse
    void fxMouseIn(MouseEvent event) {
    	Button b = (Button) event.getSource();
    	b.setStyle(CssSamples.animaMouseIn(10, 10));
    }

    @FXML
    // fx Voltar botão ao normal ao retirar mouse
    void fxMouseOut(MouseEvent event) {
    	Button b = (Button) event.getSource();
    	b.setStyle(CssSamples.animaMouseBack());
    }

	/* ------>>>>>>> MÉTODOS SEM EVENTOS <<<<<<< ------ */

	// Iniciar AnchorPanes corretamente no inicio do código
	private void initializeAnchor() {
		anchorMain.setVisible(true);
		anchorMenuPrincipal.setVisible(true);
		
		anchorTarefas.setVisible(false);
		anchorNovaTarefa.setVisible(false);
	}
	
	
	@Override
	// Método que é executado primeiro
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeAnchor();
	}
}
