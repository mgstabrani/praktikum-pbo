#include "WarungNasgor.hpp"
#include <iostream>
using namespace std;

WarungNasgor::WarungNasgor(int uang, int nasi, int telur, int kecap) : WarungNasi(uang, nasi, telur){
    this->kecap = kecap;
}

bool WarungNasgor::masak(int pesanan){
    if (this->getNasi() < pesanan && this->getTelur() < pesanan && this->kecap < pesanan) {
        return false;
    } else {
        int pendapatan = pesanan * 15000;
        setUang(getUang() + pendapatan);
        return true;
    }
}