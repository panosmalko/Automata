import java.io.File;
import java.util.Scanner;

public class readfile {

	private Scanner x;
	
	public void openFile(){
		try{
			@SuppressWarnings("resource")
			Scanner user_input = new Scanner( System.in );
			System.out.print("Δώσε το όνομα του αρχέιου: ");
			String filename;
			filename = user_input.next();
			x= new Scanner(new File(filename));
			
		}
		catch(Exception e){
			System.out.println("could not find file");
		}
	}
	
	public void readFile(){	
		int plithos_katastasewn = Integer.parseInt(x.next()); //System.out.println("Το αυτόματο έχει " + plithos_katastasewn + " καταστάσεις");
			
		char arxiki_katastash = x.next().charAt(0); //System.out.println("Αρχική κατάσταση είναι η "+arxiki_katastash);
			
		int plithos_telikwnkatastasewn;
		plithos_telikwnkatastasewn = Character.getNumericValue(x.next().charAt(0));
		boolean[] A = new boolean[plithos_katastasewn];
		
		for(int i=0; i<plithos_telikwnkatastasewn; i++){
			A[Integer.parseInt(x.next())-1]= true;
		}
		
		/*System.out.println("ΠΙΝΑΚΑΣ ΚΑΤΑΣΤΑΣΕΩΝ");
		for(int i=0; i<plithos_katastasewn; i++){
			System.out.println(i+1 +"η κατάσταση: "+A[i]);
		}*/
			
		int plithos_metabasewn;
		plithos_metabasewn = Character.getNumericValue(x.next().charAt(0));
		char[][] multi = new char[plithos_metabasewn][3];
			
		for(int i=0; i<plithos_metabasewn; i++){
			multi[i][0]= x.next().charAt(0);
			multi[i][1]= x.next().charAt(0);
			multi[i][2]= x.next().charAt(0);
		}
		
		/*System.out.println("ΠΙΝΑΚΑΣ ΜΕΤΑΒΑΣΕΩΝ");
		for(int i=0; i<plithos_metabasewn; i++){
			
			System.out.print(multi[i][0] + " ");
			System.out.print(multi[i][1] + " ");
			System.out.print(multi[i][2] + "\n");
			}*/

		@SuppressWarnings("resource")
		Scanner user_input = new Scanner( System.in );	
		String word;
		System.out.print("Δώσε χαρακτήρες: ");
		word = user_input.next();
		 
		int l;
		l=0;
		while (l==0){
		
		char trexousa_katastasi= arxiki_katastash;
		int k=0;
		outerloop: 	
		for(int j=0; j<word.length(); j++){
			outerloop1: 
			for(int i=0; i<plithos_metabasewn; i++){
				if (multi[i][0]== trexousa_katastasi){
					int k1=0;
					for(int p=0; p<plithos_metabasewn; p++){
						if ((multi[i][0]==multi[p][0]) && (word.charAt(j)== multi[p][1])){
							k1=1;
							trexousa_katastasi= multi[p][2]; //System.out.print("\nΑπό την κατάσταση: "+ multi[i][0] + " στην κατάσταση: " + trexousa_katastasi + "\n");
							break outerloop1;
							}
					}
					if (k1==0){
						k=1;
						System.out.println("Το αυτόματο τερμάτισε σε μη-τελική κατάσταση");
						break outerloop;
					}
				}
			}
		}
		if (k==0){
			int tk = Character.getNumericValue(trexousa_katastasi);
			if (A[tk-1]){
				System.out.println("\nΤο αυτόματο τερμάτισε σε τελική κατάσταση");
			}else{
				System.out.println("\nΤο αυτόματο τερμάτισε σε μη-τελική κατάσταση"); 
			}
		}
		
	int ap;
	System.out.print("\nΘα εισάγεις νέα λέξη; (Πληκτρολόγησε '0' για ΟΧΙ ή '1' για ΝΑΙ)");
	ap = Integer.parseInt(user_input.next());
	
	if(ap==1){
		System.out.print("\nΔώσε χαρακτήρες: ");
		word = user_input.next();
		l=0;
	} else{l=1; System.out.print("\nΚλείσιμο προγράμματος"); }
	
	}
		
	}

	public void closeFile(){
		x.close();
	}
}