addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")
//resolvers += "Flyway" at "https://flywaydb.org/repo" // ’Ç‰Á
resolvers += "Flyway" at "https://davidmweber.github.io/flyway-sbt.repo"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "4.2.0") // ’Ç‰Á
addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.0")