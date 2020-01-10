package com.springboot.hbase.utli;

import com.springboot.hbase.service.HBaseService;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HBaseConfig
 * @Description TODO
 * @Author L
 * @Date Create by 2020/1/8
 */
@Configuration
public class HBaseConfig {

    @Bean
    public HBaseService getHbaseService() {
        //设置临时的hadoop环境变量，之后程序会去这个目录下的\bin目录下找winutils.exe工具，windows连接hadoop时会用到
        //System.setProperty("hadoop.home.dir", "D:\\Program Files\\Hadoop");
        //执行此步时，会去resources目录下找相应的配置文件，例如hbase-site.xml
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        return new HBaseService(conf);
    }
}
