import java.util.Arrays;

public class Main {

    static class MaxHeap {
        int[] a;
        int size;

        MaxHeap(int capacity) {
            a = new int[capacity];
            size = 0;
        }

        MaxHeap(int[] arr) {
            a = Arrays.copyOf(arr, arr.length);
            size = arr.length;
            buildMaxHeap();
        }

        static void swap(int[] x, int i, int j) {
            int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        // Xây max-heap từ mảng hiện có: O(n)
        void buildMaxHeap() {
            for (int i = (size / 2) - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        // Đẩy lên (để thêm mới)
        void heapifyUp(int childIndex) {
            int parentIndex = (childIndex - 1) / 2;
            while (childIndex > 0 && a[childIndex] > a[parentIndex]) {
                swap(a, childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }

        // Chèn: O(log n)
        void insert(int value) {
            a[size] = value;
            heapifyUp(size);
            size++;
        }

        // Đẩy xuống (heapify xuống để xóa)
        void siftDown(int parent) {
            while (true) {
                int left = 2 * parent + 1, right = 2 * parent + 2, largest = parent;
                if (left < size && a[left] > a[largest]) largest = left;
                if (right < size && a[right] > a[largest]) largest = right;
                if (largest == parent) break;
                swap(a, parent, largest);
                parent = largest;
            }
        }

        // Lấy max: O(log n)
        int extractMax() {
            int max = a[0];
            a[0] = a[size - 1];
            size--;
            if (size > 0) siftDown(0);
            return max;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(a, size));
        }
    }

    public static void main(String[] args) {
        int[] arr = {30, 20, 15, 10, 25}; // chưa là max-heap
        MaxHeap heap = new MaxHeap(arr);  // buildMaxHeap() sẽ chuẩn hóa

        System.out.println("Heap ban đầu: " + heap);

        int max1 = heap.extractMax();
        System.out.println("Extract max: " + max1);
        System.out.println("Heap sau: " + heap);

        int max2 = heap.extractMax();
        System.out.println("Extract max: " + max2);
        System.out.println("Heap sau: " + heap);

        // Demo insert
        heap.insert(40);
        heap.insert(5);
        System.out.println("Sau khi insert 40 và 5: " + heap);
    }
}
