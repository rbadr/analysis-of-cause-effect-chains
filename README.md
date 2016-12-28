# Repair with analysis of cause-effect chains. [![Build Status](https://travis-ci.org/Mama59/CauseEffectChain.svg?branch=master)](https://travis-ci.org/Mama59/CauseEffectChain) [![Coverage Status](https://coveralls.io/repos/github/Mama59/CauseEffectChain/badge.svg)](https://coveralls.io/github/Mama59/CauseEffectChain)

Delta-debugging for Java, by Marine Bal, Antonin Durey, José Pansa and Badr Rahal.

## **Mutation Coverage** : **73%**

To provide high standard test coverage for our Delta-debugging tool, we used Pitest, a mutation testing system for Java.

Pitest will mutate the code in our project defined by the targetClasses we set in the pom file. 

```xml
<plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <version>1.1.11</version>
    <configuration>
        <targetClasses>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger.*</param>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.action.helper.*</param>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.challenge.*</param>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.jdb.*</param>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.model.*</param>
            <param>fr.univlille1.m2iagl.opl.causechaineffect.main.*</param>
        </targetClasses>
    </configuration>
</plugin>
```

To run pitest directly from the commandline :
```
mvn clean install
mvn org.pitest:pitest-maven:mutationCoverage
```

To speed-up repeated analysis of the same codebase :
```
mvn -DwithHistory=true org.pitest:pitest-maven:mutationCoverage
```

This will output an html report to **target/pit-reports/YYYYMMDDHHMI/index.html**.




