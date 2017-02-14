public class vigenere{
    public static void main(String args[]){
        String text="wearediscoveredsaveyourself";
        String key="deceptive";

        
        text=text.toUpperCase();
        key=key.toUpperCase();
        vigenere cr=new vigenere();
        String cText=cr.encrypt(text,key);
        System.out.println("Encrypted text: "+cText);
       
        System.out.println("Decrypted text: "+cr.decrypt(cText,key));
       
    }
   
    //Encrypt string
    private String encrypt(String painText,String key){
        String newTxt="";
        for(int i=0;i<painText.length();i++){
        boolean ok=true;
            int index=i;
            while(ok){
                if(index>=key.length()){
                    index-=key.length();
                }else{
                    ok=false;
                }
            }
            newTxt+=increse(painText.charAt(i),key.charAt(index));
        }
        return newTxt;
    }
   
   
    private char increse(char textChar,char keyChar){
        int value=(int)textChar+(int)keyChar-65;
        if(value>90) value-=26;
        return (char)value;
    }
   
    //Decrypt data
    private String decrypt(String cText,String key){
        String newTxt="";
        for(int i=0;i<cText.length();i++){
            boolean ok=true;
            int index=i;
            while(ok){
                if(index>=key.length()){
                    index-=key.length();
                }else{
                    ok=false;
                }
            }
                newTxt+=decrese(cText.charAt(i),key.charAt(index));
        }
        return newTxt;
    }
   
    private char decrese(char textChar,char keyChar){
        int value=(int)textChar-(int)keyChar+65;
        if(value<65)value+=26;
        return (char)value;
    }
}