#pragma once
#include <string>
#include "Item.h"

class Book : public Item {

 private:
  std::string author;
  std::string publisher;
  std::string blurb;
  int length;

 public:
  Book();
  Book(std::string the_name, std::string the_genre, std::string the_author, std::string the_publisher, std::string the_blurb, int the_length);
  std::string getauthor();
  std::string getpublisher();
  std::string getblurb();
  int getlength();

  std::string setauthor(std::string set_author);
  std::string setpublisher(std::string set_publisher);
  std::string setblurb(std::string set_blurb);
  int setlength(int set_length);

  void print();
  ~Book();
};
