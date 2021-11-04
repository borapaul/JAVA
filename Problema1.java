package Lab4Tema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


enum Stare 
{
	achizitionat,
	expus,
	vandut
	}
enum ModScriere 
{
	Color,
	AlbNegru
	}
enum Format
{
	A4,
	A3
	}
enum SistemOperare
{
	Windows,
	Linux
	}
class Echipament{
	private String denumire;
	private int nr_inv;
	private double pret;
	private String zona_mag;
	private Stare stare;
	
	public Echipament()
	{}
	public Echipament(String denumire, int nr_inv, double pret, String zona_mag,Stare stare)
	{
		this.denumire = denumire;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.stare = stare;
	}
	@Override
	public String toString()
	{
		return "Denumire: " + this.denumire + "\n" +
				"Numar inventar: " + this.nr_inv + "\n" +
				"Pret: " + this.pret + "\n" +
				"Zona magazin: " + this.zona_mag + "\n" +
				"Stare: " + this.stare + "\n" ;
		
	}
	public String getDenumire() {
		return denumire;
	}

	public int getNr_inv() {
		return nr_inv;
	}

	public double getPret() {
		return pret;
	}

	public String getZona_mag() {
		return zona_mag;
	}

	public Stare getStare() {
		return stare;
	}
	public void setStare(Stare stare) {
		this.stare = stare;
	}
	public void setDenumire(String denumire)
	{
		this.denumire = denumire;
	}
	
}

class Imprimante extends Echipament{
	private String rezolutie; 
	private String p_car;
	private ModScriere m_scriere;
	private int ppm;
	
	public  Imprimante (String denumire, int nr_inv, double pret, String zona_mag,Stare stare,int ppm,String rezolutie , String p_car, ModScriere m_scriere) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.ppm = ppm;
		this.rezolutie = rezolutie;
		this.p_car = p_car;
		this.m_scriere = m_scriere;
	}
	@Override
	public String toString()
	{
		return super.toString() + 
				"Ppm: " + this.ppm + "\n" +
				"Rezolutie: " + this.rezolutie + "\n" +
				"Puncte per cartus: " + this.p_car + "\n" +
				"Metoda scriere: " + this.m_scriere + "\n" ;
	}
	public String getRezolutie() {
		return rezolutie;
	}

	public String getP_car() {
		return p_car;
	}

	public ModScriere getM_scriere() {
		return m_scriere;
	}
	public void setModScriere (ModScriere m_scriere) {
		this.m_scriere = m_scriere;
	}
}
class Copiatoare extends Echipament{
	private String p_ton;
	private Format format;
	private int ppm;
	public Copiatoare (String denumire, int nr_inv, double pret, String zona_mag,Stare stare,int ppm, String p_ton, Format format)
	{
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.p_ton = p_ton;
		this.ppm = ppm;
		this.format = format;
	}
	@Override
	public String toString()
	{
		return super.toString() + 
				"Ppm: " + this.ppm + "\n" +
				"P_ton: " + this.p_ton + "\n" +
				"Format: " + this.format + "\n";
	}

	public String getP_ton() {
		return p_ton;
	}

	public Format getFormat() {
		return format;
	}
	public void setFormat (Format format) {
		this.format = format;
	}
}

class SistemeDeCalcul extends Echipament{
	private String tip_mon;
	private String vit_proc;
	private String c_hdd; 
	private SistemOperare sist_op;
	public SistemeDeCalcul (String denumire, int nr_inv, double pret, String zona_mag,Stare stare, String tip_mon, String vit_proc, String c_hdd, SistemOperare sist_op)
	{
		super (denumire, nr_inv, pret, zona_mag,stare);
		this.tip_mon = tip_mon;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.sist_op = sist_op;
	}
	@Override
	public String toString()
	{
		return super.toString() + 
				"Tip Monitor: " + this.tip_mon + "\n" +
				"Viteza procesare: " + this.vit_proc + "\n" +
				"C_hdd:  " + this.c_hdd + "\n" +
				"Sistem de operare: " + this.sist_op + "\n";
	}

	public String getTip_mon() {
		return tip_mon;
	}
	public String getVit_proc() {
		return vit_proc;
	}
	public String getC_hdd() {
		return c_hdd;
	}
	public SistemOperare getSist_op() {
		return sist_op;
	}

	public void setSistemOperare(SistemOperare sist_op) {
		this.sist_op = sist_op;
	}
	
}

public class Problema1 {

