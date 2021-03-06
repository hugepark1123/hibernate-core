package org.hibernate.metamodel.source.annotations.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.junit.Test;

import org.hibernate.id.Assigned;
import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.metamodel.binding.EntityIdentifier;
import org.hibernate.metamodel.domain.Attribute;
import org.hibernate.metamodel.domain.Component;

import static junit.framework.Assert.assertTrue;

/**
 * @author Strong Liu
 */
public class EmbeddedIdTests extends BaseAnnotationBindingTestCase {
    @Test
    public void testEmbeddable() {
        buildMetadataSources( User.class, Address.class );
        EntityBinding binding = getEntityBinding( User.class );
        EntityIdentifier identifier = binding.getEntityIdentifier();
        assertTrue( identifier.isEmbedded() );
//        assertTrue(
//                "EmbeddedId generator should be 'assigned'", identifier.getIdentifierGenerator() instanceof Assigned
//        );
    }

    @Entity
    @Access( AccessType.FIELD )
    class User {
        private String name;
        @EmbeddedId
        private Address address;
    }

    @Embeddable
    class Address {
        String street;
        String city;
        String postCode;
    }
}



