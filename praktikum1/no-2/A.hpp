#ifndef A_HPP
#define A_HPP

#include <iostream>
using namespace std;

class A {
public:
    A(char d);
    A(const A&);
    virtual ~A();

    A& operator=(const A&);

    void show();
private:
    char data;
};

#endif