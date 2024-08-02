function partition(array , low , high){
    let pivot = Math.floor(Math.random() * (high - low) + low);
    let left = low;
    let right = high - 1;
    while (true){
        while (array[left] < array[pivot]){
            left++;
        }
        while (array[right] > array[pivot]){
            right--;
        }
        if (left >= right)
            return pivot;
        [array[left] , array[right]] = [array[right] , array[left]];
    }
}

function quickSort(array , pivot = null){
    console.log(pivot)
    if (pivot == null){
        pivot = partition(array , 0 , array.length)
        quickSort(array , pivot);
    }else{
        // console.log(pivot)
        if ((pivot == 0) || (pivot == array.length - 1))
            return null
        quickSort(array , partition(array , 0 , pivot - 1));
        quickSort(array , partition(array , pivot + 1 , array.length - 1));
    }
}

array = [15,35,154,2,654,28,12,84];
console.log(array);
quickSort(array);
console.log(array);