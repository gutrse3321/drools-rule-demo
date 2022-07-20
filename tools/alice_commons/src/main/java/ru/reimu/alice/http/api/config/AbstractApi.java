package ru.reimu.alice.http.api.config;

import ru.reimu.alice.http.HttpClientManager;
import ru.reimu.alice.http.config.HttpClientProperties;
import ru.reimu.alice.support.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author: Tomonori
 * @Date: 2019/12/24 17:42
 * @Title:
 * @Desc: ↓ ↓ ↓ ↓ ↓
 * -----
 */
public abstract class AbstractApi implements ApiProvider {

    protected static final Logger log = LoggerFactory.getLogger(AbstractApi.class);
    protected static final String HTTP_PREFIX = "http://";
    protected static final String HTTPS_PREFIX = "https://";
    protected static final String DELIMITER = "/";

    protected HttpClientManager clientManager;
    protected HttpClientProperties properties;
    protected Boolean https;
    protected Map<String, String> apiMap;

    @Override
    public void setHttpClientProperties(HttpClientProperties properties) {
        this.properties = properties;

        if (null != this.properties) {
            apiMap = properties.getUrlMap();
            https = properties.getHttps();

            if (https == null) {
                https = false;
            }
        }
    }

    @Override
    public HttpClientProperties getHttpClientProperties() {
        return this.properties;
    }

    @Override
    public void setHttpClientManager(HttpClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public void init() {

    }

    protected String getProperties(String name) {
        return apiMap.get(name);
    }

    protected StringBuilder makeUrl(String name) {
        StringBuilder builder = new StringBuilder(properties.getHost());
        String properties = getProperties(name);

        if (!StringUtility.hasText(properties)) {
            return builder;
        }

        if (properties.indexOf(DELIMITER) == 0) {
            builder.append(properties);
        } else {
            builder.append(DELIMITER).append(properties);
        }

        return builder;
    }

    protected String makeHttpUrl(String name) {
        StringBuilder builder = makeUrl(name);

        if (builder.toString().indexOf(HTTP_PREFIX) == 0) {
            return builder.toString();
        }

        builder.insert(0, HTTP_PREFIX);

        return builder.toString();
    }

    protected String makeHttpsUrl(String name) {
        StringBuilder builder = makeUrl(name);

        if (builder.toString().indexOf(HTTPS_PREFIX) == 0) {
            return builder.toString();
        }

        builder.insert(0, HTTPS_PREFIX);

        return builder.toString();
    }

    protected String makeAutoUrl(String name) {
        if (https) {
            return makeHttpsUrl(name);
        } else {
            return makeHttpUrl(name);
        }
    }

    protected StringBuilder makeUrl4V3(String name, String machineVersion) {
        StringBuilder builder = new StringBuilder(properties.getHost());
        String properties = getProperties(name);

        if (!StringUtility.hasText(properties)) {
            return builder;
        }

        if (properties.indexOf(DELIMITER) == 0) {
            builder.append(properties);
        } else {
            builder.append(DELIMITER).append(properties);
        }

        return builder;
    }

    protected String makeHttpsUrl4V3(String name, String machineVersion) {
        StringBuilder builder = makeUrl4V3(name, machineVersion);

        if (builder.toString().indexOf(HTTPS_PREFIX) == 0) {
            return builder.toString();
        }

        builder.insert(0, HTTPS_PREFIX);

        return builder.toString();
    }
}
