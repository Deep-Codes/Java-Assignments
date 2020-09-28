// Deepankar Bhade
// 28.09.2020

public class University {
    String nameOfStudent;
    int ageOfStudent;
    String programme;
    public University(String nameOfStudent , int ageOfStudent , String programme){
        this.ageOfStudent = ageOfStudent;
        this.nameOfStudent = nameOfStudent;
        this.programme = programme;
    }
    void display_student_info(){
        System.out.println("University Class: ");
        System.out.println("Name: "+this.nameOfStudent+"\n"+ "Age: "+this.ageOfStudent+"\n"+"Programme: "+this.programme+"\n");
    }

    // Graduate Students Class
    static  class GraduateStudents extends  University{
        int percentage;
        String stream;
        public GraduateStudents(String nameOfStudent , int ageOfStudent , String programme , int percentage , String stream ){
            super(nameOfStudent, ageOfStudent, programme);
            this.percentage = percentage;
            this.stream= stream;
        }
        @Override
        void display_student_info(){
            System.out.println("Graduate Students: ");
            System.out.println("Name: "+this.nameOfStudent+"\n"+ "Age: "+this.ageOfStudent+"\n"+"Programme: "+this.programme+"\n"+"Percentage: "+this.percentage+"%"+"\n"+"Stream: "+this.stream+"\n");
        }
    }

    // Research Students Class
    static  class ResearchStudents extends  University{
        int workExp;
        String specialization;
        public ResearchStudents(String nameOfStudent , int ageOfStudent , String programme , int workExp , String specialization ){
            super(nameOfStudent, ageOfStudent, programme);
            this.workExp = workExp;
            this.specialization= specialization;
        }
        @Override
        void display_student_info(){
            System.out.println("Research Students: ");
            System.out.println("Name: "+this.nameOfStudent+"\n"+ "Age: "+this.ageOfStudent+"\n"+"Programme: "+this.programme+"\n"+"Work Experience: "+this.workExp+"years"+"\n"+"Specialization: "+this.specialization+"\n");
        }
    }

    public static void main(String args[]){
        University uni1 = new University("Deepankar",19,"Btech");
        uni1.display_student_info();

        GraduateStudents grad1 = new GraduateStudents("Deepankar",19,"Btech",78,"IT engineering");
        grad1.display_student_info();

        ResearchStudents res1 = new ResearchStudents("Deepankar",19,"PHD",3,"Computer Science");
        res1.display_student_info();

    }

}
