
端口：36601
### 添加规则
- ``/addRule``
- params
```java
* String baseName;    //规则名称
* String packageName; //规则包名称
* String content;     //drools语法规则内容
```
- response
```json
{
    "message": "添加成功",
    "code": 200
}
```
### 执行规则
- ``/triggerRule``
- params
```java
* String baseName; //规则名称
* Object param;    //计算字段
```
- response
```json
{
    "data": {
        "result": 1145,
        "kieBaseName": "test"
    },
    "code": 200
}
```
### 删除规则
- ``/deleteRule``
- params
```java
* Long ruleId; //规则id
```
- response
```json
{
  "message": "删除成功",
  "code": 200
}
```
### 修改规则
- ``/editRule``
- params
```java
* Long ruleId;    //规则id
* String content; //drools语法规则内容
```
- response
```json
{
    "message": "修改成功",
    "code": 200
}
```
### 获取规则列表
- ``/getRuleList``
- params
```java
```
- response
```json
{
  "data": {
    "list": [
      {
        "dataState": 2,
        "createdTime": "1658715670531",
        "creatorId": null,
        "updatedTime": "1658715670531",
        "updatorId": null,
        "id": 15,
        "kieBaseName": "test",
        "kiePackageName": "test_package",
        "ruleContent": "package test_package\r\n\r\nglobal ru.reimu.alice.drools.model.RuleDataModel ruleData\r\n\r\nrule \"rule-0\"\r\n    when\r\n        $i: Integer(intValue() > 3)\r\n    then\r\n         ruleData.setResult($i);\r\nend"
      }
    ]
  },
  "code": 200
}
```
