public class RecordStudioTypesLists {
    private  RecordStudioOrderedList musicStudioList;
    private  RecordStudioOrderedList socialMediaStudioList;

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

    }

}
