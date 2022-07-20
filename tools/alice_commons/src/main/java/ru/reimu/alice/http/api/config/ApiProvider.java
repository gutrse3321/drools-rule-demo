package ru.reimu.alice.http.api.config;

import ru.reimu.alice.http.HttpClientManager;
import ru.reimu.alice.http.config.HttpClientProperties;

/**
 * @Author: Tomonori
 * @Date: 2019/12/17 16:15
 * @Title:
 * @Desc: ↓ ↓ ↓ ↓ ↓
 * -----
 */
public interface ApiProvider {

    /**
     * 设置http客户端信息
     * @param properties
     */
    void setHttpClientProperties(HttpClientProperties properties);

    void setHttpClientManager(HttpClientManager clientManager);

    HttpClientProperties getHttpClientProperties();

    void init();
}
