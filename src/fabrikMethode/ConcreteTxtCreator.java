package fabrikMethode;

import java.io.IOException;

public class ConcreteTxtCreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		return new ConcreteTxtProduct() ;
	}

}
