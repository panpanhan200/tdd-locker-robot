### Tasking:

## 存包：

Given: 有顺序为A、B的两个储物柜A、B，容量均为1，储物柜皆未满
When: 给机器人一个包
Then: 将包存A，返回票据

Given: 有顺序为A、B的两个储物柜A、B，容量均为1，A满B未满
When: 给机器人一个包
Then: 将包存B，返回票据

Given: 有顺序为A、B的两个储物柜A、B，容量均为1，储物柜皆满
When: 给机器人一个包
Then: 返回储物柜已满的信息

## 取包：

Given: 有一个存了包的储物柜，且票据合法
When: 用票取包
Then: 返回包

Given: 票据已使用过
When: 用票取包
Then: 返回取包失败消息
