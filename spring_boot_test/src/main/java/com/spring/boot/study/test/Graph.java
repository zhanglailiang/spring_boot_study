class Solution {
    public int[] sortArray(int[] nums) {
        // querySort(nums, 0, nums.length-1);
        //buddleSort(nums);
        // selectSort(nums);
        // insertSort(nums);
        //shellSort(nums);
        // mergeSort(nums, 0, nums.length-1);
        // countSort(nums);
        heapSort(nums);
        return nums;
    }
    /**选择排序*/
    void selectSort(int[] nums) {
        int len = nums.length ;

        int min = 0;
        for (int i=0;i<len;i++) {
            min = i;

            for (int j=i+1;j<len;j++) {
                if (nums[j]<nums[min]) {
                    min = j;
                }
            }

            int tmp = nums[i];
            nums[i]= nums[min];
            nums[min] = tmp;
        }
    }



    /**冒泡排序*/
    void buddleSort(int[] nums) {
        int len = nums.length ;

        for (int i=0;i<len;i++) {
            for (int j=0;j<len-i-1;j++) {
                if (nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = tmp;
                }

            }
        }
    }


    /**插入排序*/
    void insertSort(int[] nums) {
        int len = nums.length ;

        for (int i=1;i<len;i++) {
            int curIndex = i;
            while(curIndex>0 && nums[curIndex-1] > nums[curIndex]) {
                int tmp = nums[curIndex-1];
                nums[curIndex-1]= nums[curIndex];
                nums[curIndex] = tmp;
                curIndex--;
            }
        }
    }


    /**希尔排序*/
    void shellSort(int[] nums) {
        int len = nums.length ;
        int d  = len >> 1;

        while (d>=1) {
            for (int i=d;i<len;i++) {
                int curIndex = i;
                while(curIndex-d>=0 && nums[curIndex-d] > nums[curIndex]) {
                    int tmp = nums[curIndex-d];
                    nums[curIndex-d]= nums[curIndex];
                    nums[curIndex] = tmp;
                    curIndex -= d;
                }
            }
            d=d>>1;
        }

    }


    /**快速排序**/
    void querySort(int[] nums, int l, int r) {
        if (l >= r) return;
        int left = l; int right  = r;
        int tmp = nums[left];
        while (left  < right) {
            while (left  < right && nums[right] >= tmp) {
                right--;
            }
            if (nums[right] < tmp) {
                nums[left] = nums[right];
                left++;
            }

            while (left  < right && nums[left] <= tmp) {
                left++;
            }
            if (nums[left] > tmp) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = tmp;

        querySort(nums,  l,left);
        querySort(nums,  left+1,r);
    }


    /**归并排序*/
    void mergeSort(int[] nums, int l, int r) {
        if (l >=r) {
            return;
        }
        int mid = l + (r - l) /2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        mergeSortInOrder(nums, l, mid,r);
    }

    // 归并排序合并两个有序数组
    void mergeSortInOrder(int[] nums, int left, int mid, int right) {
        int arrs[] = new int[right-left+1];
        int rb  = mid +1;
        int start = left;
        int k = 0;
        while (left <=mid && rb <= right) {
            if (nums[left] < nums[rb]) {
                arrs[k++] = nums[left++];
            } else {
                arrs[k++] = nums[rb++];
            }
        }

        while (left <=mid) {
            arrs[k++] = nums[left++];
        }

        while (rb < right) {
            arrs[k++] = nums[rb++];
        }

        for (int i =0;i<k;i++) {
            nums[start++] = arrs[i];
        }
    }

    // 计数排序 不一定适合当前的场景
    void countSort(int[] nums) {
        int min =0;
        int max =0;
        int len = nums.length;
        for (int  i=0;i<len;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bocket[] = new int[max -min +1];
        for (int  i=0;i<len;i++){
            bocket[nums[i]]++;
        }

        int k =0;
        for (int   i=0;i<bocket.length;i++){
            int count = bocket[i];
            for  (int j=0;j<count;j++) {
                nums[k++] = i;
            }
        }

    }

    /**构成最大二叉堆，然后再出堆*/
    void heapSort(int[] nums) {
        int len = nums.length;
        //将数组调整为最大二叉堆
        for (int i  =  len/2 -1;i>=0;i--) {
            heapB(nums, len, i);
        }

        // 在原有数组的基础上进行出堆，出堆需要调整
        for (int i  =  len -1;i>=0;i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapB(nums, i, 0);
        }


    }

    void heapB(int[] nums,int len, int index) {
        // 左儿子位置
        int left = 2*index +1;
        // 右儿子位置
        int right = 2* index +2;

        // 最大的值的节点位置
        int maxIndex = index;
        if (left < len && nums[left] > nums[maxIndex] )maxIndex = left;
        if (right < len && nums[right] > nums[maxIndex] )maxIndex = right;

        //需要调整
        if (maxIndex !=  index) {
            int tmp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = tmp;
            //这个节点发生变更，子节点也需要检查是否需要发生变更
            heapB(nums, len, maxIndex);
        }

        Integer s = 1;

    }
}