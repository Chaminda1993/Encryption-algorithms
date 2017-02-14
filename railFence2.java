public class railFence2{
	public static void main(String args[]){
		String text="ATTACKPOSTPONEDUNTILTWOAM";
		String key="4312567";

		String cText=enCrypt(text,key);
		System.out.println("Encrypted text: "+cText);
		System.out.println("Decrypted text: "+deCrypt(cText,key));
	}

	public static String enCrypt(String text,String key){
		String per1=encrypt(text,key);
		String per2=encrypt(per1,key);
		return per2;
	}
//Encrypt
	private static String encrypt(String text,String key){
		int col=key.length();
		int row;
		if((text.length()%col)==0){
			row=(text.length()/col)+1;
		}else{
			row=(text.length()/col)+2;
		}
		char tbl[][]=new char[row][col];
		for(int i=0;i<col;i++){
			tbl[0][i]=key.charAt(i);
		}

		int count=0;
		for(int i=1;i<row;i++){
			for(int j=0;j<col;j++){
				if(count<text.length()){
					tbl[i][j]=text.charAt(count++);
				}else{
					tbl[i][j]=(char)(91-col+j);
				}
			}
		}

		String cText="";
		for(int i=1;i<=col;i++){
			int useCol=0;
			for(int j=0;j<col;j++){
				if(i+48==tbl[0][j]){
					useCol=j;
				}
			}

			for(int k=1;k<row;k++){
				cText+=tbl[k][useCol];
			}
		}

		return cText;
	}

//Decrypt
	public static String deCrypt(String cText,String key){
		String per1=decrypt(cText,key);
		String per2=decrypt(per1,key);
		return per2;
	}
	private static String decrypt(String cText,String key){
		int col=key.length();
		int row=(cText.length()/col)+1;
		char tbl[][]=new char[row][col];
		for(int i=0;i<col;i++){
			tbl[0][i]=key.charAt(i);
		}
		int count=0;
		for(int i=1;i<=col;i++){
			int useCol=-1;
			for(int j=0;j<col;j++){
				if(i+48==tbl[0][j]){
					useCol=j;
				}
			}
			for(int k=1;k<row;k++){
				tbl[k][useCol]=cText.charAt(count++);
			}
		}
		String text="";
		for(int i=1;i<row;i++){
			for(int j=0;j<col;j++){
				text+=tbl[i][j];
			}
		}
		return text;
	}
}