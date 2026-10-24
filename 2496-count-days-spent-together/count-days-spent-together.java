class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int aliceStart = getDay(arriveAlice , daysInMonth);
        int aliceEnd = getDay(leaveAlice , daysInMonth);

        int bobStart = getDay(arriveBob , daysInMonth);
        int bobEnd = getDay(leaveBob , daysInMonth);

        int start = Math.max(aliceStart , bobStart);
        int end = Math.min(aliceEnd , bobEnd);

        if(start > end){
            return 0;
        }

        return end - start + 1;
    }

    private int getDay(String date , int[]daysInMonth){
        int month = Integer.parseInt(date.substring(0 , 2));
        int day = Integer.parseInt(date.substring(3 , 5));
        int total = day;

        for(int i = 0 ; i < month - 1; i++){
            total += daysInMonth[i];
        }
        return total;
    }
}