import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class readfile {

	private Scanner x;
	
	public void openFile(){
		try{
			@SuppressWarnings("resource")
			Scanner user_input = new Scanner( System.in );
			System.out.print("���� �� ����� ��� �������: ");
			String filename;
			filename = user_input.next();
			x= new Scanner(new File(filename));
			
		}
		catch(Exception e){
			System.out.println("could not find file");
		}
	}
	
	public void readFile(){	
		int plithos_katastasewn = Integer.parseInt(x.next()); //System.out.println("�� �������� ���� " + plithos_katastasewn + " �����������");
			
		char arxiki_katastash = x.next().charAt(0); //System.out.println("������ ��������� ����� � "+arxiki_katastash);
			
		int plithos_metabasewn;
		plithos_metabasewn = Character.getNumericValue(x.next().charAt(0));
		char[][] multi = new char[plithos_metabasewn][4];
		
		for(int i=0; i<plithos_metabasewn; i++){
			multi[i][0]= x.next().charAt(0);
			multi[i][1]= x.next().charAt(0);
			multi[i][2]= x.next().charAt(0);
			multi[i][3]= x.next().charAt(0);
		}

		/*System.out.println("������� ����������");
		for(int i=0; i<plithos_metabasewn; i++){
			System.out.print(multi[i][0] + " ");
			System.out.print(multi[i][1] + " ");
			System.out.print(multi[i][2] + " ");
			System.out.print(multi[i][3] + " " + "\n");
			}*/
		
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner( System.in );	
		String word;
		System.out.print("���� �� ����������� ��� �������: ");
		word = user_input.next();
		 
		int kefali;
		System.out.print("���� �� ���� ��� �������: ");
		kefali = Integer.parseInt(user_input.next());
		kefali= kefali-1;
		
		char trexousa_katastasi= arxiki_katastash;
		
		LinkedList<Character> lista = new LinkedList<Character>();
		
		for(int j=0; j<word.length(); j++){
			lista.add(word.charAt(j));
			}
		
		 outerloop2: while (true){
			
			int k=0;
			outerloop1: 
			for(int i=0; i<plithos_metabasewn; i++){
				if (multi[i][0]== trexousa_katastasi){
					for(int p=0; p<plithos_metabasewn; p++){
						if ((multi[i][0]==multi[p][0]) && (lista.get(kefali)== multi[p][1])){
							
							trexousa_katastasi= multi[p][3]; //System.out.print("\n��� ��� ���������: "+ multi[i][0] + " ���� ���������: " + trexousa_katastasi+ "\n");
							
							
							if (kefali==0 && multi[p][2] == 'L'){
								System.out.print("�� ������� ������� ����� ����������� �� ������������ ��� ������ ���� �� �������� ��� ����� �������");
								break outerloop2;
							}
							
							if (trexousa_katastasi =='0'){
								//System.out.print("��������� ��� �����������-> "); System.out.print(trexousa_katastasi);
								System.out.print("\n��� ����������� �������: ");
								for(int j=0; j<lista.size(); j++){
									System.out.print(lista.get(j));
								}
								System.out.print("\n���� ��� �������-> "); System.out.print(kefali+1 + "\n");
								break outerloop2;
							}
							
							if (multi[p][1]== lista.get(kefali) && multi[p][1] != '#')
								{   
								lista.remove(kefali);  // System.out.print("����� ��� ��� ������ ��: "+ multi[p][1]+ "\n");
								}else if (multi[p][2] == '#'){
									k=1;
								}
							
							if (k!=1 && multi[p][2] != 'R' && multi[p][2] != 'L'){
								lista.add(kefali,multi[p][2]); //System.out.print("\n���� ���� ������ ��: "+ multi[p][2]+ "\n"); 
							}
							else if (k!=1 && multi[p][2] == 'R'){

								kefali= kefali+1; // System.out.print("\n� ������ ������������ ��� ���� �����"+ "\n");  
								if (kefali==lista.size()){
									lista.add('#');
								}
							}else if (k!=1 && multi[p][2] == 'L'){
								kefali= kefali-1;  //System.out.print("\n� ������ ������������ ��� ���� ��������"+ "\n");  
							}

							break outerloop1;
							}
	
						}
					}
				}
			}
		}
					
						
	public void closeFile(){
		x.close();
	}
}