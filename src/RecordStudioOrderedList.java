public class RecordStudioOrderedList {
    private RecordStudioNode head;
    private RecordStudioNode tail;

    public RecordStudioOrderedList() {
        head = null;
        tail = null;
    }


    /**********************************************************************************
     * Adds a RecordStudio element to the end of the RecordStudioOrderedList.         *
     * Creates a new RecordStudioNode with the given element.                         *
     * If the list is empty, the new node becomes both the head and the tail.         *
     * Otherwise, it is appended to the current tail, and the tail is updated.        *
     * @param element the RecordStudio object to be added to the list                 *
     **********************************************************************************/
    public void add(RecordStudio element) {
        RecordStudioNode newRecordStudioNode = new RecordStudioNode(element, null);
        if (head == null) {
            tail = newRecordStudioNode;
            head = tail;
        } else {
            tail.setLink(newRecordStudioNode);
            tail = newRecordStudioNode;
        }


    }

    /**********************************************************************************
     * Counts and returns the number of nodes in this linked list.                    *
     * Iterates through the list starting from the head and increments a counter      *
     * until the end of the list is reached.                                          *
     * @return the total number of nodes in the list                                  *
     **********************************************************************************/
    public int size() {

        int count = 0;
        RecordStudioNode cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.getLink();
        }

        return count;
    }

    /**********************************************************************************
     * Displays the contents of the list, one item per line.                          *
     * Each item’s attributes are separated by tabs, as defined in its toString()     *
     * method. No additional text is printed.                                         *
     **********************************************************************************/
    public void display() {
        for (RecordStudioNode current = head; current != null; current = current.getLink()) {
            System.out.println(current.getData().toString());
        }
    }

    /**********************************************************************************
     * Returns the index of the first occurrence of target in the list.               *
     * Uses equals() to compare items.                                                *
     * Returns -1 if the target is not found.                                         *
     * @param target the RecordStudio object to search for                            *
     * @return the 1-based index of the target if found; -1 otherwise                 *
     **********************************************************************************/
    public int indexOf(RecordStudio target) {
        if (target == null) return -1;
        RecordStudioNode pointer = head;
        int locator = 1;
        while (pointer != null) {
            if (pointer.getData().equals(target)) {
                return locator;
            }
            locator++;
            pointer = pointer.getLink();


        }


        return -1;
    }

    /**********************************************************************************
     * Adds an element to the list at the given 1-based index (head is at index 1).    *
     * If index > current size, the element is appended to the end of the list.        *
     * If index < 1, the method does nothing and returns false.                        *
     * @param index   1-based position to insert at                                     *
     * @param element the RecordStudio to insert                                        *
     * @return true if inserted; false if index < 1                                     *
     ***********************************************************************************/
    public boolean add(int index, RecordStudio element) {
        RecordStudioNode prev = head;
        if (index < 1) return false;

        if (head == null) {
            add(element);  //  call regular add method to add the recordstudio
            return true;
        }
        if (index == 1) {
            head = new RecordStudioNode(element, head);
            return true;
        }


        for (int pos = 1; pos < index - 1 && prev.getLink() != null; pos++) {
            prev = prev.getLink();
        }

        RecordStudioNode newNode = new RecordStudioNode(element, prev.getLink());
        prev.setLink(newNode);
        if (prev == tail) tail = newNode;
        return true;


    }


    /**********************************************************************************
     * Removes one occurrence of target from the list (if any), preserving order.      *
     * Uses equals() to match. Updates head/tail as needed.                            *
     * @param target the RecordStudio to remove                                        *
     * @return true if an item was removed; false otherwise                             *
     **********************************************************************************/
    public boolean remove(RecordStudio target) {
        if (target == null || head == null) return false;  // empty list or null target

        if (target.equals(head.getData())) {
            head = head.getLink();
            if (head == null) {
                tail = null;
            }
            return true;
        }

        RecordStudioNode prev = head;
        RecordStudioNode curr = head.getLink();

        while (curr != null) {
            if (target.equals(curr.getData())) {
                prev.setLink(curr.getLink());
                if (curr == tail) {
                    tail = prev;
                }
                return true;
            }
            prev = curr;
            curr = curr.getLink();
        }

        return false;
    }

    /**********************************************************************************
     * Returns the item at the given 1-based index in the list.                        *
     * Returns null if the index is less than 1 or greater than the list size.         *
     * @param index the 1-based position of the desired RecordStudio                   *
     * @return the RecordStudio at that position, or null if out of range              *
     **********************************************************************************/
    public RecordStudio get(int index) {
        if (index < 1) return null;
        int position = 1;
        RecordStudioNode currentNode = head;

        while (currentNode != null) {
            if (position == index) {
                return currentNode.getData();
            }
            position++;
            currentNode = currentNode.getLink();
        }
        return null;
    }

    /**********************************************************************************
     * Removes the item at the given 1-based index in the list (head is index 1).     *
     * If index is less than 1 or greater than the list size, no item is removed.     *
     * Updates head and tail references as needed.                                   *
     * The order of remaining elements is preserved.                                 *
     * @param index the 1-based position of the element to remove                     *
     * @return true if an element was removed; false otherwise                        *
     **********************************************************************************/
    public boolean remove(int index) {
        if (index < 1 || head == null) return false;
        if (index == 1) {
            head = head.getLink();
            return true;
        }
        RecordStudioNode prev = head;
        int pos = 1;

        while (prev != null && prev.getLink() != null) {
            if (pos == index - 1) { // found node before target
                RecordStudioNode target = prev.getLink();
                prev.setLink(target.getLink());

                if (target == tail) { // if removing the last node
                    tail = prev;
                }
                return true;
            }
            prev = prev.getLink();
            pos++;
        }

        // index beyond list length
        return false;
    }


}