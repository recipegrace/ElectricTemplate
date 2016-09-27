package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.tests.ElectricJobTest

/**
  * Created by angela on 5/1/16.
  */
class CreateDataTest extends ElectricJobTest{

  test(" create data test"){

    val temp = createTempPath()

    launch(CreateData, OutputOnlyArgument(temp))

    val content = readSparkOut(temp)

    content should have size 100
  }
}
