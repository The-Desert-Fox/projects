#include <iostream>
#include <vector>
#include "Item.h"
#include "Book.h"


using namespace std;

// To Do:
    // Move Menus to seperate file
    // Print vector<Item> object to file
    // Read vector<item> object from file
    // Get adding to the vector working
    // Friend function, overwriteing

vector<Item> library;

void out(string s){
  cout << s <<endl;
}

int choices(){
  int c;
  out("*** Library System ***");
  out("1) Add an item");
  out("2) Remove an item");
  out("3) Edit an item");
  out("4) Serch for items");
  out("5) Sort items");
  out("0) Exit program");
  cin >> c;
  return c;
}

int adding(){
  int c;
  out("*** Adding an item ***");
  out("1) Add from file");
  out("2) Add Book");
  out("3) Add movie");
  cin >> c;
  return c;
}

Book getBookDetails(){
  string name;
  string genre;
  string author;
  string publisher;
  string blurb;
  int length;
  out("What is the name of the book?");
  cin >> name;
  out("What is the genre?");
  cin >> genre;
  out("Who is the author?");
  cin >> author;
  out("Who is the publisher?");
  cin >> publisher;
  out("Enter the blurb.");
  cin >> blurb;
  out("How long is the book in pages?");
  cin >> length;
  return Book(name,genre,author,publisher,blurb,length);

}

int main(int argc, char *argv[]) {
  int c;
  c = choices();
  int d;
  while(c != 0){
      switch(c){
        case 1:
          d = adding();
          if(d == 0){
            //out("No nothing");
          }
          else if(d == 1){
            out("namefile");
          }
          else if(d == 2){
            out("getBookDetails");
            //library.push_back(getBookDetails())
          }
          else if(d == 3){
            out("getMovieDetails");
          }
          else{
            out("not a valid number");
            cout << d;
          }
          break;
        case 2:
          cout << "removing" << endl;
          break;
        case 3:
          cout << "editing" << endl;
          break;
        case 4:
          cout << "Searching" << endl;
          break;
        case 5:
          cout << "Sorting" << endl;
          break;
      }
      cout << endl;
      c = choices();
  }
}
