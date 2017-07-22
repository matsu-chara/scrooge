lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.12.2",
    libraryDependencies ++= Seq(
      "org.apache.thrift" % "libthrift" % System.getProperty("libthrift.version"),
      "com.twitter" %% "scrooge-core" % System.getProperty("scrooge.version") exclude("com.twitter", "libthrift"),
      "com.twitter" %% "finagle-thrift" % System.getProperty("finagle.version") exclude("com.twitter", "libthrift")
  )
)
