package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.ElectricContext
import com.recipegrace.biglibrary.electric.jobs.SimpleJob

/**
  * Created by Ferosh Jacob on 1/26/16.
  */
object SequenceFileToTextFile extends SimpleJob {
  override def execute(input: String, output: String)(implicit ec: ElectricContext): Unit = {
    readFile(input)
      .saveAsTextFile(output)
  }
}
