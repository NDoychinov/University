#include <iostream>
#include <string>
#include <sstream>

using namespace std;

static int primeRandoms() {

    string line;
    int x, y;

    srand(30);
    while (getline(cin, line)) {
        stringstream(line) >> x >> y;


        cout << rand()%100;

    }


    return 0;
}



