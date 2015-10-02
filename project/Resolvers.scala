
import sbt._

object Resolvers {
  val mvnrepository = "MVN Repo" at "http://mvnrepository.com/artifact"
  val recipegrace = "Recipegrace repo" at "http://recipegrace.com:8080/nexus/content/repositories/releases/"

  val allResolvers = Seq(mvnrepository,recipegrace)

}
