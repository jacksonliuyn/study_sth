package study;

public class QuickSelect<T extends Comparable<T>> {
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {

        T t = a[i];

        a[i] = a[j];

        a[j] = t;

    }

    private int partition(T[] nums, int l, int h) {

        int i = l, j = h + 1;

        T v = nums[l];

        while (true) {

            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) break;
            swap(nums, i, j);

        }
        swap(nums, l, j);
        return j;

    }

    public T select(T[] nums, int k) {

        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }

        }
        return nums[k];
    }
}
