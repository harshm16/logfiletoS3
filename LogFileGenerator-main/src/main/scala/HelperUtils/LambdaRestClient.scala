package HelperUtils


import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.{Logger, LoggerFactory}
//import scalaj.http.{Http, HttpRequest}

class LambdaRestClient {}

object LambdaRestClient {

  //  val logger = CreateLogger(classOf[LambdaRestClient])

  def main(url: String): Unit = {


    val user_config: Config = ConfigFactory.load("lambdaJson.conf")


    val bucket = (user_config.getString("lambdaJson.Bucket"))
    val key = (user_config.getString("lambdaJson.Key"))
    val timestamp = (user_config.getString("lambdaJson.Timestamp"))
    val interval = (user_config.getString("lambdaJson.Interval"))
    val pattern = (user_config.getString("lambdaJson.Pattern"))
    //
    //    val restCall = HttpRequest(
    //      uri = "https://2k5z8ufd05.execute-api.us-east-2.amazonaws.com/loganalysisAPI/pandas?bucket=logdata-bucket&key=log7.log&timestamp=23%3A13%3A18.595&interaval=0%3A01%3A00.0&pattern=(%5Ba-c%5D%5Be-g%5D%5B0-3%5D%7C%5BA-Z%5D%5B5-9%5D%5Bf-w%5D)%7B5%2C15%7D")
    //    println(restCall)

    val restCall = scala.io.Source.fromURL("https://2k5z8ufd05.execute-api.us-east-2.amazonaws.com/loganalysisAPI/pandas?bucket=logdata-bucket&key=log7.log&timestamp=23%3A13%3A18.595&interaval=0%3A01%3A00.0&pattern=(%5Ba-c%5D%5Be-g%5D%5B0-3%5D%7C%5BA-Z%5D%5B5-9%5D%5Bf-w%5D)%7B5%2C15%7D")
    val s = restCall.mkString
    println(s)
  }
}