class Solution {
    public double myPow(double x, int n) {
        // optimal - binary exponential

        long N = n;
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        while(N > 0){
            if((N & 1) == 1)
            {
                result *= x;
            }

            x *= x;
            N /= 2;
        }

        return result;
    }
}