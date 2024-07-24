import java.util.*;
class Song{
    List<Integer> songlist = new LinkedList<>();
    int total = 0;
    public Song(List<Integer> songlist, int total){
        this.songlist = songlist;
        this.total = total;
    }
    public void addSong(int songNum){
        this.songlist.add(songNum);
    }
    
    public String toString(){
        return total + " " + songlist.toString();
    }
}
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        
        
        Map<String, Song> map = new HashMap<>();
        for(int i = 0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                Song song = map.get(genres[i]);
                song.total += plays[i];
                song.addSong(i);
                map.put(genres[i], song);
            }else{
                List<Integer> newsongs = new LinkedList<>();
                newsongs.add(i);
                map.put(genres[i], new Song(newsongs, plays[i]));
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<>(){
            public int compare(String s1, String s2){
                return map.get(s2).total - map.get(s1).total;
            }
        });
        
        for(String s : list){
            Song song = map.get(s);
            List<Integer> songlist = song.songlist;
            Map<Integer, Integer> playmap = new HashMap<>();
            for(int i = 0; i<songlist.size(); i++){
                playmap.put(songlist.get(i), plays[songlist.get(i)]);
            }
            List<Integer> playlist = new ArrayList<>(playmap.keySet());
            Collections.sort(playlist, new Comparator<Integer>(){
                public int compare(Integer v1, Integer v2){
                    if(playmap.get(v2) == playmap.get(v1)){
                        return v1 - v2;
                    }
                    return playmap.get(v2) - playmap.get(v1); 
                }
            });
            if(playlist.size() <= 2){
                answer.addAll(playlist);
                continue;
            }
            answer.add(playlist.get(0));
            answer.add(playlist.get(1));
        }
        
        return answer;
    }
}