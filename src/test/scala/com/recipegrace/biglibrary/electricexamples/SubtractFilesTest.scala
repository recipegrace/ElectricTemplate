package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.tests.ElectricJobTest


/**
  * Created by Ferosh Jacob on 2/9/16.
  */
class SubtractFilesTest extends ElectricJobTest{

  test("subtract files test") {
    val input1 = createFile("hello \t world\n" +
      "hello1\t world1")

   val input2  =  createFile("hello \t world\n" +
     "hello2\t world1")

    val output = createTempPath()
    launch(SubractFiles, TwoInputArgument(input1, input2,output ))

    val outLines = readSparkOut(output)
    outLines should have size(1)
  }
}
