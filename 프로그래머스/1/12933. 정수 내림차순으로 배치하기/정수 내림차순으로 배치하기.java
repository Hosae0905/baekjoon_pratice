import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        String[] str = String.valueOf(n).split("");
        Arrays.sort(str);

        StringBuilder sb = new StringBuilder();
        for (String strList : str) {
            sb.append(strList);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}