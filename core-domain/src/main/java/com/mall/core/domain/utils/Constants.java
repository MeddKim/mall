package com.mall.core.domain.utils;

public class Constants {

    public static final String APP_TOKEN = "-apptoken";

    public static final String LOGISTICS_APP_TOKEN = "-log-apptoken";

    // second of two month
    public static final int AUTH_TIMEOUT = 5184000;

    //60 * 60 * 24 * 30;
    public static final int TIME_OF_ONE_MONTH = 2592000;
    //60 * 60 * 24 * 10;
    public static final int TIME_OF_TEN_DAY = 864000;
    // 60 * 60 * 24;
    public static final int TIME_OF_ONE_DAY = 86400;

    public static final int TIME_OF_HALF_AN_HOUR = 60 * 30;

    public static final String SPACE = " ";

    public static final String VERTICAL_LINE = "|";

    public static final String DASH = "-";

    public static final String UNDERSCORE = "_";

    public static final String COMMA = ",";

    public static final String EMPTY = "";

    public static final String TRADING_SERVICE_INSTANCE_ID = "TRADING-API-SERVICE";
    public static final String INSURANCE_CLAIM_SERVICE_INSTANCE_ID = "INSURANCE-SERVICE";
    public static final String ENVIRONMENT = "env";
    public static final String ENVIRONMENT_DEV = "dev";
    public static final String ENVIRONMENT_TEST = "test";
    public static final String ENVIRONMENT_STAGING = "staging";
    public static final String ENVIRONMENT_PROD = "prod";


    public static final String CHEJIANER_LOGISTICS_NAME = "车件儿物流";

    public static final String SYSTEM_OPERATOR_NAME = "系统";

    public static final String VENDOR = "配件商";

    public static final String CUSTOMER_NAME = "客户";
    public static final String PRIVATE_KEY_MATCH_REGEX = "(-+BEGIN (RSA )?PRIVATE KEY-+\\r?\\n|-+END (RSA )?PRIVATE KEY-+\\r?\\n?)";
    public static final String APP_AREA_DEFAULT_CHARSET = "GBK";
    public static final String INSURANCE_ENQUIRY_BIZ_PREFIX = "INSR";
    public static final String ZONE_DIVISION_MAP = "zone-division-map";
    public static final String BUYER_COUPONS = "-buyer-coupon-id";
    public static final String PROVINCE_DIVISION_ZONE_GROUP_MAP = "province-division-group-map";

