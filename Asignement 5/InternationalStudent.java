public class InternationalStudent  extends Student {
    private String country;
    private final double creditCost = 637.91;

    public InternationalStudent (String studentName, String studentAddres, String country)
    {
        super(studentName, studentAddres);
        this.country = country;
    }
    /*
    **This will return the tuition for International Students
     */
    @Override
    public double getTuitionFeed(int credits){ return credits * creditCost;};
    /*
    **Complement the equals method
     */
    @Override
    public boolean equals(Object otherObject) {

            if (!super.equals(otherObject))
            {
                return false;
            };
            return true;
    }
    /*
    **Complement the toString method of the parent
     */
    @Override
    public String toString(){
        return super.toString() + " Country " + country + "\n";
    }

}
