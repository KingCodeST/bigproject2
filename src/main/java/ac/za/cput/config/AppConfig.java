package ac.za.cput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

import java.util.Properties;


@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value ={
        @ComponentScan("ac.za.cput.factory"),
        @ComponentScan("ac.za.cput.repository"),
        @ComponentScan("ac.za.cput.service")

})
public class AppConfig {

    @Autowired
    private Environment eeven;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
        Properties props=new Properties();

        ///setting jdbc properties
        props.put(DRIVER, eeven.getProperty("mysql.driver"));
        props.put(URL, eeven.getProperty("mysql.url"));
        props.put(USER, eeven.getProperty("mysql.user"));
        props.put(PASS, eeven.getProperty("mysql.password"));

        /// setting hiberbanet properties

        props.put(SHOW_SQL, eeven.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO,eeven.getProperty("hibernate.hbm2ddl.auto"));

        // Setting Cp30

        props.put(C3P0_MAX_SIZE,eeven.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_MAX_STATEMENTS,eeven.getProperty("hibernate.c3p0.max_statements"));
        props.put(C3P0_TIMEOUT,eeven.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_ACQUIRE_INCREMENT,eeven.getProperty("hibernate.c3p0.acqure_increment"));
        props.put(C3P0_MIN_SIZE,eeven.getProperty("hibernate.c3p0.min_size"));


        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("ac.za.cput.domain");


        return factoryBean;

    }

    @Bean
    public HibernateTransactionManager getTransactionManger(){
        HibernateTransactionManager transactionManager =new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }


}
