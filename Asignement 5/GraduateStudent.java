public class GraduateStudent extends Student {
    private String researchTopic;
    private String nameOfSupervisor;

    public GraduateStudent (String studentName, String studentAddres, String researchTopic, String nameOfSupervisor)
    {
        super(studentName, studentAddres);
        this.researchTopic = researchTopic;
        this.nameOfSupervisor = nameOfSupervisor;
    }
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
        return super.toString() + " Research topic " + researchTopic + " Name of supervisor " + nameOfSupervisor + "\n";
    }

}
