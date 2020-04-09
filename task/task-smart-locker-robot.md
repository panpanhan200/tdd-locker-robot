### Tasking:

## 存包：

Given: 有储物柜A剩余空格数量为1，储物柜B剩余空格数量为2
When: 给机器人一个包
Then: 将包存在B，返回票据

Given: 有储物柜A剩余空格数量为1，储物柜B剩余空格数量为1
When: 给机器人一个包
Then: 返回票据

Given: 有储物柜A剩余空格数量为0，储物柜B剩余空格数量为0
When: 给机器人一个包
Then: 存包失败，返回储物柜已满消息

## 取包：

Given: 有一个存了包的储物柜，且票据合法
When: 用票取包
Then: 返回包

Given: 票据已使用过
When: 用票取包
Then: 返回取包失败消息
