# EaseFieldTypeIn

[English](README.md) | [中文](README_CN.md)

![Build](https://github.com/MC-XiaoHei/EaseFieldTypeIn/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

#### 使Kotlin的字段键入变得方便快捷
<!-- Plugin description -->
<!-- Plugin description end -->

## 使用

- 键入<kbd>val:TypeName </kbd>或<kbd>var:TypeName </kbd>（最后有一个空格）
- 键入首字母（例：如果类型名是AaaBbbCccDdd，而你键入了'b'，那么自动补全列表将会出现"bbbCccDdd"， "cccDdd"，"ddd"，以此类推）
- 选择自动补全列表中想要的字段名，按下Enter键
- 完成！插件将自动补全字段名到正确的位置

## 安装

- 使用 IDE 内置插件系统：

  <kbd>设置</kbd> >
  <kbd>插件</kbd> >
  <kbd>Marketplace</kbd> > 
  <kbd>搜索 "EaseFieldTypeIn"</kbd> >
  <kbd>安装</kbd>

---
插件基于 [IntelliJ Platform Plugin Template][template] 创建.

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
