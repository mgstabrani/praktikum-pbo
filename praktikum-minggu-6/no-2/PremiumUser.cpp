#include "PremiumUser.h"
#include <iostream>
#include <cstring>
using namespace std;

PremiumUser::PremiumUser(char *n) : User(n){
    this->num_of_music_downloaded = 0;
    this->active = true;
}

PremiumUser::PremiumUser(const PremiumUser &user) : User(user.name){
    this->num_of_favourite_music = user.num_of_favourite_music;
    this->music_list = new char *[5000];
    for (int i = 0; i < user.num_of_favourite_music; i++){
        this->music_list[i] = new char[strlen(user.music_list[i])];
        strcpy(this->music_list[i], user.music_list[i]);
    }
    this->num_of_music_downloaded = user.num_of_music_downloaded;
    this->active = user.active;
}

PremiumUser::~PremiumUser(){
}

void PremiumUser::downloadMusic(char *musik){
    if (this->active){
        this->num_of_music_downloaded++;
        cout << "Music Downloaded: " << musik << endl;
    }
    else{
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