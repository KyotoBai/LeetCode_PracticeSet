import java.util.HashMap;

public class LC_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        HashMap<Character, Integer> mapMagazine = new HashMap<>();

        char[] magazineCharArray = magazine.toCharArray();

        for(char c: magazineCharArray){
            mapMagazine.put(c, mapMagazine.getOrDefault(c, 0) + 1);
        }

        char[] ransomCharArrray = ransomNote.toCharArray();

        int temp = 0;
        for(char c: ransomCharArrray){
            if(mapMagazine.getOrDefault(c, -1) > 0){
                mapMagazine.put(c, mapMagazine.get(c) - 1);
            }else{
                return false;
            }
        }
        return true;*/

        int[] arr = new int[26];

        char[] magazineCharArray = magazine.toCharArray();

        for(char c: magazineCharArray){
            arr[c - 'a'] += 1;
        }

        char[] ransomNoteArray = ransomNote.toCharArray();

        for(char c: ransomNoteArray){
           if(arr[c - 'a'] <= 0){
               return false;
           }
            arr[c - 'a'] -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        LC_383 obj = new LC_383();
        System.out.println(obj.canConstruct("aa","baa"));
    }
}
