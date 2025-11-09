package com.security.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeyVaultTest {

    @Value("${db.password}")
    private String secret;

    /**
     * Is exist secret password from Azure Key Vault?
     */
    @Test
    void isExistSecret() {
        assertThat(secret).isNotNull();
    }
}
