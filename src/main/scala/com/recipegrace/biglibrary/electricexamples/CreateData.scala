package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.ElectricContext
import com.recipegrace.biglibrary.electric.jobs.OutputOnlyJob


/**
  * Created by Ferosh Jacob on 1/26/16.
  */
object CreateData extends  OutputOnlyJob {
  override def execute(output: String)(implicit ec: ElectricContext): Unit = {
    ec.sparkContext.parallelize( 1 to 100).saveAsTextFile(output)
  }
}
