class Solution {
  public boolean wordPattern(String pattern, String s) {
      String[] arr = s.split(" ");
      if(pattern.length() != arr.length) {
          return false;
      }
      
      HashMap<Character , String> map1 = new HashMap<>();
      HashMap<String , Character> map2 = new HashMap<>();

      for(int i = 0 ; i < arr.length ; i++) {
          String word = arr[i];
          char ch = pattern.charAt(i);

          if(!map1.containsKey(ch) && !map2.containsKey(word)) {
              map1.put(ch , word);
              map2.put(word , ch);
          } else if(map1.containsKey(ch) && !map2.containsKey(word)) {
              return false;
          } else if(!map1.containsKey(ch) && map2.containsKey(word)) {
              return false;
          } else {
              if(map1.get(ch).equals(word) && map2.get(word) == ch) {
                  
              } else {
                  return false;
              }
          }

      }   
      return true;
  }
}