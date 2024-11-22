import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    static int[] words;  // 각 단어를 비트마스크로 저장
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        
        if(k < 5) {
            System.out.println(0);
            return;
        }
        
        // 단어들을 비트마스크로 저장
        words = new int[n];
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            for(char c : word.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }
        
        // a, n, t, i, c는 필수
        int base = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | 
                  (1 << ('i' - 'a')) | (1 << ('c' - 'a'));
        
        combination(k - 5, 0, base);
        
        System.out.println(result);
    }
    
    private static void combination(int remain, int start, int learned) {
        if(remain == 0) {
            int count = 0;
            for(int word : words) {
                if((word & learned) == word) {
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }
        
        for(int i = start; i < 26; i++) {
            if((learned & (1 << i)) == 0) {  // 아직 배우지 않은 글자면
                combination(remain - 1, i + 1, learned | (1 << i));
            }
        }
    }
}