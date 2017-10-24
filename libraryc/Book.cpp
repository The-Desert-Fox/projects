#include "Book.h"
#include <iostream>

using namespace std;

Book::Book() {
  cout << "Book constructor called" << endl;
}

Book::Book(std::string the_name, std::string the_genre, std::string the_author, std::string the_publisher, std::string the_blurb, int the_length) {
  name = the_name;
  genre = the_genre;
  author = the_author;
  publisher = the_publisher;
  blurb = the_blurb;
  length = the_length;
}

string Book::getauthor(){
  return author;
}

string Book::getpublisher(){
  return publisher;
}

string Book::getblurb(){
  return blurb;
}

int Book::getlength(){
  return length;
}

string Book::setauthor(std::string set_author){
  author = set_author;
}

string Book::setpublisher(std::string set_publisher){
  publisher = set_publisher;
}

string Book::setblurb(std::string set_blurb){
  blurb = set_blurb;
}

int Book::setlength(int set_length){
  length = set_length;
}

void Book::print(){};

Book::~Book(){

}
