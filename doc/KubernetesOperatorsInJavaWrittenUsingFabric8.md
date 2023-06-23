# Kubernetes Operators in Java Written using Fabric8 Kubernetes Client

You can easily rely on Fabric8 Kubernetes Client to implement your Kubernetes Operators. Here are few examples of already existing Kubernetes Operators which can give you some idea on how to get started with writing Kubernetes Operators in Java using Fabric8 Kubernetes Client:

- [Strimzi Kafka Operator: Apache Kafka Running on Kubernetes](https://github.com/strimzi/strimzi-kafka-operator)
- [Spark Operator: Operator for managing Spark Clusters on Kubernetes](https://github.com/radanalyticsio/spark-operator)
- [Kerberos Operator for Kubernetes](https://github.com/novakov-alexey/krb-operator)
- [Windup Operator: Operator to deploy Windup/MTA on OpenShift](https://github.com/windup/windup-operator)
- [Instana Agent Operator: A Kubernetes Operator to install and manage Instana agent](https://github.com/instana/instana-agent-operator)
- [Strimzi Schema Registry Operator: A Kubernetes Operator (based on Java) for running the Confluent Schema Registry and KSQL with a Strimzi-based Kafka cluster](https://github.com/shangyuantech/strimzi-registry-ksql-operator)
- [Tomcat Operator: An operator managing Tomcat and deploying war file to it.](https://github.com/java-operator-sdk/tomcat-operator)
- [Flink Native Kubernetes Operator: Apache Flink on Kubernetes](https://github.com/wangyang0918/flink-native-k8s-operator)
- [Activiti Cloud Apps Operator](https://github.com/salaboy/activiti-cloud-apps-operator)
- [JVM Controller(Demo)](https://github.com/nfrankel/jvm-controller)
- [RabbitMQ Operator](https://github.com/YJFinBJ/rabbitmq-operator)
- [Locust k8s operator: Cloud native solution to run Locust on any Kubernetes cluster](https://github.com/AbdelrhmanHamouda/locust-k8s-operator)

While sometimes simply using the client is enough to create an operator, using a specialized 
framework to do so might make the task easier. The 
[Java Operator SDK (JOSDK)](https://github.com/operator-framework/java-operator-sdk) builds on 
top of the Fabric8 Kubernetes Client to provide higher-level abstractions, common operator 
patterns and optimizations, letting developers focus on their operator's logic.
