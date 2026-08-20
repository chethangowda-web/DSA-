class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
     int low = 1;
     int high = (int)1e7;
     int ans = -1;

    while(low <= high){
        int mid = low + (high - low) / 2;
        if(canReach(dist , hour , mid)){
            ans = mid;
            high = mid - 1;
        }else{
            low = mid + 1;
        }
     }   
     return ans;
    }
    private boolean canReach(int[] dist , double hour , int speed){
        double time = 0.0;

        for(int i = 0; i < dist.length; i++){
            double t = (double) dist[i] / speed;

            if(i != dist.length - 1){
                time += Math.ceil(t);
            }else{
                time += t;
            }
        }
        return time <= hour;
    }
}