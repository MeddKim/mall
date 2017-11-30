## 服务说明
### domain
- core-domain : 实体类及MyBatis相关接口文件
### 基础设施
端口：8001-8099
- mall-base-eureka-server : 服务注册发现中心（8001）
- mall-base-config-server : 配置中心（8002）
- mall-base-stream-server : 消息总驱动（8003）

### 基础业务模块
端口：8101-8299
- mall-module-product : 商品模块（8101）
- mall-module-product : 订单模块（8102）

### 网关服务
端口: 8301-8499
- mall-api-merchant

