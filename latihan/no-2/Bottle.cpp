#include <iostream>
#include "Bottle.hpp"
using namespace std; 

int Bottle::numOfBottle = 0;

Bottle::Bottle() : id(numOfBottle+1){
    this->height = 10.0;
    this->radius = 10.0;
    this->waterHeight = 0;
    numOfBottle += 1;
}

Bottle::Bottle(float height, float radius) : id(numOfBottle+1) {
    this->height = height;
    this->radius = radius;
    this->waterHeight = 0;
    numOfBottle += 1;
}
Bottle::Bottle(const Bottle& bottle) : id(bottle.id){
    this->height = bottle.height;
    this->waterHeight = bottle.waterHeight;
    this->radius = bottle.radius;
}
Bottle::~Bottle(){
}
int Bottle::getId() const{
    return this->id;
}
float Bottle::getWaterVolume() const{
    return this->waterHeight * PI * this->radius * this->radius;
}

float Bottle::getBottleVolume() const{
    return this->height * PI * this->radius * this->radius;
}

void Bottle::setHeight(float height){
    if(height < this->waterHeight){
        this->height = height;
        this->waterHeight = height;
    }else{
        this->height = height;
    }
}

void Bottle::addWater(float waterVolume){
    if(this->getWaterVolume() + waterVolume > this->getBottleVolume()){
        this->waterHeight = this->height;
    }else{
        this->waterHeight = this->waterHeight + this->getWaterHeightIfVolume(waterVolume);
    }
}

void Bottle::substractWater(float waterVolume){
    if(this->getWaterVolume() - waterVolume < 0){
        this->waterHeight = 0;
    }else{
        this->waterHeight = this->waterHeight - this->getWaterHeightIfVolume(waterVolume);
    }
}

float Bottle::getWaterHeightIfVolume(float waterVolume) const{
    return waterVolume / (this->radius * PI * this->radius);
}

void Bottle::pourWaterTo(Bottle& other){
    if(this->getWaterVolume() + other.getWaterVolume() > other.getBottleVolume()){
        other.addWater(other.getBottleVolume()-other.getWaterVolume());
        this->substractWater(other.getBottleVolume()-other.getWaterVolume());
    }else{
        other.addWater(this->getWaterVolume());
        this->substractWater(this->getWaterVolume());
    }
}