package reaquecimento;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;

public class JanelaFX extends Application  {

	private ComboBox<String> consultaNumCaixa;
	private TextField consultaNome;
	private TextField consultaIdade;
	private Banco banco;
	private static TextArea textArea;
	Window stage = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		setup();
		textArea = new TextArea();
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #1abc9c;");
		GridPane leftPane = new GridPane();
		leftPane.setAlignment(Pos.CENTER);
		leftPane.setHgap(10);
		leftPane.setVgap(10);
		leftPane.setPadding(new Insets(10, 10, 10, 10));
	
		//----botões--//
		Button btnConsultaNumCaixa = new Button("Enviar");
		btnConsultaNumCaixa.setPrefWidth(250);
		btnConsultaNumCaixa.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(btnConsultaNumCaixa, 0, 9);
		Button btnConsulta = new Button("Enviar");
		btnConsulta.setPrefWidth(250);
		btnConsulta.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(btnConsulta, 1, 9);
		
		
		//-----Número do caixa do banco---/
		String[] options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		consultaNumCaixa = new ComboBox<String>(FXCollections.observableArrayList(options));
		leftPane.add(consultaNumCaixa, 0, 8);
		consultaNumCaixa.setStyle("-fx-background-color:#ecf0f1");
		consultaNumCaixa.setPromptText("Número do caixa");
		btnConsultaNumCaixa.setOnAction(e -> {
			if(consultaNumCaixa.getSelectionModel().getSelectedItem() != null){
				consultaNumCaixa();
			}
        });
	
		//-----Nome e idade do usuário---/

		consultaNome = new TextField("Nome");
		consultaNome.setPrefWidth(200);
		consultaNome.setStyle("-fx-background-color:#ecf0f1");
		consultaIdade = new TextField("Idade");
		consultaIdade.setPrefWidth(200);
		consultaIdade.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(consultaNome, 1, 7);
		leftPane.add(consultaIdade, 1, 8);
		
		btnConsulta.setOnAction(e -> {
			if(consultaNome.getText() != null || consultaIdade.getText() !=null){
				consulta();
			}
		});
		
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(5);
		root.getChildren().add(new Label("Output consulta04:"));
		root.getChildren().add(textArea);

		pane.setLeft(leftPane);
		pane.setBottom(root);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercício de reaquecimento");
	
		primaryStage.show();
	}
	private void setup() {
		banco = new Banco();
	}
	
	public void consulta(){
		textArea.setText(" ");
		String inputName = consultaNome.getText();
		int inputNumber =  Integer.parseInt(consultaIdade.getText());
		banco.adicionaNaFila(new Cliente(inputName, inputNumber));
		textArea.setText("Aguarde na fila, por favor, você será chamado em breve");
	}
	public void consultaNumCaixa(){
		textArea.setText(" ");
		int numero = Integer.parseInt(consultaNumCaixa.getSelectionModel().getSelectedItem());
			Cliente cliente = banco.retiraFila(new Caixa(numero));
			textArea.setText("Próximo usuário é: " + cliente.getNome());
	}

}
