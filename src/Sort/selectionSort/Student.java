package Sort.selectionSort;

public class Student implements Comparable<Student>{
    private String name;
    private int score;

    public Student(){};

    public Student(String name,int score) {
        this.name = name;
        this.score =score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if(this == student) {
            return true;
        }
        if(student == null) {
            return false;
        }
        if(this.getClass() != student.getClass()) {
            return false;
        }

        Student another = (Student)student;
        return this.name.equals(another.name);
    }

    /** 按score顺序,
     * @param another
     * @return
     */
    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
        //逆序
        //return another.score = this.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
