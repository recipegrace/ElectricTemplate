package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.ElectricContext
import com.recipegrace.biglibrary.electric.jobs.TwoInputJob

/**
  * Created by Ferosh Jacob on 2/9/16.
  */
object SubractFiles extends TwoInputJob {
  override def execute(one: String, two: String, output: String)(implicit ec: ElectricContext): Unit = {


    val ids=
    readTextFile(one).map(f=> f.split("\t",-1)(0))
      .subtract(readTextFile(two).map(f=> f.split("\t",-1)(0)))
        .map(f=> (f,false))

     ids.join(
      readTextFile(one).map(f=> {
        val parts = f.split("\t",-1)
        (parts.head, parts.tail.mkString("\t"))
      }))

          .map(f=>f._1+"\t"+ f._2._2)
        .saveAsTextFile(output)
  }
}
