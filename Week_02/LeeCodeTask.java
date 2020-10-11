/**
 * 字母异位词分组
 * 构建hashMap
 *
 * @param strs
 * @return
 */
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> anagramsMap = new HashMap<>();
    for (String str : strs) {
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

    for (String key : anagramsMap.keySet()) {
        result.add(anagramsMap.get(key));
    }
    return result;
}

/**
 * N叉树的前序遍历
 *
 * @param root
 * @return
 */
public List<Integer> preorder(NTreeNode root) {
    List<Integer> result = new ArrayList<>();
    rootFirst(root, result);
    return result;
}

public void rootFirst(NTreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }
    result.add(root.val);
    for (NTreeNode node : root.children) {
        rootFirst(node, result);
    }
}