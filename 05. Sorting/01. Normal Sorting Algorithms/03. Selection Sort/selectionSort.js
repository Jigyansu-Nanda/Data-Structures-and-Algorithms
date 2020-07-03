function swap(arr, i, j) {
  let tmp = arr[i];
  arr[i] = arr[j];
  arr[j] = tmp;
}

function selectionSort(arr, n) {
  for (let i = 0; i < n-1; i++) {
    var minIndex = i;
    for (let j=i+1; j<n; j++) {
      if (arr[minIndex] > arr[j]) {
        minIndex = j;
      }
    }
    if (minIndex != i) {
      swap(arr, minIndex, i);
    }
  }
}

var arr = [32,19,76,7,24];
selectionSort(arr, arr.length);
var s = "";
for (let i=0; i<arr.length; i++) {
  s += arr[i]+" ";
}
console.log(s);
