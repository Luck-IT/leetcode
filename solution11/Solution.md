# [盛水最多的容器](https://leetcode-cn.com/problems/container-with-most-water/)

## description

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

## solution

盛水容器的面积与两个端点的最短高度以及两个坐标直接的距离有关。
可以得出如下公式：   
    Area(i,j)=min(height[i],height[j])*(j-i) (j>=i)

### solution1：枚举
通过循环找出每一个可能的值，但是会超时

### solution2：双指针

设置左右两个指针，l,r;开始分别执行两个端点。每次向**中间**移动height**较小**的那个指针，然后再次计算面积，从而通过N的时间复杂度就可以得到最大面积。
>> 证明：
开始两个指针(l,r)指向左右边界，则面积Aini = min(height[l],height[r]) * (r-l). 假设此时height[r]>height[l];如果移动r指针，则移动后的面积一定小于Aini，也就是说对于找到最大面积移动height较大的没有作用，则只能移动较小height的指针向中间移动，即**缩小**了问题的规模。