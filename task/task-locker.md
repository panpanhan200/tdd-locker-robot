# Tasking

## 柜子容量设置:

### AC1
Given 在Locker系统中，柜子容量未初始化

When 初始化柜子容量

Then 可以成功设置柜子容量

### AC2

Given 在Locker系统中，柜子容量已初始化，且柜子当前未使用

When 修改柜子容量时

Then 可以成功设置柜子容量

### AC3

Given 在Locker系统中，柜子容量已初始化，且柜子当前被使用

When 修改柜子容量时

Then 返回设置柜子容量失败

## 存包

### AC1
Given Locker系统已经初始化并成功运行，且有空位

When 在 Locker 系统中发起存包请求

Then 成功返回一个票据

### AC2

Given Locker系统已经初始化并成功运行，且无空位

When 在 Locker 系统中发起存包请求

Then 返回存包失败消息

### AC3

Given 在Locker系统中，柜子容量未初始化

When 在 Locker 系统中发起存包请求

Then 返回系统未初始化错误信息

## 取包

### AC1

Given Locker系统已经初始化并成功运行，且票据合法

When 在 Locker 系统中发起取包请求

Then 返回取包成功消息

### AC2

Given Locker系统已经初始化并成功运行，且票据是已经取过包的

When 在 Locker 系统中发起取包请求

Then 返回取包失败消息

### AC3

Given 在Locker系统中，柜子容量未初始化

When 在 Locker 系统中发起取包请求

Then 返回系统未初始化错误信息