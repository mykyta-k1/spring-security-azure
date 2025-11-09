# Spring Security Azure - Practice Project

A Spring Boot application demonstrating secure secret management using Azure Key Vault, automated CI/CD pipeline, and code security scanning.

## 🔧 Technologies & Integrations

- **Framework:** Spring Boot 3.2.12 (Java 17)
- **Database:** H2 (in-memory)
- **Secret Management:** Azure Key Vault with Spring Cloud Azure 5.16.0
- **Configuration:** Spring Dotenv 4.0.0
- **Security Scanning:** 
  - Gitleaks (pre-commit hook for secret detection)
  - SpotBugs (static analysis)
- **CI/CD:** GitHub Actions (automated testing on push to `main`)

## 🚀 Getting Started

### Prerequisites

- JDK 17
- Maven
- Azure account with Key Vault configured

### Setup

1. **Clone the repository**
```bash
   git clone https://github.com/your-username/spring-security-azure.git
   cd spring-security-azure
```

2. **Configure environment variables**
   
   Create `.env` file in the project root:
```env
   AZURE_CLIENT_ID=your-client-id
   AZURE_CLIENT_SECRET=your-client-secret
   AZURE_TENANT_ID=your-tenant-id
   AZURE_ENDPOINT=your-azure-endpoint
```

3. **Update Azure Key Vault endpoint**
   
   Edit `src/main/resources/application.yml`:
```yaml
   spring.cloud.azure.keyvault.secret.property-sources[0].endpoint: https://your-vault-name.vault.azure.net/
```

4. **Run the application**
```bash
   mvn spring-boot:run
```

5. **Run tests**
```bash
   mvn test
```

## 🛡️ Security Features

- **Secret Detection:** Gitleaks pre-commit hook prevents committing sensitive data
- **Secure Storage:** All secrets stored in Azure Key Vault, not in code
- **CI/CD Integration:** GitHub Secrets used for automated testing

## 📝 Notes

This is an educational project for practicing secure application development patterns. The intentionally simple codebase focuses on demonstrating integration techniques rather than production-ready features.

## 🔮 Future Plans

- Rate limiting implementation
- Security vulnerability remediation
- Additional security scanning tools integration

---

**Academic Project** | Spring 2025
