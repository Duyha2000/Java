import java.util.Arrays;

public class Main {
    // https://docs.google.com/document/d/1V2uhLBNN_ITpXO2eL9MTpHiFdcwVnWSNZ4J6JV1zAvs/edit?tab=t.4swdymkap22l
    // https://code-with-me.global.jetbrains.com/G7Mlq_j9Rqi-c6lUQPXt9Q#p=IU&fp=DA1DF37C7714832CF1C0A16034364EB78DEABA83B01C07E51847084BA85B70D0&newUi=true
    // https://meet.google.com/hzq-wjgp-wyj
    // https://docs.google.com/spreadsheets/d/1AHleYM1JweYpHPo8dx8kWsNQCkXjRfn-yRd7HVzWBXo/edit?gid=704761184#gid=704761184
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

        // Xây max-heap từ mảng hiện có: O(n)
        void buildMaxHeap() {
            for (int i = (size / 2) - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        // Đẩy lên (để thêm mới)
        void heapifyUp(int childIndex) {

        }

        // Chèn: O(log n)
        void insert(int value) {

        }

        void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // Đẩy xuống (heapify xuống để xóa)
//        void siftDown(int parent) {
//            while (true) {
//                // parent = 15 -> largest = parent = 15
//                // left = 78 -> 15 < 78 -> largest = left = 78
//                // right = 78 ->
//                // largest = 78
//                int left = 2 * parent + 1, right = 2 * parent + 2, largest = parent;
//                if (left < size && a[left] > a[largest]) largest = left; // So sánh largest với left
//                if (right < size && a[right] > a[largest]) largest = right; // So sánh largest với right
//                if (largest == parent) break; // duừng vòng lặp nếu parent = giá trij max (> left > right)
//                swap(a, parent, largest); // Đảo chỗ soo 78 (largest) cho so 15(parent)
//                parent = largest;
//            }
//        }
        void siftDown(int parent) { // (int i)
            while (true) {
                int left = 2 * parent + 1, right = 2 * parent + 2;
                int largest = parent;
                // thay doi vi tri
                if (left < size && a[largest] < a[left]) {
                    largest = left; // 78
                }

                if (right < size && a[largest] < a[right]) {
                    largest = right; // 81
                }

                // if - else if => Chọn 1 trong 2 điều kiện
                //   65
                // left: 78 right = 81
                // 90 -> largest = 90
                // left 78 right 81
                if (largest == parent) break;

                swap(a, parent, largest); // thay doi phan tu
                parent = largest;
            }
        }

        // Lấy max: O(log n)
        int extractMax() {
            int max = a[0]; // gan max voi phan tu dau tien tai vi tri 0 (xoa phan tu tren cung)
            a[0] = a[size - 1];// gan phan tu dau tien = phan tu cuoi cung.
            // phan tu cuoi cung = chieu dai - 1
            size--;
            siftDown(0); // so sanh bang cach doi vi tri va so phan tu cua max
            // thoa man max la so phan tu cao nhat o vi tri 0
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

//        int max2 = heap.extractMax();
//        System.out.println("Extract max: " + max2);
//        System.out.println("Heap sau: " + heap);
//
//        // Demo insert
//        heap.insert(40);
//        heap.insert(5);
//        System.out.println("Sau khi insert 40 và 5: " + heap);
    }
}
