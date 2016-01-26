package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.jobs.Arguments.TwoArgument
import com.recipegrace.biglibrary.electric.tests.SimpleJobTest

/**
  * Created by Ferosh Jacob on 1/26/16.
  */
class SequenceFileToTextFileTest extends SimpleJobTest {

  test("sequence file to text file  ") {

    val text = "hello"
    val input = createFile(text)
    val output1 = createTempPath()
    WordCount.runLocal(TwoArgument(input,output1))
    val output2 = createTempPath()
    SequenceFileToTextFile.runLocal(TwoArgument(output1,output2))

    readSparkOut(output2) should contain (text+"\t1")
  }

}
