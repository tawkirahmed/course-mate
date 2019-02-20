package crawler.prototypes

import java.io.File

import org.jsoup.Jsoup

/**
  * Created by: Tawkir Ahmed (tawkirahmed@gmail.com)
  * Date: 2/20/2019
  */
object Crawl {

  val RootUrl =
    "https://www.in.tum.de/en/current-students/masters-programs/data-engineering-and-analytics/compulsory-elective-and-support-elective-modules/fpso-2018/"
  val RootFilePath =
    "D:\\Work\\course-mate\\src\\main\\resources\\data_ea_root.html"
  val input = new File(RootFilePath)
  def main(args: Array[String]): Unit = {
    val doc = Jsoup.parse(input, "UTF-8", RootUrl)
    val content = doc.getElementById("content")
    val headers = content.getElementsByTag("h2")
    val tables = content.getElementsByTag("table")
    headers.forEach(header => println(header.text))
    println(tables.size)
    tables.forEach(table => {
      println(table.text)
    })
  }
}
