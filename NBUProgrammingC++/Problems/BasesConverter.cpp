#include <iostream>
#include <string>

using namespace std;

 static int basesConverter() {
    char symbols[16] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int n, base, temp;
    string result;

    cout << "Enter conversion base: ";
    cin >> base;
    cout << "Enter decimal number: ";
    cin >> n;
    temp = n;

    do {
        result = symbols[n % base] + result;
        n /= base;
    } while (n != 0);
    cout << temp << "(10) = " <<  result << "(" << base << ")";

    return 0;
}


