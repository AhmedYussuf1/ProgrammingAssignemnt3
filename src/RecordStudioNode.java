public class RecordStudioNode {
private RecordStudio data ;
private  RecordStudioNode link;

    public RecordStudioNode(RecordStudio i, RecordStudioNode n) {
      this.data = i;
      this.link = n;
    }

    public RecordStudio getData() {
        return data;
    }

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
