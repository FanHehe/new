# SpringProject

## 说明

1. 基于SSM 实现简单的web应用。
2. 日志方面采用logback + slf4j 记录日志
3. 项目根路径分为前后端项目，统一使用gradle进行项目构建
4. 使用Gretty插件，支持开发阶段热重启。
5. 使用Dubbo作为SOA，进行SRPC通信工具

## 要求

- Java 8

## 使用方式

因为开发环境在Mac，因此仅涉及了Mac方面使用方式

如果 */usr/libexec/java_home* 的结果是1.8版本，则可以直接执行 gradle tomcatRun 运行。

否则执行 */usr/libexec/java_home -V* 查看本地所有Jdk版本，并找出其中1.8版本的JAVA_HOME

则执行：

> gradle tomcatRun -Dorg.gradle.java.home=${1.8版本的Java_HOME}


## Change Logs

- 1.1.0 支持Dubbo
- 1.0.0 init
