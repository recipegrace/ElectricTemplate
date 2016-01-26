package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.jobs.{SequenceFileJob, ArgumentsToMap}
import com.recipegrace.biglibrary.electric.{ElectricContext, ElectricJob}


/**
  * Created by Ferosh Jacob on 1/26/16.
  */
case class SampleDataInput(input:String,isSequenceFile:Boolean, sampleRate:Double,output:String)
object SampleData extends  SequenceFileJob[SampleDataInput] with ArgumentsToMap {
  override def execute(t: SampleDataInput)(implicit sc: ElectricContext): Unit = {


    val content=
    ( if(t.isSequenceFile) readFile(t.input)
    else readFile(t.input,false)
      ).sample(false, t.sampleRate,System.currentTimeMillis().toInt)

    if(!t.isSequenceFile) content.saveAsTextFile(t.output)
    else writeFile(content, t.output)

  }

  override def parse(args: Array[String]): SampleDataInput = {
  val input = "input"
  val isSequence = "isSequence"
  val sampleRate = "sampleRate"
  val output = "output"

  val mainText=s"Should have --$input val --$isSequence val --$sampleRate val --$output"


    val mapArgs = convertArgsToMap(args)
    validateArgs(args,mapArgs,mainText, input, isSequence,sampleRate,output)

    SampleDataInput(mapArgs(input), mapArgs(isSequence).toBoolean, mapArgs(sampleRate).toDouble, mapArgs(output))
  }
}
