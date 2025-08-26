package pe.com.ncquality.sad.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@ComponentScan({"pe.gob.pension65.mpd.*"})
@PropertySource("classpath:application.properties")
public class AppConfig { 
	@Bean
        @Primary
	public DataSource dataSource()
	{
	  JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	  //DataSource dataSource = dataSourceLookup.getDataSource("java:/mpdDSProd");
            DataSource dataSource = dataSourceLookup.getDataSource("java/mpdDS");
	  return dataSource;
	}
    

}
