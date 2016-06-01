package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.jobs.Arguments.OneArgument
import com.recipegrace.biglibrary.electric.tests.OutputOnlyJobTest

/**
  * Created by angela on 5/1/16.
  */
class CreateDataTest extends OutputOnlyJobTest {

  test(" create data test"){

    val temp = createTempPath()

    launch(CreateData, OneArgument(temp))

    val content = readSparkOut(temp)

    content should have size 100
  }
}
