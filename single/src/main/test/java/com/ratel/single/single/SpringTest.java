package com.ratel.single.single;

import com.ratel.single.Api;
import io.swagger.models.Swagger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;


/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/10
 */
@SpringBootTest(classes = Api.class)
@RunWith(SpringRunner.class)
public class SpringTest {
    @Autowired
    private ServiceModelToSwagger2Mapper mapper;
    @Autowired
    private DocumentationCache documentationCache;

    @Autowired
    private Docket docket;


    @Test
    public void test() throws Exception {
        String groupName = Docket.DEFAULT_GROUP_NAME;
        Documentation documentation = documentationCache.documentationByGroup(groupName);
        Swagger swagger = mapper.mapDocumentation(documentation);
        System.out.println(swagger);
    }

}
