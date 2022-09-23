class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Map<String, List<Transaction>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Transaction transaction = Transaction.parse(transactions[i], i);
            List<Transaction> nameTransactions = map.getOrDefault(transaction.name, new ArrayList<>());
            nameTransactions.add(transaction);
            map.putIfAbsent(transaction.name, nameTransactions);
        }
        
        List<String> invalidTransactions = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Transaction> neighbors = map.get(name);
            for (Transaction t : neighbors)
                if (isInvalid(t, neighbors))
                    invalidTransactions.add(transactions[t.idx]);
        }
        return invalidTransactions;
    }
    
    boolean isInvalid(Transaction transaction, List<Transaction> neighbors) {
        if (transaction.amount > 1000) return true;
        for (Transaction t : neighbors) {
            if (t.name.equals(transaction.name) 
                && !transaction.city.equals(t.city) 
                && Math.abs(t.time - transaction.time) <= 60)
                return true;
        }
        return false;
    }
    
    static class Transaction {
        String name;
        int time;
        int amount;
        String city;
        int idx;
        
        Transaction(String n, int t, int a, String c, int i) {
            name = n;
            time = t;
            amount = a;
            city = c;
            idx = i;
        }
        
        static Transaction parse(String transaction, int idx) {
            String[] split = transaction.split(",");
            String name = split[0];
            int time = Integer.parseInt(split[1]);
            int amount = Integer.parseInt(split[2]);
            String city = split[3];
            return new Transaction(name, time, amount, city, idx);
        }
    }
}