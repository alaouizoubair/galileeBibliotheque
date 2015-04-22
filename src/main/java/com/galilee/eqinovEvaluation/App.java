package com.galilee.eqinovEvaluation;


public class App 
{
	private static char T[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static boolean testMot(String mot1,String mot2){
		if(mot1.length()!=mot2.length())
			return false;
		
		StructMot[] structMot1 = new StructMot[26];
		StructMot[] structMot2 = new StructMot[26];
		for(int i=0;i<26;i++){
			structMot1[i] = new StructMot(T[i],0);
			structMot2[i] = new StructMot(T[i],0);
		}
		
		for(int i=0;i<mot1.length();i++){
			int occ = structMot1[getLetterPos(mot1.codePointAt(i))].getOccurence() + 1;
			structMot1[getLetterPos(mot1.codePointAt(i))].setOccurence(occ);
		}
		for(int i=0;i<mot2.length();i++){
			int occ = structMot2[getLetterPos(mot2.codePointAt(i))].getOccurence() + 1;
			structMot2[getLetterPos(mot2.codePointAt(i))].setOccurence(occ);
		}
		
		for(int i=0;i<26;i++){
			if(structMot1[i].getOccurence()!=structMot2[i].getOccurence() )
				return false;
		}
		
		return true;
	}
	
	public static int getLetterPos(int n){
		if(n>64 && n<91)
			return n-65;
		else
			return n-97;
	}
	
	
    public static void main( String[] args )
    {
        if(testMot("alaiui","uoiAlA")){
        	System.out.println("good");
        }else{
        	System.out.println("not good");
        }
    	
    	
        
    }
}
