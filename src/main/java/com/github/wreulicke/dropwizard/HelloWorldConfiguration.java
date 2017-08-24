package com.github.wreulicke.dropwizard;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.wreulicke.dropwizard.core.Template;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;

@Data
public class HelloWorldConfiguration extends Configuration {
	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "Stranger";
	
	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	
	
	public Template buildTemplate() {
		return new Template(template, defaultName);
	}
	
}