    //-----------------------------cache key begin ---------------------------------------------//
    public static final String PROVINCE_DIVISION_MAP = "province-division-map";
    public static final String CITY_DIVISION_PROVINCE_GROUP_MAP = "city-division-group-map";
    public static final String CITY_DIVISION_MAP = "city-division-map";
    public static final String COUNTY_DIVISION_CITY_GROUP_MAP = "county-division-group-map";
    public static final String COUNTY_DIVISION_MAP = "county-division-map";
    public static final String MESSAGE_SERVICE_PUSH_MESSAGE_APP_TOPIC = "ms-push-to-app";
    public static final String MESSAGE_SERVICE_PUSH_MESSAGE_WEB_TOPIC = "ms-push-to-web";
    public static final String MESSAGE_SERVICE_SEND_SMS_TOPIC = "ms-send-sms";
    public static final String SHOPPING_CART_KEY_SUFFIX = "-cart";
    public static final String ESHOP_SHOPPING_CART_KEY_PREDIX = "eshop-cart-";
    public static final String ESHOP_SHOPPING_CART_SETTLE_KEY_PREDIX = "eshop-settle-";
    public static final String SHOPPING_CART_SETTLE_KEY_SUFFIX = "-cart-settle";
    public static final String SHOPPING_CART_PART_KEY_PREFIX = "cart-part-";
    public static final String SHOPPING_CART_PART_SETTLE_KEY_PREFIX = "cart-part-settle-";
    public static final String TRADING_IOS_APP_BUYER_LAST_VERSION = "trading-ios-app-buyer-last-version";
    public static final String TRADING_IOS_APP_VENDOR_LAST_VERSION = "trading-ios-app-vendor-last-version";
    public static final String ADMIN_AUTH_USER_HASH_KEY = "base-admin-auth-user-map";
    public static final String GEO_LOCATION_HASH_KEY = "base-geo-location-map";
    public static final String MATCH_LOGISTICS_ROUTE_KEY = "match-logistics-route";
    public static final String PINYIN_HEAD_MATCHED_HASH_KEY = "base-pinyin-head-matched-map";
    public static final String LOGISTICS_STAFF_RESPONSIBLE_AREA_HASH_KEY = "logistics-staff-responsible-area-map";
    public static final String TOTAL_MATCHED_VENDOR_COMPANY_LIMIT = "matchVendorCompanyLimit-system-variables";
    public static final String FAKE_VENDOR = "-fake-vendor";
    public static final String SMS_DAYU_KEY = "sms-dayu-key";
    public static final String PARENT_INSURANCE_COMPANY_MAP = "parent-insurance-company-map";
    public static final String INSURANCE_COMPANY_GROUP_MAP = "insurance-company-group-map";
    public static final String INSURANCE_COMPANY_MAP = "insurance-company-map";
    /**
     * 立洋数据最新更新记录ID
     */
    public static final String AUTOMOTIVE_LY_VERSION_KEY = "automotive-ly-latest-version";
    /**
     * 立洋整表缓存(AutomotiveLY)
     */
    public static final String AUTOMOTIVE_LY_MAP_KEY = "automotive-ly-map";
    /**
     * 立洋品牌映射表缓存 (AutomotiveLyMapping)
     * //
     */
    public static final String AUTOMOTIVE_LY_MAPPING_MAP_KEY = "automotive-ly-mapping-map";
    /**
     * 立洋Mapping 中图片LOGO缓存
     */
    public static final String AUTOMOTIVE_LY_PIC_MAP_KEY = "automotive-ly-pic-map";
    /**
     * 图片系统
     */
    public static final String BRAND_PIC_MAP = "brand-pic-map";
    public static final Integer ENQUIRY_ALLOCATION_TRIGGER_SEQUENCE_SYSTEM = -2;
    public static final Integer ENQUIRY_ALLOCATION_TRIGGER_SEQUENCE_PARTNERSHIPS = -1;
    public static final Integer ENQUIRY_ALLOCATION_TRIGGER_SEQUENCE_NORMAL = 0;
    public static final String BANNER_CAROUSE_LIST_KEY = "banner-carousel-list";
    public static final String ENQUIRY_UNREAD_KEY_PREFIX = "unread-enquiry-";
    public static final String ORDER_UNREAD_KEY_PREFIX = "unread-order-";
    public static final String UPDATE_ENQUIRY_LOCK_KEY_PREFIX = "locked-enquiry-";
    public static final String VENDOR_PERFORMANCE = "vendor-performance";
    public static final String TRADING_APP_BUYER_LAST_VERSION = "trading-buyer-app-last-version";
    public static final String TRADING_APP_VENDOR_LAST_VERSION = "trading-vendor-app-last-version";
    public static final String TRADING_APP_ANNOUNCEMENTS = "trading-app-announcements";
    public static final String TRADING_APP_ANNOUNCEMENTS_V3 = "trading-app-announcements-v3";
    public static final String TRADING_APP_POP_UP_MESSAGES = "trading-app-pop-up-messages";
    public static final String TRADING_APP_OPERATION_MESSAGE_MAP = "trading-app-operation-message-map";
    public static final String ENQUIRY_TRIGGER_EXECUTE_COUNT_LIMIT = "enquiry-trigger-execute-count-limit";
    public static final String ROOT_TAG = "root-tag";
    //DEFAULT 30 Minutes value : 30
    public static final String DEFAULT_TIMEOUT_UNPAID_TIME = "timeout-unpaid-time-system-variables";
    //DEFAULT 7 DAY  value : 7
    public static final String DEFAULT_TIMEOUT_UNDELIVERED_TIME = "timeout-undelivered-time-system-variables";
    //DEFAULT 3 DAY  value : 3
    public static final String DEFAULT_TIMEOUT_NO_CONFIRM_TIME = "timeout-no-confirm-time-system-variables";
    //DEFAULT 1 DAY  value : 1
    public static final String DEFAULT_TIMEOUT_NO_REPLIED_TIME = "timeout-no-replied-time-system-variables";
    //DEFAULT 3 DAY  value : 3
    public static final String DEFAULT_TIMEOUT_NO_OFFER_TIME = "timeout-no-offer-time-system-variables";
    //DEFAULT 7 DAY  value : 7
    public static final String DEFAULT_UNLOCK_PAID_AMOUNT_TIME = "timeout-unlock-paid-time-system-variables";
    //DEFAULT 2 DAY  value : 2
    public static final String DEFAULT_ADVANCE_ENQUIRY_TIMEOUT_TIME = "timeout-advance-enquiry-system-variables";
    /**
     * 正常超时未报价期限(300秒)
     */
    public static final String ALLOCATION_TIMEOUT_NO_REPLIED_PERIOD = "allocation-timeout-no-replied-period";
    /**
     * 合作伙伴超时未报价期限(60秒)
     */
    public static final String PARTNERSHIPS_TIMEOUT_NO_REPLIED_PERIOD = "partnerships-timeout-no-replied-period";
    public static final String OSS_ACCESS_SIGN = "oss-access-sign-system-variables";
    public static final String OSS_STS_TOKEN = "oss-sts-token-system-variables";
    //DEFAULT DISTANCE : 20000 Miles(20 Kilometers)
    public static final String DEFAULT_GEO_LOCATE_MATCH_DISTANCE = "default-geo-locate-match-distance-system-variables";
    public static final String BASIC_ORDER_ONLINE_PAY_DISCOUNT_OFFERS_KEY = "basic-order-online-pay-discount-offers-system-variables";
    public static final String BASIC_ORDER_ONLINE_PAY_DISCOUNT_LIMIT_KEY = "basic-order-online-pay-discount-limit-system-variables";
    //00000000-0000-0000-0000-000000000000
    public static final String DEFAULT_SYSTEM_BUYER_COMPANY_ID_KEY = "default-system-buyer-company-id-system-variables";
    //00000000-0000-0000-0000-000000000010
    public static final String DEFAULT_SYSTEM_VENDOR_COMPANY_ID_KEY = "default-system-vendor-company-id-system-variables";
    //00000000-0000-0000-0000-000000000001
    public static final String DEFAULT_SYSTEM_BUYER_ACCOUNT_ID_KEY = "default-system-buyer-account-id-system-variables";
    //00000000-0000-0000-0000-000000000011
    public static final String DEFAULT_SYSTEM_VENDOR_ACCOUNT_ID_KEY = "default-system-vendor-account-id-system-variables";
    public static final String ZJJZ_MEMBER_ACC_SELECT_FLAG = "2";
    public static final String ZJJZ_FUNCTION_ACC_SELECT_FLAG = "3";
    public static final String ZJJZ_ZAITU_ACC_TYPE = "7";
    /**
     * 在线支付方式Map
     */
    public static final String ONLINE_PAYMENT_METHOD_MAP = "trading-online-pay-method-map";
    public static final String ONLINE_PAY_REDUCTION_INFO = "online-pay-reduction-info";
    public static final String SCORE_CONVERSION_INFO = "system-score-conversion";

    //-----------------------------cache key end ---------------------------------------------//
    static final String PUBLIC_KEY_MATCH_REGEX = "(-+BEGIN PUBLIC KEY-+\\r?\\n|\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)";
    static final String ALGORITHM_RSA = "RSA";
    static final String ALGORITHM_RSA256 = "SHA256withRSA";
}
