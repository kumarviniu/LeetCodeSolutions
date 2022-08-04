class Solution {
    public String numberToWords(int num) {
        String[] numberMap =  {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] twoNumberMap = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num == 0)
            return "Zero";
        StringBuilder sb = new StringBuilder("");
        String number = String.valueOf(num);
        int i = number.length() - 1;
        String[] appendArray = {"", " Thousand", " Million", " Billion"};
        int idx = 0;
        while (i >= 0) {
            int j = i;
            while (j >= 0 && j >= i - 2)
                j--;
            String threeOrLessDigitNum = number.substring(j + 1, i + 1);
            System.out.println(threeOrLessDigitNum);
            String result = solveThree(threeOrLessDigitNum, numberMap, twoNumberMap);
            result = !result.isEmpty() ? result + appendArray[idx] + " ": "";
            sb.insert(0, result);
            idx++;
            i = j;
        }
        
        return sb.toString().trim();
    }
    
    
    public String solveThree(String threeOrLessDigitNum, String[] numberMap, String[] twoNumberMap) {
        if (threeOrLessDigitNum.isEmpty())
            return "";
        
        if (threeOrLessDigitNum.length() == 1)
            return numberMap[Integer.parseInt(threeOrLessDigitNum)];
        
        if (threeOrLessDigitNum.length() == 2)
            return solveTwo(threeOrLessDigitNum, numberMap, twoNumberMap);
        
        int hunderedDigit = Integer.parseInt(threeOrLessDigitNum.charAt(0) + "");
        String twoResult = solveTwo(threeOrLessDigitNum.substring(1), numberMap, twoNumberMap);
        return hunderedDigit == 0 ? twoResult : numberMap[hunderedDigit] + " " + "Hundred" + (!twoResult.isEmpty() ? " " + twoResult : "");
    }
    
    public String solveTwo(String twoDigitNumber, String[] numberMap, String[] twoNumberMap) {
        int num = Integer.parseInt(twoDigitNumber);
        if (num <= 19)
            return numberMap[num];
        String result = twoNumberMap[num / 10];
        if (num % 10 != 0)
            return result + " " + numberMap[num % 10];
        return result;
    }
}