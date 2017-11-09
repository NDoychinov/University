#include <iostream>
#include <string>
#include <sstream>

using namespace std;

static int basesConvertions() {
    int x;
    int decimal = 0;
    string y;
    string line;

    while (getline(cin, line)) {
        stringstream(line) >> x >> y;

        if (x == 2) {
            decimal = stoi(y, nullptr, 2);
        } else if (x == 8) {
            decimal = stoi(y, nullptr, 8);
        } else if (x == 16) {
            decimal = stoi(y, nullptr, 16);
        }
        cout << decimal;
    }


    return 0;
}


