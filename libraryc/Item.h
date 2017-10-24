#pragma once
#include <string>
#include <iostream>
#include <ostream>
using std::cout;
using std::endl;
using std::ostream;
using std::istream;

class Item {

protected:
  std::string name;
  std::string genre;


 public:
  Item();
  Item(std::string the_name, std::string the_genre);
  std::string getname();
  std::string getgenre();
  
  ~Item();

};
