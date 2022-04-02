import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println("Testing");   
    }
    public Map<Character, Integer> stringToMap (String text) {
        Map<Character, Integer> alphaCount = new HashMap<Character, Integer>(); 
        Integer a = 0,b = 0,c = 0,d = 0,e = 0,f = 0,g = 0,h = 0,i = 0,j = 0,k = 0,l = 0,m = 0,n = 0,o = 0,p = 0,q = 0,r = 0,s = 0,t = 0,u = 0,v = 0,w = 0,x = 0,y = 0,z = 0;

        for (int in = 0; in < text.length(); in++) {
            Character current = text.charAt(in);
            current = Character.toLowerCase(current);
            switch (current) {
                case 'a':  a += 1;
                         break;
                case 'b':  b += 1;
                         break;
                case 'c':  c += 1;
                         break;
                case 'd':  d += 1;
                         break;
                case 'e':  e += 1;
                         break;
                case 'f':  f += 1;
                         break;
                case 'g':  g += 1;
                         break;
                case 'h':  h += 1;
                         break;
                case 'i':  i += 1;
                         break;
                case 'j':  j += 1;
                         break;
                case 'k':  k += 1;
                         break;
                case 'l':  l += 1;
                         break;
                case 'm':  m += 1;
                         break;
                case 'n':  n += 1;
                         break;
                case 'o':  o += 1;
                         break;
                case 'p':  p += 1;
                         break;
                case 'q':  q += 1;
                         break;
                case 'r':  r += 1;
                         break;
                case 's':  s += 1;
                         break;
                case 't':  t += 1;
                         break;
                case 'u':  u += 1;
                         break;
                case 'v':  v += 1;
                         break;
                case 'w':  w += 1;
                         break;
                case 'x':  x += 1;
                         break;
                case 'y':  y += 1;
                         break;
                case 'z':  z += 1;
                         break;
            
            }
        }//END loop through string
        alphaCount.put('a', a);
        alphaCount.put('b', b);
        alphaCount.put('c', c);
        alphaCount.put('d', d);
        alphaCount.put('e', e);
        alphaCount.put('f', f);
        alphaCount.put('g', g);
        alphaCount.put('h', h);
        alphaCount.put('i', i);
        alphaCount.put('j', j);
        alphaCount.put('k', k);
        alphaCount.put('l', l);
        alphaCount.put('m', m);
        alphaCount.put('n', n);
        alphaCount.put('o', o);
        alphaCount.put('p', p);
        alphaCount.put('q', q);
        alphaCount.put('r', r);
        alphaCount.put('s', s);
        alphaCount.put('t', t);
        alphaCount.put('u', u);
        alphaCount.put('v', v);
        alphaCount.put('w', w);
        alphaCount.put('x', x);
        alphaCount.put('y', y);
        alphaCount.put('z', z);

        return alphaCount;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = stringToMap(ransomNote);
        Map<Character, Integer> magMap = stringToMap(magazine);

        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
            if (entry.getValue() > magMap.get(entry.getKey())) {
                return false;
            }//If we are no good
        }
        return true;
    }
}