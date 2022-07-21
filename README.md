
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
