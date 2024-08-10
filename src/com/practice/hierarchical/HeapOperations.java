package hierarchical;

public class  HeapOperations {

    private void heapify(int [] array, int size, int index) {
        int largest = index;
        int left  = 2*index+1;
        int right = 2*index+2;

        //left child is greater than the root
        if(left < size && array[left] > array[index]) {
            largest = left;
        }

        //left child is greater than the root
        if(right < size && array[right] > array[index]) {
            largest = right;
        }

        //largest is not root
        if(largest != index) {
            int swapElement = array[largest];
            array[largest]=array[index];
            array[index] = swapElement;

            heapify(array,size,largest);
        }
    }

    private void deleteNode(int []array, int size) {

        int lastElement = array[size-1];
        array [0] = lastElement;
        size=size-1;
        heapify(array,size, 0);

    }

    private void insertNode(int [] array, int size, int key) {
        size = size + 1;
        array[size - 1] = key;
        heapify(array,size,size-1);
    }
}
