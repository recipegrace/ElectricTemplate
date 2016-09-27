package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.{ElectricContext, SequenceFileJob}


/**
  * Created by Ferosh Jacob on 1/26/16.
  */
case class SampleDataInput(input:String,isSequenceFile:Boolean, sampleRate:Double,output:String)
object SampleData extends  SequenceFileJob[SampleDataInput]  {
  override def execute(t: SampleDataInput)(implicit sc: ElectricContext): Unit = {


    val content=
    ( if(t.isSequenceFile) readFile(t.input)
    else readFile(t.input,false)
      ).sample(false, t.sampleRate,System.currentTimeMillis().toInt)

    if(!t.isSequenceFile) content.saveAsTextFile(t.output)
    else writeFile(content, t.output)

  }


}
