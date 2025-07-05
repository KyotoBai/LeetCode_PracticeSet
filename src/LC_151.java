import java.util.Arrays;

public class LC_151 {
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        charArr = deleteSpace(charArr);
        charArr = reverseLines(charArr);
        charArr = reverseWord(charArr);
        return new String(charArr);
    }

    public char[] deleteSpace(char[] charArr){
        int slow = 0;
        int fast = 0;
        for(;fast < charArr.length; fast++){
            if(charArr[fast] != ' '){
                if(slow != 0) charArr[slow++] = ' ';
                while(fast < charArr.length && charArr[fast] != ' '){
                    charArr[slow++] = charArr[fast++];
                }
            }
        }

        return Arrays.copyOfRange(charArr, 0, slow);
    }

    public char[] reverseLines(char[] charArr){
        int left = 0;
        int right = charArr.length - 1;

        while(left < right){
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left += 1;
            right -= 1;
        }
        return charArr;
    }

    public char[] reverseWord(char[] charArr){
        int wordLeft = 0;
        int wordRight = 0;

        for(; wordRight < charArr.length; wordRight++){
            if(charArr[wordRight] == ' ' || wordRight == charArr.length - 1){
                int next = wordRight + 1;
                if(wordRight != charArr.length - 1){
                    wordRight -= 1;
                }

                while(wordLeft < wordRight){
                    char temp = charArr[wordLeft];
                    charArr[wordLeft] = charArr[wordRight];
                    charArr[wordRight] = temp;
                    wordLeft += 1;
                    wordRight -= 1;
                }

                wordLeft = next;
                wordRight = next;
            }
        }

        return charArr;
    }

    public static void main(String[] args) {
        LC_151 obj = new LC_151();
        String arr = new String(" Hello World    ");
        //arr = obj.deleteSpace(arr);
        //arr = obj.reverseLines(arr);
        System.out.println(obj.reverseWords(arr));
    }
}
