class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        String[] numberMap =  {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] twoNumberMap = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] appendArray = {"", " Thousand", " Million", " Billion"};
        
        String number = String.valueOf(num);
        Deque<String> stack = new ArrayDeque<>();
        int i = number.length() - 1;
        int idx = 0;
        
        while (i >= 0) {
            String threeOrLessDigitNum = number.substring(Math.max(0, i - 2), i + 1);
            String result = solveThree(threeOrLessDigitNum, numberMap, twoNumberMap);
            result = !result.isEmpty() ? result + appendArray[idx] + " ": "";
            stack.add(result);
            idx++;
            i -= 3;
        }
        
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty())
            sb.append(stack.pollLast());
        return sb.toString().trim();
    }
    
    
    public String solveThree(String threeOrLessDigitNum, String[] numberMap, String[] twoNumberMap) {
        if (threeOrLessDigitNum.isEmpty())
            return "";
        
        if (threeOrLessDigitNum.length() == 1)
            return numberMap[Integer.parseInt(threeOrLessDigitNum)];
        
        if (threeOrLessDigitNum.length() == 2)
            return solveTwo(threeOrLessDigitNum, numberMap, twoNumberMap);
        
        int hunderedDigit = Integer.parseInt(threeOrLessDigitNum.substring(0, 1));
        String twoResult = solveTwo(threeOrLessDigitNum.substring(1), numberMap, twoNumberMap);
        return hunderedDigit == 0 ? twoResult : numberMap[hunderedDigit] + " " + "Hundred" + (!twoResult.isEmpty() ? " " + twoResult : "");
    }
    
    public String solveTwo(String twoDigitNumber, String[] numberMap, String[] twoNumberMap) {
        int num = Integer.parseInt(twoDigitNumber);
        if (num <= 19)
            return numberMap[num];
        String result = twoNumberMap[num / 10];
        num %= 10;
        if (num != 0)
            return result + " " + numberMap[num];
        return result;
    }
}