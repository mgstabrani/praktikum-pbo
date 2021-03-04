#include "ArtistUser.h"
#include <iostream>
#include <cstring>
using namespace std;

int ArtistUser::num_of_artist = 0;

ArtistUser::ArtistUser(char *n) : User(n){
    this->num_of_music_uploaded = 0;
    this->uploaded_music_list = new char *[255];
    num_of_artist++;
}

ArtistUser::ArtistUser(const ArtistUser &user) : User(user.getName()){
    this->num_of_favourite_music = user.num_of_favourite_music;
    this->music_list = new char *[255];

    for (int i = 0; i < user.num_of_favourite_music; i++){
        this->music_list[i] = new char[strlen(user.music_list[i])];
        strcpy(this->music_list[i], user.music_list[i]);
    }

    this->num_of_music_uploaded = user.num_of_music_uploaded;
    this->uploaded_music_list = new char *[255];

    for (int i = 0; i < user.num_of_music_uploaded; i++){
        this->uploaded_music_list[i] = new char[strlen(user.uploaded_music_list[i])];
        strcpy(this->uploaded_music_list[i], user.uploaded_music_list[i]);
    }

    num_of_artist++;
}

ArtistUser::~ArtistUser(){
    cout << "Artist user " << this->name << " deleted" << endl;
}

void ArtistUser::uploadMusic(char *musik){
    this->num_of_music_uploaded++;
    this->uploaded_music_list[this->num_of_music_uploaded - 1] = new char[strlen(musik)];
    strcpy(this->uploaded_music_list[this->num_of_music_uploaded - 1], musik);
}

void ArtistUser::deleteUploadedMusic(char *musik){
    if (this->num_of_music_uploaded > 0){
        int deleted = -1;
        for (int i = 0; i < this->num_of_music_uploaded; i++){
            if (strcmp(this->uploaded_music_list[i], musik) == 0){
                deleted = i;
                break;
            }
        }
        if (deleted != -1 and deleted < this->num_of_music_uploaded){
            this->num_of_music_uploaded--;
            for (int j = deleted; j < this->num_of_music_uploaded; j++){
                strcpy(this->uploaded_music_list[j], this->uploaded_music_list[j + 1]);
            }
        }
    }
}

void ArtistUser::viewUploadedMusicList() const{
    if (this->num_of_music_uploaded > 0){
        for (int i = 0; i < this->num_of_music_uploaded; i++){
            cout << (i + 1) << ". " << this->uploaded_music_list[i] << endl;
        }
    }
    else{
        cout << "No music uploaded" << endl;
    }
}

int ArtistUser::getNumOfMusicUploaded() const{
    return this->num_of_music_uploaded;
}

int ArtistUser::getNumOfArtist(){
    return ArtistUser::num_of_artist;
}