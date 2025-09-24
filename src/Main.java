import java.util.Arrays;

public class Main {
    // https://docs.google.com/document/d/1V2uhLBNN_ITpXO2eL9MTpHiFdcwVnWSNZ4J6JV1zAvs/edit?tab=t.4swdymkap22l
    // https://docs.google.com/spreadsheets/d/1AHleYM1JweYpHPo8dx8kWsNQCkXjRfn-yRd7HVzWBXo/edit?gid=704761184#gid=704761184
    // https://meet.google.com/hzq-wjgp-wyj
    static class MaxHeap {
        int[] a;
        int size;
        int capacity;

        MaxHeap(int capacity) {
            a = new int[capacity];
            size = 0;
        }

        public MaxHeap(int[] arr) {
            if (arr == null) {
                throw new IllegalArgumentException("Input array cannot be null");
            }
            this.capacity = Math.max(arr.length, 10); // Ensure minimum capacity
            this.a = Arrays.copyOf(arr, capacity);
            this.size = arr.length;
            buildMaxHeap();
        }

        // Xây max-heap từ mảng hiện có: O(n)
        void buildMaxHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                siftDown(i);
            }

        }

        // Đẩy lên (để thêm mới)
        void siftUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;// Cha
                if (a[index] <= a[parentIndex]) {
                    break;
                }

                if (a[index] > a[parentIndex]) {
                    swap(a, index, parentIndex);
                    index = parentIndex;
                }
            }

        }

        // Chèn: O(log n)
        void insert(int value) {
            // B1: Gán phần tử value -> index cuối
            // arr [1,2,3,4,5], add number 8
            //  arr[5] = 8
            a[size] = value;
            siftUp(size);
            size++;

        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(a, size));
        }

        void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        void siftDown(int parent) {
            while (true) {
                int left = 2 * parent + 1; // 5
                int right = 2 * parent + 2; // 6
                int largest = parent;

                if (left < size && a[largest] < a[left]) {
                    largest = left;
                }
                if (right < size && a[largest] < a[right]) {
                    largest = right;
                }
                if (largest == parent)
                    break;

                swap(a, parent, largest);
                parent = largest;
            }
        }

        // Lấy max: O(log n)
        int extractMax() {
            int max = a[0];
            a[0] = a[size - 1];
            size--;
            siftDown(0);
            return max;
        }


    }

    public static void main(String[] args) {
        int[] arr = {30, 20, 15, 10, 25, 40, 52}; // chưa là max-heap
        MaxHeap heap = new MaxHeap(arr);  // buildMaxHeap() sẽ chuẩn hóa

        System.out.println("Heap ban đầu: " + heap);

        int max1 = heap.extractMax();
        System.out.println("Extract max: " + max1);
        System.out.println("Heap sau: " + heap);

//        // Demo insert
        heap.insert(50);
        System.out.println("Sau khi insert 40: " + heap);
    }
}
