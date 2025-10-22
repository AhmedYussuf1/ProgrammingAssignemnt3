public class RecordStudioTypesLists {
    private RecordStudioOrderedList musicStudioList;
    private RecordStudioOrderedList socialMediaStudioList;

    public RecordStudioTypesLists() {
        musicStudioList = new RecordStudioOrderedList();
        socialMediaStudioList = new RecordStudioOrderedList();
    }

    /**********************************************************************************
     * Adds a RecordStudio element to the correct ordered list based on its subtype.  *
     * Uses instanceof to determine whether the element is a MusicStudio or           *
     * SocialMediaContentStudio. If it is neither, throws and catches a               *
     * ClassNotFoundException and terminates the program.                             *
     * @param element the RecordStudio item to add to the correct list                *
     **********************************************************************************/
    public void add(RecordStudio element) {
        try {
            if (element instanceof MusicStudio) {
                musicStudioList.add(element);
            } else if (element instanceof SocialMediaContentStudio) {
                socialMediaStudioList.add(element);
            } else {
                throw new ClassCastException("Element is not an instance of either MusicRecordStudio or SocialMediaContentstudio.");

            }
        } catch (ClassCastException e) {
            System.out.println("Element not instance of either subclass.");

        }
    }

    /**********************************************************************************
     * Returns the number of nodes in the specified RecordStudioOrderedList.          *
     * Calls the size() method of the given list.                                     *
     * @param iol the RecordStudioOrderedList whose size will be returned             *
     * @return the number of nodes in the list                                        *
     **********************************************************************************/
    public int sizeOf(RecordStudioOrderedList iol) {
        if (iol == null) return 0;
        return iol.size();
    }

    /**********************************************************************************
     * Displays the contents of the specified RecordStudioOrderedList.                *
     * Calls the display() method of the given list.                                  *
     * The method prints the items on the screen and does not return a String.        *
     * @param iol the RecordStudioOrderedList to display                              *
     **********************************************************************************/
    public void display(RecordStudioOrderedList iol) {
        if (iol == null) {
            System.out.println("The list is empty or null.");
            return;
        }
        iol.display();
    }

    /**********************************************************************************
     * Adds a RecordStudio element to the correct ordered list at the given index.    *
     * The head node is at index 1. If index > list size, the element is appended.    *
     * If index < 1 or element is not an instance of either subtype, nothing happens. *
     * Uses instanceof to determine which list to insert into.                        *
     * @param index   the 1-based position to insert at                               *
     * @param element the RecordStudio to add                                         *
     * @return true if the item was added; false otherwise                            *
     **********************************************************************************/
    public boolean add(int index, RecordStudio element) {
        if (index < 1 || element == null) return false;

        try {
            if (element instanceof MusicStudio) {
                return musicStudioList.add(index, element);
            } else if (element instanceof SocialMediaContentStudio) {
                return socialMediaStudioList.add(index, element);
            } else {
                throw new ClassNotFoundException("Element not instance of either subclass.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Element not instance of either subclass.");

        }

        return false;
    }

    /**********************************************************************************
     * Removes one occurrence of the specified RecordStudio from the correct list.    *
     * Uses equals() to search for the target.                                        *
     * If the target is not found or invalid, no changes are made.                    *
     * If the target is not an instance of either subtype, prints an error message    *
     * and terminates the program.                                                    *
     * @param target the RecordStudio object to remove                                *
     * @return true if an item was removed; false otherwise                           *
     **********************************************************************************/
    public boolean remove(RecordStudio target) {
        if (target == null) return false;

        try {
            if (target instanceof MusicStudio) {
                return musicStudioList.remove(target);
            } else if (target instanceof SocialMediaContentStudio) {
                return socialMediaStudioList.remove(target);
            } else {
                throw new ClassNotFoundException("Element not instance of either subclass.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Element not instance of either subclass.");
        }

        return false;
    }

    /**********************************************************************************
     * Removes the item at the given 1-based index from the specified list.            *
     * Returns true if an element is removed; false if index < 1, index > size,       *
     * or the list reference is null.                                                 *
     * @param iol   the RecordStudioOrderedList to remove from                        *
     * @param index the 1-based index of the element to remove                        *
     * @return true if an element was removed; false otherwise                        *
     **********************************************************************************/
    public boolean remove(RecordStudioOrderedList iol, int index) {
        if (iol == null) return false;
        return iol.remove(index);
    }

    /**********************************************************************************
     * Returns the 1-based index of the first occurrence of target in the appropriate *
     * ordered list (MusicStudio list or SocialMediaContentStudio list).              *
     * Uses equals() for comparison. Returns -1 if not found or target is invalid.    *
     * @param target the RecordStudio object to search for                            *
     * @return the 1-based index if found; -1 otherwise                               *
     **********************************************************************************/
    public int indexOf(RecordStudio target) {
        if (target == null) return -1;

        if (target instanceof MusicStudio) {
            return musicStudioList.indexOf(target);
        } else if (target instanceof SocialMediaContentStudio) {
            return socialMediaStudioList.indexOf(target);
        } else {
            // Not one of the two subtypes → not in either list
            return -1;
        }
    }

    /**********************************************************************************
     * Returns the ordered list for the given type character.                         *
     * 'a' → MusicStudio list, 'b' → SocialMediaContentStudio list.                   *
     * Character matching is case-insensitive. Returns null if the type is invalid.   *
     * @param type the list selector ('a' or 'b')                                      *
     * @return the corresponding RecordStudioOrderedList, or null if invalid          *
     **********************************************************************************/
    public RecordStudioOrderedList getList(char type) {
        switch (Character.toLowerCase(type)) {
            case 'a':
                return musicStudioList;
            case 'b':
                return socialMediaStudioList;
            default:
                return null;
        }
    }

    /**********************************************************************************
     * Returns the item at the given 1-based index from the specified list.           *
     * Returns null if the list reference is null, index < 1, or index > size.        *
     * @param iol   the RecordStudioOrderedList to read from                          *
     * @param index the 1-based index of the desired element                          *
     * @return the RecordStudio at that position, or null if out of range             *
     **********************************************************************************/
    public RecordStudio get(RecordStudioOrderedList iol, int index) {
        if (iol == null) return null;
        return iol.get(index);
    }

}
