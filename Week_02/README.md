# 学习笔记

## 第一部分：题目分析

### Task 1： 异位词分组

```
题目描述：
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
#### 题目分析

首先弄清楚什么是异位词？  
异位词是字符串的字母和字母个数相同，但位置不一样的字符串（词）。字符串区分大小写，本题的输入都是小写字符串。  
既然是异位词，那么字符串的字母排序后的结果将会相同，根据这个特性，我们定义一个Map存储一组异位词，key值就是排序后的字符串，value就是输入字符串的一个数组，最后将数组输出。  
代码如下：
```java
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> anagramsMap = new HashMap<>();
    for (String str: strs) {
        char[] tempChar = str.toCharArray();
        Arrays.sort(tempChar);
        if (anagramsMap.get(new String(tempChar)) == null) {
            List<String> value = new ArrayList<>();
            value.add(str);
            anagramsMap.put(new String(tempChar), value);
        } else {
            anagramsMap.get(new String(tempChar)).add(str);
        }
    }

    for(String key : anagramsMap.keySet()) {
        result.add(anagramsMap.get(key));
    }
    return result;
}
```

### Task 2：  N叉树的前序遍历

```
题目描述：
给定一个 N 叉树，返回其节点值的前序遍历。
树的描述就省略了。
```

#### 题目分析

这是一个典型的树相关的题目，二叉树的解法与此类似。  
树的题目以便使用递归即可。这个主要说一下递归的一个模板。  
递归一般时候该怎么写？  
递归函数一般包含这几部分：
+ 递归的终结条件
+ 本层需要做的处理
+ 进入下一层递归

代码模板如下：
```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    // process current logic
    process(level, param);
    // drill down
    recur( level: level + 1, newParam);
    // restore current status
}
```
题目比较简单，直接上代码：
```java
public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    rootFirst(root, result);
    return result;
}

public void rootFirst(Node root, List<Integer> result) {
    if (root == null) {
        return;
    }
    result.add(root.val);
    for (Node node : root.children) {
        rootFirst(node, result);
    }
}
```

