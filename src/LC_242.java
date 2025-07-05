import java.util.HashMap;
import java.util.Map;

public class LC_242 {
    public boolean isAnagram(String s, String t) {
        /*
        HashMap<Character, Integer> a = new HashMap<>(), b = new HashMap<>();

        for(char c: s.toCharArray()){
            if(a.containsKey(c)){
                a.put(c, a.get(c) + 1);
            }else{
                a.put(c, 1);
            }
        }

        for(char c: t.toCharArray()){
            if(b.containsKey(c)){
                b.put(c, b.get(c) + 1);
            }else{
                b.put(c, 1);
            }
        }
        if(a.size() != b.size()){
            return false;
        }

        for(Map.Entry<Character, Integer> entry: a.entrySet()){
            if(!entry.getValue().equals(b.get(entry.getKey()))){
                return false;
            }
        }
        return true;*/

        int[] hash_a = new int[26], hash_b = new int[26];

        char[] char_s = s.toCharArray();
        for(char c: char_s){
            hash_a[c - 'a'] += 1;
        }

        char[] char_t = t.toCharArray();
        for(char c: char_t){
            hash_b[c - 'a'] += 1;
        }

        for(int i = 0; i < 26; i++){
            if(hash_a[i] != hash_b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_242 obj = new LC_242();
        String s = "abcd", t = "bdace";
        System.out.println(obj.isAnagram(s, t));
    }
}
