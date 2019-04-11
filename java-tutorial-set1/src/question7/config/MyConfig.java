package question7.config;

public class MyConfig {
	
	private String dbHost;
    private String dbPort;
    private String dbService;
    private String dbUrl;
    private String dbPassword;
	public String getDbHost() {
		return dbHost;
	}
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbService() {
		return dbService;
	}
	public void setDbService(String dbService) {
		this.dbService = dbService;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	@Override
	public String toString() {
		return "Configuraion [dbHost=" + dbHost + ", dbPort=" + dbPort + ", dbService=" + dbService + ", dbUrl=" + dbUrl
				+ ", dbPassword=" + dbPassword + "]";
	}
    
    
    
    
}
