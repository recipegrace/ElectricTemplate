package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.{ElectricContext, SequenceFileJob}


/**
  * Created by Ferosh Jacob on 1/26/16.
  */
case class OutputOnlyArgument(output:String)
object CreateData extends  SequenceFileJob[OutputOnlyArgument]  {
  override def execute(output:OutputOnlyArgument)(implicit ec: ElectricContext): Unit = {
    ec.sparkContext.parallelize( 1 to 100).saveAsTextFile(output.output)
  }
}
