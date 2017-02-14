public class myCryptosystem{
    public static void main(String args[]){
        String text="Hello";
        String key="pass";
        String dkey="pass";
        myCryptosystem cr=new myCryptosystem();
        String cText=cr.encrypt(text,key);
        System.out.println("Encrypted text: "+cText);
       
        System.out.println("Decrypted text: "+cr.decrypt(cText,dkey));
       
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
        int value=(int)textChar+(int)keyChar;
        if(value>127) value-=127;
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
        int value=(int)textChar-(int)keyChar;
        if(value<0)value+=127;
        return (char)value;
    }
}