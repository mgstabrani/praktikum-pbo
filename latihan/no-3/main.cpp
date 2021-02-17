#include "Box.hpp"
#include <iostream>
using namespace std;

int main(){
    Box *dua = new Box(2);
    Box *nol = new Box();
    Box *satu = new Box(1);
    *nol = *dua;
    Box *copy_satu = new Box(*satu);
    dua->peek();
    satu->peek();
    delete dua;
    delete satu;
    delete copy_satu;
    delete nol;
    return 0;
}