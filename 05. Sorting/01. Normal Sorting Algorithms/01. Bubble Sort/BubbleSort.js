function swap(arr, i, j) {
  let tmp = arr[i];
  arr[i] = arr[j];
  arr[j] = tmp;
}

function bubbleSort(arr, n) {
  for (let i = 0; i < n-1; i++) {
    var swapped = false;
    for (let j=0; j<n-i-1; j++) {
      if (arr[j] > arr[j+1]) {
        swap(arr, j, j+1);
        swapped = true;
      }
    }
    if (swapped === false) {break;}
  }
}

var arr = [32,19,76,7,24];
bubbleSort(arr, arr.length);
var s = "";
for (let i=0; i<arr.length; i++) {
  s += arr[i]+" ";
}
console.log(s);
