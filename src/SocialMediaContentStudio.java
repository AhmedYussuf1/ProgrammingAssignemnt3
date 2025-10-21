public class SocialMediaContentStudio extends RecordStudio {

    private Integer numberOfVideosProduced = 0;

    /**
     * Creates a SocialMediaContentStudio with the provided arguments
     * @param s name of the studio
     * @param n1 number of years the studio has operated
     * @param n2 number of videos produced
     */
    public SocialMediaContentStudio(String s, Integer n1, Integer n2) {
        super(s, n1);
        this.numberOfVideosProduced = n2;
    }

    public Integer getNumberOfVideosProduced() {
        return numberOfVideosProduced;
    }

    public void setNumberOfVideosProduced(Integer numberOfVideosProduced) {
        this.numberOfVideosProduced = numberOfVideosProduced;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\tnumberOfVideosProduced=" + numberOfVideosProduced +
                '}';
    }

    /**
     * Checks equality of this object with another SocialMediaContentStudio
     * First calls parent equals(), then checks subclass variable
     * @param a another SocialMediaContentStudio object
     * @return true if both parent and subclass variables are equal
     */
    public boolean equals(SocialMediaContentStudio a) {
        if (!super.equals(a)) {
            return false;
        }
        return this.getNumberOfVideosProduced() ==  a.getNumberOfVideosProduced();
    }

}
