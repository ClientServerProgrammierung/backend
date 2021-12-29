package Controller;

import model.Fahrrad;
import java.util.List;


public class JsfTest {	
	public static void main (String[] args) {
		Fahrrad f = new Fahrrad();
		List<Fahrrad> liste = f.getFahrrader();
		for (Fahrrad fahrrad : liste) 
		{ 
			System.out.print(fahrrad.getModel());
		}
	
		
	}

}
