lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.12.2",
    libraryDependencies ++= Seq(
      "org.apache.thrift" % "libthrift" % "0.9.2",
      "com.twitter" %% "scrooge-core" % "4.18.0" exclude("com.twitter", "libthrift"),
      "com.twitter" %% "finagle-thrift" % "6.45.0" exclude("com.twitter", "libthrift")
  )
)
