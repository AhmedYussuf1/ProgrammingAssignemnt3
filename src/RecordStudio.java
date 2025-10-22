import javax.swing.plaf.synth.SynthOptionPaneUI;
public abstract class RecordStudio implements Comparable<RecordStudio> {
    private String StudioName;
    private Integer numberOfYearsInOperation;

    /**********************************************************************************
     * creates a RecordStudio with the provided arguments                             *
     * @param s name of the studio                                                     *
     * @param n value of the nunber of yewars the studio is /was operating             *
     ***********************************************************************************/
    public RecordStudio(String s, Integer n) {
        StudioName = s;
        this.numberOfYearsInOperation = n;
    }

    /**********************************************************************************
     * to getter for studio name
     * @return name of the studio
     *********************************************************************************/
    public String getStudioName() {
        return StudioName;
    }

    public Integer getNumberOfYearsInOperation() {
        return numberOfYearsInOperation;
    }

    public void setStudioName(String studioName) {
        StudioName = studioName;
    }

    /**********************************************************************************
     * setter for number of yearsInOperation.
     * @param numberOfYearsInOperation
     *********************************************************************************/
    public void setNumberOfYearsInOperation(Integer numberOfYearsInOperation) {
        this.numberOfYearsInOperation = numberOfYearsInOperation;
    }

    @Override
    public String toString() {
        return " " + getStudioName() + "\t" + getNumberOfYearsInOperation()  ;
    }

    /***************************************************************************
     * this method compares this instace with the provided object              *
     * @param obj an object with same type as this instance                    *
     * @return true if the two objects are equeal.                             *
     **************************************************************************/
    @Override
    public boolean equals(Object obj) {


        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecordStudio)) {
            return false;
        }
        RecordStudio other = (RecordStudio) obj;
        return this.compareTo(other) == 0;
    }


    /**************************************************************************
     * Compares this RecordStudio with another by name (ignore case),          *
     * then by years in operation if names are equal.                          *
     * @param o the RecordStudio object to be compared with this instance.     *
     * @return a negative integer, zero, or a positive integer as this object  *
     * is less than, equal to, or greater than the specified object.           *
     **************************************************************************/

    @Override
    public int compareTo(RecordStudio o) {

        int nameComparison = this.StudioName.compareToIgnoreCase(o.StudioName);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return this.getNumberOfYearsInOperation().compareTo(o.getNumberOfYearsInOperation());
    }

}
