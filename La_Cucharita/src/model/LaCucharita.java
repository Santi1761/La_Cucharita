package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LaCucharita implements Serializable  {

private static final long serialVersionUID = 4L;
private ArrayList<Products> productsList;
private ArrayList<Products> productsEnabled;
private ArrayList<String> typesAmount;
private ArrayList<String> typesEnabled;
private ArrayList<String> ingredients;
private ArrayList<String> ingredientsEnabled;
private ArrayList<Client> clients;
private ArrayList<User> users;
private ArrayList<Order> orders;
private ArrayList<String> codeAmount;
private ArrayList<LocalDateTime> dates;
private final static String PRODUCTS_SAVE_PATH_FILE="Data/products.muc";
private final static String PRODUCTSENABLED_SAVE_PATH_FILE="Data/ProductsEnabled.muc";
private final static String ORDER_SAVE_PATH_FILE="Data/Order.muc";
private final static String USER_SAVE_PATH_FILE="Data/User.muc";
private final static String CLIENT_SAVE_PATH_FILE="Data/Client.muc";
private final static String INGREDIENTS_SAVE_PATH_FILE="Data/Ingredients.muc";
private final static String INGREDIENTSENABLED_SAVE_PATH_FILE="Data/IngredientsEnabled.muc";
private final static String TYPESENABLED_SAVE_PATH_FILE="Data/TypesEnabled.muc";
private final static String TYPES_SAVE_PATH_FILE="Data/Types.muc";
private final static String CODES_SAVE_PATH_FILE="Data/Codes.muc";
private final static String DATES_SAVE_PATH_FILE="Data/Dates.muc";
private  String separator;




	public LaCucharita() {
		
		productsList=new ArrayList<Products>();
		productsEnabled=productsList;
		typesAmount=new ArrayList<String>();
		typesEnabled=typesAmount;
		ingredients=new ArrayList<String>();
		ingredientsEnabled= ingredients;
		clients=new ArrayList<Client>();
		users=new ArrayList<User>();
		codeAmount=new ArrayList<String>();
		dates=new ArrayList<LocalDateTime>();
		separator=";";
		
	
		 
	}
	//getters de ArrayList
	public ArrayList<LocalDateTime> getDate(){
		return dates;
	}
	
	public ArrayList<String> getCodes(){
		return codeAmount;
	}
	public ArrayList<User> getUsers(){
		return users;
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	public ArrayList<String> getTypesEnabled(){
		return typesEnabled;
	}
	public ArrayList<String> getTypesList(){
		return typesAmount;
	}
	public ArrayList<Products> getEnabledProducts(){
		return productsEnabled;
	}
	public ArrayList<Products> getProducts(){
		return productsList;
	}
	public ArrayList<String> getIngredients(){
		return ingredients;
	}
	public ArrayList<String> getIngredientsEnabled(){
		return ingredientsEnabled;
	}
//Serialización
	
	public void saveProductsData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(PRODUCTS_SAVE_PATH_FILE));
		writer.writeObject(productsList);
		writer.close();
	}
	@SuppressWarnings("unchecked")
	public boolean loadProductsData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(PRODUCTS_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			productsList=(ArrayList<Products>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveProductsEnabledData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(PRODUCTSENABLED_SAVE_PATH_FILE));
		writer.writeObject(productsEnabled);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadProductsEnabledData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(PRODUCTSENABLED_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			productsEnabled=(ArrayList<Products>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveOrdersData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(ORDER_SAVE_PATH_FILE));
		writer.writeObject(orders);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadOrders() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(ORDER_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			orders=(ArrayList<Order>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveUserData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(USER_SAVE_PATH_FILE));
		writer.writeObject(users);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(USER_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			users=(ArrayList<User>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveClientData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(CLIENT_SAVE_PATH_FILE));
		writer.writeObject(clients);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadClient() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(CLIENT_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			clients=(ArrayList<Client>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveIngredientData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
		writer.writeObject(ingredients);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadIngredients() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(INGREDIENTS_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			ingredients=(ArrayList<String>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveIngredientEnabledData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(INGREDIENTSENABLED_SAVE_PATH_FILE));
		writer.writeObject(ingredientsEnabled);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadIngredientsEnabled() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(INGREDIENTSENABLED_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			ingredientsEnabled=(ArrayList<String>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveTypesEnabledData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(TYPESENABLED_SAVE_PATH_FILE));
		writer.writeObject(typesEnabled);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadTypesEnabled() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(TYPESENABLED_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			typesEnabled=(ArrayList<String>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveTypesData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(TYPES_SAVE_PATH_FILE));
		writer.writeObject(typesAmount);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadTypes() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(TYPES_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			typesAmount=(ArrayList<String>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveCodesData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(CODES_SAVE_PATH_FILE));
		writer.writeObject(codeAmount);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadCodes() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(CODES_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			codeAmount=(ArrayList<String>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	public void saveDatesData() throws FileNotFoundException, IOException {
		ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(DATES_SAVE_PATH_FILE));
		writer.writeObject(dates);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadDates() throws FileNotFoundException, IOException, ClassNotFoundException {
		File a= new File(DATES_SAVE_PATH_FILE);
		boolean loaded=false;
		if(a.exists()) {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(a));
			dates=(ArrayList<LocalDateTime>)reader.readObject();
			reader.close();
			loaded=true;
		}
		return loaded;
	}
	
	
	//Productos
	public boolean createProduct(String name, String type, String[] ingredients, String size, double price) throws FileNotFoundException, IOException {
		Products productsTemp=new Products(name, type, ingredients, size, price);
		if(productsList.isEmpty()) {
			productsList.add(productsTemp);
			saveProductsData();
			return true;
		}
		if(productsList.add(productsTemp)) {
			if(productsList.size()>1) {
				sortProducts(productsList);
			}
			saveProductsData();
			return true;
		}
		return false;
	}
	
	//Creo un type para los productos
	public boolean createType(String name) throws FileNotFoundException, IOException {
		if(typesAmount.isEmpty()) {
			typesAmount.add(name);
			saveTypesData();
			return true;
		}
		for(int i=0;i<typesAmount.size();i++) {
			if(name.equalsIgnoreCase(typesAmount.get(i))) {
				return false;
			}
			else {
				typesAmount.add(name);
				saveTypesData();
				return true;
			}
		}
		return false;
	}
	//Se escoge el tipo que se le va a pasar al constructor
	//metodo para la Ui de esta forma se valida si el tipo sí existe
	
	public boolean chooseTypeToAProduct(String type) {
		for(int i=0;i<typesAmount.size();i++){
			if(type.equalsIgnoreCase(typesAmount.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean createIngredient(String ingredient) throws FileNotFoundException, IOException {
		if(ingredients.isEmpty()) {
			ingredients.add(ingredient);
			saveIngredientData();
			return true;
		}
		for(int i=0;i<ingredients.size();i++) {
			if(ingredient.equalsIgnoreCase(ingredients.get(i))) {
				return false;
			}
			else {
				ingredients.add(ingredient);
				saveIngredientData();
				return true;
			}
		}
		
		return false;
	}
	//El metodo que acompaña a este para la UI debe poder tomar el número de ingredientes que el usuario seleccione
	//Cree un array String de ese tamaño
	//y tome el nombre de cada uno de los campos y se los agregue al array String en desorden.
	//De esta forma se le escogerá un String[] para el producto indicado.
	public String[] chooseIngredientToAProduct(String[] ingredient) {
		String[] finalIngredient=amountIngredientToAProduct(ingredient);
		for(int i=0; i<ingredient.length;i++) {
			for(int j=0;j<ingredientsEnabled.size();j++) {
				if(ingredient[i].equalsIgnoreCase(ingredientsEnabled.get(j))) {
					finalIngredient[i]=ingredient[i];
				}
			}
		}
		return finalIngredient;
	}
	
	public String[] amountIngredientToAProduct(String[] ingredient) {
		int amount=0;
		for(int i=0;i<ingredient.length;i++){
			for(int j=0;j<ingredients.size();j++) {
			if(ingredient[i].equalsIgnoreCase(ingredients.get(j))) {
				amount++;	
			}
		}
	}
		String[] finalIngredients=new String[amount];
		return finalIngredients;
		
	}
	//Si se no se agrega es porque existe previamente.

	
	
	
	public boolean deleteProduct(String name) throws FileNotFoundException, IOException {
		for(int i=0; i<productsList.size();i++) {
			for(int j=0;j<productsEnabled.size();j++) {
			if(name.equalsIgnoreCase(productsList.get(i).getName())) {
				productsList.remove(i);
				saveProductsData();
				if(name.equalsIgnoreCase(productsEnabled.get(i).getName())){
					productsEnabled.remove(j);
					saveProductsEnabledData();
				}
				return true;
			}
		}
	}
		return false;
}
	
	public boolean deleteType(String type) throws FileNotFoundException, IOException {
		for(int i=0;i<productsList.size();i++) {
			if(!(type.equalsIgnoreCase(productsList.get(i).getType()))) {
				for(int j=0;j<typesAmount.size();j++) {
					if(type.equalsIgnoreCase(typesAmount.get(j))) {
						typesAmount.remove(j);
						saveTypesData();
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean deleteIngredients(String ingredient) throws FileNotFoundException, IOException {
		boolean temp=false;
		for(int i=0;i<productsList.size();i++) {
			for(int j=0;j<productsList.get(i).getIngredients().length;j++) {
				if(ingredient.equalsIgnoreCase(productsList.get(i).getIngredients()[j])) {
					return false;
					
				}
				else {
					temp=true;
				}
			}
		}
		if(temp=true) {
			for(int i=0; i<ingredients.size();i++) {
				if(ingredient.equalsIgnoreCase(ingredients.get(i))) {
					ingredients.remove(i);
					saveIngredientData();
					for(int j=0;j<ingredientsEnabled.size();j++) {
						if(ingredients.get(i).equalsIgnoreCase(ingredientsEnabled.get(j))) {
							ingredientsEnabled.remove(j);
							saveIngredientEnabledData();
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public boolean disableProduct(String name) throws FileNotFoundException, IOException {
		
		for(int i=0; i<productsList.size();i++) {
			productsEnabled.add(i,productsList.get(i));
		}
		saveProductsEnabledData();
		//Relleno productsEnabled
		
		for(int i=0;i<productsList.size();i++) {
				if(name.equalsIgnoreCase(productsEnabled.get(i).getName())) {
					productsList.get(i).setState(false);
					productsEnabled.remove(i);
					saveProductsEnabledData();
					saveProductsData();
					return true;
			}
		}
		return false;
	}
	
	public boolean disableType(String type) throws FileNotFoundException, IOException {
		for(int i=0; i<typesAmount.size();i++) {
			typesEnabled.add(i,typesAmount.get(i));
			saveTypesEnabledData();
		}
		//Relleno typesEnabled
		
		for(int i=0;i<typesAmount.size();i++) {
				if(type.equalsIgnoreCase(typesEnabled.get(i))){
					typesEnabled.remove(i);
					saveTypesEnabledData();
					return true;
			}
		}
		return false;
	}

	public boolean disableIngredients(String ingredient) throws FileNotFoundException, IOException {
		for(int i=0; i<ingredients.size();i++) {
			ingredientsEnabled.add(i,ingredients.get(i));
		}
		saveIngredientEnabledData();
		//Relleno ingredientsEnabled
		
		for(int i=0;i<ingredients.size();i++) {
				if(ingredient.equalsIgnoreCase(ingredientsEnabled.get(i))){
					ingredientsEnabled.remove(i);
					saveIngredientEnabledData();
					return true;
			}
		}
		return false;
	}
	
	//Todos los update requieren el nombre del producto para así mismo buscarlo
	public boolean updateNameProducts(String finalName, String name) throws FileNotFoundException, IOException{	
		for(int i=0;i<productsEnabled.size();i++) {
			if(name.equalsIgnoreCase(productsEnabled.get(i).getName())) {
				productsEnabled.get(i).setName(finalName);
				for(int j=0;j<productsList.size();j++) {
					if(productsEnabled.get(i).getName().equalsIgnoreCase(productsList.get(j).getName())) {
						productsList.get(j).setName(finalName);
					}
					saveProductsData();
					saveProductsEnabledData();
				return true;
				}
			}
		}
		return false;
}		
	
	public boolean updateTypes(String name, String newName) {
		for(int i=0;i<typesAmount.size();i++) {
			if(name.equalsIgnoreCase(typesAmount.get(i))) {
				typesAmount.set(i, newName);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateTypeProducts(String name, String finalType) throws FileNotFoundException, IOException {
		for(int i=0;i<productsEnabled.size();i++) {
			if(name.equalsIgnoreCase(productsEnabled.get(i).getName())) {
				if(chooseTypeToAProduct(finalType)) {
					productsEnabled.get(i).setType(finalType);
					for(int j=0;j<productsList.size();j++) {
						if(productsEnabled.get(i).getName().equalsIgnoreCase(productsList.get(j).getName())) {
							productsList.get(j).setType(finalType);
						}
					}
					saveProductsData();
					saveProductsEnabledData();
					return true;
				}
			}
		}
		return false;
	}
	
	//Para actualizar los ingredientes de un producto será necesario 
	//Crear una interfaz la cual le permita al usuario dar click en los nuevos ingredientes
	public boolean updateIngredientstoaProduct(String name, String[] newIngredients) throws FileNotFoundException, IOException {
		for(int i=0; i<productsList.size();i++) {
		if(name.equalsIgnoreCase(productsList.get(i).getName())) {
			productsList.get(i).setIngredients(chooseIngredientToAProduct(newIngredients));
			for(int j=0;j<productsEnabled.size();j++) {
			if(name.equalsIgnoreCase(productsEnabled.get(j).getName())) {
				productsEnabled.get(j).setIngredients(chooseIngredientToAProduct(newIngredients));
				saveProductsEnabledData();
				saveProductsData();
				return true;
			}
		}
		}
		
	}
		return false;
}
	public boolean updateIngredients(String name, String newName) {
		for(int i=0;i<ingredients.size();i++) {
			if(name.equalsIgnoreCase(ingredients.get(i))) {
				ingredients.set(i, newName);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateSize(String name, String newSize) throws FileNotFoundException, IOException {
		for(int i=0; i<productsList.size();i++) {
			if(name.equalsIgnoreCase(productsList.get(i).getName())) {
				productsList.get(i).setSize(newSize);
				for(int j=0;j<productsEnabled.size();j++) {
				if(name.equalsIgnoreCase(productsEnabled.get(j).getName())){
					productsEnabled.get(j).setSize(newSize);
				}
				}
				saveProductsData();
				saveProductsEnabledData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updatePrice(String name, double newPrice) throws FileNotFoundException, IOException {
		for(int i=0;i<productsList.size();i++) {
			if(name.equalsIgnoreCase(productsList.get(i).getName())) {
				productsList.get(i).setPrice(newPrice);
				for(int j=0;j<productsEnabled.size();j++) {
				if(name.equalsIgnoreCase(productsEnabled.get(j).getName())) {
					productsEnabled.get(j).setPrice(newPrice);
				}
				}
				saveProductsData();
				saveProductsEnabledData();
				return true;
			}
		}
		return false;
	}
	
	//Aqui empiezo a trabajar con clientes, usuarios, empleados
	
	public boolean addClient(String name, String lastName, String identification, String advices, String phoneNumber, String address) throws FileNotFoundException, IOException{
		if(clients.isEmpty()) {
			clients.add(new Client(name, lastName, identification, advices, phoneNumber, address));
			saveClientData();
			return true;
		}
		for(int i=0;i<clients.size();i++) {
			if(!(name.equalsIgnoreCase(clients.get(i).getName()))){
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.add(new Client(name, lastName, identification, advices, phoneNumber, address));
				sortPerson(clients);
				saveClientData();
				return true;
				}
			}
		}
		return false;
	}
	
	public boolean updateClientName(String name, String lastName, String finalName) throws FileNotFoundException, IOException {
		for(int i=0; i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setName(finalName);
				saveClientData();
				return true;
				}
			}
				
		}
		return false;
	}
	
	public boolean updateClientLastName(String name, String lastName, String finalLastName) throws FileNotFoundException, IOException {
		for(int i=0; i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setLastName(finalLastName);
				saveClientData();
				return true;
				}
			}
				
		}
		return false;
	}
	
	public boolean updateID(String name, String lastName, String newId) throws FileNotFoundException, IOException {
		for(int i=0;i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setIdentification(newId);
				saveClientData();
				return true;
				}
			}
		}
		return false;	
	}
	
	public boolean updateAdvice(String name, String lastName, String newAdvice) throws FileNotFoundException, IOException {
		for(int i=0;i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setAdvices(newAdvice);
				saveClientData();
				return true;
				}
			}
		}
		return false;	
	}
	
	public boolean updatePhone(String name, String lastName, String newPhone) throws FileNotFoundException, IOException {
		for(int i=0;i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setPhoneNumber(newPhone);
				saveClientData();
				return true;
				}
			}
		}
		return false;	
	}
	
	public boolean updateAdress(String name, String lastName, String newAdress) throws FileNotFoundException, IOException {
		for(int i=0;i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())) {
				if(lastName.equalsIgnoreCase(clients.get(i).getLastName())) {
				clients.get(i).setAdress(newAdress);
				saveClientData();
				return true;
				}
			}
		}
		return false;	
	}
	
	public boolean deleteClient(String name, String lastName) throws FileNotFoundException, IOException {
		for(int i=0;i<clients.size();i++) {
			if(name.equalsIgnoreCase(clients.get(i).getName())&&(lastName.equalsIgnoreCase(clients.get(i).getLastName()))) {
				clients.remove(i);
				saveClientData();
				return true;
			}
		}
		return false;
	}
	//Trabajo relacionado a los usuarios
	
	public boolean createUser(String name, String lastName, String identification, String username, String password) throws FileNotFoundException, IOException {
		if(users.isEmpty()) {
			users.add(new User(name, lastName, identification, username, password));
			saveUserData();
			return true;
		}
		for(int i=0;i<users.size();i++) {
			if((!(name.equalsIgnoreCase(users.get(i).getName())))&&(!(lastName.equalsIgnoreCase(users.get(i).getLastName())))) {
				users.add(new User(name, lastName, identification, username, password));
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserName(String name, String lastName, String newName) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if(name.equalsIgnoreCase(users.get(i).getName())&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.get(i).setName(newName);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserLastName(String name, String lastName, String newLastName) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if(name.equalsIgnoreCase(users.get(i).getName())&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.get(i).setLastName(newLastName);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserID(String name, String lastName, String newID) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if(name.equalsIgnoreCase(users.get(i).getName())&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.get(i).setIdentification(newID);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserUsername(String name, String lastName, String newUsername) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if((name.equalsIgnoreCase(users.get(i).getName()))&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.get(i).setUsername(newUsername);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateUserPassword(String name, String lastName, String newPassword) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if((name.equalsIgnoreCase(users.get(i).getName()))&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.get(i).setPassword(newPassword);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteUser(String name, String lastName) throws FileNotFoundException, IOException {
		for(int i=0;i<users.size();i++) {
			if((name.equalsIgnoreCase(users.get(i).getName()))&&(lastName.equalsIgnoreCase(users.get(i).getLastName()))) {
				users.remove(i);
				saveUserData();
				return true;
			}
		}
		return false;
	}
	//Aqui empiezo a trabajar con lo relacionado a pedidos
	//Falta el metodo de seleccionar los productos para una orden, ese se coloca en la UI
	public boolean enterOrder(String code, String observations, String name, String lastName, String identification, String currentStatus, String clientName, String clientLastName, String clientIdentification, String clientAdvices, String clientPhoneNumber, String clientAdress) throws FileNotFoundException, IOException {
		Order temp=new Order(code, observations, name, lastName, identification, currentStatus, clientName, clientLastName, clientIdentification, clientAdvices, clientPhoneNumber, clientAdress);
		if(orders.isEmpty()) {
			orders.add(temp);
			codeAmount.add(code);
			dates.add(temp.getLocalDateTime());
			saveCodesData();
			saveDatesData();
			saveOrdersData();
			return true;
		}
		for(int i=0;i<orders.size();i++) {
			if(!(code.equalsIgnoreCase(orders.get(i).getCode()))) {
				orders.add(temp);
				codeAmount.add(code);
				dates.add(temp.getLocalDateTime());
				saveCodesData();
				saveDatesData();
				saveOrdersData();
				return true;
			}
		}
		return false;
	}
	
	public boolean changeOrderState(String code, int ind) throws FileNotFoundException, IOException {
		for(int i=0;i<orders.size();i++) {
			if(code.equalsIgnoreCase(orders.get(i).getCode())) {
				orders.get(i).setCurrentStatus(ind, orders.get(i).getCurrentStatus());
				saveOrdersData();
				return true;
			}
		}
		return false;
	}
	
	//CSV
	public void generateOrderCSV(String filePath, String separator, LocalDateTime firstDate, LocalDateTime lastDate) throws FileNotFoundException {
		PrintWriter CSVW= new PrintWriter(filePath);
		OrderInsertionSortByDate();
		String titles= "Cliente"+separator+"Dirección"+separator+"Numero telefonico"+separator+"Codigo"+separator+"Observacion del cliente"+
		"Empleado"+separator+"Estado del pedido"+separator+"Fecha de reporte"+separator+"Nombre producto"+separator+"cantidad por producto"+separator+"precio";
		CSVW.println(titles);
		
		
		for(int i=0;i<orders.size();i++) {
			Order temp = orders.get(i);
			LocalDateTime timeTemp= temp.getLocalDateTime();
			if(timeTemp.isAfter(firstDate)&& timeTemp.isBefore(lastDate)){
				setSeparator(separator);
				CSVW.println(orders.get(i).getInformation(separator)+separator+orders.get(i).getOrderProductsInformation(separator));
			}
		}
		
	}
	
	public void generateOrderDoneCSV(String filePath, String separator, LocalDateTime firstDate, LocalDateTime lastDate) throws FileNotFoundException{
		PrintWriter CSVW= new PrintWriter(filePath);
		OrderInsertionSortByDate();
		String temp="Nombre Empleado"+separator+"ID"+separator+"Pedidos entregados"+separator+"Suma de los valores de pedidos";
		CSVW.println(temp);
		int c=0;
		double d=0;
		for(int i=0;i<orders.size();i++) {
			
			Order aux= orders.get(i);
			c=amountOfOrdersByEmployee(aux.getOrderEmployee().getName(),aux.getOrderEmployee().getLastName());
			d=quantityOfOrdersByEmployee(aux.getOrderEmployee().getName(),aux.getOrderEmployee().getLastName());
			if("ENTREGADO".equalsIgnoreCase(aux.getCurrentStatus())) {
			LocalDateTime a=aux.getLocalDateTime();
				if(a.isAfter(firstDate)&&(a.isBefore(lastDate))) {
					setSeparator(separator);
					CSVW.println(aux.getEmployeeInformation(separator)+c+separator+d);
				}
		}
	}
		
	}
	
	public int amountOfOrdersByEmployee(String name, String lastName) {
		int a=0;
		String b="ENTREGADO";
		for(int i=0;i<orders.size();i++) {
			if((name.equalsIgnoreCase(orders.get(i).getOrderEmployee().getName())&&(lastName.equalsIgnoreCase(orders.get(i).getOrderEmployee().getLastName())))){
				if(b.equalsIgnoreCase(orders.get(i).getCurrentStatus())) {
					a++;
				}
			}
		}
		return a;
	}
	public double quantityOfOrdersByEmployee(String name, String lastName) {
		double a=0;
		String b="ENTREGADO";
		for(int i=0;i<orders.size();i++) {
			if((name.equalsIgnoreCase(orders.get(i).getOrderEmployee().getName())&&(lastName.equalsIgnoreCase(orders.get(i).getOrderEmployee().getLastName())))){
				if(b.equalsIgnoreCase(orders.get(i).getCurrentStatus())) {
					a+=orders.get(i).orderPrize();
				}
			}
		}
		return a;
	}
	
	public void setSeparator(String separator) {
		this.separator=separator;
	}
	
	public void generateProductsCSV(String filePath, String separator, LocalDateTime firstDate, LocalDateTime lastDate) throws FileNotFoundException{
		PrintWriter CSVW= new PrintWriter(filePath);
		OrderInsertionSortByDate();
		String temp="Nombre Producto"+separator+"Tipo de producto"+separator+"Ingredients"+separator+"Tamaño de producto"+separator+"Precio"+separator+"Veces que se pide"+separator+"Cantidad de dinero que generó";
		CSVW.println(temp);
		int c=0;
		double d=0;
		for(int i=0;i<orders.size();i++) {
			
			Order aux= orders.get(i);
			c=amountOfProductssByOrders(aux.getProducts().get(i).getName());
			d=quantityOfProductsByOrders(aux.getProducts().get(i).getName());
			if("ENTREGADO".equalsIgnoreCase(aux.getCurrentStatus())) {
			LocalDateTime a=aux.getLocalDateTime();
				if(a.isAfter(firstDate)&&(a.isBefore(lastDate))) {
					setSeparator(separator);
					CSVW.println(aux.getProductsInformation(separator)+c+separator+d);
				}
		}
	}
		
	}
	
	public int amountOfProductssByOrders(String name) {
		int a=0;
		String b="ENTREGADO";
		for(int i=0;i<orders.size();i++) {
			for(int j=0;j<orders.get(i).getProducts().size();j++) {
			if((name.equalsIgnoreCase(orders.get(i).getProducts().get(j).getName()))){
				if(b.equalsIgnoreCase(orders.get(i).getCurrentStatus())) {
					a++;
				}
			}
		}
		}
		return a;
	}
	
	public double quantityOfProductsByOrders(String name) {
		double a=0;
		String b="ENTREGADO";
		for(int i=0;i<orders.size();i++) {
			for(int j=0;j<orders.get(i).getProducts().size();j++){
			if((name.equalsIgnoreCase(orders.get(i).getProducts().get(j).getName()))){
				if(b.equalsIgnoreCase(orders.get(i).getCurrentStatus())) {
					a+=orders.get(i).orderPrize();
				}
			}
		}
	}
		return a;
	}
//Metodos nuevos
	//Reportes
	
	
	public String generateProductsReport(String separator) {
		String temp="Nombre;TipoDePlato;Ingredientes;Tamaño;Precio;Estado\n";
		String a="";
		for(int i=0;i<productsList.size();i++) {
			a+=productsList.get(i).getName()+";"+productsList.get(i).getType()+";"+productsList.get(i).getAllIngredients(separator)+";"+productsList.get(i).getSize()+";"+productsList.get(i).getPrice()+";"+stateSetter(productsList.get(i).getState())+"\n";
		}
		return temp=temp+a;
	}
	
	public String stateSetter(boolean a) {
		String b;
		if(a==true) {
			return b="Activo";
		}
		return b="Inactivo";
	}
	
	//Imports
	public void importDataClients(String filePath) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String line= br.readLine();
		while(line!=null){
		      String[] parts = line.split(";");
		      addClient(parts[0],parts[1], parts[2],parts[3],parts[4], parts[5]);
		      line = br.readLine();
		    }
		    br.close();
		
	}
	
	public void importDataProducts(String filePath) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String line=br.readLine();
		while(line!=null){
		      String[] parts = line.split(";");
		      createProduct(parts[0], parts[1], splitIngredients(parts[2]),parts[3],StringToDouble(parts[4]));
		      line = br.readLine();
		    }
		    br.close();
	}
	
	public void importDataOrders(String filePath) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String line=br.readLine();
		while(line!=null){
		      String[] parts = line.split(";");
		     enterOrder(parts[0], parts[1], parts[2],parts[3],parts[4], parts[5],parts[6], parts[7], parts[8],parts[9],parts[10], parts[11]);
		      line = br.readLine();
		    }
		    br.close();
	}
	
	public String[] splitIngredients(String a) {
		String[] b= a.split(";");
		return b;
	}
	
	public boolean convertStringToBoolean(String a) {
		boolean temp;
		if("TRUE".equalsIgnoreCase(a)) {
			temp=true;
		}
		else {
			temp=false;
		}
		return temp;
	}
	
	public double StringToDouble(String a) {
		double b;
		b=Double.parseDouble(a);
		return b;
	}
	
	//Logearse
	
	public String login(String username, String password) {
		String a;
		for(int i=0;i<users.size();i++) {
		if(username.equalsIgnoreCase((users.get(i).getUsername()))) {
			if(password.equalsIgnoreCase(users.get(i).getPassword())) {
				return a="true";
			}
			else {
				return a="contraseña incorrecta";
			}
			
		}
		else {
			return a="Usuario incorrecto, registrese o intentelo de nuevo";
		}
		}
		return a="false";
	}
	
	//metodos nuevos fin
	//ORDENAMIENTOS
	
	public void sortPerson(ArrayList<Client> a) {
		Collections.sort(a, new NameComparator());
	}
	public void sortProducts(ArrayList<Products> a) {
		Collections.sort(a);
	}
	
	public void OrderInsertionSortByDate(){                                            
		int j=0;
		Order aux;
		DateComparator sorter=new DateComparator();
		for (int i = 1; i <orders.size(); i++){
			aux = orders.get(i);        
			j = i - 1;           
			while ((j >= 0) && (sorter.compare(aux, orders.get(j)))<0){                             
				orders.set(j+1,orders.get(j));
				j--;        
			}
			orders.set(j+1, aux);
		}
	}
	
	
	}

