#include <iostream>

using namespace std;

class Hewan{
	public:
		Hewan(string nm){
			name = nm;
		}

		~Hewan(){
			cout << "Hewan mati " << this->name << endl;
		}

		virtual void print(){
			cout << "Hewan ini namanya " << this->name << endl;
		}

	protected:
		string name;
};

class Anjing : public Hewan{
	public:
		Anjing(string nm) : Hewan(nm){};

		void print(){
			cout << "Anjing ini namanya " << this->name << endl;
		}

		~Anjing(){
			cout << "Anjing mati " << this->name << endl;
		}
};

class Kucing : public Hewan{
	public:
		Kucing(string nm) : Hewan(nm){};

		virtual ~Kucing(){
			cout << "Kucing mati " << this->name << endl;
		}
};

class AnjingBulldog : public Anjing{
	public:
		AnjingBulldog(string nm, string milik) : Anjing(nm){
			pemilik = milik;
		}

		void print(){
			cout << "Anjing bulldog ini namanya " << this->name << ". Pemiliknya adalah " << this->pemilik << endl;
		}

		virtual ~AnjingBulldog(){
			cout << "Anjing bulldog mati " << this->name << endl;
		}

	private:
		string pemilik;
};

class KucingAnggora : public Kucing{
	public:
		KucingAnggora(string nm, string milik) : Kucing(nm){
			pemilik = milik;
		}

		void print(){
			cout << "Kucing anggora ini namanya " << this->name << ". Pemiliknya adalah " << this->pemilik << endl;
		}

		virtual ~KucingAnggora(){
			cout << "Kucing anggora mati " << this->name << endl;
		}

	private:
		string pemilik;
};