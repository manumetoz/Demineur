import java.util.Scanner;

public class Main {
  public static void main(String[] args) 
  	{
    	@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

		Demineur D = new Demineur();
		
		
     	D.palcerBombes(4);
     	
     	System.out.println("voici le d�mineur avec toutes les cellules initialis�s par false. Mais parmi ces cellules se trouvent des mines.");
      	D.afficherTableau();
      	System.out.println("\n vous disposez de (04) essais");

      	int x,y;
      	do
      	{
      		System.out.println("vous devrez saisir l'abscisse et l'ordonn�e");

      		do
      		{
    	      	System.out.print("x= ");
    	      	 x = sc.nextInt();	
      		}
      		while(x<=0 && x>= D.T.length);
	      		
      		do
          	{      	
      			System.out.print("y= ");
      	      	 y = sc.nextInt();
          	}
      		while(y<0 && y>= D.T.length);
      	}
      	while(D.verifierMine(x,y)!=false);

  	}
}



