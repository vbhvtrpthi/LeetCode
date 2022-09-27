class Solution {
    public String pushDominoes(String dominoes) {
      dominoes = "L" + dominoes + "R";
      int pi = 0;
      char[] arr = dominoes.toCharArray();
        
      for(int i = 1; i < arr.length; i++){
          if(arr[i] == 'L'){
                  if(arr[pi] == 'L'){
                      for(int k = pi + 1; k < i; k++)
                           arr[k] = 'L';
                      
                   }else if(arr[pi] == 'R'){
                       int tel = (i - pi  + 1)/2;
                       for(int k = 1; k < tel; k++){
                            arr[pi + k] = 'R';
                            arr[i - k] = 'L';
                       }
                  }
              
              pi = i;
             
          }else if(arr[i] == 'R'){
              
              if(arr[pi] == 'R'){
                  for(int k = pi + 1; k < i; k++)
                       arr[k] = 'R';
              }
            pi = i;
        
          }
     }
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < arr.length - 1; i++){
        sb.append(arr[i]);
    }
          
   return sb.toString();
    }
}