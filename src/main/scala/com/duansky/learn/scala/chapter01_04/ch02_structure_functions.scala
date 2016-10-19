package com.duansky.learn.scala.chapter01_04

/**
  * Created by duansky on 16-10-18.
  */
class ch02_structure_functions {

  /**
    * 计算x的n次幂
    * @param x 底数
    * @param n 幂
    * @return x的n次幂
    */
  def pow(x:Int,n:Int) : Long = {
    if(x < 0 ) 1 / pow(x,-n)
    else if (x == 0) 1
    else if(x % 2 == 0){var t = pow(x,n/2); t * t}
    else x * pow(x,n-1)
  }

}
