//9:30
import java.util.*;

class Person{
    int index;
    int price;
    
    public Person(int index, int p){
        this.index = index;
        this.price = p;
    }
    
    public void addPrice(int p){
        this.price += p;
    }
    
    public String toString(){
        return index + " " + price;
    }
   
}
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, Person> map = new HashMap<>();
        for(int i = 0; i<enroll.length; i++){
            map.put(enroll[i], new Person(i, 0));
        }
        
        int index = 0;
        while(index < seller.length){
            String cs = seller[index];
            int ca = amount[index] * 100;
            
            Person c = map.get(cs); // 7
            int price = ca / 10;
            int myPrice = ca - price;
            c.addPrice(myPrice); 
            
            dfs(c, map, referral, price); //120
            index ++;
        }
        
        for(int i = 0; i<enroll.length; i++){
            answer[i] = map.get(enroll[i]).price;
        }
        
        return answer;
    }
    
    public void dfs(Person cperson, Map<String, Person> map, String[] ref, int price){
        if(ref[cperson.index].equals("-") || price < 1){
            return;
        }
        String giver = ref[cperson.index];
        
        int nprice = price/10;
        int myPrice = price - nprice;
        
        Person c = map.get(giver);
        c.addPrice(myPrice);
        
        dfs(map.get(giver), map, ref, nprice);
    }
}