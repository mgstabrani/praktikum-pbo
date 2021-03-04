#include <iostream>
#include <cstring>
#include "User.h"
using namespace std;

int User::n_user = 0;

User::User(char* name){
    this->name = new char[strlen(name)];
    strcpy(this->name, name);
    this->num_of_favourite_music = 0;
    this->music_list = new char*[255];
    n_user++;
}

User:: User(const User& user){
    this->name = new char[strlen(user.name)];
    strcpy(this->name,user.name);
    this->num_of_favourite_music = user.num_of_favourite_music;
    for(int i = 0; i < this->num_of_favourite_music; i++){
        this->music_list[i] = new char[strlen(user.music_list[i])];
        strcpy(this->music_list[i],user.music_list[i]);
    }
    n_user++;
}

User:: ~User(){
    cout << "User " << this->name << " deleted" << endl;
    delete[] this->name;
    delete[] this->music_list;
    n_user--;
}

void User::addFavouriteMusic(char* judul){
    this->num_of_favourite_music++;
    this->music_list[this->num_of_favourite_music-1] = new char[strlen(judul)];
    strcpy(this->music_list[this->num_of_favourite_music-1],judul);
}

void User::deleteFavouriteMusic(char* judul){
    char** tmp;
    for(int i = 0; i < this->num_of_favourite_music; i++){
        if(strcmp(this->music_list[i],judul)){
            strcpy(tmp[i],music_list[i]);
        }
    }
    this->num_of_favourite_music--;
    delete[] this->music_list;
    this->music_list = new char*;
    for(int i = 0; i < this->getNumOfFavouriteMusic();i++){
        this->music_list[i] = tmp[i];
    }
}

void User::setName(char* name){
    strcpy(this->name,name);
}


char* User::getName() const{
    return this->name;
}

int User::getNumOfFavouriteMusic() const{
    return this->num_of_favourite_music;
}

void User::viewMusicList() const{
    if(this->getNumOfFavouriteMusic() > 0){
        for(int i = 0; i < this->num_of_favourite_music; i++){
            cout << (i+1) << ". " << this->music_list[i] << endl;
        }
    }else{
        cout << "No music in your favourite list" << endl;
    }
}

int User::getNumOfUser(){
    return User::n_user;
}