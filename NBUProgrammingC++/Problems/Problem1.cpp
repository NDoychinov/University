#include <iostream>

using namespace std;

static void swap(int *a, int *b) {
    int tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}

static int partition(int vec[], int left, int right) {
    int i, j;

    i = left;
    for (j = left + 1; j <= right; ++j) {
        if (vec[j] > vec[left]) {
            ++i;
            swap(&vec[i], &vec[j]);
        }
    }
    swap(&vec[left], &vec[i]);

    return i;
}

static void quickSort(int vec[], int left, int right) {
    int r;

    if (right > left) {
        r = partition(vec, left, right);
        quickSort(vec, left, r - 1);
        quickSort(vec, r + 1, right);
    }
}

static void problem1() {
    int n;
    cin >> n;

    int days[n];

    for (int i = 0; i < n; ++i) {
        cin >> days[i];
    }

    quickSort(days, 0 , n - 1);

    int indicator = n;
    for (int m = 0; m < n; ++m) {
        int k = days[m];

        if (m + 1 >= k ) {
            indicator = k;
            break;
        }
    }

    cout << indicator;

}





