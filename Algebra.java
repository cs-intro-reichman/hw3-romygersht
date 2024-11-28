// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) { 
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	
    // Returns x1 + x2
    public static int plus (int a, int b) {
        
        if (b>0) 
        {
            for (int i=0; i<b; i++) 
            {
             a++;
            }
        }
        else
        {
            for (int j=0; j>b; j--) 
            {
                a--;
            }
        }
        return a;
    }

    // Returns x1 - x2
    public static int minus(int a, int b) {
            
        if (b>0) 
        {
            for (int i=0; i<b; i++) 
            {
             a--;
            }
        }
        else
        {
            for (int j=0; j>b; j--) 
            {
                a++;
            }
        }
        return a;
    }

    // Returns x1 * x2
    public static int times (int a, int b) {

        int answer = 0;
        if (a>0 && b>0) // both positive
        {
        for (int i=0; i<b; i++) 
        {
            answer = plus(answer, a);
        }
        }

        if (a<0 && b<0) // both are negative
        {
        for (int k=0; k>b; k--) 
        {
            answer = plus(answer, a);
        }
        }

        if (a<0) //only a negative
        { 
            for (int j=0; j>a; j--) 
            {
                answer = minus(answer, b);
             
            } 
        } 

        if (a==0 || b ==0)
        {
          return 0;
        
        }

        if (b<0) //only b negative 
        {
        for (int j=0; j>b; j--) 
        {
            answer = minus(answer, a);
         
        }
        }
        return answer;
    }


    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int answer = 1;
        for (int i =0; i<n; i++)
        {
          answer = times(answer, x);
        }
        return answer;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int a, int b) {
      if (a==0 || b==0){
        return 0;
      }

      if (a<0 && b<0) {
        a = minus(0,a);
        b = minus(0,b);
      }
      if (b>a && a>0) {
       return 0;
      }

      if (a<0) {
        a = minus (0,a);
        int x = b;
        int sum = 1;
          
           while (minus(a,x)>=b){ 
            x=plus(x,b);
            sum++;
           }
        return minus(0,sum);
      }
      if (b<0) {
        b = minus (0,b);
        int x = b;
        int sum = 1;
          
           while (minus(a,x)>=b){
            x=plus(x,b);
            sum++;
           }
        return minus(0,sum);
      }

      int x = b;
      int sum = 1;
      while (minus(a,x)>=b){
        x = plus(x,b);
        sum++;
      }
      return sum;
    }


        /*int sum = 1;
        int count = 0;

        if (a==0 || b==0) //zero
        {
          return 0;
        } 

        if (a==b) //equall
        {
          return 1; 
        } 
        
        else {

            for (int i = 1; i < a; i++) //positiv
            {
             sum = times(b, i);
            
            if (sum < a) 
            {
              count ++;             
            }
            if (sum == a) 
            {
              count ++;
              return count; 
            } 
            if (sum > a)
            { 
                return count;
            }
            }

            for (int j = 1; j > a; j--) //negatives
            {
             sum = times(b, j);
    
            if (sum > a) 
            {
              count++; 
              return count;            
            } 
            if (sum == a) 
            {
              count++;
              return count;
            }
            if (sum < a)
            {
                count++;
            }
             
            }


            for (int j = 1; j > b; j--) //negatives
            {
             sum = times(a, j);
    
            if (sum > b) 
            {
              count ++;             
            } 
            if (sum == b) 
            {
              count ++;
              return count;
            }
            if (sum < b)
            {
                count++;
                return count;
            }
            }

            }  
            return count;
        }*/

        
    

    // Returns x1 % x2
    public static int mod (int a, int b) {

        int div = div(a, b);
        int sum = times(div, b);
        
        if (a == 0) //zero
        {
          return 0;  
        }
        if (a<b) //if a is smaller
        {
           return a;
        }

        if (sum == b) //mod 0
        {
        return 0;
        }
        else {
         int mod = a-sum;
         return mod;
        }
    }   

    // Returns the integer part of sqrt(x) 
    public static int sqrt (int x) {
        int answer = 0;
         
        if (x == 1)
        {
            answer = 1;
        }

        for (int i =1; i < x; i++)
        {
            if (pow(i,2) == x)
            {
                answer = i;   
            }
            if (x - pow(i, 2)< 0)
            {
                answer = i -1;
                break;
            }
        }
      return answer;
    } 
}        
