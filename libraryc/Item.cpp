#include "Item.h"
#include <iostream>

// Syntax: ClassName::MethodName

using namespace std;

Item::Item() {
  name = "";
  genre= "";
}

Item::Item(std::string the_name, std::string the_genre) {
  name = the_name;
  genre = the_genre;
}

string Item::getname() {
  return name;
}

string Item::getgenre(){
  return genre;
}


Item::~Item() {

}
