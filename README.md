JPMML-Evaluator [![Build Status](https://travis-ci.org/jpmml/jpmml-evaluator.png?branch=master)](https://travis-ci.org/jpmml/jpmml-evaluator)
===============

Java Evaluator API for Predictive Model Markup Language (PMML).

# Features

The preprocessing functionality for the JPMML evaluator is a bit limited. One of the biggest lacks is that there are no date calculations. 

This extends the pre-processing of the JPMML evaluator active fields according to the [DataDictionary] (http://www.dmg.org/v4-2-1/DataDictionary.html) and [MiningSchema] (http://www.dmg.org/v4-2-1/MiningSchema.html) elements:

For more information on jpmml, please see the [JPMML evaluator on github] (https://github.com/jpmml/jpmml-evaluator/).

# Usage
mvn clean install

```
java -jar pmml-evaluator-example/target/example-1.2-SNAPSHOT.jar --model model.pmml --input input.tsv --output output.tsv
```

You might want to have a look at the provided example PMML file in pmml-evaluator/src/main/resources/. 