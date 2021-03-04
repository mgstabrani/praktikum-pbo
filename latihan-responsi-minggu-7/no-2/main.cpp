#include "Bike.h"
#include "Car.h"
#include "Vehicle.h"

int main()
{
    Car *car1 = new Car(4);
    Car *car2 = new Car(10);
    Bike *bike1 = new Bike();
    Vehicle *vehicle1 = new Vehicle(*bike1);
    delete bike1;
    car2->Vehicle::drive();
    vehicle1->Vehicle::clean();
    car1->drive();
    vehicle1->Vehicle::park();
    delete car2;
    delete vehicle1;
    delete car1;
}