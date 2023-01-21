class Solution {

    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray(); //for converting integer into char array

        int i = arr.length - 1;
        //finding the first dip from end
        while (i > 0) {
            if (arr[i - 1] >= arr[i]) {
                i--;
            } else {
                break;
            }
        }

        //if reached 0 then dip didn't find, simply return -1;
        if (i == 0) {
            return -1;
        }

        //finding first greater element then dip from end
        int idx1 = i - 1; // idx1 poitns to dip index

        int j = arr.length - 1;
        while (j > idx1) {
            if (arr[j] > arr[idx1]) {
                break;
            }
            j--;
        }

        // swap the dip element and first greater element
        swap(arr, idx1, j);

        // reverse after dip idx
        int left = i;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }

        String res = new String(arr); //converting char array back to string
        long val = Long.parseLong(res); //now parsing our string into long val
        return (val > Integer.MAX_VALUE ? -1 : (int) val); //check whether val is > intmax, if
        //yes , return -1 else return val after typecasting it inot integer.
    }

    //swapping the idxes
    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
