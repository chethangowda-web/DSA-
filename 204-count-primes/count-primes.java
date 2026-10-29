class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n];

        for(int i = 3; i < n; i+=2){
            isPrime[i] = true;
        }

        int count = n / 2;

        for(int i = 3; i * i < n; i+=2){
            if(isPrime[i]){
                for(int j = i * i; j < n; j+= 2 * i){
                    if(isPrime[j]){
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}