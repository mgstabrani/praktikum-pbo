#include "WarungSaltedEgg.hpp"
#include <iostream>
using namespace std;

WarungSaltedEgg::WarungSaltedEgg(int uang, int nasi, int telur, int telurAsin, int ayam) : WarungNasi(uang, nasi, telur){
    this->ayam = ayam;
    this->telurAsin = telurAsin;
}

bool WarungSaltedEgg::masak(int pesanan){
    if (this->getNasi() < pesanan && this->getTelur() < pesanan && this->ayam < pesanan && this->telurAsin < 3*pesanan) {
        return false;
    } else {
        int pendapatan = pesanan * 30000;
        setUang(getUang() + pendapatan);
        return true;
    }
}