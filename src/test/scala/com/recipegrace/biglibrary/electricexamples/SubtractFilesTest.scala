package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.jobs.Arguments.ThreeArgument
import com.recipegrace.biglibrary.electric.tests.TwoInputJobTest

/**
  * Created by Ferosh Jacob on 2/9/16.
  */
class SubtractFilesTest extends TwoInputJobTest{

  test("subtract files test") {
    val input1 = createFile("hello \t world\n" +
      "hello1\t world1")

   val input2  =  createFile("hello \t world\n" +
     "hello2\t world1")

    val output = createTempPath()
    launch(SubractFiles, ThreeArgument(input1, input2,output ))

    val outLines = readSparkOut(output)
    outLines should have size(1)
  }
}
