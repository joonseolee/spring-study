package com.joonseolee.enc.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JaspytConfigurationTest {

    @Autowired
    private JaspytConfiguration jaspytConfiguration;

    @Autowired
    private DatasourcePropertiesConfiguration datasourcePropertiesConfiguration;

    @Autowired
    private SampleProperties sampleProperties;

    private static final String url = "localhost:3306";
    private static final String username = "root";
    private static final String password = "password123^";

    @Test
    @DisplayName("디비 접속정보들을 인코딩한다.")
    void encoding() {
        String encodedUrl = jaspytConfiguration.stringEncryptor().encrypt(url);
        String encodedUsername = jaspytConfiguration.stringEncryptor().encrypt(username);
        String encodedPassword = jaspytConfiguration.stringEncryptor().encrypt(password);

        assertThat(encodedUrl).isNotEqualTo(url);
        assertThat(encodedUsername).isNotEqualTo(username);
        assertThat(encodedPassword).isNotEqualTo(password);
    }

    @Test
    @DisplayName("디비 접속정보들을 디코딩한다.")
    void decoding() {
        String encodedUrl = datasourcePropertiesConfiguration.getUrl();
        String encodedUsername = datasourcePropertiesConfiguration.getUsername();
        String encodedPassword = datasourcePropertiesConfiguration.getPassword();

        assertThat(encodedUrl).isEqualTo(url);
        assertThat(encodedUsername).isEqualTo(username);
        assertThat(encodedPassword).isEqualTo(password);
    }

    @Test
    @DisplayName("ENC 로 감싸지않은 속성들은 복호화되지않는다.")
    void notDecoding() {
        String sampleUrl = sampleProperties.getUrl();
        String sampleUsername = sampleProperties.getUsername();
        String samplePassword = sampleProperties.getPassword();

        assertThat(sampleUrl).isNotEqualTo(url);
        assertThat(sampleUsername).isNotEqualTo(username);
        assertThat(samplePassword).isNotEqualTo(password);
    }
}