# 归并排序
思想:
递归思想伪代码演示
```
MergeSort(arr, l r){
    if(l>=r) return;
    int mid =(l+r) /2

    //对 arr[l,mid]排序
    MergeSort(arr,l,mid);
    //对 arr[mid+1,r]排序
    MergeSort(arr,mid+1,r);
    //合并
    merge(arr, l, mid ,r);
}
```
需要一个与原数组长度相同的辅助数组,因此空间复杂度为O(n)
