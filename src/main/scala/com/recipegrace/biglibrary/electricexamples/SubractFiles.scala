package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.{ElectricContext, SequenceFileJob}

/**
  * Created by Ferosh Jacob on 2/9/16.
  */
case class TwoInputArgument(input1:String, input2:String, output:String)
object SubractFiles extends SequenceFileJob[TwoInputArgument] {
  override def execute(argument:TwoInputArgument)(implicit ec: ElectricContext): Unit = {


    val ids=
    readTextFile(argument.input1).map(f=> f.split("\t",-1)(0))
      .subtract(readTextFile(argument.input2).map(f=> f.split("\t",-1)(0)))
        .map(f=> (f,false))

     ids.join(
      readTextFile(argument.input1).map(f=> {
        val parts = f.split("\t",-1)
        (parts.head, parts.tail.mkString("\t"))
      }))

          .map(f=>f._1+"\t"+ f._2._2)
        .saveAsTextFile(argument.output)
  }
}
