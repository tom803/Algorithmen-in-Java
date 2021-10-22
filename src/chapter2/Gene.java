package chapter2;

import java.util.ArrayList;
import java.util.Comparator;

public class Gene {
	public enum Nucleotide {
		A, C, G, T
	}
	
	public static class Codon implements Comparable<Codon> {
		public final Nucleotide first, second, third;
		private final Comparator<Codon> comparator =
				Comparator.comparing((Codon c) -> c.first)
				.thenComparing((Codon c) -> c.second)
				.thenComparing((Codon c) -> c.third);

		public Codon(String codonStr)  {
			first = Nucleotide.valueOf(codonStr.substring(0, 1));
			second = Nucleotide.valueOf(codonStr.substring(1, 2));
			third = Nucleotide.valueOf(codonStr.substring(2, 3));
		}
		
		@Override
		public int compareTo(Codon other) {
			// first wird zuerst verglichen, dann second usw.
			// D. h. first hat Vorrang vor second und second vor first
			return comparator.compare(this, other);
		}
		
		@Override
		public String toString() {
			return "(" + first + second + third + ")";
		}

	}
	
	private ArrayList<Codon> codons = new ArrayList<>();
	
	public Gene(String geneStr) {
		for(int i=0; i < geneStr.length() - 3; i += 3 ) {
			// Alle 3 Zeichen im String nehmen und ein Codon formen
			codons.add(new Codon(geneStr.substring(i, i + 3)));
		}
	}
	
	@Override
	public String toString() {
		return codons.toString();
	}

}
