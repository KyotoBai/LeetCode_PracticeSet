public class KamaCoder_54 {
    public String replaceNumber(String str){
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                res.append("number");
            }else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        KamaCoder_54 obj = new KamaCoder_54();
        String newStr = obj.replaceNumber("a1b2c3");
        System.out.println(newStr);
    }
}
