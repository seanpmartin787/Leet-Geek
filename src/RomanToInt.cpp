class RomanToInt {
    public:
        int romanToInt(string s) {
            int sum = 0;
            for (int i = 0; i < s.length() ; i++) {
                //s[i] = s[i].toupper();
                int temp = 0;
                switch(s[i]) {
                    case 'I' :
                        temp = 1;
                        break;
                    case 'V' :
                        temp = 5;
                        break;
                    case 'X' :
                        temp = 10;
                        break;
                    case 'L' :
                        temp = 50;
                        break;
                    case 'C' :
                        temp = 100;
                        break;
                    case 'D' :
                        temp = 500;
                        break;
                    case 'M' :
                        temp = 1000;
                        break;
                    default :
                        cout << "Invalid input" << endl;
                        throw "error";
                }//END switch statement
                
                if (temp == 1 && (s[i+1] == 'V' || s[i+1] == 'X')) {temp = temp * -1;}
                else if (temp == 10 && (s[i+1] == 'L' || s[i+1] == 'C')) {temp = temp * -1;}
                else if (temp == 100 && (s[i+1] == 'D' || s[i+1] == 'M')) {temp = temp * -1;}
                         
                sum += temp;
            }/*End for loop*/
                return sum;
        }
    };