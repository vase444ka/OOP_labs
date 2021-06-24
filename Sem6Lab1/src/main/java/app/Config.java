package app;

public class Config {
    public static String getConnectionUrl() {
        return connectionUrl;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriver() {
        return driver;
    }

    public static Long getCompanyId() {
        return companyId;
    }

    private static final Long companyId = 1L;
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/lowcost";
    private static final String userName = "postgres";
    private static final String password = "zalupa";
    private static final String driver = "org.postgresql.Driver";
}
