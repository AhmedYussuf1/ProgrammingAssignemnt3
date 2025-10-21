public class MusicStudio extends RecordStudio {
    private Boolean hasLiveRecording;

    /*****************************************************************************
     * Creates a MusicStudio with a name, years in operation, and live recording. *
     * Calls the parent constructor to set common attributes.                     *
     * @param s  the name of the studio.                                          *
     * @param n1 number of years the studio has been operating (parent field).    *
     * @param n2 true if the studio supports live recording, false otherwise.     *
     *******************************************************************************/
    public MusicStudio(String s, Integer n1, Boolean n2) {
        super(s, n1);
        this.hasLiveRecording = n2;
    }

    /*****************************************************************************
     * Gets the live recording availability of this music studio.                 *
     * @return true if live recording is supported, false otherwise.              *
     *******************************************************************************/
    public Boolean getHasLiveRecording() {
        return hasLiveRecording;
    }

    /*****************************************************************************
     * Sets whether the music studio supports live recording.                     *
     * @param hasLiveRecording true if live recording is supported, false otherwise.*
     *******************************************************************************/
    public void setHasLiveRecording(Boolean hasLiveRecording) {
        this.hasLiveRecording = hasLiveRecording;
    }

    /*****************************************************************************
     * Returns a string representation of this MusicStudio.                       *
     * Combines parent string with subclass field separated by tabs.              *
     * @return a tab-separated string of all instance variables.                  *
     *******************************************************************************/
    @Override
    public String toString() {
        return super.toString() + "\t" + hasLiveRecording;
    }

    /*****************************************************************************
     * Compares this music studio with another.                                   *
     * First calls the equal method in the super class.                           *
     * @param b musicstudio given.                                                *
     * @return true or false depending on the result of the comparison true/false *
     * if pattern are the same. or subclass is the same                           *
     *******************************************************************************/
    public boolean equals(MusicStudio b) {
        if (!super.equals(b)) {
            return false;
        }
        return this.hasLiveRecording.equals(b.hasLiveRecording);
    }
}