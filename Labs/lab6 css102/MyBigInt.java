public class MyBigInt implements Comparable<MyBigInt> {

    private int[] basamaklar;
    private int len;
    
    private static final int uzunluk = 200;

    public MyBigInt(String inputStr) {
        this.basamaklar = new int[uzunluk];

        if (inputStr == null || inputStr.equals("")) {
            throw new IllegalArgumentException("Input boş olamaz");
        }

        char[] chars = inputStr.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            if (!Character.isDigit(chars[k])) {
                throw new IllegalArgumentException("Invalid character: " + chars[k]);
            }
        }

        String tempStr = inputStr;
        if (inputStr.length() > uzunluk) {
            tempStr = inputStr.substring(inputStr.length() - uzunluk);
        }

        int strLen = tempStr.length();
        for (int i = 0; i < strLen; i++) {
            String sDigit = tempStr.charAt(strLen - 1 - i) + "";
            this.basamaklar[i] = Integer.parseInt(sDigit);
        }

        calculateEffectiveSize();
    }

    public MyBigInt(long val) {
        this(val + "");
    }

    private MyBigInt() {
        this.basamaklar = new int[uzunluk];
        this.len = 1;
    }

    private void calculateEffectiveSize() {
        this.len = 1;
        boolean foundTop = false;
        int idx = uzunluk - 1;
        
        while (idx >= 0 && !foundTop) {
            if (this.basamaklar[idx] != 0) {
                this.len = idx + 1;
                foundTop = true; 
            }
            idx--;
        }
    }

    public MyBigInt add(MyBigInt other) {
        MyBigInt result = new MyBigInt();
        int carryOver = 0;
        
        int loopLen = this.len;
        if (other.len > loopLen) {
            loopLen = other.len;
        }
        
        int i = 0;
        while ((i < loopLen || carryOver != 0) && i < uzunluk) {
            int v1 = this.basamaklar[i];
            int v2 = other.basamaklar[i];

            int total = carryOver + v1 + v2;

            result.basamaklar[i] = total % 10; 
            carryOver = total / 10;
            i++;
        }

        result.calculateEffectiveSize();
        return result;
    }

    public MyBigInt subtract(MyBigInt other) {
        if (this.compareTo(other) < 0) {
            throw new ArithmeticException("Negatif olamaz");
        }

        MyBigInt result = new MyBigInt();
        int borrow = 0;
        
        for (int i = 0; i < uzunluk; i++) {
            int val1 = this.basamaklar[i];
            int val2 = other.basamaklar[i];
            
            int diff = val1 - val2 - borrow;

            if (diff < 0) {
                diff = diff + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.basamaklar[i] = diff;
        }
        result.calculateEffectiveSize();
        return result;
    }

    public MyBigInt multiply(MyBigInt other) {
        int len1 = this.len;
        int len2 = other.len;
        
        int maxLen = len1;
        if (len2 > maxLen) maxLen = len2;

        if (maxLen > 20) {
            return multiplyRecursive(this, other);
        } else {
            return multiplyIterativeee(this, other);
        }
    }

    private MyBigInt multiplyIterativeee(MyBigInt n1, MyBigInt n2) {
        MyBigInt res = new MyBigInt();
        
        for (int i = 0; i < n1.len; i++) {
            int carry = 0;
            int j = 0;
            
            while ((j < n2.len || carry > 0) && (i + j < uzunluk)) {
                int digit2 = 0;
                if (j < n2.len) {
                    digit2 = n2.basamaklar[j];
                }

                int product = (n1.basamaklar[i] * digit2) + res.basamaklar[i + j] + carry;
                
                res.basamaklar[i + j] = product % 10;
                carry = product / 10;
                j++;
            }
        }
        res.calculateEffectiveSize();
        return res;
    }

    private MyBigInt multiplyRecursive(MyBigInt x, MyBigInt y) {
        int n = x.len;
        if (y.len > n) n = y.len;

        if (n <= 20) {
            return multiplyIterativeee(x, y);
        }
        
        int half = (n / 2) + (n % 2);
        
        MyBigInt xHigh = x.getUpperPart(half);


        
        MyBigInt xLow = x.getLowerPart(half);
        MyBigInt yHigh = y.getUpperPart(half);

        MyBigInt yLow = y.getLowerPart(half);



        MyBigInt z0 = xLow.multiply(yLow);      
        MyBigInt z2 = xHigh.multiply(yHigh);    
        
        MyBigInt sumX = xLow.add(xHigh);


        MyBigInt sumY = yLow.add(yHigh);
        MyBigInt z1Raw = sumX.multiply(sumY);
        
        MyBigInt z1 = z1Raw.subtract(z2).subtract(z0);

        MyBigInt z2Shifted = z2.solaKaydır(2 * half);





        MyBigInt z1Shifted = z1.solaKaydır(half);
        
        return z2Shifted.add(z1Shifted).add(z0);
    }

    private MyBigInt getUpperPart(int cutPoint) {
        MyBigInt part = new MyBigInt();



        for (int i = cutPoint; i < uzunluk; i++) {



            part.basamaklar[i - cutPoint] = this.basamaklar[i];
        }
        part.calculateEffectiveSize();


        return part;
    }

    private MyBigInt getLowerPart(int cutPoint) {


        MyBigInt part = new MyBigInt();




        for (int i = 0; i < cutPoint && i < uzunluk; i++) {



            part.basamaklar[i] = this.basamaklar[i];


        }
        part.calculateEffectiveSize();



        return part;
    }

    private MyBigInt solaKaydır(int shift) {
        MyBigInt shifted = new MyBigInt();


        for (int i = 0; i < uzunluk - shift; i++) {

            shifted.basamaklar[i + shift] = this.basamaklar[i];
        }



        shifted.calculateEffectiveSize();



        return shifted;
    }

    public int compareTo(MyBigInt valll) {
        if (this.len > valll.len) {
            return 1;
        }
        if (this.len < valll.len) {
            return -1;
        }
        
        for (int i = this.len - 1; i >= 0; i--) {


            if (this.basamaklar[i] > valll.basamaklar[i]) {
                return 1;


            }
            if (this.basamaklar[i] < valll.basamaklar[i]) {




                return -1;
            }
        }
        return 0;
    }

    public String toString() {
        String s = "";


        for (int i = this.len - 1; i >= 0; i--) {




            s = s + this.basamaklar[i];
        }
        return s;
    }
}