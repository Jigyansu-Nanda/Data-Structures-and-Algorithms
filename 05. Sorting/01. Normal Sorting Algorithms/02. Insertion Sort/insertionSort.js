function insertionSort(arr, n) {
  for (let i = 0; i < n; i++) {
    var key = arr[i];
    var j = i-1;
    while (j >= 0 && arr[j] > key) {
      arr[j+1] = arr[j];
      j--;
    }
    arr[j+1] = key;
  }
}

var arr = [32,19,76,7,24];
insertionSort(arr, arr.length);
var s = "";
for (let i=0; i<arr.length; i++) {
  s += arr[i]+" ";
}
console.log(s);
