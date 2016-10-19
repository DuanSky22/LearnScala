package com.duansky.learn.scala.chapter01_04

/**
  * Created by duansky on 16-10-18.
  */
class ch03_array {

    /*
    1. 生成[0,n)的随机数组
     */
    def getRandom(n:Int):Array[Int] = {
      var res = new Array[Int](n);
      for(i <- 0 until n) res(i) = scala.util.Random.nextInt(n)
      res
    }

    val n = 10
    var nums = getRandom(n)

  /*
    2. 交换数组相邻元素
   */
    def pairReverse(nums:Array[Int]): Unit ={
      for(i <- 0 until (if(nums.length % 2 == 0) nums.length else nums.length - 1,2)) swap(i,i+1,nums)
    }

    def swap(i:Int,j:Int,nums:Array[Int]): Unit ={
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }

  /*
    3. 交换相邻元素
   */

    for(i <- 0 until nums.length) yield{
      if(i % 2 == 0 && i+1 < nums.length)
        nums(i+1)
      else
        nums(i-1)
    }

  /*
    4. 正数，0，负数排列
   */
  (for(i <- nums if i > 0) yield i) ++ (for(i <- nums if i == 0) yield i) ++ (for(i <- nums if i < 0) yield i)
  nums.filter(_ > 0) ++ nums.filter(_ == 0) ++ nums.filter(_ < 0)

  /*
    5. 计算平均值
   */
  nums.sum.toDouble / nums.length

  /*
    6. 反序排列
   */
  nums.reverse

  /*
    7. 去掉重复项
   */
  nums.distinct


}
