package com.pablo.system.common.global;

import com.pablo.system.domain.WorkerVo;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 12:21
 * @package com.pablo.system.common.global
 * @characterization 全局常量配置
 */
public class GlobalConfig {
    public static final String APPLICATION_CONFIG_XML = "applicationContext.xml";

    public static final String DATE_FORMAT_ONE        = "yyyy-MM-dd HH:mm:ss";

    public static WorkerVo CURRENT_WORKER             = null;

    public static String REDIS_TEMPLETE               = "redisTemplate";

    public static String STRING_REDIS_TEMPLETE        = "stringRedisTemplate";
}
