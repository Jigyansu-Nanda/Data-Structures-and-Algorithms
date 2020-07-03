function mergeSort(arr, l, r) {
  if (r > l) {
    var m = l + Math.floor((r-l)/2);
    mergeSort(arr, l, m);
    mergeSort(arr, m+1, r);
    merge(arr, l, m, r);
  }
}

function merge(arr, l, m, r) {
  var left = [];
  var right = [];
  var n1 = m-l+1;
  var n2 = r-m;
  for (let i=0; i<n1; i++) {
    left.push(arr[l+i]);
  }
  for (let j=0; j<n2; j++) {
    right.push(arr[m+1+j]);
  }
  var i = 0;
  var j = 0;
  var index = l;
  while (i < n1 && j < n2) {
    if (left[i] <= right[j]) {
      arr[index] = left[i];
      i++;
      index++;
    }
    else {
      arr[index] = right[j];
      j++;
      index++;
    }
  }
  while (i < n1) {
    arr[index] = left[i];
    i++;
    index++;
  }
  while (j < n2) {
    arr[index] = right[j];
    j++;
    index++;
  }
}

var arr = [32,19,76,7,24];
mergeSort(arr, 0, arr.length-1);
var s = "";
for (let i=0; i<arr.length; i++) {
  s += arr[i]+" ";
}
console.log(s);
