// +-------------------------------------------------------------------------------------+
// | SBT Eclipse (https://github.com/typesafehub/sbteclipse)                             |
// | Creates .project and .classpath files for easy Eclipse project imports              |
// |                                                                                     |
// | See also: Eclipse downloads (http://www.eclipse.org/downloads/)                     |
// | See also: Scala IDE downloads (http://download.scala-ide.org/)                      |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")

// +-------------------------------------------------------------------------------------+
// | Dependency graph SBT plugin (https://github.com/jrudolph/sbt-dependency-graph)      |
// | Lists all library dependencies in a nicely formatted way for easy inspection.       |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")


// +-------------------------------------------------------------------------------------+
// | SBT-Pack SBT plugin (https://github.com/xerial/sbt-pack)                            |
// | A sbt plugin for creating distributable Scala packages that include dependent jars  |
// | and launch scripts.                                                                 |
// +-------------------------------------------------------------------------------------+
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.6.5")
