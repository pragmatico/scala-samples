## Dependencies

Disable transitivity:

> libraryDependencies += "org.apache.felix" % "org.apache.felix.framework" % "1.8.0" intransitive()

Exclude certain transitive dependencies

> libraryDependencies += 
  "log4j" % "log4j" % "1.2.15" exclude("javax.jms", "jms")
  
or

> libraryDependencies +=
  "log4j" % "log4j" % "1.2.15" excludeAll(
    ExclusionRule(organization = "com.sun.jdmk"),
    ExclusionRule(organization = "com.sun.jmx"),
    ExclusionRule(organization = "javax.jms")
  )
  
Overriding a version

> dependencyOverrides += "log4j" % "log4j" % "1.2.16"



## SBT commands

SBT version:
> sbt sbt-version

Compile:
> sbt compile

Package:
> sbt package

Test:
> sbt test

Show project/modules versions:
> show version

Show dependencies classpath
> show dependencyClasspath

Go to a project module
> project <name>

---

Continuous build and test
> ~ compile

