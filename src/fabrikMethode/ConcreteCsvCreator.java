package fabrikMethode;


import java.io.IOException;

public class ConcreteCsvCreator extends Creator {
	
	
	
	

	public Product factoryMethod() throws IOException {
		return new ConcreteCsvProduct() ;
	}

}
