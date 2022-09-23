class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] trxns = new Transaction[n];
        for (int i = 0; i < n; i++) {
            String transaction = transactions[i];
            trxns[i] = Transaction.parse(transaction);
        }
        List<String> invalidTransactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isInvalid(trxns, i))
                invalidTransactions.add(transactions[i]);
        }
        return invalidTransactions;
    }
    
    boolean isInvalid(Transaction[] trxns, int idx) {
        Transaction transaction = trxns[idx];
        if (transaction.amount > 1000) return true;
        for (int i = 0; i < trxns.length; i++) {
            if (i != idx
                && trxns[i].name.equals(transaction.name) 
                && !transaction.city.equals(trxns[i].city) 
                && Math.abs(trxns[i].time - transaction.time) <= 60)
                return true;
        }
        return false;
    }
    
    static class Transaction {
        String name;
        int time;
        int amount;
        String city;
        
        Transaction(String n, int t, int a, String c) {
            name = n;
            time = t;
            amount = a;
            city = c;
        }
        
        static Transaction parse(String transaction) {
            String[] split = transaction.split(",");
            String name = split[0];
            int time = Integer.parseInt(split[1]);
            int amount = Integer.parseInt(split[2]);
            String city = split[3];
            return new Transaction(name, time, amount, city);
        }
    }
}