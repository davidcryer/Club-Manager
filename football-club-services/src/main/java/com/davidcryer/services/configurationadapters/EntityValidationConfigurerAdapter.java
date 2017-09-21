package com.davidcryer.services.configurationadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;

@Configuration
public class EntityValidationConfigurerAdapter extends RepositoryRestConfigurerAdapter {
    private final Validator validator;

    @Autowired
    public EntityValidationConfigurerAdapter(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }
}
