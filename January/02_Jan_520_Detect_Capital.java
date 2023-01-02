class Solution {
  public boolean detectCapitalUse(String word) {
    int n = word.length();
    char ch = word.charAt(0);
    boolean firstLetterCaps = (ch >= 'A' && ch <= 'Z') ? true : false;

    if (!firstLetterCaps) {
      for (int i = 1; i < n; i++) {
        char c = word.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          return false;
        }
      }
    } else if (word.length() > 1) {
      char c2 = word.charAt(1);
      boolean secondLetterCaps = (c2 >= 'A' && c2 <= 'Z') ? true : false;
      if (secondLetterCaps) {
        for (int i = 2; i < n; i++) {
          char c = word.charAt(i);
          if (c >= 'a' && c <= 'z') {
            return false;
          }
        }
      } else {
        for (int i = 2; i < n; i++) {
          char c = word.charAt(i);
          if (c >= 'A' && c <= 'Z') {
            return false;
          }
        }
      }
    }

    return true;
  }
}