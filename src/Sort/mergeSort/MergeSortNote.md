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


**优化**：
1. 每次Merge前，判断 arr[mid].compareTo(arr[mid+1]),如果已经 <0,则
无需merge,那么就会形成 O(n) 级别的算法了；
2. 当排序数组长度(r-l) <=15，则采用插入排序，使用递归会使小规模问题中的方法
调用过于频繁；
3. 一次性创建辅助空间节省每次创建辅助空间的内存消耗，

**自底向上**


**例题**
[剑指51-求解逆序对数量的问题](// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/) 


**拓展题**
1.使用自底向上的方式解决逆序对数
2.使用插入排序法进一步优化上述解决逆序对数的代码
 
 
 