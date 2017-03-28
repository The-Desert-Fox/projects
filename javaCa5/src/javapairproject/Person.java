/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapairproject;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author S
 */
public class Person {
    private float score;
    private String quearyName;
    private String name;
    private int id;
    private ArrayList<Image> imgurl; // Need to use image urls
    private String personLink;
    private int myRating;
    private String comments;

    public Person(float score, String quearyName, String name, int id, ArrayList<Image> imgurl, String personLink, int myRating, String comments) {
        this.score = score;
        this.quearyName = quearyName;
        this.name = name;
        this.id = id;
        this.imgurl = imgurl;
        this.personLink = personLink;
        this.myRating = myRating;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Person{" + "score=" + score + ", quearyName=" + quearyName + ", name=" + name + ", id=" + id + ", imgurl=" + imgurl + ", personLink=" + personLink + ", myRating=" + myRating + ", comments=" + comments + '}';
    }

    
    
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getQuearyName() {
        return quearyName;
    }

    public void setQuearyName(String quearyName) {
        this.quearyName = quearyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Image> getImgurl() {
        return imgurl;
    }

    

    public String getPersonLink() {
        return personLink;
    }

    public void setPersonLink(String personLink) {
        this.personLink = personLink;
    }

    public int getMyRating() {
        return myRating;
    }

    public void setMyRating(int myRating) {
        this.myRating = myRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Float.floatToIntBits(this.score);
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
        if (Float.floatToIntBits(this.score) != Float.floatToIntBits(other.score))
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
        if (!Objects.equals(this.imgurl, other.imgurl))
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
        return true;
    }
}
