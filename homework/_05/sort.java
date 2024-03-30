package homework._05;
public class sort {
    public static void bubble (int[] nums){
        int end = nums.length;
        while(end!= 0){
            int flag = 0;
            for(int i = 0;i<end-1 ;i++){
                if(nums[i] > nums[i+1]){
                    int temp = nums[i] ;
                    nums[i] = nums[i+1];
                    nums[i +1 ] = temp;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
            end--;
        }
    }
public static void insertsort(int[] nums){
        int end = nums.length ;
    for (int i = 1; i < end; i++) {
        if(nums[i] < nums[i-1]){
          int temp = nums[i] ;
          nums[i ] = nums[i - 1];
          int j  = i -1;
          while(j>=0&& temp < nums[j]){
              nums[j + 1 ] = nums[j];
              j--;
          }
          nums[j + 1] = temp;
    }

    }
}
public static void quicksort(int[] nums,int begin ,int end ){
        if(begin >= end){
            return ;
        }
        int temp = nums[begin];
        int left = begin , right = end;
        while(begin<end){
            while(end>begin && nums[end] >= temp){
                end --;
            }
            nums[begin] = nums[end];
            while(end > begin && nums[begin] <= temp){
                begin ++;

            }
            nums[end] = nums[begin];
        }
        nums[end] = temp;
        quicksort(nums,left,begin - 1);
        quicksort(nums , begin + 1, right);
}
    public static void merge(int[] nums , int left , int right ){
        if(left < right ) {
            int mid = (left + right )/2;
            merge(nums , left , mid );
            merge(nums , mid + 1 , right );
            mergeSort(nums, left , mid , right );
        }
    }

    public static void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temps = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temps[k++] = nums[i++];
            } else {
                temps[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temps[k++] = nums[i++];
        }
        while (j <= right) {
            temps[k++] = nums[j++];
        }
        for (int p = 0; p < temps.length; p++) {
            nums[left + p] = temps[p];
        }
    }
    public static void HeapSort(int[] nums, int n) {
        for (int i = (n - 1) / 2; i >= 0; --i) {
            AdjustDown(nums, n, i);
        }
        int end = n - 1;
        while (end > 0) {
            int temp = nums[end];
            nums[end] = nums[0];
            nums[0] = temp;
            AdjustDown(nums, end, 0);
            --end;
        }
    }
    public static void AdjustDown(int[] nums, int n, int root) {
        int parent = root;
        int child = parent * 2 + 1;
        while (child < n) {
            if (child + 1 < n && nums[child + 1] > nums[child]) {
                ++child;
            }
            if (nums[child] > nums[parent]) {
                int temp = nums[parent];
                nums[parent] = nums[child];
                nums[child] = temp;
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {12,21,20,6,14,78};
        //bubble(nums);
        //quicksort(nums,0 , nums.length - 1);
        //merge(nums, 0 , nums.length - 1);
       // insertsort(nums);
       HeapSort(nums, nums.length - 1);
        for(int i : nums){
            System.out.print(i+"\t");
        }
    }
}