	public static void main(String[] args) throws IOException  {
		Scanner flux_in = new Scanner(new File("electronice.txt"));
		ArrayList <Echipament> lista = new ArrayList<Echipament>();
		while (flux_in.hasNext())
		{
			String cit_aux = new String(flux_in.nextLine());
			String[] citire_fis = cit_aux.split(";");
			if (cit_aux.contains("imprimanta"))
			{
				Imprimante a = new Imprimante(citire_fis[0],
									Integer.parseInt(citire_fis[1]),
									Double.parseDouble(citire_fis[2]),
									citire_fis[3],
									Stare.valueOf(citire_fis[4]),
									Integer.parseInt(citire_fis[6]),
									citire_fis[7],
									citire_fis[8],
									ModScriere.valueOf(citire_fis[9])
									);
				lista.add(a);
			}
			if (cit_aux.contains("copiator"))
			{
				Copiatoare c = new Copiatoare(
						citire_fis[0],
						Integer.parseInt(citire_fis[1]),
						Double.parseDouble(citire_fis[2]),
						citire_fis[3],
						Stare.valueOf(citire_fis[4]),
						Integer.parseInt(citire_fis[6]),
						citire_fis[7],
						Format.valueOf(citire_fis[8]));
				lista.add(c);
			}
			if (cit_aux.contains("sistem de calcul"))
			{
				SistemeDeCalcul s = new SistemeDeCalcul(citire_fis[0],
						Integer.parseInt(citire_fis[1]),
						Double.parseDouble(citire_fis[2]),
						citire_fis[3],
						Stare.valueOf(citire_fis[4]),
						citire_fis[6],
						citire_fis[7], citire_fis[8], 
						SistemOperare.valueOf(citire_fis[9]));
				lista.add(s);
			}
		}
		flux_in.close();
		System.out.println("_-_-_AFISARE IMPRIMANTE_-_-_");
		Echipament e = new Echipament();
		for(int i = 0; i < lista.size(); i++)
		{
			e = lista.get(i);
			if (e instanceof Imprimante)
				System.out.println(e);
		}
		System.out.println("_-_-_AFISARE COPIATOARE_-_-_");
		Echipament c = new Echipament();
		for(int i = 0; i < lista.size(); i++)
		{
			c = lista.get(i);
			if (c instanceof Copiatoare)
				System.out.println(c);
		}
		System.out.println("_-_-_AFISARE SISTEME DE CALCUL_-_-_");
		Echipament s = new Echipament();
		for(int i = 0; i < lista.size(); i++)
		{
			s = lista.get(i);
			if (s instanceof SistemeDeCalcul)
				System.out.println(s);
		}
		Echipament afisare_ech_vandute = new Echipament();
		System.out.println("_-_-_Echipamentele care sunt vandute sunt urmatoarele:_-_-_");
		for(int i = 0; i < lista.size(); i++)
		{
			afisare_ech_vandute = lista.get(i);
			if("vandut".compareTo(afisare_ech_vandute.getStare().toString()) == 0)
					{
						System.out.println(afisare_ech_vandute);
					}
		}
		System.out.println("Dati numele echipamentului pentru a-i schimba starea");
		BufferedReader citire_nume = new BufferedReader(new java.io.InputStreamReader(System.in));
		String denumire_echipament = citire_nume.readLine();
		System.out.println("Dati noua stare a echipamentului (achizitionat || expus || vandut)");
		String stare_noua = citire_nume.readLine();
		Echipament modificare_aux = new Echipament();
		for (int i = 0; i < lista.size(); i++)
		{
			modificare_aux = lista.get(i);
			if (denumire_echipament.compareTo(modificare_aux.getDenumire()) == 0)
			{
				modificare_aux.setStare(Stare.valueOf(stare_noua));
			}
				
		}
		System.out.println("Dati numele imprimantei la care vreti sa schimbati modul de scriere");
		String nume_imprimanta = citire_nume.readLine();
		System.out.println("Setati modul in care vreti sa scrie imprimanta (Color || AlbNegru)");
		String stare_scriere_noua = citire_nume.readLine();
		Echipament modificare_imp = new Echipament();
		for (int i = 0; i < lista.size(); i++)
		{
			modificare_imp = lista.get(i);
			if (nume_imprimanta.compareTo(modificare_imp.getDenumire()) == 0)
			{
					Imprimante imp = (Imprimante) modificare_imp;
					imp.setModScriere(ModScriere.valueOf(stare_scriere_noua));
			}
		}
		Echipament modificare_copiat = new Echipament();
		System.out.println("Dati numele copiatorului la care vreti sa schimbati modul de copiere");
		String nume_copiator = citire_nume.readLine();
		System.out.println("Setati modul in care vreti sa scrie imprimanta (A4 || A3)");
		String stare_copiere_noua = citire_nume.readLine();		
		for (int i = 0; i < lista.size(); i++)
		{
			modificare_copiat = lista.get(i);
			if (nume_copiator.compareTo(modificare_copiat.getDenumire()) == 0)
			{
					Copiatoare cop = (Copiatoare) modificare_copiat;
					cop.setFormat(Format.valueOf(stare_copiere_noua));
			}
		}
		Echipament modificare_sist = new Echipament();
		System.out.println("Dati numele sistemului de calcul la care vreti sa schimbati sistemul de operare");
		String nume_sist_calc = citire_nume.readLine();
		System.out.println("Setati sistemul de operere (Windows || Linux)");
		String sist_op_nou = citire_nume.readLine();	
		for (int i = 0; i < lista.size(); i++)
		{
			modificare_sist = lista.get(i);
			if (nume_sist_calc.compareTo(modificare_sist.getDenumire()) == 0)
			{
					SistemeDeCalcul sist = (SistemeDeCalcul) modificare_sist;
					sist.setSistemOperare(SistemOperare.valueOf(sist_op_nou));
			}
		}
		citire_nume.close();
		System.out.println(lista);
	}
}
