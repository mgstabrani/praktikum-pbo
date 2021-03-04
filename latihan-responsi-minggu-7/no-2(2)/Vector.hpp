#ifndef _Vector_HPP_
#define _Vector_HPP_

#include <iostream>

using namespace std;

template <class T, int N>
class Vector{
    private:
        T *elements;

    public:
        Vector(){
            this->elements = new T[N];
        }

        Vector(const Vector &vector){
            this->elements = new T[N];
            for (int i = 0; i < N; i++){
                this->elements[i] = vector.elements[i];
            }
        }

        ~Vector(){
            delete[] this->elements;
        }

        T &operator[](int idx){
            return this->elements[idx];
        }

        Vector operator+(const Vector &vector){
            Vector<T, N> result;
            for (int i = 0; i < N; i++){
                result.elements[i] = elements[i] + vector.elements[i];
            }
            return result;
        }

        Vector operator-(const Vector &vector){
            Vector<T, N> result;
            for (int i = 0; i < N; i++){
                result.elements[i] = elements[i] - vector.elements[i];
            }
            return result;
        }

        bool operator<(const Vector &vector){
            for (int i = 0; i < N; i++){
                if (elements[i] != vector.elements[i]){
                    return elements[i] < vector.elements[i];
                }
            }
            return false;
        }

        bool operator>(const Vector &vector){
            for (int i = 0; i < N; i++){
                if (elements[i] != vector.elements[i]){
                    return elements[i] > vector.elements[i];
                }
            }
            return false;
        }

        friend std::ostream &operator<<(ostream &os, Vector vector){
            os << "<";
            for (int i = 0; i < N; i++){
                os << vector.elements[i];
                if (i != N - 1){
                    os << ",";
                }
            }
            os << ">";
            return os;
        }

        friend std::istream &operator>>(istream &is, Vector &vector){
            for (int i = 0; i < N; i++){
                is >> vector.elements[i];
            }
            return is;
        }
};

#endif