package ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;

public class ControllerClassGUI {
	
	private LaCucharita GH=new LaCucharita();
		
	private String temp="";
	private String[] temp2;
	private String tempa="";
	private String[] tempa2;
	private String tempPName="";
	
	
	public ControllerClassGUI(LaCucharita gh) {
	GH=gh;
	}
	//Ingredients
	 	@FXML
	    private BorderPane ingredientsBorder;
	 	
	   @FXML
	    private TableView<String> ingredientsTbv;

	    @FXML
	    private TableColumn<String, String> ingredientsCol1tbv;

	    @FXML
	    private TextField ingredientNametxt;
	    
	    
	    @FXML
	    void addIngredientbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=ingredientNametxt.getText();
	    	if(GH.createIngredient(name)) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("Info");
	        alert.setContentText("El ingrediente se añadió");
	        alert.showAndWait();
	        initializetbvIngredients();
	    	}
	    	else {
	    		 	Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El producto ya existe o hubo una excepción");
	    		    alert.showAndWait();
	    		    initializetbvIngredients();
	    	}
	    }

	    @FXML
	    void deleteIngredientbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=ingredientNametxt.getText();
	    	if(GH.deleteIngredients(name)) {
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setHeaderText(null);
		        alert.setTitle("Info");
		        alert.setContentText("El ingrediente se elimino");
		        alert.showAndWait();
		        initializetbvIngredients();
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("El producto no existe o hubo una excepción");
    		    alert.showAndWait();
    		    initializetbvIngredients();
	    	}
	    	
	    }

	    @FXML
	    void disIngredientbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=ingredientNametxt.getText();
	    	if(GH.disableIngredients(name)) {
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setHeaderText(null);
		        alert.setTitle("Info");
		        alert.setContentText("El ingrediente se deshabilito");
		        alert.showAndWait();
		        initializetbvIngredients();
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("El producto no existe o hubo una excepción");
    		    alert.showAndWait();
    		    initializetbvIngredients();
	    	}
	    }

	    @FXML
	    private TextField newIngredientNametxt;

	    @FXML
	    void updateIngredientbtn(ActionEvent event) {
	    	String name=ingredientNametxt.getText();
	    	String newName=newIngredientNametxt.getText();
	    	if(GH.updateIngredients(name, newName)) {
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setHeaderText(null);
		        alert.setTitle("Info");
		        alert.setContentText("El ingrediente se actualizo");
		        alert.showAndWait();
		        initializetbvIngredients();
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("El producto no existe o hubo una excepción");
    		    alert.showAndWait();
    		    initializetbvIngredients();
	    	}
	    }
	    
	    public void initializetbvIngredients() {
	    	ObservableList<String> ingredientsObservable;
	    	ingredientsObservable=FXCollections.observableArrayList(GH.getIngredients());
	    	ingredientsTbv.setItems(ingredientsObservable);
	    	ingredientsCol1tbv.setCellValueFactory(ingredients -> new SimpleStringProperty(ingredients.getValue()));
	    	
	    }
	
	    //Types
	    
	    @FXML
	    public void initializeTbvTypes() {
	    	ObservableList<String> typesObservable;
	    	typesObservable=FXCollections.observableArrayList(GH.getTypesList());
	    	ingredientsTbv.setItems(typesObservable);
	    	ingredientsCol1tbv.setCellValueFactory(types -> new SimpleStringProperty(types.getValue()));
	    }
	    private BorderPane tiposBorder;

	    @FXML
	    private TableView<String> TypeTbv;

	    @FXML
	    private TableColumn<String, String> typeColtbv;

	    @FXML
	    private TextField TypeNametxt;

	    @FXML
	    private TextField newTypeNametxt;

	    @FXML
	    void addTypebtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=TypeNametxt.getText();
	    	if(GH.createType(name)) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("Info");
	        alert.setContentText("El tipo se añadió");
	        alert.showAndWait();
	        initializeTbvTypes();
	        }
	    	else {
	    		 	Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo ya existe o hubo una excepción");
	    		    alert.showAndWait();
	    		    initializeTbvTypes();
	    	}
	    }

	    @FXML
	    void deleteTypebtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=TypeNametxt.getText();
	    	if(GH.deleteType(name)) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("Info");
	        alert.setContentText("El tipo se elimino");
	        alert.showAndWait();
	        initializeTbvTypes();
	        }
	    	else {
	    		 	Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo no existe o hubo una excepción");
	    		    alert.showAndWait();
	    		    initializeTbvTypes();
	    	}
	    }

	    @FXML
	    void disTypebtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String name=TypeNametxt.getText();
	    	if(GH.disableType(name)) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("Info");
	        alert.setContentText("El tipo se deshabilito ya no aparecerá en la listaa la hora de realizar un pedido");
	        alert.showAndWait();
	        initializeTbvTypes();
	        }
	    	else {
	    		 	Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo no existe o hubo una excepción");
	    		    alert.showAndWait();
	    		    initializeTbvTypes();
	    	}
	    }

	    @FXML
	    void updateTypebtn(ActionEvent event) {
	    	String name=TypeNametxt.getText();
	    	String newName=newTypeNametxt.getText();
	    	if(GH.updateTypes(name, newName)) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setHeaderText(null);
	        alert.setTitle("Info");
	        alert.setContentText("El tipo se actualizo");
	        alert.showAndWait();
	        initializeTbvTypes();
	        }
	    	else {
	    		 	Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo no existe o hubo una excepción");
	    		    alert.showAndWait();
	    		    initializeTbvTypes();
	    	}
	    }
	    
	    //products
	    
	    
	    public void initializeTbvProducts() {
	    	ObservableList<Products> productsObservable;
	    	productsObservable=FXCollections.observableArrayList(GH.getProducts());
	    	ProductTbv.setItems(productsObservable);
	    	ProductColtbv.setCellValueFactory(new PropertyValueFactory<Products,String>("name"));
	    	ProductIngrColtbv.setCellValueFactory(new PropertyValueFactory<Products,String>("ingredients"));
	    	ProductSizeColtbv.setCellValueFactory(new PropertyValueFactory<Products,String>("size"));
	    	ProductTypeColtbv.setCellValueFactory(new PropertyValueFactory<Products,String>("type"));
	    	ProductPriceColtbv.setCellValueFactory(new PropertyValueFactory<Products, Double>("price"));
	    	
	    }
	  
	    
	    @FXML
	    private TableColumn<Products, String> ProductTypeColtbv;

	    @FXML
	    private TableColumn<Products, String> ProductIngrColtbv;

	    @FXML
	    private TableColumn<Products, Double> ProductPriceColtbv;
	    
	    @FXML
	    private TableColumn<Products, String> ProductSizeColtbv;
	    
	    @FXML
	    private BorderPane productBorder;

	    @FXML
	    private TableView<Products> ProductTbv;

	    @FXML
	    private TableColumn<Products, String> ProductColtbv;

	    @FXML
	    private TextField productNametxt;

	    @FXML
	    private TextField newProductNametxt;

	    @FXML
	    void addProductbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Generic.fxml"));
	    	loader.setController(this);
            genericBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(genericBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Ingredient to a product return array[] with ingredients
	    public void initializeTbvIngredientsToP() {
	    	ObservableList<String> ingredientsObservable;
	    	ingredientsObservable=FXCollections.observableArrayList(GH.getIngredients());
	    	ingredientstoProductTbv.setItems(ingredientsObservable);
	    	ingredientstoProductCol1tbv.setCellValueFactory(ingredients -> new SimpleStringProperty(ingredients.getValue()));
	    }
	    @FXML
	    private BorderPane ingredients2Border;

	    @FXML
	    private TableView<String> ingredientstoProductTbv;

	    @FXML
	    private TableColumn<String, String> ingredientstoProductCol1tbv;

	    @FXML
	    private TextField ingredientToProductNametxt;

	    @FXML
	    void EndIngredientbtn(ActionEvent event) throws IOException {
	    	temp2=temp.split(" ");
	    	temp="";
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Generic.fxml"));
	    	loader.setController(this);
	    	genericBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(genericBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Generic FXML
	    @FXML
	    private BorderPane genericBorder;

	    @FXML
	    private TextField newNamePtxt;

	    @FXML
	    private TextField newpricetxt;

	    @FXML
	    private TextField Newsizetxt;

	    @FXML
	    private TextField newtypetxt;

	    @FXML
	    void addIngredientsToPbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingredients chooser.fxml"));
	    	loader.setController(this);
	    	ingredients2Border = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(ingredients2Border);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void AddProduct(ActionEvent event) throws IOException {
	    	if(newNamePtxt.getText()!=""&&Newsizetxt.getText()!=""&&newtypetxt.getText()!=""&&newpricetxt.getText()!="") {
	    		String name=newNamePtxt.getText();
	    		String type="";
	    		if(GH.chooseTypeToAProduct(newtypetxt.getText())) {
	    			type=newtypetxt.getText();
	    		}
	    		else {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo no existe escoja uno que sí sea valido");
	    		    alert.showAndWait();
	    		   
	    		}
	    		double price=Double.parseDouble(newpricetxt.getText());
	    		String size=Newsizetxt.getText();
	    		if(type!="") {
	    			if(GH.createProduct(name, type, temp2, size, price)) {
	    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    		        alert.setHeaderText(null);
	    		        alert.setTitle("Info");
	    		        alert.setContentText("El producto se añadió");
	    		        alert.showAndWait();
	    		       
	    			}
	    			else {
	    				Alert alert = new Alert(Alert.AlertType.ERROR);
		    		    alert.setHeaderText(null);
		    		    alert.setTitle("Error");
		    		    alert.setContentText("El producto no se añadio alguno de los parametros están mal");
		    		    alert.showAndWait();
	    			}
	    		}
	    		
	    	}
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Products.fxml"));
	    	loader.setController(this);
	    	productBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(productBorder);
            appStage.setScene(scene);
            appStage.show();
            initializeTbvProducts();
	    }
	    //end

	    @FXML
	    void addIngredienToProducttbtn(ActionEvent event) {
	    			temp+=ingredientToProductNametxt.getText()+"";			
	    			
	    }
	    
// products again
	    @FXML
	    void delProductbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String a=productNametxt.getText();
	    	if(GH.deleteProduct(a)) {
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setHeaderText(null);
		        alert.setTitle("Info");
		        alert.setContentText("El producto se eliminó");
		        alert.showAndWait();
		        initializeTbvProducts();
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("El producto no existe escoja uno que sí sea valido");
    		    alert.showAndWait();
    		    initializeTbvProducts();
	    	}
	    }

	    @FXML
	    void disProductbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	String a=productNametxt.getText();
	    	if(GH.disableProduct(a)) {
	    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setHeaderText(null);
		        alert.setTitle("Info");
		        alert.setContentText("El producto se deshabilito ya no aparecerá en los pedidos");
		        alert.showAndWait();
		        initializeTbvProducts();

	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("El producto no existe escoja uno que sí sea valido");
    		    alert.showAndWait();
    		    initializeTbvProducts();
	    	}

	    }

	    @FXML
	    void updateProductbtn(ActionEvent event) throws IOException {
	    	tempPName=productNametxt.getText();
	    	if(productNametxt.getText()!="") {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Generic2.fxml"));
	    	loader.setController(this);
	    	generic2Border = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(generic2Border);
            appStage.setScene(scene);
            appStage.show();
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("Porfavor seleccione el nombre del producto a actualizar en la casilla NOMBRE DE PRODUCTO");
    		    alert.showAndWait();
	    	}
            
	    }
//Generic 2
	    @FXML
	    private BorderPane generic2Border;

	    @FXML
	    private TextField newName2Ptxt;

	    @FXML
	    private TextField newprice2txt;

	    @FXML
	    private TextField Newsize2txt;

	    @FXML
	    private TextField newtype2txt;

	    @FXML
	    void AddProduct2(ActionEvent event) throws FileNotFoundException, IOException {
	    	if(newName2Ptxt.getText()!=""&&Newsize2txt.getText()!=""&&newtypetxt.getText()!=""&&newprice2txt.getText()!="") {
	    		String name=newName2Ptxt.getText();
	    		String type="";
	    		if(GH.chooseTypeToAProduct(newtype2txt.getText())) {
	    			type=newtype2txt.getText();
	    		}
	    		else {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("El tipo no existe escoja uno que sí sea valido");
	    		    alert.showAndWait();
	    		   
	    		}
	    		double price=Double.parseDouble(newprice2txt.getText());
	    		String size=Newsize2txt.getText();
	    		if(type!="") {
	    			if(GH.updateNameProducts(tempPName, name)&&GH.updatePrice(tempPName, price)&&
					GH.updateSize(tempPName, size)&&GH.updateTypeProducts(tempPName, type)&&GH.updateIngredientstoaProduct(tempPName, tempa2)) {
	    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    		        alert.setHeaderText(null);
	    		        alert.setTitle("Info");
	    		        alert.setContentText("El producto se acualizo ");
	    		        alert.showAndWait();
	    		       
	    			}
	    			else {
	    				Alert alert = new Alert(Alert.AlertType.ERROR);
		    		    alert.setHeaderText(null);
		    		    alert.setTitle("Error");
		    		    alert.setContentText("El producto no se actualizo");
		    		    alert.showAndWait();
		    			
	    			}
	    			
	    		}
	    	}
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Products.fxml"));
	    	loader.setController(this);
	    	productBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(productBorder);
            appStage.setScene(scene);
            appStage.show();
            initializeTbvProducts();
	    }

	    @FXML
	    void addIngredientsToP2btn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingredients chooser2.fxml"));
	    	loader.setController(this);
	    	ingredientsc2Border = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(ingredientsc2Border);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Ingredients chooser 2
	    @FXML
	    private BorderPane ingredientsc2Border;

	    @FXML
	    private TableView<String> ingredientstoProduct2Tbv;

	    @FXML
	    private TableColumn<String, String> ingredientstoProduct2Col1tbv;

	    @FXML
	    private TextField ingredientToProduct2Nametxt;

	    @FXML
	    void EndIngredient2btn(ActionEvent event) throws IOException {
	    	tempa2=tempa.split(" ");
	    	tempa="";
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Generic2.fxml"));
	    	loader.setController(this);
	    	generic2Border = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(generic2Border);
            appStage.setScene(scene);
            appStage.show();
	    }

	    @FXML
	    void addIngredienToProductt3btn(ActionEvent event) {
	    	tempa+=ingredientToProductNametxt.getText()+"";
	    }
	    
	    //Login
	    
	    @FXML
	    private BorderPane loginPane;

	    @FXML
	    private TextField usernamelogintxt;

	    @FXML
	    private PasswordField passwordlogintxt;

	    @FXML
	    private Label message;

	    @FXML
	    void signinloginBtn(ActionEvent event) throws IOException {
	    	System.out.println(GH.getUsers().size());
	    	for(int i=0;i<GH.getUsers().size();i++) {
	    		if(usernamelogintxt.getText().equals(GH.getUsers().get(i).getUsername())) {
	    			if(passwordlogintxt.getText().equals(GH.getUsers().get(i).getPassword())) {
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	    	loader.setController(this);
	    	    	menuBorder = (BorderPane) loader.load();
	                Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
	                appStage.getOnCloseRequest();
	                Scene scene = new Scene(menuBorder);
	                appStage.setScene(scene);
	                appStage.show();
	    			}
	    			else {
	    				Alert alert = new Alert(Alert.AlertType.ERROR);
		    		    alert.setHeaderText(null);
		    		    alert.setTitle("Error");
		    		    alert.setContentText("contraseña erronea");
		    		    alert.showAndWait();
	    			}
	    		}
	    		else {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    		    alert.setHeaderText(null);
	    		    alert.setTitle("Error");
	    		    alert.setContentText("Usuario erroneo");
	    		    alert.showAndWait();
	    		}
	    	}
	    }

	    @FXML
	    void signuploginBtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
	    	loader.setController(this);
	    	RegisterPane = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(RegisterPane);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Register
	    @FXML
	    private BorderPane RegisterPane;

	    @FXML
	    private TextField lastNameUsertxt;

	    @FXML
	    private TextField idUsertxt;

	    @FXML
	    private TextField usernameUsertxt;

	    @FXML
	    private TextField passwordUsertxt;

	    @FXML
	    private TextField repasswordUsertxt;

	    @FXML
	    private TextField nameUsertxt;

	    @FXML
	    void registerbtn(ActionEvent event) throws FileNotFoundException, IOException {
	    	if(passwordUsertxt.getText().equals(repasswordUsertxt.getText())) {
	    		if(GH.createUser(nameUsertxt.getText(),lastNameUsertxt.getText(),idUsertxt.getText(), usernameUsertxt.getText(), passwordUsertxt.getText())) {
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		        alert.setHeaderText(null);
    		        alert.setTitle("Info");
    		        alert.setContentText("Usuario creado");
    		        alert.showAndWait();
    		        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    		    	loader.setController(this);
    	           loginPane = (BorderPane) loader.load();
    	            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
    	            appStage.getOnCloseRequest();
    	            Scene scene = new Scene(loginPane);
    	            appStage.setScene(scene);
    	            appStage.show();
		    	}
	    	}
	    	else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setTitle("Error");
    		    alert.setContentText("Las contraseñas no coinciden");
    		    alert.showAndWait();
	    	}
	    	
	    }

	    @FXML
	    void turnbackbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
	    	loader.setController(this);
	    	loginPane = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(loginPane);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Menu
	    @FXML
	    private BorderPane menuBorder;

	    @FXML
	    void Gencsv(ActionEvent event) {

	    }

	    @FXML
	    void Gestionbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu2.fxml"));
	    	loader.setController(this);
	    	menuBorder2 = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder2);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Menu2
	    @FXML
	    private BorderPane menuBorder2;
	    
	    @FXML
	    void Backtomenu2(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }

	    @FXML
	    void GestClient(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
	    	loader.setController(this);
	    	clientBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(clientBorder);
            appStage.setScene(scene);
            appStage.show();
            initializetbvIngredients();
	    }

	    @FXML
	    void GestIngr(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingredient.fxml"));
	    	loader.setController(this);
	    	ingredientsBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(ingredientsBorder);
            appStage.setScene(scene);
            appStage.show();
            initializetbvIngredients();
	    }

	    @FXML
	    void GestProduct(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Products.fxml"));
	    	loader.setController(this);
	    	productBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(productBorder);
            appStage.setScene(scene);
            appStage.show();
            initializeTbvProducts();
	    }

	    @FXML
	    void GestType(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Types.fxml"));
	    	loader.setController(this);
	    	tiposBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(tiposBorder);
            appStage.setScene(scene);
            appStage.show();
            initializeTbvTypes();
	    }

	    @FXML
	    void GestUser(ActionEvent event) throws IOException {
	    	
	    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Users.fxml"));
		    	loader.setController(this);
		    	 usersBorder = (BorderPane) loader.load();
	            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
	            appStage.getOnCloseRequest();
	            Scene scene = new Scene( usersBorder);
	            appStage.setScene(scene);
	            appStage.show();
	    }
	   
	    @FXML
	    void Registerbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu3.fxml"));
	    	loader.setController(this);
	    	menuBorder3 = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder3);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Menu3
	    @FXML
	    private BorderPane menuBorder3;
	    
	    @FXML
	    void RegCambiPed(ActionEvent event) {

	    }

	    @FXML
	    void RegPedi(ActionEvent event) {

	    }

	    @FXML
	    void formbtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu4.fxml"));
	    	loader.setController(this);
	    	menuBorder4 = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder4);
            appStage.setScene(scene);
            appStage.show();
	    }
	    @FXML
	    void Backtomenu3(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Menu4

	    @FXML
	    private BorderPane menuBorder4;

	    @FXML
	    void FormEmp(ActionEvent event) {

	    }

	    @FXML
	    void Formingre(ActionEvent event) {

	    }

	    @FXML
	    void Formped(ActionEvent event) {

	    }

	    @FXML
	    void formClient(ActionEvent event) {

	    }

	    @FXML
	    void formUser(ActionEvent event) {

	    }

	    @FXML
	    void formproduc(ActionEvent event) {

	    }
	    
	    @FXML
	    void backtomenu4(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void BacktomenuPro(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void backtomenuIngr(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void backtomenuTy(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void backfromgeneric(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    void backformgenr(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Users
	    
	    @FXML
	    private BorderPane usersBorder;

	    @FXML
	    private TableView<User> usersTbv;

	    @FXML
	    private TableColumn<User, String> usersCol1tbv;

	    @FXML
	    private TextField userrtNametxt;

	    @FXML
	    void adduser(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Register2.fxml"));
	    	loader.setController(this);
	    	RegisterPane2 = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(RegisterPane2);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    //Register2
	    
	    @FXML
	    private BorderPane RegisterPane2;

	    @FXML
	    private TextField lastNameUser2txt;

	    @FXML
	    private TextField idUser2txt;

	    @FXML
	    private TextField usernameUser2txt;

	    @FXML
	    private TextField passwordUser2txt;

	    @FXML
	    private TextField repasswordUser2txt;

	    @FXML
	    private TextField nameUser2txt;

	    @FXML
	    void registerbtn2(ActionEvent event) throws FileNotFoundException, IOException {
	    	
	    }

	    @FXML
	    void turnbackbtn2(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }

	    @FXML
	    void deleteuser(ActionEvent event) {

	    }

	    @FXML
	    void updateUserInfo(ActionEvent event) {

	    }
	    
	    @FXML
	    void comeback(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    	loader.setController(this);
            menuBorder = (BorderPane) loader.load();
            Stage appStage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            appStage.getOnCloseRequest();
            Scene scene = new Scene(menuBorder);
            appStage.setScene(scene);
            appStage.show();
	    }
	    
	    @FXML
	    private BorderPane clientBorder;

	    @FXML
	    private TableView<?> clientTbv;

	    @FXML
	    private TableColumn<?, ?> clientCol1tbv;

	    @FXML
	    private TextField clientNametxt;

	    @FXML
	    void Updateclient(ActionEvent event) {

	    }

	    @FXML
	    void addClient(ActionEvent event) {

	    }

	    @FXML
	    void comeback2(ActionEvent event) {

	    }

	    @FXML
	    void deleteClient(ActionEvent event) {

	    }
	    
	    //Orders
	    
	    
}