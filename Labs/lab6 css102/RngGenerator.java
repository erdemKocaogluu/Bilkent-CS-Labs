public class RngGenerator {

    public static MyBigInt[] createSequence(MyBigInt seed, int amount) {
        MyBigInt[] seq = new MyBigInt[amount];
        MyBigInt current = seed;
        
        int nDigits = seed.toString().length();

        for (int k = 0; k < amount; k++) {
            MyBigInt sq = current.multiply(current);
            MyBigInt val = sq.add(current);
            
            String sNum = val.toString();
            
            while (sNum.length() < 2 * nDigits) {
                sNum = "0" + sNum;
            }
            
            int startIdx = (sNum.length() - nDigits) / 2;
            String middlePart = sNum.substring(startIdx, startIdx + nDigits);
            
            int shiftCursor = startIdx;
            while (middlePart.length() > 0 && (middlePart.charAt(0) + "").equals("0") && shiftCursor > 0) {
                shiftCursor--;
                middlePart = sNum.substring(shiftCursor, shiftCursor + nDigits);
            }
            
            current = new MyBigInt(middlePart);
            seq[k] = current;
        }
        
        return seq;
    }
}