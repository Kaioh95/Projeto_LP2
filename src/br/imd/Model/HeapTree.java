package br.imd.Model;

import java.util.Arrays;

public class HeapTree {
    private Node[] myHeap;
    private int size; //how many elements the array has
    private int capacity; //how many elements the array can have

    public HeapTree() {
        this(100);
    }

    public HeapTree(int capacity) {
        myHeap = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void addNode(double key, String[] content) {
        addNode(new Node(key, content));
    }

    public void addNode(Node node) {
        this.ensureCapacity();
        this.myHeap[getSize()] = node;
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        if (!(hasParent(index))) {
            return;
        }
        int parentIndex = getParentIndex(index);
        Node node = myHeap[index];
        Node parent = myHeap[parentIndex];

        if (node.getKey() > parent.getKey()) {
            myHeap[index] = parent;
            myHeap[parentIndex] = node;
            heapifyUp(parentIndex);
        }
        parent = null;
        node = null;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (getSize() == capacity) {
            this.myHeap = Arrays.copyOf(this.myHeap, getSize() * 2);
            capacity = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Node[] peek(int k) {
        if (getSize() == 0) {
            return null;
        }
        return Arrays.copyOfRange(myHeap, 0, k);
    }

    public void remove() {
        myHeap[0] = myHeap[getSize() - 1];
        myHeap[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int childIndex = -1;

        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex < 0) {
            return;
        }

        if (rightChild < getSize()) {
            if (myHeap[rightChild].getKey() > myHeap[leftChild].getKey()) {
                childIndex = rightChild;
            }
        }

        if (myHeap[childIndex].getKey() > myHeap[index].getKey()) {
            Node tmp = myHeap[index];
            myHeap[index] = myHeap[childIndex];
            myHeap[childIndex] = tmp;
            tmp = null;
            heapifyDown(childIndex);
        }
    }

    public void heapSort() {
        for(int i = getSize()-1; i>0; --i){
            Node aux = myHeap[i];
            myHeap[i] = myHeap[0];
            myHeap[0] = aux;
            size--;
            heapifyDown(0, i);
        }
    }

    public void heapifyDown(int index, int length){
        int leftChild = index*2+1;
        int rightChild = index*2+2;

        int maxIndex = index;

        if(leftChild < length && myHeap[leftChild].getKey() > myHeap[index].getKey()){
            maxIndex = leftChild;
        }

        if(rightChild < length && myHeap[rightChild].getKey() > myHeap[maxIndex].getKey()){
            maxIndex = rightChild;
        }

        if(maxIndex != index){
            Node tmp = myHeap[maxIndex];
            myHeap[maxIndex] = myHeap[index];
            myHeap[index] = tmp;
            tmp = null;
            heapifyDown(maxIndex, length);
        }
    }

    public void fillNa(){
        Arrays.fill(myHeap, null);
    }

    @Override
    public String toString() {
        String first = null;
        for (Node node: myHeap) {
            first = first + node.toString();
        }
        return first;
    }
}
