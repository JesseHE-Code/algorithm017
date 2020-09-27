# 学习笔记

## 1、测试Git

### 本地Git配置

```shell
    git config --global user.email "nnkajima@163.com"

    git config --global user.name "hezhiqiang"
```

### 操作

```shell

    git add .

    git commit -m ""

    git push
```

### git 记录

```shell
    git config --global --list
```

### 配置本地SSH Key

```txt
https://git-scm.com/book/zh/v2/%E6%9C%8D%E5%8A%A1%E5%99%A8%E4%B8%8A%E7%9A%84-Git-%E7%94%9F%E6%88%90-SSH-%E5%85%AC%E9%92%A5
```

### 新建Git分支

```shell

    git branch "name"

    git checkout "name"

    git push origin "name"

```

## 2、学习心得

本周国庆请假休假了，所以周末的任务会提交的比较晚。
本周一共完成了11道题目的提交，还有一些超哥推荐的题目在学习。记录一下在解决几个题目时的一个心得。

### 2.1 猜数字

猜数字这个题目，题目读题需要一点时间，看评论也有同学因为题目复杂而放弃，我在做题目的时候，审题也花了一定的时间。具体对题目的理解是这样的：这个题目的关键是求 x,y的值，怎么取x、y的值分析清楚就好。
比如x怎么取？
```java
char cs = secret.charAt(i);
char cg = guess.charAt(i);
if (cs == cg) {
    x++;
}
```
这个条件比较好理解，一般x值是不会算错的。我觉得大家在解题的时候，也不会有问题。
主要是y怎么处理呢？
抽象成一句话：当你的字符串在A 和 B中同时出现，但他们位置不相等的地方，y的值需要累加。
如果是这样的话，基本上和上面处理x条件完全对立的条件里。
同时运用只有数字这个背景，自定义一个cache[10]，出现在guess的字符，我们在cache中对应位置-1；出现在secret的字符，我们在cache中对应位置+1
-- -1 的同时判断其是否大于0，如果大于0，是不是表示其在secret中出现过？同理！
代码如下：
```java
public String getHint(String secret, String guess) {
    int len = secret.length();
    int[] cache = new int[10];
    int x = 0, y = 0;
    for (int i = 0; i < len; i++) {
        char cs = secret.charAt(i);
        char cg = guess.charAt(i);
        if (cs == cg) {
            x++;
        } else {
            if (cache[cs - '0']++ < 0) y++;
            if (cache[cg - '0']-- > 0) y++;
        }
    }
    return x + "A" + y + "B";
}

```
本周学习心得先记录在这里，辛苦大半年，休假中的日子有一些放松，但希望自己坚持去学习总结。