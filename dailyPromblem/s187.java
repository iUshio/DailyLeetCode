package dailyPromblem;

import java.util.*;

public class s187 {
    public List<String> findRepeatedDnaSequences1(String s) {
        int len = s.length();
        List<String> res = new LinkedList<>();
        if(len < 10){
            return res;
        }

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();
        int pe = 0;
        while(pe <=9){
            sb.append(str[pe]);
            pe++;
        }
        map.put(sb.toString(),1);
        while(pe < len){
            sb.deleteCharAt(0);
            sb.append(str[pe]);
            int tmp = map.getOrDefault(sb.toString(),0);
            if(tmp == 0){
                map.put(sb.toString(),1);
            }else if(tmp == 1){
                res.add(sb.toString());
                map.put(sb.toString(),2);
            }
            pe++;
        }

        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        if(len < 10){
            return new LinkedList<>(res);
        }

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        int pe = 0;
        while(pe <=9){
            sb.append(str[pe]);
            pe++;
        }
        set.add(sb.toString());
        while(pe < len){
            sb.deleteCharAt(0);
            sb.append(str[pe]);
            if(set.contains(sb.toString())){
                res.add(sb.toString());
            }else{
                set.add(sb.toString());
            }
            pe++;
        }

        return new LinkedList<>(res);
    }

}
