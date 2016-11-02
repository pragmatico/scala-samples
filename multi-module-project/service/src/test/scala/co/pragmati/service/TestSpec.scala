package co.pragmati.service

import org.scalatest.FunSuite

class TestSpec extends FunSuite {

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
