package Laborator3;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


class Vers{
	private String VersCantec;
	
	public Vers(String VersCantec)
	{
		this.VersCantec = VersCantec;
	}
	
	
	public String getVersCantec() {return VersCantec;}
	
	public void setVersCantec(String VersCantec)
	{
		this.VersCantec = VersCantec;	
	}
	
	public int NumarCuvinte(String Vers)
	{
		String [] impartire;
		impartire = Vers.split(" ");
		return impartire.length;
	}
	
	public int NumarVocale(String Vers)
	{
		int ct = 0;
		for (int i = 0; i < Vers.length(); i++)
		if (	Vers.charAt(i) == 'a'||
				Vers.charAt(i) == 'e'||
				Vers.charAt(i) == 'i'||
				Vers.charAt(i) == 'o'||
				Vers.charAt(i) == 'u'||
				Vers.charAt(i) == 'A'||
				Vers.charAt(i) == 'E'||
				Vers.charAt(i) == 'I'||
				Vers.charAt(i) == 'O'||
				Vers.charAt(i) == 'U'
		)
		{
			ct++;
		}
		return ct;
	}
	
	public char SfarstiVers(String Vers) 
	{
		char rezultat;
		String sfarsit = "e";
		//BufferedReader citire_sf = new BufferedReader(new InputStreamReader(System.in));
		//String sfarsit = citire_sf.readLine();
		if (Vers.endsWith(sfarsit))
		{
			rezultat = '*';
		}
		else 
			rezultat= ' ';
		
		return rezultat;
		
	}
	
	public static double ValoareRandom()
	{
		double numar = 0;
		numar= Math.random();
		return numar;
	}
	
}

public class Problema1 {

	public static void main(String[] args)  throws FileNotFoundException {
		// TODO Auto-generated method stub
	Scanner flux_in = new Scanner(new File("cantec.txt"));
	PrintStream flux_out = new PrintStream("cantec_out.txt");
	String rezultat;
	while (flux_in.hasNext())
	{
		Vers VersAuxiliar = new Vers(flux_in.nextLine());
		rezultat = VersAuxiliar.getVersCantec() + " " + VersAuxiliar.NumarCuvinte(VersAuxiliar.getVersCantec()) + " " + VersAuxiliar.NumarVocale(VersAuxiliar.getVersCantec()) + " " + VersAuxiliar.SfarstiVers(VersAuxiliar.getVersCantec());
		//flux_out.println(VersAuxiliar.getVersCantec() + " " + VersAuxiliar.NumarCuvinte(VersAuxiliar.getVersCantec()) + " " + VersAuxiliar.NumarVocale(VersAuxiliar.getVersCantec()) + " " + VersAuxiliar.SfarstiVers(VersAuxiliar.getVersCantec()) );
		if (Vers.ValoareRandom()>=0.1)
		{
			flux_out.println(rezultat);
		}
		else 
			flux_out.println(rezultat.toUpperCase());
		}
	flux_in.close();
	flux_out.close();
	}
	
}
