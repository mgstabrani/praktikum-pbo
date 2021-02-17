#include "A.hpp"

int main(){
    A *a = new A(1); //a = 1
    A *b = new A(2); //b = 2
    A *c = new A(3); //c = 3
    A *d = new A(4); //d = 4
    *c = *a;  //c = 1
    A *e = new A(5);
    *d = *e; //d = 5
    delete e;
    A *f = new A(6); //f = 6
    A *g = new A(*d); //g = 5
    A *h = new A(*b); //h = 2
    *h = *f; // h = 6
    *c = *g; //c = 5
    b->show();
    delete b;
    delete c;
    delete h;
    delete g;
    delete a;
    delete f;
    delete d;

    return 0;
}