package swmfjavaca5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Person implements Serializable{
    private double score;
    private String quearyName;
    private String name;
    private int id;
    private ArrayList<String> imgurl; 
    private String personLink;
    private int myRating;
    private String comments;

    public Person(){
        this.score = 0;
        this.quearyName = "";
        this.name = "";
        this.id = 0;
        this.imgurl = new ArrayList<String>();
        this.personLink = "";
        this.myRating = 0;
        this.comments = "";
    }
    
    public Person(double score, String quearyName, String name, int id, ArrayList<String> imgurl, String personLink, int myRating, String comments) {
        this.score = score;
        this.quearyName = quearyName;
        this.name = name;
        this.id = id;
        this.imgurl = imgurl;
        this.personLink = personLink;
        this.myRating = myRating;
        this.comments = comments;
    }

    
    private void writeObject(ObjectOutputStream o)
            throws IOException{
        o.writeObject(score);
        o.writeObject(quearyName);
        o.writeObject(name);
        o.writeObject(id);
        o.writeObject(imgurl); 
        o.writeObject(personLink);
        o.writeObject(myRating);
        o.writeObject(comments);
    }
    
    private void readObject(ObjectInputStream o) throws IOException,ClassNotFoundException{
        score = (double) o.readObject();
        quearyName = (String) o.readObject();
        name = (String) o.readObject();
        id = (int) o.readObject();
        imgurl = (ArrayList<String>) o.readObject();
        personLink =(String) o.readObject();
        myRating =(int) o.readObject();
        comments =(String) o.readObject();
    }
    @Override
    public String toString() {
        return "Person{" + "score=" + score + ", quearyName=" + quearyName + ", name=" + name + ", id=" + id + ", imgurl=" + imgurl + ", personLink=" + personLink + ", myRating=" + myRating + ", comments=" + comments + '}';
    }
    public double getScore(){
        return score;
    }
    public void setScore(float score){
        this.score = score;
    }
    public String getQuearyName(){
        return quearyName;
    }
    public void setQuearyName(String quearyName){
        this.quearyName = quearyName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public ArrayList<String> getImgurl(){
        return imgurl;
    }
    
    public String getImgurlAlt(){
        return imgurl.get(0);
    }
    public String getPersonLink(){
        return personLink;
    }
    public void setPersonLink(String personLink){
        this.personLink = personLink;
    }
    public int getMyRating(){
        return myRating;
    }
    public void setMyRating(int myRating){
        this.myRating = myRating;
    }
    public String getComments(){
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 83 * hash + Double.hashCode(score);
        hash = 83 * hash + Objects.hashCode(this.quearyName);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.imgurl);
        hash = 83 * hash + Objects.hashCode(this.personLink);
        hash = 83 * hash + this.myRating;
        hash = 83 * hash + Objects.hashCode(this.comments);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Person other = (Person) obj;
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score))
        {
            return false;
        }
        if (this.id != other.id)
        {
            return false;
        }
        if (this.myRating != other.myRating)
        {
            return false;
        }
        if (!Objects.equals(this.quearyName, other.quearyName))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.personLink, other.personLink))
        {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments))
        {
            return false;
        }
        if (!Objects.equals(this.imgurl, other.imgurl))
        {
            return false;
        }
        return true;
    }
    public String toHTML(){
        return "<td>" + this.score + "</td>"
                + "<td>" + this.name + "</td>"
                + "<td>" + this.id + "</td>"
                + "<td>" + this.imgurl + "</td>"
                + "<td>" + this.personLink + "</td>"
                + "<td>" + this.comments + "</td>";
    }
    int compareTo(Person value) {
        // Ascending order
        return this.id - value.id;
    }
    int compareToRating(Person value){
        return this.myRating - value.myRating;
    }
    
    
}