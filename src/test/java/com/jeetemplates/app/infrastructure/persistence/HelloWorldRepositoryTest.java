/**
 *
 */
package com.jeetemplates.app.infrastructure.persistence;

import java.io.FileInputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeetemplates.app.common.repository.BaseRepositoryTest;
import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.domain.HelloWorldRepository;

/**
 * Test of {@link HelloWorldDao}.
 *
 * @author jeetemplates
 */
public class HelloWorldRepositoryTest extends BaseRepositoryTest {

    /**
     * {@link HelloWorldDao}.
     */
    @Autowired
    private HelloWorldRepository helloWorldRepository;

    /**
     * @return @throws java.lang.Exception
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset/dataset.xml"));
    }

    @Test
    public void testRetrieveAll() {
        List<HelloWorld> results = helloWorldRepository.findAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

}
