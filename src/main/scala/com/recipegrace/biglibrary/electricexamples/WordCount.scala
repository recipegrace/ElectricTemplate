package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.{ElectricContext, SequenceFileJob}


/**
 * Created by fjacob on 9/25/15.
 */

object WordCount extends SequenceFileJob[SimpleJobArgument] {
  override def execute(argument:SimpleJobArgument)(implicit ec: ElectricContext) = {
    val file = readFile(argument.input)
    val words = file.flatMap(_.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+"))
    val wordCounts = words
      .map(x => (x, 1)).reduceByKey(_ + _)
      .map(f => f._1 + "\t" + f._2)
    writeFile(wordCounts, argument.output)
  }
}
