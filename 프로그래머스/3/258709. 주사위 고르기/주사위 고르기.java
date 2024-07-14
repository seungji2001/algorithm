import java.util.*;
class Dice{
    List<Integer> dice = new ArrayList<>();
    List<Integer> sum = new ArrayList<>();
    public Dice(List<Integer> d, List<Integer> sum){
        this.dice = d;
        this.sum = sum;
    }
    public String toString(){
        return dice.toString() + " " + sum.toString();
    }
}

class Solution {
    List<Dice> dicesum = new ArrayList<>();
    int dicenum = 0;
    int max = Integer.MIN_VALUE;
    List<Integer> list;
    public int[] solution(int[][] dice) {
        dicenum = dice.length;
        int[] answer = new int[dicenum/2];
        List<Integer> bucket = new ArrayList<>();
        combination(0, bucket, dice);
        for(int i = 0; i<dicesum.size()/2; i++){
            fight(dicesum.get(i), dicesum.get(dicesum.size() - i - 1), 0, 0);
        }
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i) + 1;
        }
        
        return answer;
    }

    public void fight(Dice d1, Dice d2, int s1, int s2){
        Map<Integer, Integer> m1 = new HashMap<>();
        List<Integer> l1 = d1.sum;
        for(int num : l1){
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> m2 = new HashMap<>();
        List<Integer> l2 = d2.sum;
        for(int num : l2){
            m2.put(num, m2.getOrDefault(num, 0) + 1);
        }
        
        for(int m1num : m1.keySet()){
            for(int m2num : m2.keySet()){
                if(m1num > m2num){
                    s1 += m1.get(m1num) * m2.get(m2num);
                }else if(m1num<m2num){
                    s2 += m1.get(m1num) * m2.get(m2num);
                }
            }
        }
        
        if(s1 > max){
            max = s1;
            list = new ArrayList<>(d1.dice);
        }
        if(s2 > max){
            max = s2;
            list = new ArrayList<>(d2.dice);
        }
        
    }
    
    public void combination(int diceidx, List<Integer> bucket, int[][] dice){
        if(bucket.size() == dicenum/2){
            makeDiceSum(new ArrayList<>(bucket), dice);
            return;
        }
        for(int i = diceidx; i<dicenum; i++){
            if(bucket.contains(i)){
                continue;
            }
            bucket.add(i);
            combination(i, bucket, dice);
            bucket.remove(bucket.size()-1);
        }
    }
    
     public void makeDiceSum(List<Integer> bucket, int[][] dice){
        List<Integer> sums = new ArrayList<>();
        generateSums(bucket, dice, 0, 0, sums);
        dicesum.add(new Dice(bucket, sums));
    }

    public void generateSums(List<Integer> bucket, int[][] dice, int idx, int currentSum, List<Integer> sums) {
        if (idx == bucket.size()) {
            sums.add(currentSum);
            return;
        }

        int diceIndex = bucket.get(idx);
        for (int i = 0; i < dice[diceIndex].length; i++) {
            generateSums(bucket, dice, idx + 1, currentSum + dice[diceIndex][i], sums);
        }
    }
}