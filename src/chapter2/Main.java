package chapter2;

public class Main {

	public static void main(String[] args) {
		String geneStr1 = "ACGTGGCTCTCTAACGTACGTA";
		
		Gene gen1 = new Gene(geneStr1);
		
		System.out.println("Geen-String:" +geneStr1);
		System.out.println("Codon-Sequenz" + gen1);		

	}

}
