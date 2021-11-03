package HelperUtils

import com.amazonaws.AmazonServiceException
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import com.typesafe.config.{Config, ConfigFactory}

import java.io.File

object sendtoS3:

  val user_config: Config = ConfigFactory.load("lambdaJson.conf")


  val bucket = (user_config.getString("lambdaJson.Bucket"))
  val key = (user_config.getString("lambdaJson.Key"))
  val path = (user_config.getString("lambdaJson.File_path"))


  val s3: AmazonS3 = AmazonS3ClientBuilder.standard.withRegion(Regions.US_EAST_2).build

  try s3.putObject(bucket, key, new File(path))
  catch {
    case e: AmazonServiceException =>
      System.err.println(e)
      System.exit(1)
  }
