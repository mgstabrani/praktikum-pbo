#include "User.h"
#include <iostream>
#include <cstring>
using namespace std;

int User::n_user = 0;

User::User(char *n){
    this->name = new char[strlen(n)];
    strcpy(this->name, n);
    this->num_of_favourite_music = 0;
    this->music_list = new char *[5000];
    n_user++;
}

User::User(const User &user){
    this->name = new char[strlen(user.getName())];
    strcpy(this->name, user.getName());
    this->num_of_favourite_music = user.num_of_favourite_music;
    this->music_list = new char *[255];
    for (int i = 0; i < user.num_of_favourite_music; i++)
    {
        this->music_list[i] = new char[strlen(user.music_list[i])];
        strcpy(this->music_list[i], user.music_list[i]);
    }
    n_user++;
}

User::~User(){
    cout << "User " << this->name << " deleted" << endl;
}

void User::addFavouriteMusic(char *musik){
    this->num_of_favourite_music++;
    this->music_list[this->num_of_favourite_music - 1] = new char[strlen(musik)];
    strcpy(this->music_list[this->num_of_favourite_music - 1], musik);
}

void User::deleteFavouriteMusic(char *musik){
    if (this->num_of_favourite_music > 0){
        int deleted = -1;
        for (int i = 0; i < this->num_of_favourite_music; i++){
            if (strcmp(this->music_list[i], musik) == 0){
                deleted = i;
                break;
            }
        }
        if (deleted != -1 and deleted < this->num_of_favourite_music){
            this->num_of_favourite_music--;
            for (int j = deleted; j < this->num_of_favourite_music; j++){
                strcpy(this->music_list[j], this->music_list[j + 1]);
            }
        }
    }
}

void User::setName(char *name){
    strcpy(this->name, name);
}

char *User::getName() const{
    return this->name;
}

int User::getNumOfFavouriteMusic() const{
    return this->num_of_favourite_music;
}

void User::viewMusicList() const{
    if (this->num_of_favourite_music > 0){
        for (int i = 0; i < this->num_of_favourite_music; i++){
            cout << (i + 1) << ". " << this->music_list[i] << endl;
        }
    }
    else{
        cout << "No music in your favourite list" << endl;
    }
}

int User::getNumOfUser(){
    return User::n_user;
}