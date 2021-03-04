#include <iostream>
#include <cstring>
#include "ArtistUser.h"
using namespace std;

int ArtistUser::num_of_artist = 0;

ArtistUser::ArtistUser(char* name) : User(name){
    this->num_of_artist++;
}
        
ArtistUser::ArtistUser(const ArtistUser& name) : User(name){
    this->num_of_artist++;
}

        // dtor
        // selain implementasi, print juga "Artist user <nama user> deleted"
        // Contoh:
        // Artist user A deleted
ArtistUser::~ArtistUser(){
    this->num_of_artist--;
    cout << "Artist user " << this->name << " deleted" << endl;
}
void ArtistUser::uploadMusic(char* judul){
    this->num_of_music_uploaded++;
    strcpy(uploaded_music_list[this->num_of_music_uploaded-1],judul);
}

void ArtistUser::deleteUploadedMusic(char* judul){
    char** tmp;
    for(int i = 0; i < this->num_of_music_uploaded; i++){
        if(strcmp(this->uploaded_music_list[i],judul)){
            strcpy(tmp[i],uploaded_music_list[i]);
        }
    }
    this->num_of_music_uploaded--;
    delete[] this->uploaded_music_list;
    this->uploaded_music_list = new char*;
    for(int i = 0; i < this->getNumOfMusicUploaded();i++){
        this->uploaded_music_list[i] = tmp[i];
    }
}

void ArtistUser::viewUploadedMusicList() const{
    if(this->getNumOfMusicUploaded() > 0){
        for(int i = 0; i < getNumOfMusicUploaded(); i++){
            cout << (i+1) << ". " << this->uploaded_music_list[i] << endl;
        }
    }else{
        cout << "No music uploaded" << endl;
    }
}

int ArtistUser::getNumOfMusicUploaded() const{
    return this->num_of_music_uploaded;
}

int ArtistUser::getNumOfArtist(){
    return num_of_artist;
}