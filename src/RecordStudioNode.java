public class RecordStudioNode {
private RecordStudio data ;
private  RecordStudioNode link;

/*****************************************************************************
 * Constructor for the RecordStudioNode
 * @param i data for RecordStudio field
 * @param n reference to teh next RecordStudioNode
 ******************************************************************************/
    public RecordStudioNode(RecordStudio i, RecordStudioNode n) {
      this.data = i;
      this.link = n;
    }

    /*****************************************************************************
     * To get Data field
     * @return RecordStudioNode's data
    *****************************************************************************/
    public RecordStudio getData() {
        return data;
    }

    /*****************************************************************************
     * Modify the RecordStudio fild
     * @param data new RecordStudio to store in the RecordStudio field
    *****************************************************************************/
    public void setData(RecordStudio data) {
        this.data = data;
    }

    public RecordStudioNode getLink() {
        return link;
    }

    public void setLink(RecordStudioNode link) {
        this.link = link;
    }
}
