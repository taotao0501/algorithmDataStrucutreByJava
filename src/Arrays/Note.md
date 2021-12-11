动态数组复杂度分析
- 增：O(n)  因为有resize; 
- 删：O(n)  因为有resize;
- 改：已知索引O(1)；未知索引O(n)
- 查：已知索引O(1)；未知索引O(n)

 均摊复杂度 && 复杂度震荡
 
 复杂度震荡主要在于 removeLast时 resize
 过于着急，可以使用Lazy法，为了避免 先减后加导致
 的频繁 缩容，扩容，可以采取当 size == capacity / 4
 时，才将 capacity减半的策略。