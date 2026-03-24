class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int l=0,r=0,maxcount=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.getOrDefault(s.charAt(l),0)==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(map.size()==k){
                maxcount=Math.max(maxcount,(r-l)+1);
            }
            r++;
        }
        return maxcount;
    }
}