#include "A.hpp"
#include "B.hpp"

int main()
{
  B b;
  A *a = &b;
  b.setValue(10888);
  a->setValue(888);

  b.print();
  return 0;
}