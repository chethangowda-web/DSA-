class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            boolean isAlive = true;

            while(isAlive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                // stack smaller -> pop and continue
                if(stack.peek() < -asteroid){
                    stack.pop();
                }
                //stack is equal 
                else if(stack.peek() == -asteroid){
                    stack.pop();
                    //  current dies
                    isAlive = false;
                }else{
                    // stack larger -> current dies
                    isAlive = false;
                }
            }
            // if they are alive
            if(isAlive){
                stack.push(asteroid);
            }
        }
         int[] result = new int[stack.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = stack.get(i);
        }
       return result;

    }
}

// if they explodes and there is no astroids left for collision then simply return empty array
// so the positive left value and the negative right value will be exploded

