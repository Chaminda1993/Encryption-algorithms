public class railFence1{
	public static void main(String args[]){
		String text="MEET ME AFTER THE TOGA PARTY";
		int depth=3;
		text=text.replace(" ","");

		String cText=enCrypt(text,depth);
		System.out.println("Encrypted text: "+cText);
		System.out.println("Decrypted text: "+deCrypt(cText,depth));
	}
//Encrypt
	public static String enCrypt(String text,int depth){
		int size=(text.length()+depth)/(depth-1);
		char fence[][]=new char[depth][size];
		int top[]=new int[depth];
		for(int i=0;i<depth;i++){
			top[i]=0;
		}
		index=-1;
		for(int i=0;i<text.length();i++){
			int row=nxt(depth);
			fence[row][top[row]++]=text.charAt(i);
		}
		String cText="";
		for(int i=0;i<depth;i++){
			for(int j=0;j<top[i];j++){
				cText+=fence[i][j];
			}
		}

		return cText;
	}

	//getNextIndex
	static int index= -1;
	static boolean inc=true;
	private static int nxt(int depth){
		if(inc){
			index++;
			if(index==depth){
				index-=2;
				inc=false;
			}
		}else{
			index--;
			if(index==-1){
				index+=2;
				inc=true;
			}
		}
		return index;
	}
//Decrypt
	public static String deCrypt(String cText,int depth){
		int size=(cText.length()+depth)/(depth-1);
		char fence[][]=new char[depth][size];
		int top[]=new int[depth];
		for(int i=0;i<depth;i++){
			top[i]=0;
		}
		index=-1;
		int row=0;
		for(int i=0;i<cText.length();i++){
			top[nxt(depth)]++;
		}
		int count=0;
		String text="";
		for(int i=0;i<depth;i++){
			for(int j=0;j<top[i];j++){
				fence[i][j]=cText.charAt(count++);
			}
		}
		for(int i=0;i<depth;i++){
			top[i]=0;
		}
		index=-1;
		for(int i=0;i<cText.length();i++){
			row=nxt(depth);
			text+=fence[row][top[row]++];
		}
		return text;
	}
}