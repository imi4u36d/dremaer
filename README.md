# 后端管理系统 - README

本项目是一个仿小红书的后端管理系统，提供完整的分享社交功能。使用了以下技术栈：

- Spring Boot：用于构建后端应用程序。
- MySQL：作为主要的数据库存储引擎。
- Redis：用于缓存和提高系统性能。
- Elasticsearch：用于实现全文搜索功能。

## 功能特点

1. 用户管理：包括用户注册、登录、个人信息修改等功能。
2. 分享管理：用户可以发布分享内容，包括图片、文字、视频等多种形式。
3. 社交功能：用户可以关注其他用户、评论分享内容、点赞等。
4. 搜索功能：支持对分享内容进行全文搜索，提供快速检索功能。

## 技术架构

本项目采用前后端分离的架构，后端部分基于 Spring Boot 框架开发。具体技术组件如下：

- Spring Boot: 用于快速构建后端应用程序。
- MySQL: 作为主要的数据库存储引擎，用于存储用户信息、分享内容等数据。
- Redis: 用于缓存热门分享内容、用户关系等数据，提高系统性能。
- Elasticsearch: 用于实现全文搜索功能，提供快速、准确的搜索结果。

## 快速开始

1. 克隆项目到本地：

```
shellCopy Codegit clone https://github.com/imi4u36d/dremaer.git
```

1. 导入项目到开发工具中，推荐使用 IntelliJ IDEA。
2. 配置数据库和 Redis 连接信息，在 `application.properties` 文件中设置相应配置。
3. 启动应用程序：

```
shellCopy Codemvn spring-boot:run
```

1. 访问后端管理系统：

```
Copy Codehttp://localhost:6060
```

## 贡献

欢迎对该项目提交问题和改进建议。如果您希望为该项目做出贡献，请按照以下步骤操作：

1. Fork 该仓库到自己的 GitHub 账号下。
2. 创建新的分支进行开发：

```
shellCopy Codegit checkout -b new-feature
```

1. 提交代码并推送到自己的仓库中：

```
shellCopy Codegit add .
git commit -m "Add new feature"
git push origin new-feature
```

1. 在 GitHub 网站上提交 Pull Request，等待审核。

## 许可证
请勿用于商业用途。

如有任何疑问或建议，请随时联系我：[wxwzmail@163.com](mailto:wxwzmail@163.com)。
