package com.recipegrace.biglibrary.electricexamples

import com.recipegrace.biglibrary.electric.tests.ElectricJobTest

/**
  * Created by Ferosh Jacob on 1/26/16.
  */
class SampleDataTest  extends ElectricJobTest[SampleDataInput]{

  test("sample data test") {

    val input =  createFile((1 to 1000)   .map(f=> f.toString).mkString("\n"))
    val output = createTempPath()
    launch(SampleData, SampleDataInput(input, false, 0.01, output))
    readSparkOut(output).size<15 should equal(true)
  }

}
