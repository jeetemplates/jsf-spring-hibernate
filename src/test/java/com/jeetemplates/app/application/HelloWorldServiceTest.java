/**
 *
 */
package com.jeetemplates.app.application;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.domain.HelloWorldRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test of {@link HelloWorldService}.
 *
 * @author jeetemplates
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServiceTest {

    /* ************************************************************** */
    /* Service to test */
    /* ************************************************************** */
    /**
     * {@link HelloWorldService}.
     */
    @InjectMocks
    private HelloWorldService helloWorldService;

    /* ************************************************************** */
    /* Mocks */
    /* ************************************************************** */
    /**
     * {@link HelloWorldRepository}.
     */
    @Mock
    private HelloWorldRepository helloWorldRepository;

    /* ************************************************************** */
    /* Methods */
    /* ************************************************************** */
    /**
     * Test of method {@link HelloWorldService#retrieveAll()}.
     */
    @Test
    public void testCreate() {
        // Test inutile en soi.
        // Montre la configuration et l'injection des mocks

        // Mock result
        HelloWorld entity = new HelloWorld();
        entity.setFirstName("first name");
        entity.setLastName("last name");

        HelloWorld mock = new HelloWorld();
        mock.setId(1L);
        mock.setFirstName("first name");
        mock.setLastName("last name");

        // Mock call method
        Mockito.when(helloWorldRepository.save(entity)).thenReturn(mock);

        // Call service
        HelloWorld persistedEntity = helloWorldService.create(entity);

        Assert.assertNotNull(persistedEntity);
        Assert.assertNotNull(persistedEntity.getId());
        Assert.assertEquals(mock.getId(), persistedEntity.getId());

    }

}
