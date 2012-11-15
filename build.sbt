name := "Graph"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.2"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= Seq(
	"com.novocode" % "junit-interface" % "0.9" % "test",
	 "org.scalatest" %% "scalatest" % "2.0.M4" % "test"
)

