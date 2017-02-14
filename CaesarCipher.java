public class CaesarCipher{
	public static void main(String args[]){
		String text="HELLO";
		int shift=4;

		String cText=enCrypt(text,shift);
		System.out.println("Shifted: "+shift);

		System.out.println("Encripted text: "+cText);

		System.out.println("Decripted text: "+deCript(cText,shift));
	}

	//Encryption
	public static String enCrypt(String text,int shift){
		String cText="";
		int value=0;
		for(int i=0;i<text.length();i++){
			value=text.charAt(i)-shift+1;
			if(value<65){
				value+=26;
				cText+=(char)value;
			}else{
				cText+=(char)value;
			}
		}
		return cText;
	}

	//Decryption
	public static String deCript(String cText,int shift){
		String text="";
		int value=0;
		for(int i=0;i<cText.length();i++){
			value=cText.charAt(i)+shift-1;
			if(value>90){
				value-=26;
				text+=(char)value;
			}else{
				text+=(char)value;
			}
		}
		return text;
	}
}