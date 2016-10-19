package com.duansky.learn.scala.chapter01_04

import scala.collection.JavaConversions.mapAsScalaMap


/**
  * Created by duansky on 16-10-19.
  */
class ch04_map_tuples {

  val equivments = Array("gun","car","knife","glass","shoes")
  val prices = Array(100.99,100000,10,25,29)
  val pairs = equivments.zip(prices)
  val discount = 0.9
  /*
  1. 打折优惠
   */
  val newPairs = for((k,v) <- pairs) yield (k,v*discount)

  /*
  2-5. 读取文件并统计单词出现的频率
   */
  def wordCounter(path:String): Unit ={
    val in = new java.util.Scanner(new java.io.File(path))
//    var map = new scala.collection.mutable.HashMap[String,Int]           // 2. 可变map
//    var map = Map[String,Int]()                                           // 3. 不可变map
//    var map = scala.collection.immutable.SortedMap[String,Int]()          // 4. 排序map
    //here we need import scala.collection.JavaConversions.mapAsScalaMap
    var map:collection.Map[String, Int] = new java.util.TreeMap[String,Int] // 5. java.util.TreeMap
    while(in.hasNext){
      val line = in.nextLine()
      for(k <- line.split(" ")) map = map + ( k-> (map.getOrElse(k,0) + 1))
    }
    for((k,v) <- map) println(k + ":" + v)
  }

  //6
  var weekdays :collection.mutable.Map[String,Int] = new scala.collection.mutable.LinkedHashMap[String,Int]
  weekdays("Monday") = java.util.Calendar.MONDAY;

  //7
  import scala.collection.JavaConversions.propertiesAsScalaMap
  var props:scala.collection.Map[String,String] = System.getProperties
  var maxLength = 0
  for(k <- props.keys) maxLength = maxLength max k.length
  for((k,v) <- props) println(k + " "*(maxLength-k.length)+"|" + v)

  //8
  def minmax(values:Array[Int]): (Int,Int)={
    (values.min,values.max)
  }

  //9
  def lteqgt(values:Array[Int],v:Int):(Int,Int,Int)={
    (values.filter(_<v).length,values.filter(_==v).length,values.filter(_>v).length)
  }
}
