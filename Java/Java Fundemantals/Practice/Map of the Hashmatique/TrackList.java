import java.util.HashMap;
import java.util.Set;
public class TrackList{
    public static void main(String[] args) {
        HashMap <String,String> trackList = new HashMap<String,String>();
        trackList.put("Dendelions","i feel okay when i see your smile !");
        trackList.put("Loose yourself", "His palms are sweaty,knees weak,arms are heavy!");
        trackList.put("Dancing with your ghost", "I stay up all night, tell myself I'm alright!");
        trackList.put("Everytime we touch", "Your arms are my castle,Your heart is my sky!");
        System.out.println(trackList.get("Dendelions"));
        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key+": "+trackList.get(key));
        }
        
    }
}