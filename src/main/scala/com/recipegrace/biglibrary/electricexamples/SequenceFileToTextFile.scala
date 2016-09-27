package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.{ElectricContext, SequenceFileJob}

/**
  * Created by Ferosh Jacob on 1/26/16.
  */
case class SimpleJobArgument(input:String, output:String)
object SequenceFileToTextFile extends SequenceFileJob[SimpleJobArgument] {
  override def execute(argument:SimpleJobArgument)(implicit ec: ElectricContext): Unit = {
    readFile(argument.input)
      .saveAsTextFile(argument.output)
  }
}
