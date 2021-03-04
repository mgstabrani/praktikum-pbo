        
#include <iostream>
#include <cstring>
#include "PremiumUser.h"
using namespace std;        

PremiumUser::PremiumUser(char* name) : User(name){
    this->activatePremium();
}
        
PremiumUser::PremiumUser(const PremiumUser& user) : User(user){
    cout << "Premium User Copied" << endl;
    this->num_of_music_downloaded = user.num_of_music_downloaded;
    this->active = user.active;
}

PremiumUser::~PremiumUser(){
    cout << "Premimum User " << this->name << " deleted" << endl;
}
void PremiumUser::downloadMusic(char* judul){
    if(this->active){
        cout << "Music Downloaded: " << judul << endl;
        this->num_of_music_downloaded++;
    }else{
        cout << "Activate premium account to download music" << endl;
    }

}

void PremiumUser::inactivatePremium(){
    this->active = false;
}
void PremiumUser::activatePremium(){
    this->active = true;
}
        
int PremiumUser::getNumOfMusicDownloaded() const{
    return this->num_of_music_downloaded;
}

bool PremiumUser::getPremiumStatus() const{
    return this->active;
}