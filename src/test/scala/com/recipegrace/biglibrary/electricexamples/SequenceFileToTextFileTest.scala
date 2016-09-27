package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.tests.ElectricJobTest


/**
  * Created by Ferosh Jacob on 1/26/16.
  */
class SequenceFileToTextFileTest extends ElectricJobTest {

  test("sequence file to text file  ") {

    val text = "hello"
    val input = createFile(text)
    val output1 = createTempPath()
    launch(WordCount,SimpleJobArgument(input,output1))
    val output2 = createTempPath()
    launch(SequenceFileToTextFile,SimpleJobArgument(output1,output2))

    readSparkOut(output2) should contain (text+"\t1")
  }

}
