public class playfair{
	public static void main(String args[]){
		String text="ATTACKPOSTPONEDUNTILTWOAM";
		String key="HELLO";

		String cText=enCrypt(text,key);	
		System.out.println("Key is: "+key);
		System.out.println("Encrypted text: "+cText);
		System.out.println("Decrypted text: "+deCrypt(cText,key));
	}

//Get next letter
	static int count=0;
	static String added="";
	private static char nxt(String key){
		boolean exists=false;
		for(int i=0;i<added.length();i++){
			if(key.charAt(count)==added.charAt(i)){
				exists=true;
			}
		}
		if(!exists){
			added+=key.charAt(count);
			return key.charAt(count++);
		}else{
			count++;
			return nxt(key);
		}
	}

//Encrypt
	public static String enCrypt(String text,String key){
		char tbl[][]=new char[5][5];
		key=key.replace("J","I");
		key+="ABCDEFGHIKLMNOPQRSTUVWXYZ";
		if(text.length()%2==1){
			text+='X';
		}

		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				tbl[i][j]=nxt(key);
			}
		}

		String cText="";
		for(int i=0;i<text.length()/2;i++){
			String peace=text.substring(i*2,i*2+2);
			int points[][]=new int[2][2];
			//System.out.println(peace);
			for(int j=0;j<tbl.length;j++){
				for(int k=0;k<tbl[j].length;k++){
					if(tbl[j][k]==peace.charAt(0)){
						points[0][0]=j;
						points[0][1]=k;
					}
					if(tbl[j][k]==peace.charAt(1)){
						points[1][0]=j;
						points[1][1]=k;
					}
				}
			}
			//System.out.print(points[0][0]+","+points[0][1]+"  "+points[1][0]+","+points[1][1]+"\n");

			if(points[0][0]==points[1][0]){
				cText+=tbl[points[0][0]][mkNo(points[0][1]+1)];
				cText+=tbl[points[1][0]][mkNo(points[1][1]+1)];
			}else if(points[0][1]==points[1][1]){
				cText+=tbl[mkNo(points[0][0]+1)][points[0][1]];
				cText+=tbl[mkNo(points[1][0]+1)][points[1][1]];
			}else{
				cText+=tbl[points[0][0]][points[1][1]];
				cText+=tbl[points[1][0]][points[0][1]];
			}
			//System.out.println(cText);
		}

		return cText;
	}

//At same line,fix out of bound
	private static int mkNo(int no){
		if(no>=5){
			no=0;
		}else if(no<0){
			no=4;
		}
		return no;
	}
//Decrypt
	public static String deCrypt(String cText,String key){
		char tbl[][]=new char[5][5];
		key=key.replace("J","I");
		key+="ABCDEFGHIKLMNOPQRSTUVWXYZ";
		if(cText.length()%2==1){
			cText+='X';
		}
		count=0;
		added="";
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				tbl[i][j]=nxt(key);
			}
		}

		String text="";
		for(int i=0;i<cText.length()/2;i++){
			String peace=cText.substring(i*2,i*2+2);
			int points[][]=new int[2][2];
			//System.out.println(peace);
			for(int j=0;j<tbl.length;j++){
				for(int k=0;k<tbl[j].length;k++){
					if(tbl[j][k]==peace.charAt(0)){
						points[0][0]=j;
						points[0][1]=k;
					}
					if(tbl[j][k]==peace.charAt(1)){
						points[1][0]=j;
						points[1][1]=k;
					}
				}
			}
			//System.out.print(points[0][0]+","+points[0][1]+"  "+points[1][0]+","+points[1][1]+"\n");

			if(points[0][0]==points[1][0]){
				text+=tbl[points[0][0]][mkNo(points[0][1]-1)];
				text+=tbl[points[1][0]][mkNo(points[1][1]-1)];
			}else if(points[0][1]==points[1][1]){
				text+=tbl[mkNo(points[0][0]-1)][points[0][1]];
				text+=tbl[mkNo(points[1][0]-1)][points[1][1]];
			}else{
				text+=tbl[points[0][0]][points[1][1]];
				text+=tbl[points[1][0]][points[0][1]];
			}
			//System.out.println(cText);
		}
		return text;
	}
}